package com.webapptestproject.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webapptestproject.actiondriver.ActionImpl;
import com.webapptestproject.base.Base;

// ShoppingCartSummaryPage
public class OrderSummaryPage extends Base{
	
	ActionImpl action = new ActionImpl();
	
	@FindBy(xpath="//tr//td//span//span[1]")
	private WebElement productPrice;
	
	@FindBy(xpath="//tr//td//input[@autocomplete='off']")
	private WebElement productQuantity;
	
	@FindBy(xpath="//span[@id='total_price']")
	private WebElement totalPrice;
	
	@FindBy(id="total_shipping")
	private WebElement shippingPrice;
	
	//private WebElement deleteProductBtn;
	
	@FindBy(xpath="//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckoutBtn;
	
	public OrderSummaryPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateTotalPrice() {
		boolean price = false;
		if(getTotalProductPriceValue().equals(getTotalPriceValue())) {
			price = true;
		} else {
			price = false;
		}
		return price;
	}
	
	
	
	public void validateCheckoutBtn() throws InterruptedException {	
		action.JSClick(getDriver(), getProceedToCheckoutBtn());
		}
	
	public AddressPage goToAddressPage() {
		action.JSClick(getDriver(), getProceedToCheckoutBtn());
		return new AddressPage();
	}
	
	
	
	// Helper methods to remove special characters
	public Double getTotalProductPriceValue() {
		String priceValue = getProductPrice().getText();                //$11.00
		String price = priceValue.replaceAll("[^a-zA-Z0-9]", "");  //1100
		Double finalPrice = Double.parseDouble(price) / 100;       //11
		finalPrice = (finalPrice * getProductQuantityValue());
		return finalPrice;
	}

	public Double getTotalPriceValue() {
		String totalPriceValue = getTotalPrice().getText();                       //$11.00
		String totalPrice = totalPriceValue.replaceAll("[^a-zA-Z0-9]", "");  //1100
		Double finalTotalPrice = Double.parseDouble(totalPrice) / 100        //11 
						+ getShippingPriceValue();	
		return finalTotalPrice;
	}
	
	public Double getProductQuantityValue() {
		Double quantity = Double.parseDouble(getProductQuantity().getText());
		return quantity;
	}
	
	public Double getShippingPriceValue() {
		String shipPriceValue = getShippingPrice().getText();                       //$11.00
		String shipPrice = shipPriceValue.replaceAll("[^a-zA-Z0-9]", "");  //1100
		Double finalShipPrice = Double.parseDouble(shipPrice) / 100;       //11
		return finalShipPrice;
	}
	
	public WebElement getProductPrice() {
		return productPrice;
	}

	public WebElement getProductQuantity() {
		return productQuantity;
	}
	
	

	public WebElement getTotalPrice() {
		return totalPrice;
	}

	public WebElement getShippingPrice() {
		return shippingPrice;
	}

	public WebElement getProceedToCheckoutBtn() {
		return proceedToCheckoutBtn;
	}
	
	
	
}
