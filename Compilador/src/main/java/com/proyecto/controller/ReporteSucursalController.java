package com.proyecto.controller;

import com.proyecto.models.Sucursal;
import com.proyecto.service.SucursalService;

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
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class ReporteSucursalController {

    @Autowired
    private SucursalService sucursalService;

    @GetMapping(value = "/sucursales/reportes", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> generarReporteSucursales() {
        try {
            List<Sucursal> sucursales = sucursalService.listarTodas();

            PDDocument document = new PDDocument();
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14);
            contentStream.beginText();
            contentStream.setLeading(16.5f);
            contentStream.newLineAtOffset(50, 800);

            contentStream.showText("Reporte de Sucursales");
            contentStream.newLine();
            contentStream.showText("___________________________________________");
            contentStream.newLine();
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
            contentStream.showText("Listado de Sucursales Registradas");
            contentStream.newLine();
            contentStream.showText("___________________________________________");
            contentStream.newLine();
            contentStream.newLine();

            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 10);
            contentStream.showText(String.format("%-5s | %-15s | %-25s | %-15s | %-15s", 
                    "ID", "Nombre", "Dirección", "Técnico", "Teléfono"));
            contentStream.newLine();
            contentStream.showText("-------------------------------------------------------------------------------------------------------------");
            contentStream.newLine();
            contentStream.setFont(PDType1Font.HELVETICA, 10);
            for (Sucursal sucursal : sucursales) {
                contentStream.showText(String.format("%-5s | %-15s | %-25s | %-15s | %-15s", 
                        sucursal.getId(),
                        sucursal.getNombre(),
                        sucursal.getDireccion(),
                        sucursal.getTecnico(),
                        sucursal.getTelefono()));
                contentStream.newLine();
            }

            contentStream.endText();
            contentStream.close();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            document.save(baos);
            document.close();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("filename", "reporte_sucursales.pdf");

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(baos.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
