package sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Ejercicio5 {

	public static void main(String argv[]) {

		try {

			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();

			DefaultHandler handler = new DefaultHandler() {

				boolean bTitulo = false;
				boolean bLugar = false;
				boolean bFecha = false;
				boolean bHora = false;

				public void startElement(String uri, String localName, String qName,
						Attributes attributes) throws SAXException {
					if ("cita".equals(qName)) {
						System.out.println("Start Element :" + uri + localName + qName);
					}
					if ("titulo".equals(qName)) {
						bTitulo = true;
					}
					if ("lugar".equals(qName)) {
						bLugar = true;
					}
					if ("fecha".equals(qName)) {
						bFecha = true;
					}
					if ("hora".equals(qName)) {
						bHora = true;
					}

				}

				public void endElement(String uri, String localName,
						String qName) throws SAXException {
					if ("cita".equals(qName)) {
						System.out.println("End Element :" + qName);
					}

				}

				public void characters(char ch[], int start, int length) throws SAXException {

					if (bTitulo) {
						System.out.println("Titulo: " + new String(ch, start, length));
						bTitulo = false;
					}

					if (bLugar) {
						System.out.println("Lugar: " + new String(ch, start, length));
						bLugar = false;
					}

					if (bFecha) {
						System.out.println("Fecha: " + new String(ch, start, length));
						bFecha = false;
					}

					if (bHora) {
						System.out.println("Hora: " + new String(ch, start, length));
						bHora = false;
					}

				}

			};

			saxParser.parse("D:\\xmlTasks\\src\\main\\resources\\xml\\agenda.xml", handler);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
