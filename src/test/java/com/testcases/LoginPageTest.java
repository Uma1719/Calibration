package com.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.DashBoardPage;
import com.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	DashBoardPage dashBoard;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}
	
	@Test
	public void LoginPage_TitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "login");
		Reporter.log("LoginPage Title Verified", true);
	}
	
	@Test(dependsOnMethods="LoginPage_TitleTest")
	public void LoginTest() throws Exception{
		dashBoard=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User Loggedin Successfully & Dash Board Page Opened", true);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}
