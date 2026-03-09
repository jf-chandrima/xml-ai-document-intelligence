package com.document.ai.util;

import com.document.ai.model.Invoice;
import org.w3c.dom.*;
import javax.xml.parsers.*;

import java.io.File;

public class XmlParser {

    public static Invoice parseInvoice(String filePath) throws Exception {

        File file = new File(filePath);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = builder.parse(file);
        doc.getDocumentElement().normalize();

        Invoice invoice = new Invoice();

        invoice.setInvoiceNumber(
                doc.getElementsByTagName("invoiceNumber").item(0).getTextContent());

        invoice.setCustomerName(
                doc.getElementsByTagName("customerName").item(0).getTextContent());

        invoice.setAmount(
                doc.getElementsByTagName("amount").item(0).getTextContent());

        invoice.setDueDate(
                doc.getElementsByTagName("dueDate").item(0).getTextContent());

        return invoice;
    }
}