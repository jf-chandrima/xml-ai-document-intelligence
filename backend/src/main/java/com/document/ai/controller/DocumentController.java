package com.document.ai.controller;


import com.document.ai.model.Invoice;
import com.document.ai.service.PdfService;
import com.document.ai.service.AiExtractionService;
import com.document.ai.util.XmlParser;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocumentController {

    private final AiExtractionService aiExtractionService;
    private final PdfService pdfService;

    public DocumentController(AiExtractionService aiExtractionService,
                              PdfService pdfService) {
        this.aiExtractionService = aiExtractionService;
        this.pdfService = pdfService;
    }

    @GetMapping("/generate")
    public String generatePdf() throws Exception {

        String xmlContent = Files.readString(
                Path.of("../sample-data/invoice.xml"));

        // call AI microservice
        String extractedFields = aiExtractionService.extractFields(xmlContent);

        pdfService.generatePdf(extractedFields);

        return "PDF generated using AI extraction";
    }
    
    @GetMapping("/test")
    public String test(){
        return "Hello API";
    }
}