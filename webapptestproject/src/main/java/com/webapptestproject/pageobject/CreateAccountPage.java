package com.webapptestproject.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webapptestproject.actiondriver.ActionImpl;
import com.webapptestproject.base.Base;

public class CreateAccountPage extends Base {
	
	ActionImpl action = new ActionImpl();
	
	@FindBy(xpath="//h1[normalize-space()='Create an account']")
	private WebElement formTitle;
	// personal Information form
	@FindBy(id="id_gender1")
	private WebElement titleMr;
	@FindBy(id="id_gender2")
	private WebElement titleMrs;
	@FindBy(id="customer_firstname")
	private WebElement firstname;
	@FindBy(id="customer_firstname")
	private WebElement lastname;
	@FindBy(id="email")
	private WebElement email;
	@FindBy(id="passwd")
	private WebElement password;
	@FindBy(id="days")
	private WebElement day;
	@FindBy(id="uniform_months")
	private WebElement month;
	@FindBy(id="uniform_years")
	private WebElement year;
	@FindBy(id="uniform_newsletter")
	private WebElement newLetterSignup;
	
	public CreateAccountPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	//address information form
	@FindBy(id="firstname")
	private WebElement firstnameAddressForm;
	@FindBy(id="lastname")
	private WebElement lastnameAddressForm;
	@FindBy(id="company")
	private WebElement company;
	@FindBy(id="address1")
	private WebElement address;
	@FindBy(id="city")
	private WebElement city;
	@FindBy(id="state")
	private WebElement state;
	@FindBy(id="postcode")
	private WebElement postalCode;
	@FindBy(id="id_country")
	private WebElement country;
	@FindBy(id="other")
	private WebElement additionalInformation;
	@FindBy(id="phone")
	private WebElement homePhone;
	@FindBy(id="phone_mobile")
	private WebElement mobilePhone;
	@FindBy(id="alias")
	private WebElement addressAlias;
	@FindBy(xpath="//span[normalize-space()='Register']")
	private WebElement registerButton;
	
	
	
	public void createAccountInformation(String title, 
						String firstname, 
						String lastname, 
						String email,
						String password, 
						String day, 
						String month, 
						String year, 
						String newLetterSignup,
						String company,
						String address, 
						String city, 
						String state,
						String postalCode,
						String country, 
						String mobilePhone) {
		
		if(title.equals("Mr")) {
			action.click(getDriver(), getTitleMr());
		} else {
			action.click(getDriver(), getTitleMrs());
		}
		action.type(this.firstname, firstname);
		action.type(this.lastname, lastname);
		action.type(this.email, email);
		action.selectByValue(this.day, day);
		action.selectByValue(this.month, month);
		action.selectByValue(this.year, year);
		// select checkbox method for newsLetter
		action.type(this.company, company);
		action.type(this.address, address);
		action.type(this.city, city);
		action.selectByVisibleText(this.state, state);
		action.type(this.postalCode, postalCode);
		action.selectByVisibleText(this.country, country);
		action.type(this.mobilePhone, mobilePhone);
	
	}
	
	public HomePage validateAccountRegistration() {
		registerButton.click();
		return new HomePage();
	}
	
	public boolean validateCreateAccountPage() {
		return action.isDisplayed(getDriver(), getFormTitle());
	}

	public WebElement getFormTitle() {
		return formTitle;
	}

	public WebElement getTitleMr() {
		return titleMr;
	}

	public WebElement getTitleMrs() {
		return titleMrs;
	}

	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getDay() {
		return day;
	}

	public WebElement getMonth() {
		return month;
	}

	public WebElement getYear() {
		return year;
	}

	public WebElement getNewLetterSignup() {
		return newLetterSignup;
	}

	public WebElement getFirstnameAddressForm() {
		return firstnameAddressForm;
	}

	public WebElement getLastnameAddressForm() {
		return lastnameAddressForm;
	}

	public WebElement getCompany() {
		return company;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getState() {
		return state;
	}

	public WebElement getPostalCode() {
		return postalCode;
	}

	public WebElement getCountry() {
		return country;
	}

	public WebElement getAdditionalInformation() {
		return additionalInformation;
	}

	public WebElement getHomePhone() {
		return homePhone;
	}

	public WebElement getMobilePhone() {
		return mobilePhone;
	}

	public WebElement getAddressAlias() {
		return addressAlias;
	}

	public WebElement getRegisterButton() {
		return registerButton;
	}
	
}
