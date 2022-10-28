package com.webapptestproject.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webapptestproject.actiondriver.ActionImpl;
import com.webapptestproject.base.Base;

public class PaymentPage extends Base {

	ActionImpl action = new ActionImpl();
	
	@FindBy(xpath="//a[@title='Pay by bank wire']")
	private WebElement payByBankWire;
	@FindBy(xpath="a[title='Pay by check.']")
	private WebElement payByCheque;
	@FindBy(xpath="//span[normalize-space()='I confirm my order']")
	private WebElement confirmOrderBtn;
	
	public PaymentPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public OrderConfirmationPage clickPayByBankWire() throws InterruptedException {
		action.JSClick(getDriver(), getPayByBankWire());
		Thread.sleep(3000);
		action.JSClick(getDriver(), getConfirmOrderBtn());
		return new OrderConfirmationPage();
	}
	
	public OrderConfirmationPage clickPayByCheque() {
		action.JSClick(getDriver(), getPayByCheque());
		return new OrderConfirmationPage();
	}

	public WebElement getPayByBankWire() {
		return payByBankWire;
	}

	public WebElement getPayByCheque() {
		return payByCheque;
	}

	public WebElement getConfirmOrderBtn() {
		return confirmOrderBtn;
	}
	
	
}
