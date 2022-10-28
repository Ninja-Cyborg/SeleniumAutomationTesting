package com.webapptestproject.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.webapptestproject.base.Base;
import com.webapptestproject.dataprovider.DataProviders;
import com.webapptestproject.pageobject.CartPage;
import com.webapptestproject.pageobject.HomePage;
import com.webapptestproject.pageobject.IndexPage;
import com.webapptestproject.pageobject.SearchPage;
import com.webapptestproject.pageobject.SigninPage;
import com.webapptestproject.utility.Log;

public class CartPageTest extends Base{
	
	private IndexPage indexPage;
	private SearchPage searchPage ;
	private CartPage cartPage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke", "Sanity", "Regression"})
	public void setup(String browser) {
		loadWebapp(browser);
	}
	
	@AfterMethod(groups= {"Smoke", "Sanity", "Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups={"Regression","Sanity"})
	//, dataProvider = "getProduct", dataProviderClass = DataProviders.class) String productName, String quantity, String size
	public void addToCartTest() throws InterruptedException {
		Log.testCasestarts("addToCartTest");
		indexPage= new IndexPage();
		String productName = "dress";
		String size = "S";
		String quantity = "4";
		searchPage = indexPage.searchProduct(productName);
		cartPage = searchPage.clickOnProduct();
		cartPage.addToCart(quantity);
		Log.info("product size, quantity selected");
		boolean result = cartPage.validateAddToCartBtn();
		Assert.assertTrue(result);
		Log.testCaseEnds("addToCartTest");
	}
	
}
