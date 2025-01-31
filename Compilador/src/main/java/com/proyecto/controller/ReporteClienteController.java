package com.proyecto.controller;

import com.proyecto.models.Cliente;
import com.proyecto.service.ClienteService;

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
public class ReporteClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/clientes/reportes", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> generarReporteClientes() {
        try {
            List<Cliente> clientes = clienteService.listarTodos();
            PDDocument document = new PDDocument();
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14);
            contentStream.beginText();
            contentStream.setLeading(16.5f);
            contentStream.newLineAtOffset(50, 800);

            contentStream.showText("Reporte de Clientes");
            contentStream.newLine();
            contentStream.showText("____________________________________________________________");
            contentStream.newLine();
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
            contentStream.showText("Listado de Clientes Registrados");
            contentStream.newLine();
            contentStream.showText("________________________________________________________________");
            contentStream.newLine();
            contentStream.newLine();
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 10);
            contentStream.showText(String.format("%-5s | %-20s | %-20s | %-20s | %-25s | %-30s", 
                    "ID", "Nombre", "Apellido Paterno", "Apellido Materno", "Dirección", "Correo"));
            contentStream.newLine();
            contentStream.showText("______________________________________________________________________________________________");
            contentStream.newLine();
            contentStream.setFont(PDType1Font.HELVETICA, 10);
            for (Cliente cliente : clientes) {
                contentStream.showText(String.format("%-5s | %-20s | %-20s | %-20s | %-25s | %-30s", 
                        cliente.getId(),
                        cliente.getNombre(),
                        cliente.getApellidoPaterno(),
                        cliente.getApellidoMaterno(),
                        cliente.getDireccion(),
                        cliente.getCorreo()));
                contentStream.newLine();
            }
            
            contentStream.showText("______________________________________________________________________________________________");

            contentStream.endText();
            contentStream.close();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            document.save(baos);
            document.close();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("filename", "reporte_clientes.pdf");

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(baos.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
