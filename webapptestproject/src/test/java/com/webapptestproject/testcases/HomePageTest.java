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

public class HomePageTest extends Base {
	
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

	@Test(groups="Smoke")
	//, dataProvider = "credentials", dataProviderClass = DataProviders.class) String username, String password
	public void wishlistTest() throws InterruptedException{
		Log.testCasestarts("wishListTest");
		indexPage = new IndexPage();
		signinPage = indexPage.clickOnSigin();
		homePage = signinPage.login(prop.getProperty("username"), prop.getProperty("password"));
	//	homePage = signinPage.login(username, password);
		boolean result = homePage.validateWishList();
		Assert.assertTrue(result);
		Log.info("Wish List page visit successful");
		Log.testCaseEnds("wishListTest");
	}
	
	@Test(groups="Smoke")
	//, dataProvider = "credentials", dataProviderClass = DataProviders.class) String username, String password
	public void orderHistoryTest() throws InterruptedException{
		Log.testCasestarts("OrderHistoryTest");
		indexPage = new IndexPage();
		signinPage = indexPage.clickOnSigin();
		homePage = signinPage.login(prop.getProperty("username"), prop.getProperty("password"));
	//	homePage = signinPage.login(username, password);
		boolean result = homePage.validateOrderHistory();
		Assert.assertTrue(result);
		Log.info("Order History page visit successful");
		Log.testCaseEnds("OrderHistoryTest");
	}
	
	@Test(groups="Smoke")
	// , dataProvider = "credentials", dataProviderClass = DataProviders.class) String username, String password
	public void personalInformationTest() throws InterruptedException{
		Log.testCasestarts("PersonalInformationtest");
		indexPage = new IndexPage();
		signinPage = indexPage.clickOnSigin();
		homePage = signinPage.login(prop.getProperty("username"), prop.getProperty("password"));
	//	homePage = signinPage.login(username, password);
		boolean result = homePage.validatePersonalInformation();
		Assert.assertTrue(result);
		Log.info("Personal Infomation page visit successful");
		Log.testCaseEnds("PersonalInfoTest");
	}
	
	@Test(groups="Smoke")
	//,dataProvider = "credentials", dataProviderClass = DataProviders.class) String username, String password
	public void currentUrlTest() throws InterruptedException {
		Log.testCaseEnds("currentUrlTest");
		indexPage = new IndexPage();
		signinPage = indexPage.clickOnSigin();
		homePage = signinPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Log.info("User enters credentails");
	//	homePage = signinPage.login(username, password);
		String currentUrl = homePage.getCurrentUrl();
		String expectedUrl = "http://automationpractice.com/index.php?controller=my-account";
		Assert.assertEquals(currentUrl, expectedUrl);
		Log.info("Homepage Login successful");
		Log.testCaseEnds("CurrentUrlTest");
	}
	
}
