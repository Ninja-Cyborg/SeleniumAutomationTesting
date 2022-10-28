package com.webapptestproject.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webapptestproject.actiondriver.ActionImpl;
import com.webapptestproject.base.Base;

public class SigninPage extends Base {
	
	ActionImpl action = new ActionImpl();
	
	@FindBy(id="email_create")
	private WebElement createAccountEmail;
	@FindBy(xpath="//span[normalize-space()='Create an account']")
	private WebElement createAccountBtn;
	
	@FindBy(xpath="//*[@id=\"email\"]")
	private WebElement loginEmail;
	@FindBy(id="passwd")
	private WebElement loginPassword;
	
	@FindBy(xpath="//span[normalize-space()='Sign in']")
	private WebElement signinButton;
	@FindBy(xpath="//a[normalize-space()='Forgot your password?']")
	private WebElement forgotpasswordLink;
	
	public SigninPage() {
		PageFactory.initElements(Base.getDriver(), this);
	}
	
	// create Account
	public CreateAccountPage createAccount(String email) {
		action.type(this.createAccountEmail, email);
		action.click(getDriver(), getCreateAccountBtn());
		return new CreateAccountPage();
	}
	
	// login account
	public HomePage login(String username, String password) throws InterruptedException {
		Thread.sleep(2000);
		action.scrollByVisibilityOfElement(getDriver(), loginEmail);
		Thread.sleep(3000);
		action.type(getLoginEmail(), username);
		action.type(getLoginPassword(), password);
		action.click(getDriver(), getSigninButton());
		return new HomePage();
	}
	
	// login in order checkout window 
	public AddressPage loginOnOrderPage(String username, String password) {	
		action.type(getLoginEmail(), username);
		action.type(getLoginPassword(), password);
		return new AddressPage();
	}
	
	public void forgetLink() {
		action.click(getDriver(), getForgotpasswordLink());
	}

	public WebElement getCreateAccountEmail() {
		return createAccountEmail;
	}

	public WebElement getCreateAccountBtn() {
		return createAccountBtn;
	}

	public WebElement getLoginEmail() {
		return loginEmail;
	}

	public WebElement getLoginPassword() {
		return loginPassword;
	}

	public WebElement getSigninButton() {
		return signinButton;
	}

	public WebElement getForgotpasswordLink() {
		return forgotpasswordLink;
	}
	
	
}
