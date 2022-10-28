package com.webapptestproject.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webapptestproject.actiondriver.ActionImpl;
import com.webapptestproject.base.Base;

public class ContactUsPage extends Base {
	
	ActionImpl action;
	
	@FindBy(id="id_contact")
	WebElement subject;
	@FindBy(id="email")
	WebElement email;
	@FindBy(id="id_order")
	WebElement orderReference;
	@FindBy(id="fileUpload")
	WebElement chooseFileBtn;
	@FindBy(className="icon-chevron-right right")
	WebElement sendBtn;
	@FindBy(id="message")
	WebElement message;
	
	public ContactUsPage() {
		PageFactory.initElements(getDriver(), this);
	}
	//thorugh AutoId | only run in windowsOS
	public void uploadFile() {
		
	}
	
	public void sendMessage(String subject,
							String email,
							String orderReference
							,String message) {
		action.selectByValue(this.subject, subject);
		action.type(this.email, email);
		action.type(this.orderReference, orderReference);
		action.type(this.message, message);
	}
	
	public void validateSendBtn() {
		action.click(getDriver(), sendBtn);
	}
	
	
}
