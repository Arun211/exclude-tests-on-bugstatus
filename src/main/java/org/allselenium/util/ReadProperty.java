package org.allselenium.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperty {

	private Properties properties;
	
	public ReadProperty(String propertiesPath) {
		properties = new Properties();
		try(InputStream inputStream = new FileInputStream(new File(propertiesPath))) {
			properties.load(inputStream);
		}
		catch (IOException ioException) {
			/**
			 * Exception Handling
			 */
		}
	}
	
	public String getValue(String key) {
		String value = null;
		if (properties.containsKey(key)) {
			value = properties.getProperty(key);
		}
		return value;
	}
}
