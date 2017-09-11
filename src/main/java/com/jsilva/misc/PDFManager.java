package com.jsilva.misc;


import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import com.jsilva.bean.Property;

public class PDFManager {
	private String filePath;

	public PDFManager(String filePath) {
		this.filePath = filePath;
	}
	
	public List<Property> getPropList() throws IOException {
		File file = new File(filePath);
		PDFParser parser = new PDFParser(new RandomAccessFile(file,"r")); // update for PDFBox V 2.0

		parser.parse();
		COSDocument cosDoc = parser.getDocument();
		PDFTextStripper pdfStripper = new PDFTextStripper();
		PDDocument pdDoc = new PDDocument(cosDoc);
		pdDoc.getNumberOfPages();
		pdfStripper.setStartPage(1);
		//pdfStripper.setEndPage(10);
		pdfStripper.setEndPage(pdDoc.getNumberOfPages());
		String text = pdfStripper.getText(pdDoc);

		// get a list of properties in the PDF file
	    PropertyManager propManager = new PropertyManager(text);
	    List<Property> propList = propManager.getPropList();

		return propList;
	}
}