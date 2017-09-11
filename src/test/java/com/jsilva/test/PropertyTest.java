package com.jsilva.test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.jsilva.bean.Property;
import com.jsilva.misc.PropertyManager;
import com.jsilva.misc.WebHostedPdfExtractor;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for Property object read from the PDF
 */
public class PropertyTest extends TestCase {
	private final static String PDF_URL = "http://www.lowelldeeds.com/2012DataFiles/2012-12/bill12-12.pdf";
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PropertyTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( PropertyTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testProperty() {
	    WebHostedPdfExtractor webPagePdfExtractor = new WebHostedPdfExtractor();
	    Map<String, Object> extractedMap = webPagePdfExtractor.processRecord(PDF_URL);
	    PropertyManager propManager = new PropertyManager((String)extractedMap.get("text"));
	    List<Property> propList = null;
		try {
			propList = propManager.getPropList();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
        assertTrue( propList != null );
        
        // build a property we know must be in the list
        // 57 TREBLE COVE RD, 220,000, 9/12/2012, 26406, 213
        Property expProperty = new Property();
        expProperty.setAddress("57 TREBLE COVE RD");
        expProperty.setValue("220,000");
        expProperty.setDate("9/12/2012");
        expProperty.setBook("26406");
        expProperty.setPage("213");
        
        // verify that that property is in the list of extracted properties
        assertTrue( propList.contains(expProperty));
    }
    
}
