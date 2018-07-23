package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.TestBase;

public class CalibrationPage extends TestBase {

	// Objects Repository(OR):........................................................................
	// Page verification
	@FindBy(xpath="//a[contains(text(),'Calibration')]")
	WebElement calibrationLink;
	
	
	

	// Initializing the Page Objects:................................................................
	public CalibrationPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:......................................................................................
	public void verify_CalibrationPage() {
		Assert.assertTrue(calibrationLink.isDisplayed(), "Unable to Navigate Calibration Page");
	}

	
}












