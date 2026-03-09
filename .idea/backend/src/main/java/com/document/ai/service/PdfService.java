package com.document.ai.service;

import com.document.ai.model.Invoice;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

public class PdfService {

    public void generatePdf(Invoice invoice) throws Exception {

        PdfWriter writer = new PdfWriter("invoice.pdf");

        PdfDocument pdf = new PdfDocument(writer);

        Document document = new Document(pdf);

        document.add(new Paragraph("Invoice Number: " + invoice.getInvoiceNumber()));
        document.add(new Paragraph("Customer Name: " + invoice.getCustomerName()));
        document.add(new Paragraph("Amount: " + invoice.getAmount()));
        document.add(new Paragraph("Due Date: " + invoice.getDueDate()));

        document.close();
    }
}