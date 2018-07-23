package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.TestBase;
import com.util.GenericLibrary;
import com.util.JavascriptLibrary;

public class AssetsPage extends TestBase {

	// Objects Repository(OR):........................................................................
	// Page verification 
	@FindBy(xpath="//a[contains(text(),'Assets')]")
	WebElement assetsLink;
	
	// Create Assets
	@FindBy(xpath=".//*[@id='addAssets']")
	WebElement addAssetsBtn;
	
	@FindBy(xpath=".//*[@id='name']")
	WebElement assetNameTextBox;
	
	@FindBy(xpath=".//*[@id='description']")
	WebElement assetDescrptionTextBox;
	
	@FindBy(xpath=".//*[@id='choiceuser']")
	WebElement assignOwnerBtn;
	
	@FindBy(xpath=".//*[@id='choiceuser']//following::input[5]")
	WebElement ownerSearchBox;
	
	@FindBy(xpath="//strong[text()='John']")
	WebElement johnSmit;
	
	@FindBy(xpath=".//*[@id='Manufacturer']")
	WebElement ManufacturerDropDown;
	
	@FindBy(xpath=".//*[@id='CurrentLocation']")
	WebElement CurrentLocationDropDown;
	
	@FindBy(xpath=".//*[@id='StorageLocation']")
	WebElement StorageLocationDropDown;
	
	@FindBy(xpath=".//*[@id='Type']")
	WebElement TypeDropDown;
	
	@FindBy(xpath=".//*[@id='CalibrationStatus']")
	WebElement CalibrationStatusDropDown;
	
	@FindBy(xpath="//i[@title='Change Date']")
	WebElement DateAcquiredBtn;
	
	@FindBy(xpath=".//*[@id='my-dropzone']")
	WebElement assertImageBrowseBtn;
		
	@FindBy(xpath=".//*[@id='btnSave']")
	WebElement assetSaveBtn;
	
	@FindBy(xpath=".//*[@id='backbtn']")
	WebElement backBtn;
	
	@FindBy(xpath=".//*[@id='searchbox']")
	WebElement assetsSearchBox;
	
	@FindBy(xpath=".//*[@id='search']")
	WebElement assetsSearchBtn;
	
	@FindBy(xpath="//td[text()='VOLT001']")
	WebElement VOLT001;
	
	// Clear Date
	@FindBy(xpath=".//*[@id='dateAcquiredControl']/input")
	WebElement createdDateField;
	
	
	
	
	// Initializing the Page Objects:................................................................
	public AssetsPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:......................................................................................
	public void verify_AssetsPage() {
		GenericLibrary.waitForElementVisibility(driver, assetsLink);
		Assert.assertTrue(assetsLink.isDisplayed(), "Unable to Navigate Asserts Page");
	}

	public void verify_Create_Asset(String name, String description, String ownerName, String manufacturer,	String currentLocation, 
			String storageLocation, String equipementType, String calibrationStatus, String filePath, String assetName) throws Exception {
		Thread.sleep(1000);
		addAssetsBtn.click();
		GenericLibrary.waitForElementVisibility(driver, assetNameTextBox);
		JavascriptLibrary.javascriptType(driver, assetNameTextBox, name);
		JavascriptLibrary.javascriptType(driver, assetDescrptionTextBox, description);
		JavascriptLibrary.javascriptClickElement(driver, assignOwnerBtn);
		GenericLibrary.waitForElementVisibility(driver, ownerSearchBox);
		ownerSearchBox.sendKeys(ownerName);
		GenericLibrary.waitForElementVisibility(driver, johnSmit);
		JavascriptLibrary.javascriptClickElement(driver, johnSmit);
		GenericLibrary.selectElementByVisibleText(ManufacturerDropDown, manufacturer);
		GenericLibrary.selectElementByVisibleText(CurrentLocationDropDown, currentLocation);
		GenericLibrary.selectElementByVisibleText(StorageLocationDropDown, storageLocation);
		GenericLibrary.selectElementByVisibleText(TypeDropDown, equipementType);
		GenericLibrary.selectElementByVisibleText(CalibrationStatusDropDown, calibrationStatus);
		JavascriptLibrary.javascriptClickElement(driver, DateAcquiredBtn);
		List<WebElement> switchToYear = driver.findElements(By.cssSelector(".datepicker-switch"));
		for (WebElement ele : switchToYear) {
			String text = ele.getText();
			if(text.equalsIgnoreCase("2018")) {
				ele.click();
				break;
			}
		}
		List<WebElement> switchToYear2 = driver.findElements(By.cssSelector(".datepicker-switch"));
		for (WebElement ele : switchToYear2) {
			String text = ele.getText();
			if(text.equalsIgnoreCase("2018")) {
				ele.click();
				break;
			}
		}
		List<WebElement> yearsList = driver.findElements(By.cssSelector(".year"));
		for (WebElement ele : yearsList) {
			String text = ele.getText();
			if(text.equalsIgnoreCase("2018")) {
				ele.click();
				break;
			}
		}
		List<WebElement> monthsList = driver.findElements(By.cssSelector(".month"));
		for (WebElement ele : monthsList) {
			String text = ele.getText();
			if(text.equalsIgnoreCase("Jun")) {
				ele.click();
				break;
			}
		}
		List<WebElement> dayList = driver.findElements(By.cssSelector(".day"));
		for (WebElement ele : dayList) {
			String text = ele.getText();
			if(text.equalsIgnoreCase("15")) {
				ele.click();
				break;
			}
		}
		GenericLibrary.uploadFile(assertImageBrowseBtn, filePath);
		JavascriptLibrary.javascriptClickElement(driver, assetSaveBtn);
		GenericLibrary.waitForElementVisibility(driver, assetsSearchBox);
		JavascriptLibrary.javascriptType(driver, assetsSearchBox, assetName);
		JavascriptLibrary.javascriptClickElement(driver, assetsSearchBtn);
		GenericLibrary.waitForElementVisibility(driver, VOLT001);
		Assert.assertTrue(VOLT001.isDisplayed(), "Asset Not Created");
	}
	
	
	
}















