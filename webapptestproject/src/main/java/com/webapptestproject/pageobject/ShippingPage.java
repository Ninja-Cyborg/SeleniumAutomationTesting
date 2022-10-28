package com.webapptestproject.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webapptestproject.actiondriver.ActionImpl;
import com.webapptestproject.base.Base;

public class ShippingPage extends Base {
	
	ActionImpl action = new ActionImpl();
	
	@FindBy(xpath="//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckoutBtn;
	@FindBy(xpath="//label[@for='cgv']")
	private WebElement termConditionsCheck;
	
	public ShippingPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public ShippingPage clickOnCheckoutBtn() {
		action.JSClick(getDriver(), getProceedToCheckoutBtn());
		return new ShippingPage();
	}
	
	public void validateTermsAndConditions() {
		action.JSClick(getDriver(), getTermConditionsCheck());
	}
	
	public PaymentPage goToPaymentPage() throws InterruptedException {
		action.JSClick(getDriver(), getTermConditionsCheck());
		Thread.sleep(2000);
		action.JSClick(getDriver(), getProceedToCheckoutBtn());
		return new PaymentPage();
	}

	public WebElement getProceedToCheckoutBtn() {
		return proceedToCheckoutBtn;
	}

	public WebElement getTermConditionsCheck() {
		return termConditionsCheck;
	}
	
}
