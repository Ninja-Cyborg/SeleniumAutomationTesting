package com.webapptestproject.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webapptestproject.actiondriver.ActionImpl;
import com.webapptestproject.base.Base;

public class OrderConfirmationPage extends Base {
	
	ActionImpl action = new ActionImpl();
	
	@FindBy(className="page-heading")
	private WebElement pageTitle;
	
	@FindBy(xpath="//strong[normalize-space()='Your order on My Store is complete.']")
	private WebElement confirmationText;
	
	@FindBy(xpath="a[title='Back to orders']")
	private WebElement backToOrderBtn;
	
	public OrderConfirmationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void validatePageTitle() {
		action.getTitle(getDriver());
	}
	
	public String validateOrderConfirmation() {
		String message = getConfirmationText().getText();
		return message;
	}
	
	public OrderHistoryPage clickBackToOrderBtn() {
		action.click(getDriver(), getBackToOrderBtn());
		return new OrderHistoryPage();
	}

	public WebElement getConfirmationText() {
		return confirmationText;
	}

	public WebElement getBackToOrderBtn() {
		return backToOrderBtn;
	}

	public WebElement getPageTitle() {
		return pageTitle;
	}
	
}
