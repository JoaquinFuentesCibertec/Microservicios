package com.proyecto.controller;

import com.proyecto.models.Libro;
import com.proyecto.service.LibroService;

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
public class ReporteLibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping(value = "/libros/reportes", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> generarReporteLibros() {
        try {
            List<Libro> libros = libroService.listarTodos();

            PDDocument document = new PDDocument();
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14);
            contentStream.beginText();
            contentStream.setLeading(16.5f);
            contentStream.newLineAtOffset(50, 800);

            contentStream.showText("Reporte de Libros");
            contentStream.newLine();
            contentStream.showText("___________________________________________");
            contentStream.newLine();
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
            contentStream.showText("Listado de Libros Registrados");
            contentStream.newLine();
            contentStream.showText("____________________________________________");
            contentStream.newLine();
            contentStream.newLine();

            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 10);
            contentStream.showText(String.format("%-5s | %-20s | %-20s | %-20s | %-10s | %-15s | %-15s", 
                    "ID", "Nombre", "Autor", "País", "Stock", "Fecha Restock", "Editoriales"));
            contentStream.newLine();
            contentStream.showText("-------------------------------------------------------------------------------------------------------------");
            contentStream.newLine();

            contentStream.setFont(PDType1Font.HELVETICA, 10);
            for (Libro libro : libros) {
                contentStream.showText(String.format("%-5s | %-20s | %-10s | %-10s | %-10d | %-5s", 
                        libro.getId(),
                        libro.getNombre(),
                        libro.getAutor(),
                        libro.getPais(),
                        libro.getStock(),
                        libro.getFechaRestock() != null ? libro.getFechaRestock().toString() : "N/A"));
                contentStream.newLine();
            }

            contentStream.endText();
            contentStream.close();


            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            document.save(baos);
            document.close();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("filename", "reporte_libros.pdf");

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(baos.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}

