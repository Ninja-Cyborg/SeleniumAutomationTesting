package com.webapptestproject.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webapptestproject.actiondriver.ActionImpl;
import com.webapptestproject.base.Base;

public class AddressPage extends Base{
	
	ActionImpl action = new ActionImpl();
	
	@FindBy(xpath="//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckoutBtn;
	
	public AddressPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public ShippingPage goToShippingPage() {
		action.JSClick(getDriver(), getProceedToCheckoutBtn());
		return new ShippingPage();
	}

	public WebElement getProceedToCheckoutBtn() {
		return proceedToCheckoutBtn;
	}
	
}
