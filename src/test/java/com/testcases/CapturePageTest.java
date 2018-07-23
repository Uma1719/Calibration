package com.testcases;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.CapturePage;
import com.pages.DashBoardPage;
import com.pages.LoginPage;
import com.util.TestUtil;

public class CapturePageTest extends TestBase{
	LoginPage loginPage;
	DashBoardPage dashBoardPage;
	TestUtil testUtil;
	CapturePage capturePage;

	public CapturePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		dashBoardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		capturePage= new CapturePage();
	}

	@Test
	public void CapturePage_Verification_Test() {
		dashBoardPage.clickOnCaptureLink();
		capturePage.verify_CapturePage();
		Reporter.log("Capture Page Verified Successfully",true);
	}

	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
