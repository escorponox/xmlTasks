package sax;

import com.sun.org.apache.xpath.internal.XPathAPI;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;

public class Ejercicio7 {

	public static void main(String[] args) {
		try {

			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder()
					.parse("D:\\xmlTasks\\src\\main\\webapp\\xml\\agenda.xml");
			Element raiz = document.getDocumentElement();
			NodeList nodeList = XPathAPI.selectNodeList(raiz,
					"/*[name()='agenda']/*[name()='contactos']/*[name()='contacto'][contains(@alias,\"amigo\")]/@alias");
			for (int i = 0; i < nodeList.getLength(); i++) {
				String alias = nodeList.item(i).getNodeValue();
				System.out.println("Contacto: " + alias);

				NodeList nodeList2 = XPathAPI.selectNodeList(raiz,
						"/*[name()='agenda']/*[name()='contactos']/*[name()='contacto'][contains(@alias,\"" + alias + "\")]/*");
				for (int j = 0; j < nodeList2.getLength(); j++) {
					System.out.println(nodeList2.item(j).getNodeName() + ": " + nodeList2.item(j).getFirstChild().getNodeValue());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
