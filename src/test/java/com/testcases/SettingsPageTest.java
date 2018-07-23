package com.testcases;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.DashBoardPage;
import com.pages.LoginPage;
import com.pages.SettingsPage;
import com.util.TestUtil;

public class SettingsPageTest extends TestBase{
	LoginPage loginPage;
	DashBoardPage dashBoardPage;
	TestUtil testUtil;
	SettingsPage settingsPage;

	public SettingsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		dashBoardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		settingsPage = new SettingsPage();
	}

	@Test
	public void Customs_Fields_Verification_Test() {
		dashBoardPage.clickOnSettingsLink();
		settingsPage.verify_Custom_Fields_Page();
		Reporter.log("Custom Fields Page Verified Successfully",true);
	}
	
	@Test
	public void Control_Units_Verification_Test() {
		dashBoardPage.clickOnSettingsLink();
		settingsPage.verify_Control_Units_Page();
		Reporter.log("Control Units Page Verified Successfully",true);
	}
	
	@Test
	public void User_Permissions_Verification_Test() {
		dashBoardPage.clickOnSettingsLink();
		settingsPage.verify_User_Permissions_Page();
		Reporter.log("User Permissions Page Verified Successfully",true);
	}
	
	@Test
	public void Terms_and_Options_Verification_Test() {
		dashBoardPage.clickOnSettingsLink();
		settingsPage.verify_Terms_and_Options_Page();
		Reporter.log("Terms & Options Page Verified Successfully",true);
	}
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
