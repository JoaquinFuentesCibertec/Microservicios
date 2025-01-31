package com.proyecto.controller;

import com.proyecto.models.Mantenimiento;
import com.proyecto.service.MantenimientoService;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class ReporteMantenimientoController {

    @Autowired
    private MantenimientoService mantenimientoService;

    @GetMapping(value = "/mantenimientos/reportes", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> generarReporteMantenimientos() {
        try {
            List<Mantenimiento> mantenimientos = mantenimientoService.listarTodos();

            PDDocument document = new PDDocument();
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14);
            contentStream.beginText();
            contentStream.setLeading(16.5f);
            contentStream.newLineAtOffset(50, 800);

            contentStream.showText("Reporte de Mantenimientos");
            contentStream.newLine();
            contentStream.showText("___________________________________________");
            contentStream.newLine();
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
            contentStream.showText("Listado de Mantenimientos Realizados");
            contentStream.newLine();
            contentStream.showText("___________________________________________");
            contentStream.newLine();
            contentStream.newLine();

            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 10);
            contentStream.showText(String.format("%-5s | %-15s | %-15s | %-30s | %-15s", 
                    "ID", "Fecha Inicio", "Fecha Fin", "Razón", "Sucursal ID"));
            contentStream.newLine();
            contentStream.showText("-------------------------------------------------------------------------------------------------------------");
            contentStream.newLine();

            contentStream.setFont(PDType1Font.HELVETICA, 10);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            for (Mantenimiento mantenimiento : mantenimientos) {
                contentStream.showText(String.format("%-5s | %-15s | %-15s | %-30s | %-15d", 
                        mantenimiento.getId(),
                        mantenimiento.getFechaInicio() != null ? dateFormat.format(mantenimiento.getFechaInicio()) : "N/A",
                        mantenimiento.getFechaFin() != null ? dateFormat.format(mantenimiento.getFechaFin()) : "N/A",
                        mantenimiento.getRazon(),
                        mantenimiento.getIdSucursal()));
                contentStream.newLine();
            }

            contentStream.endText();
            contentStream.close();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            document.save(baos);
            document.close();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("filename", "reporte_mantenimiento.pdf");

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(baos.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
