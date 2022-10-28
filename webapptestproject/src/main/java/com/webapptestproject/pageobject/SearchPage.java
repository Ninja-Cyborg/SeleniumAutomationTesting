package com.webapptestproject.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webapptestproject.actiondriver.ActionImpl;
import com.webapptestproject.base.Base;

public class SearchPage extends Base {
	
	ActionImpl action = new ActionImpl();
	
	@FindBy(id="search_query_top")
	WebElement searchField;
	@FindBy(xpath="//span[@class='lighter']")
	WebElement searchResultTitle;
	@FindBy(xpath="//*[@id=\"center_column\"]//img")
	WebElement resultList;
	@FindBy(id="selectProductSort")
	WebElement sortByDropDown;
	
	public SearchPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateSearch() {
		if(searchField.getText().equalsIgnoreCase(getSearchResultTitle().getText())) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isProductAvailable() {
		boolean availability = action.isDisplayed(getDriver(), getResultList());
		return availability;
	}
	
	public CartPage clickOnProduct() {
		action.click(getDriver(), getResultList());
		return new CartPage();
	}
	
	public WebElement getSearchField() {
		return searchField;
	}

	public WebElement getSearchResultTitle() {
		return searchResultTitle;
	}

	public WebElement getResultList() {
		return resultList;
	}

	public WebElement getSortByDropDown() {
		return sortByDropDown;
	}
	
}
