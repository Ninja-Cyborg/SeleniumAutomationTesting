package com.webapptestproject.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.webapptestproject.base.Base;
import com.webapptestproject.dataprovider.DataProviders;
import com.webapptestproject.pageobject.CartPage;
import com.webapptestproject.pageobject.IndexPage;
import com.webapptestproject.pageobject.OrderSummaryPage;
import com.webapptestproject.pageobject.SearchPage;
import com.webapptestproject.utility.Log;

// OrderSummary > signIn > address > shipping > confirmation
public class OrderPageTest extends Base{
	private IndexPage indexPage;
	private SearchPage searchPage ;
	private CartPage cartPage;
	private OrderSummaryPage orderSummaryPage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke", "Sanity", "Regression"})
	public void setup(String browser) {
		loadWebapp(browser);
	}
	
	@AfterMethod(groups= {"Smoke", "Sanity", "Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups="Regression")
	//, dataProvider = "getProduct", dataProviderClass = DataProviders.class) String productName, String quantity, String size
	public void validateTotalPriceTest() throws InterruptedException {
		Log.testCasestarts("validateTotalPriceTest");
		indexPage= new IndexPage();
		String productName = "dress";
		String size = "S";
		String quantity = "4";
		searchPage = indexPage.searchProduct(productName);
		cartPage = searchPage.clickOnProduct();
		Log.info("Added Product to cart");
		orderSummaryPage = cartPage.goToOrderSummaryPage();
		Thread.sleep(2000);
		boolean result = orderSummaryPage.validateTotalPrice();
		Assert.assertTrue(result);
		Log.testCaseEnds("validateTotalPriceTest()");
	}
	
}
