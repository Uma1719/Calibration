package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.TestBase;
import com.util.GenericLibrary;
import com.util.JavascriptLibrary;

public class SettingsPage extends TestBase{
	// Objects Repository(OR):........................................................................
	@FindBy(xpath="//span[text()='Custom Fields']")
	WebElement customFieldsPage;
	
	@FindBy(xpath="//a[contains(text(),'Custom Fields')]")
	WebElement customFieldsLink;
	
	@FindBy(xpath="//span[text()='Control Units']")
	WebElement controlUnitsPage;
	
	@FindBy(xpath="//a[contains(text(),'Control Units')]")
	WebElement controlUnitsLink;
	
	@FindBy(xpath="//span[text()='User Permissions']")
	WebElement userPermissionsPage;
	
	@FindBy(xpath="//a[contains(text(),'User Permissions')]")
	WebElement userPermissionsLink;
	
	@FindBy(xpath="//span[text()='Terms & Options']")
	WebElement termsAndOptionsPage;
	
	@FindBy(xpath="//a[contains(text(),'Terms & Options')]")
	WebElement termsAndOptionsLink;
	
	
	

	// Initializing the Page Objects:................................................................
	public SettingsPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:......................................................................................
	
	public void verify_Custom_Fields_Page() {
		GenericLibrary.waitForElementVisibility(driver, customFieldsPage);
		JavascriptLibrary.javascriptClickElement(driver, customFieldsPage);
		Assert.assertTrue(customFieldsLink.isDisplayed(), "Unable to Navigate Custom Fields Page");
	}
	
	public void verify_Control_Units_Page() {
		GenericLibrary.waitForElementVisibility(driver, controlUnitsPage);
		JavascriptLibrary.javascriptClickElement(driver, controlUnitsPage);
		Assert.assertTrue(controlUnitsLink.isDisplayed(), "Unable to Navigate Control Units Page");
	}
	
	public void verify_User_Permissions_Page() {
		GenericLibrary.waitForElementVisibility(driver, userPermissionsPage);
		JavascriptLibrary.javascriptClickElement(driver, userPermissionsPage);
		Assert.assertTrue(userPermissionsLink.isDisplayed(), "Unable to Navigate User Permissions Page");
	}
	
	public void verify_Terms_and_Options_Page() {
		GenericLibrary.waitForElementVisibility(driver, termsAndOptionsPage);
		JavascriptLibrary.javascriptClickElement(driver, termsAndOptionsPage);
		Assert.assertTrue(termsAndOptionsLink.isDisplayed(), "Unable to Navigate Terms & Options Page");
	}
	
	
	
}
