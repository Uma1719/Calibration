package com.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.DashBoardPage;
import com.pages.LoginPage;
import com.util.TestUtil;

public class DashBoardPageTest extends TestBase {
	LoginPage loginPage;
	DashBoardPage dashBoardPage;
	TestUtil testUtil;

	public DashBoardPageTest() {
		super();
	}

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		dashBoardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void Verify_DashBoardPage_Title_Test(){
		String dashBoardTitle = dashBoardPage.verify_DashBoard_Title();
		Assert.assertEquals(dashBoardTitle, "A2Z Calibration","DashBoard page title not matched");
		Reporter.log("Title Verified - Test PASS", true);
	}
	
	@Test(dependsOnMethods="Verify_DashBoardPage_Title_Test")
	public void Verify_DashBoardPage_Test(){
		Assert.assertTrue(dashBoardPage.verify_DashBoard(), "Dashboard Page Not Present - Test FAIL");
		Reporter.log("DashBoard Page Verified - Test PASS", true);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}
