package com.jsilva.misc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.jsilva.bean.Property;

public class PropertyManager {
	private String text;
	
	public PropertyManager(String text) {
		this.text = text;
	}
	
	public List<Property> getPropList() throws IOException {
		// break text into lines
		StringTokenizer st = new StringTokenizer(text, "\n");
		List<Property> list = new ArrayList<Property>();
		while (st.hasMoreTokens()) {
			String line = st.nextToken();
			//System.out.println(line);
			Property prop = getProperty(line);
			if (prop.getAddress() != null && prop.getBook() != null && prop.getValue() != null) {
				list.add(prop);
			}
		}
		return list;
	}

	private Property getProperty(String string) {
		List<String> list = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(string);
		
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			list.add(token);
		}
		
		StringBuilder sb = new StringBuilder();
		Property prop = new Property();
		int i = 0;
		
		for (String str : list) {
			if (str.endsWith("$")) {
				prop.setAddress(sb.toString().trim());
				prop.setValue(str.substring(0, str.length()-1)); 
				prop.setDate(list.get(i+1).trim());
				prop.setBook(list.get(i+2).trim());
				prop.setPage(list.get(i+3).trim());
				break;
			}
			sb.append(str+" ");
			i++;
		}
		
		return prop;
	}
	

}
