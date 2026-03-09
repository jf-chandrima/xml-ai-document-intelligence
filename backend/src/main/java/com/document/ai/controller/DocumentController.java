package com.document.ai.controller;

import com.document.ai.model.Invoice;
import com.document.ai.service.PdfService;
import com.document.ai.util.XmlParser;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocumentController {

    @GetMapping("/generate")
    public String generatePdf() throws Exception {

        // parse XML
        Invoice invoice = XmlParser.parseInvoice("../sample-data/invoice.xml");

        // generate PDF
        PdfService pdfService = new PdfService();
        pdfService.generatePdf(invoice);

        return "PDF generated successfully";
    }
    
    @GetMapping("/test")
    public String test(){
        return "Hello API";
    }
}