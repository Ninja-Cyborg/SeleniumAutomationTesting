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
import com.webapptestproject.pageobject.SearchPage;
import com.webapptestproject.pageobject.SigninPage;
import com.webapptestproject.utility.Log;

public class SearchPageTest extends Base{
	
	private IndexPage indexPage;
	private SigninPage signinPage;
	private HomePage homePage;
	private SearchPage searchPage ;
	
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
	//, dataProvider = "searchProduct", dataProviderClass = DataProviders.class)
	public void validateSearchTest() throws InterruptedException {
		Log.testCasestarts("validateSearchTest");
		indexPage = new IndexPage();
		String productName = "shirt";
		searchPage = indexPage.searchProduct(productName);
		Thread.sleep(2000);
		boolean result = searchPage.validateSearch();
		Assert.assertTrue(result);
		Log.testCaseEnds("validateSearchTest");
	}
	
	@Test(groups="Smoke")
	//, dataProvider = "searchProduct", dataProviderClass = DataProviders.class)
	public void verifyProductAvailability() throws InterruptedException {
		Log.testCasestarts("verifyProductAvailability");
		indexPage = new IndexPage();
		String productName = "shirt";
		searchPage = indexPage.searchProduct(productName);
		Log.info("showing search for product: " + productName);
		boolean result = searchPage.isProductAvailable();
		Assert.assertTrue(result);
		Log.testCaseEnds("verifyProductAvailability");
	}
	
}
