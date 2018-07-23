package com.testcases;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.CalibrationPage;
import com.pages.DashBoardPage;
import com.pages.LoginPage;
import com.util.TestUtil;

public class CalibrationPageTest extends TestBase{
	LoginPage loginPage;
	DashBoardPage dashBoardPage;
	TestUtil testUtil;
	CalibrationPage calibrationPage;

	public CalibrationPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		dashBoardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		calibrationPage= new CalibrationPage();
	}

	@Test
	public void CalibrationPage_Verification_Test() throws Exception {
		dashBoardPage.clickOnCalibrationlink();
		calibrationPage.verify_CalibrationPage();
		Reporter.log("Calibration Page Verified Successfully",true);
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
