package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.TestBase;
import com.util.GenericLibrary;
import com.util.JavascriptLibrary;

public class LoginPage extends TestBase{

	// Objects Repository(OR):........................................................................
	@FindBy(id="txtLoginName")
	WebElement username;

	@FindBy(name="password")
	WebElement password;

	@FindBy(id="btnLogin")
	WebElement loginBtn;

	@FindBy(xpath=".//*[@id='btnMainMenuTitle']//preceding::a[20]")
	WebElement menuBtn;

	@FindBy(xpath="//span[text()='Calibration']")
	WebElement Calibration;

	@FindBy(xpath="//span[text()='Dashboard']")
	WebElement dashBoardLink;

	// Initializing the Page Objects:................................................................
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}

	// Actions:......................................................................................
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}

	public DashBoardPage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		JavascriptLibrary.javascriptClickElement(driver, loginBtn);
		GenericLibrary.waitForElementToBeClickable(driver, menuBtn);
		JavascriptLibrary.javascriptClickElement(driver, menuBtn);
		GenericLibrary.waitForElementToBeClickable(driver, Calibration);
		JavascriptLibrary.javascriptClickElement(driver, Calibration);
		Assert.assertTrue(dashBoardLink.isDisplayed());
		return new DashBoardPage();
	}























}
