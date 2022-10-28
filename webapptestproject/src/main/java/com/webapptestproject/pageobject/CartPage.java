package com.webapptestproject.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webapptestproject.actiondriver.ActionImpl;
import com.webapptestproject.base.Base;

public class CartPage extends Base {
	
	ActionImpl action = new ActionImpl();
	
	@FindBy(id="group_1")
	private WebElement size;
	@FindBy(id="quantity_wanted")
	private WebElement quantity;
	@FindBy(xpath="//span[normalize-space()='Add to cart']")
	private WebElement addToCartBtn;
	@FindBy(xpath="//*[@id=\"layer_cart\"]//h2/i")
	private WebElement addToCartMessage;
	@FindBy(xpath="//td[@class='cart_unit']/span/span")
	private WebElement productPrice;
	@FindBy(xpath="//span[@id='total_price']")
	private WebElement totalPrice;
	@FindBy(id="total_shipping")
	private WebElement shippingPrice;
	private WebElement deleteProductBtn;
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckoutBtn;
	
	public CartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void validatDeleteBtn() {
		action.click(getDriver(), getDeleteProductBtn());
	}
	
	public SigninPage clickOnCheckoutBtn() {
		action.click(getDriver(), getProceedToCheckoutBtn());
		return new SigninPage();
	}
	
	public boolean validateAddToCartBtn() {
		action.fluentWait(getDriver(), getAddToCartMessage(), 10);
		return action.isDisplayed(getDriver(), getAddToCartMessage());
	}
	
	public void addToCart(String quantity) throws InterruptedException {
	//	action.selectByVisibleText(getSize(), size);
		action.type(getQuantity(), quantity);
		action.click(getDriver(), getAddToCartBtn());
		Thread.sleep(2000);
	}
	
	public OrderSummaryPage goToOrderSummaryPage() throws InterruptedException {
	//	action.selectByVisibleText(getSize(), size);
		String quantity = "4";
		action.type(getQuantity(), quantity);
		action.click(getDriver(), getAddToCartBtn());
		Thread.sleep(2000);
		action.JSClick(getDriver(), getProceedToCheckoutBtn());
		
		return new OrderSummaryPage();
	}
	
	public WebElement getAddToCartMessage() {
		return addToCartMessage;
	}

	public WebElement getAddToCartBtn() {
		return addToCartBtn;
	}

	public WebElement getProductPrice() {
		return productPrice;
	}
	
	public WebElement getTotalPrice() {
		return totalPrice;
	}
	
	public WebElement getShippingPrice() {
		return shippingPrice;
	}

	public WebElement getQuantity() {
		return quantity;
	}

	public WebElement getDeleteProductBtn() {
		return deleteProductBtn;
	}

	public WebElement getProceedToCheckoutBtn() {
		return proceedToCheckoutBtn;
	}

	public WebElement getSize() {
		return size;
	}
	
	
}
