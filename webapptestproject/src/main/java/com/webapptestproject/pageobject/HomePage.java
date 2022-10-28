package com.webapptestproject.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webapptestproject.actiondriver.ActionImpl;
import com.webapptestproject.base.Base;

public class HomePage extends Base{
	
	ActionImpl action = new ActionImpl();
	
	@FindBy(xpath="//span[normalize-space()='Order history and details']")
	private WebElement orderHistory;
	@FindBy(xpath="//span[normalize-space()='My wishlists']")
	private WebElement wishList;
	@FindBy(xpath="//span[normalize-space()='My personal information']")
	private WebElement personalInformation;
	
	@FindBy(id="search_query_top")
	private WebElement searchField;
	@FindBy(name="submit_search")
	private WebElement searchBtn;
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateOrderHistory() {
		return action.isDisplayed(getDriver(), getOrderHistory());
	}
	
	public boolean validatePersonalInformation() {
		return action.isDisplayed(getDriver(), getPersonalInformation());
	}
	
	public boolean validateWishList() {
		return action.isDisplayed(getDriver(), getWishList());
	}
	
	public String getCurrentUrl() {
		return action.getCurrentURL(getDriver());
	}
	
	public SearchPage searchProduct(String productName) throws InterruptedException {
		action.type(getSearchField(), productName);
		action.scrollByVisibilityOfElement(getDriver(), getSearchBtn());
		action.click(getDriver(), getSearchBtn());
		Thread.sleep(3000);
		return new SearchPage();
	}
	
	

	public WebElement getSearchField() {
		return searchField;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getOrderHistory() {
		return orderHistory;
	}

	public WebElement getWishList() {
		return wishList;
	}

	public WebElement getPersonalInformation() {
		return personalInformation;
	}
	
}
