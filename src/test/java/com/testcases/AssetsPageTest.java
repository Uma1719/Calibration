package com.testcases;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.AssetsPage;
import com.pages.DashBoardPage;
import com.pages.LoginPage;
import com.util.TestUtil;

public class AssetsPageTest extends TestBase {
	LoginPage loginPage;
	DashBoardPage dashBoardPage;
	TestUtil testUtil;
	AssetsPage assertsPage;

	public AssetsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		dashBoardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		assertsPage= new AssetsPage();
	}

	@Test
	public void AssetsPage_Verification_Test() {
		dashBoardPage.clickOnAssertsLink();
		assertsPage.verify_AssetsPage();
		Reporter.log("Assets Page Verified Successfully",true);
	}

	@Test(dependsOnMethods="AssetsPage_Verification_Test")
	public void Create_Asset_Test() throws Exception {
		dashBoardPage.clickOnAssertsLink();
		assertsPage.verify_Create_Asset("VOLT001", "0-25V/5A Digital Voltmeter ", "John", "Hewlett Packard", "Standards Shop", "Gauge Stores", 
				"Voltimeters", "Calibrated", "D:\\Value chain\\Images\\test.jpeg", "VOLT001");
	}

	@Test(dependsOnMethods="AssetsPage_Verification_Test")
	public void Clear_Date_Test() throws Exception {
		dashBoardPage.clickOnAssertsLink();
		assertsPage.verify_Create_Asset("VOLT002", "0-25V/5A Digital Voltmeter ", "John", "Hewlett Packard", "Standards Shop", "Gauge Stores", 
				"Voltimeters", "Calibrated", "D:\\Value chain\\Images\\test.jpeg", "VOLT001");
	}




	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
