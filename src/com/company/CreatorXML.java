package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/*1.Create XML File in Java using DOM parser
*For example:
*
*<?xml version = "1.0" encoding = "UTF-8"?>
*<group>
* <user>
*  <name>Sophia</name>
*  <surename>Merly</surename>
*  <phone>+12879335587</phone>
* </user>
* <user>
*  <name>Sophia</name>
*  <surename>Merly</surename>
*  <phone>+12879335587</phone>
* </user>
*</group>
* */
public class CreatorXML {

    public static final String xmlFilePath = "task_1.txt";

    public static void main(String[] args) {
        try {

            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            // group element
            Element group = document.createElement("group");
            document.appendChild(group);

            // user element
            Element user = document.createElement("user");
            group.appendChild(user);

            // name element
            Element firstName = document.createElement("name");
            firstName.appendChild(document.createTextNode("Sophia"));
            user.appendChild(firstName);

            // surename element
            Element surename = document.createElement("surename");
            surename.appendChild(document.createTextNode("Merly"));
            user.appendChild(surename);

            Element phone = document.createElement("phone");
            phone.appendChild(document.createTextNode("+12879335587"));
            user.appendChild(phone);

            // create the xml file

            //transform the DOM Object to an XML File

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath));

            // If you use

            // StreamResult result = new StreamResult(System.out);

            // the output will be pushed to the standard output ...

            // You can use that for debugging

            transformer.transform(domSource, streamResult);

            System.out.println("Done creating XML File");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }

    }

}
