package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.TestBase;
import com.util.GenericLibrary;

public class CapturePage extends TestBase {

	// Objects Repository(OR):........................................................................
	// Page verification
	@FindBy(xpath="//a[contains(text(),'Capture')]")
	WebElement captureLink;

	
	
	

	// Initializing the Page Objects:................................................................
	public CapturePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:......................................................................................

	public void verify_CapturePage() {
		GenericLibrary.waitForElementVisibility(driver, captureLink);
		Assert.assertTrue(captureLink.isDisplayed(), "Unable to Navigate Capture Page");
	}

	
}















