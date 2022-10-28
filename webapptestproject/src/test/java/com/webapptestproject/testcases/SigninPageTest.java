package com.webapptestproject.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.webapptestproject.base.Base;
import com.webapptestproject.dataprovider.DataProviders;
import com.webapptestproject.pageobject.HomePage;
import com.webapptestproject.pageobject.IndexPage;
import com.webapptestproject.pageobject.SigninPage;
import com.webapptestproject.utility.Log;

public class SigninPageTest extends Base{
	
	private IndexPage indexPage;
	private SigninPage signinPage;
	private HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke", "Sanity", "Regression"})
	public void setup(String browser) {
		loadWebapp(browser);
	}
	
	@AfterMethod(groups= {"Smoke", "Sanity", "Regression"})
	public void tearDown() {
		getDriver().quit();
	}

	@Test(groups= {"Smoke", "Sanity"})
	// , dataProvider="credentials", dataProviderClass=DataProviders.class) String username, String password
	public void validateLoginTest() throws InterruptedException{
		Log.testCasestarts("validateLoginTest");
		indexPage = new IndexPage();
		signinPage = indexPage.clickOnSigin();
		Thread.sleep(5000);
		Log.info("User enters credentials");
		homePage = signinPage.login(prop.getProperty("username"), prop.getProperty("password"));
		//homePage = signinPage.login(username, password);
		Thread.sleep(5000);
		String currentUrl = homePage.getCurrentUrl();
		String expectedUrl = "http://automationpractice.com/index.php?controller=my-account";  // successful login
		Assert.assertEquals(currentUrl, expectedUrl);
		Log.info("Login Successful");
		Log.testCaseEnds("validateLoginTest");
	}
	
}
