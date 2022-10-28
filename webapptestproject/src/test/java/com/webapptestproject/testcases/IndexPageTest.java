package com.webapptestproject.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.webapptestproject.base.Base;
import com.webapptestproject.pageobject.IndexPage;
import com.webapptestproject.utility.Log;

public class IndexPageTest extends Base{
	
	private IndexPage indexPage;
	
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
	public void validateLogo() {
		indexPage = new IndexPage();
		boolean result = indexPage.logoValidation();
		Assert.assertTrue(result);
	}
	
	@Test(groups="Smoke")
	public void validateTitle() {
		Log.testCasestarts("validateTitleTest");
		indexPage = new IndexPage();
		String title = indexPage.getPageTitle();
		String expectedTitle = "My Store";
		Assert.assertEquals(title, expectedTitle);
		Log.testCaseEnds("validateTitleTest");
	}
	
}
