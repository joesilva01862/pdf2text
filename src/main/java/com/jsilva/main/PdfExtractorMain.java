package com.jsilva.main;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.jsilva.bean.Property;
import com.jsilva.misc.PDFManager;
import com.jsilva.misc.PropertyManager;
import com.jsilva.misc.WebHostedPdfExtractor;

public class PdfExtractorMain {

	private static void readWithTika(String url) throws IOException {
	    WebHostedPdfExtractor webPagePdfExtractor = new WebHostedPdfExtractor();
	    Map<String, Object> extractedMap = webPagePdfExtractor.processRecord(url);
	    
	    PropertyManager propManager = new PropertyManager((String)extractedMap.get("text"));
	    List<Property> propList = propManager.getPropList();
	    listProperties(propList);
	    
	}
	
	private static void readWithPdfBox(String filename) throws IOException {
		PDFManager pdfManager = new PDFManager(filename);
		List<Property> propList = pdfManager.getPropList();
	    listProperties(propList);
	}
	
	private static void listProperties(List<Property> propList) {
	    for (Property prop : propList ) {
			System.out.print(
					prop.getAddress() + ", " + 
					prop.getValue() + ", " +
					prop.getDate() + ", " +
					prop.getBook() + ", " +
					prop.getPage());
			
			System.out.println("");
	    }
	}
	
	public static void main(String[] args) throws IOException {
		// read with PDFBox
		readWithPdfBox("/home/joe/Downloads/bill12-12.pdf");
		
		// read PDF through Tika
		System.out.println("\n\n\n");
		readWithTika("http://www.lowelldeeds.com/2012DataFiles/2012-12/bill12-12.pdf");
	}

}
