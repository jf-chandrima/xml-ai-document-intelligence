package com.document.ai.service;

import com.document.ai.model.Invoice;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.springframework.stereotype.Service;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PdfService {

    public void generatePdf(String extractedFields) throws Exception {
        
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> data = mapper.readValue(extractedFields, Map.class);

        PdfWriter writer = new PdfWriter("invoice.pdf");
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        document.add(new Paragraph("Invoice Details"));
        document.add(new Paragraph("-------------------------"));

        for (Map.Entry<String, String> entry : data.entrySet()) {
            document.add(new Paragraph(entry.getKey() + " : " + entry.getValue()));
        }

        document.close();
    }
}