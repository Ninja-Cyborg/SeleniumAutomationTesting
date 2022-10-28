package com.webapptestproject.testcases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.webapptestproject.base.Base;
import com.webapptestproject.dataprovider.DataProviders;
import com.webapptestproject.pageobject.CreateAccountPage;
import com.webapptestproject.pageobject.HomePage;
import com.webapptestproject.pageobject.IndexPage;
import com.webapptestproject.pageobject.SigninPage;
import com.webapptestproject.utility.Log;

public class CreateAccountPageTest extends Base{
	
	private IndexPage indexPage;
	private SigninPage signinPage;
	private HomePage homePage;
	private CreateAccountPage createAccountPage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke", "Sanity", "Regression"})
	public void setup(String browser) {
		loadWebapp(browser);
	}
	
	@AfterMethod(groups= {"Smoke", "Sanity", "Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups="Sanity",dataProvider = "email", dataProviderClass = DataProviders.class)
	public void verifyAccountPageTest(String email) {
		Log.testCasestarts("verifyAccountPageTest");
		indexPage = new IndexPage();
		signinPage = indexPage.clickOnSigin();
		createAccountPage = signinPage.createAccount(email);
		boolean result = createAccountPage.validateCreateAccountPage();
		Assert.assertTrue(result);
		Log.info("adding email success");
		Log.testCaseEnds("verifyAccountPageTest");
	}
	
	@Test(dataProvider = "email", dataProviderClass = DataProviders.class)
	public void createAccount(HashMap<String, String> hashMap) {
		Log.testCasestarts("createAccount");
		indexPage = new IndexPage();
		signinPage = indexPage.clickOnSigin();
		createAccountPage = signinPage.createAccount(hashMap.get("email"));
		Log.info("adding information in fields");
		createAccountPage.createAccountInformation(hashMap.get("title"),
				hashMap.get("firstname"), 
				hashMap.get("lastname"), 
				hashMap.get("email"), 
				hashMap.get("password"), 
				hashMap.get("day"), 
				hashMap.get("month"), 
				hashMap.get("year"), 
				hashMap.get("newsLetterSignup"), 
				hashMap.get("company"), 
				hashMap.get("address"), 
				hashMap.get("city"), 
				hashMap.get("state"), 
				hashMap.get("postalCode"), 
				hashMap.get("country"), 
				hashMap.get("mobilePhone"));
		homePage = createAccountPage.validateAccountRegistration(); 
		String currentUrl = homePage.getCurrentUrl();
		String expectedUrl = "http://automationpractice.com/index.php?controller=my-account";  // successful login
		Assert.assertEquals(currentUrl, expectedUrl);
		Log.info("Created Account with email:" + hashMap.get("email"));
		Log.testCaseEnds("createAccountTest");
	}
	
	
}
