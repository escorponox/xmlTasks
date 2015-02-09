package sax;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class Ejercicio6 {

	public static void main(String argv[]) {

		try {

			File fXmlFile = new File("D:\\xmlTasks\\src\\main\\resources\\xml\\agenda.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("contacto");

			System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					if(eElement.getAttribute("alias").matches("^amigo.*")) {

						System.out.println("\nCurrent Element :" + nNode.getNodeName());
						System.out.println("Nombre : " + eElement.getElementsByTagName("nombre").item(0).getTextContent());
						System.out.println("Telefono : " + eElement.getElementsByTagName("telefono").item(0).getTextContent());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}