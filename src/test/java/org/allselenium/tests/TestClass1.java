package org.allselenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass1 {
	
	@Test
	public void sampleTest1() {
		int number = 9;
		Assert.assertTrue((3*3) == number, "Calculation mismatch.");
	}
	
	@Test
	public void sampleTest2() {
		int number = 12;
		Assert.assertTrue((3*3) == number, "Calculation mismatch.");
	}
	
	@Test
	public void sampleTest3() {
		int number = 12;
		Assert.assertTrue((3*4) == number, "Calculation mismatch.");
	}
}
