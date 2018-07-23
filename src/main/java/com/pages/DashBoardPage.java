package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class DashBoardPage extends TestBase {

	// Objects Repository(OR):........................................................................
	// Home Page Links
	@FindBy(xpath="//span[contains(text(),'Dashboard')]")
	@CacheLookup
	WebElement DashBoard;

	@FindBy(xpath="//span[contains(text(),'Assets')]")
	WebElement Assets;
	
	@FindBy(xpath="//span[contains(text(),'Capture')]")
	WebElement Capture;
	
	@FindBy(xpath="//span[text()='Capture']//following::span[1]")
	WebElement Calibration;
	
	@FindBy(xpath="//span[contains(text(),'Settings')]")
	WebElement Settings;

	// DashBoard
	@FindBy(xpath="//a[contains(text(),'Dashboard')]")
	WebElement dashBoardLink;

	


	// Initializing the Page Objects:................................................................
	public DashBoardPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:......................................................................................
	public String verify_DashBoard_Title(){
		return driver.getTitle();
	}

	public boolean verify_DashBoard(){
		return dashBoardLink.isDisplayed();
	}

	public AssetsPage clickOnAssertsLink() {
		Assets.click();
		return new AssetsPage();
	}

	public CapturePage clickOnCaptureLink() {
		Capture.click();
		return new CapturePage();
	}

	public CalibrationPage clickOnCalibrationlink() {
		Calibration.click();
		return new CalibrationPage();
	}
	
	public SettingsPage clickOnSettingsLink() {
		Settings.click();
		return new SettingsPage();
	}
	
	
}

