package org.allselenium.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.allselenium.redmineImpl.RedmineImpl;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class DisableTest implements IAnnotationTransformer {
	public ReadProperty readProperty;
	
	public DisableTest() {
		readProperty = new ReadProperty(System.getProperty("user.dir")+"/TestcaseBugIdMapping.properties");
	}
	
	@Override
	public void transform(ITestAnnotation annotation, Class testClass,
			Constructor testConstructor, Method testMethod) {
		
		/**
		 * Here we can use
		 * 		1. Test method name
		 *  (or)
		 *  	2. Test name attribute available for @Test annotation
		 */
		String bugId = readProperty.getValue(testMethod.getName());
		if(RedmineImpl.isBugValid(bugId)) {
			annotation.setEnabled(false);
		}
	}
	
}
