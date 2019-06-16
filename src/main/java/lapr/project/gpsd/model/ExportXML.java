package lapr.project.gpsd.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class ExportXML {

    public static void export(String filename, String[] line) {
        try {

            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = null;
            Element root = null;
            File f = new File(filename);
            if (f.exists()) {
                try {
                    document = documentBuilder.parse(filename);
                    root = document.getDocumentElement();
                } catch (SAXException ex) {
                    Logger.getLogger(ExportXML.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ExportXML.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                document = documentBuilder.newDocument();
                // root element
                root = document.createElement("ServiceOrders");
                document.appendChild(root);
            }

            // ServiceOrder element
            Element serviceOrder = document.createElement("ServiceOrder");

            root.appendChild(serviceOrder);

            // name element
            Element name = document.createElement("name");
            name.appendChild(document.createTextNode(line[0]));
            serviceOrder.appendChild(name);

            // email element
            Element email = document.createElement("email");
            email.appendChild(document.createTextNode(line[1]));
            serviceOrder.appendChild(email);

            // schedPrefDayStr element
            Element schedPrefDayStr = document.createElement("schedPrefDayStr");
            schedPrefDayStr.appendChild(document.createTextNode(line[2]));
            serviceOrder.appendChild(schedPrefDayStr);

            // schedPrefTimeStr elements
            Element schedPrefTimeStr = document.createElement("schedPrefTimeStr");
            schedPrefTimeStr.appendChild(document.createTextNode(line[3]));
            serviceOrder.appendChild(schedPrefTimeStr);

            // category elements
            Element category = document.createElement("category");
            category.appendChild(document.createTextNode(line[4]));
            serviceOrder.appendChild(category);

            // service elements
            Element service = document.createElement("service");
            service.appendChild(document.createTextNode(line[5]));
            serviceOrder.appendChild(service);

            // create the xml file
            //transform the DOM Object to an XML File
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            transformerFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);//added for secure issue
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(filename));

            transformer.transform(domSource, streamResult);

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}
