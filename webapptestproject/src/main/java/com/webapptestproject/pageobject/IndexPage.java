package com.webapptestproject.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webapptestproject.actiondriver.Action;
import com.webapptestproject.actiondriver.ActionImpl;
import com.webapptestproject.base.Base;


public class IndexPage extends Base{
	
	ActionImpl action = new ActionImpl();
	
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	private WebElement signinLink;
	@FindBy(xpath="(//img[@class='logo img-responsive'])")
	private WebElement pageLogo;
	@FindBy(id="search_query_top")
	private WebElement searchField;
	@FindBy(name="submit_search")
	private WebElement searchBtn;
	@FindBy(xpath="//a[@title='Contact Us']")
	private WebElement contactUsLink;
	@FindBy(xpath="//a[@title='View my shopping cart']")
	private WebElement cartLink;
	
	public IndexPage() {
		PageFactory.initElements(Base.getDriver(), this);
	}
	
	public SigninPage clickOnSigin() {
		action.fluentWait(getDriver(), getSigninLink(), 10);
		action.click(getDriver(), getSigninLink());
		return new SigninPage();
	}
	
	public ContactUsPage clickOnContactUs() {
		action.fluentWait(getDriver(), getContactUsLink(), 10);
		action.click(getDriver(), getContactUsLink());
		return new ContactUsPage();
	}
	
	public boolean logoValidation() {
		return action.isDisplayed(getDriver(), getPageLogo());
	}
	
	public String getPageTitle() {
		String title = action.getTitle(getDriver());
		return title;
	}
	
	public SearchPage searchProduct(String productName) throws InterruptedException {
		action.type(getSearchField(), productName);
		action.scrollByVisibilityOfElement(getDriver(), getSearchBtn());
		action.click(getDriver(), getSearchBtn());
		Thread.sleep(3000);
		return new SearchPage();
	}
	
	// write new working
	public CartPage clickOnCart() {
		action.click(getDriver(), getCartLink());
		return new CartPage();
	}

	public ActionImpl getAction() {
		return action;
	}

	public WebElement getSigninLink() {
		return signinLink;
	}

	public WebElement getPageLogo() {
		return pageLogo;
	}

	public WebElement getSearchField() {
		return searchField;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getContactUsLink() {
		return contactUsLink;
	}

	public WebElement getCartLink() {
		return cartLink;
	}
	
	
	
}
