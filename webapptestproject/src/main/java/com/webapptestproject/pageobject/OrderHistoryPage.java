package com.webapptestproject.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webapptestproject.actiondriver.ActionImpl;
import com.webapptestproject.base.Base;

public class OrderHistoryPage extends Base {
	
	ActionImpl action;
	
	@FindBy(xpath=".page-heading.bottom-indent")
	private WebElement pageTitle;
	@FindBy(xpath="//span[normalize-space()='Back to your account.']")
	private WebElement backToAccountBtn;
	@FindBy(xpath="//span[normalize-space()='Home']")
	private WebElement HomeBtn;
	
	public void OrderHistroyPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public HomePage clickBackToAccountBtn() {
		action.click(getDriver(), backToAccountBtn);
		return new HomePage();
	}
	
	public IndexPage clickHomeBtn() {
	action.click(getDriver(), HomeBtn);
	return new IndexPage();
	}
	
}
