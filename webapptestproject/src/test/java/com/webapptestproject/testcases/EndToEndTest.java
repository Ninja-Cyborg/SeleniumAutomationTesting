package com.webapptestproject.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.webapptestproject.base.Base;
import com.webapptestproject.dataprovider.DataProviders;
import com.webapptestproject.pageobject.AddressPage;
import com.webapptestproject.pageobject.CartPage;
import com.webapptestproject.pageobject.HomePage;
import com.webapptestproject.pageobject.IndexPage;
import com.webapptestproject.pageobject.OrderConfirmationPage;
import com.webapptestproject.pageobject.OrderSummaryPage;
import com.webapptestproject.pageobject.PaymentPage;
import com.webapptestproject.pageobject.SearchPage;
import com.webapptestproject.pageobject.ShippingPage;
import com.webapptestproject.pageobject.SigninPage;
import com.webapptestproject.utility.Log;

// Signin to OrderPlacement with Payment
public class EndToEndTest  extends Base{

	private IndexPage indexPage;
	private SearchPage searchPage;
	private SigninPage signinPage;
	private HomePage homePage;
	private CartPage cartPage;
	private OrderSummaryPage orderSummaryPage;
	private AddressPage addressPage;
	private ShippingPage shippingPage;
	private PaymentPage paymentPage;
	private OrderConfirmationPage orderConfirmationPage;
	
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
	public void validateCheckoutTest() throws InterruptedException {
		Log.testCasestarts("validateCheckoutTest");
		String productName = "shirt";
		String quantity = "3";
		indexPage= new IndexPage();
		signinPage = indexPage.clickOnSigin();
		Thread.sleep(3000);
		Log.info("User enter Credentials");
		homePage = signinPage.login(prop.getProperty("username"), prop.getProperty("password"));
		searchPage = homePage.searchProduct(productName);
		cartPage = searchPage.clickOnProduct();
		cartPage.addToCart(quantity);
		Log.info("User add product to cart");
		orderSummaryPage = cartPage.goToOrderSummaryPage();		
		addressPage= orderSummaryPage.goToAddressPage();
		shippingPage = addressPage.goToShippingPage();
		paymentPage = shippingPage.goToPaymentPage();	
		orderConfirmationPage = paymentPage.clickPayByBankWire();
		Log.info("User place order");
		String shownMessage = orderConfirmationPage.validateOrderConfirmation();
		String expectedMessage = "Your order on My Store is complete.";		
		Assert.assertEquals(shownMessage, expectedMessage);
		Log.testCaseEnds("validateCheckoutTest");
	}
}
