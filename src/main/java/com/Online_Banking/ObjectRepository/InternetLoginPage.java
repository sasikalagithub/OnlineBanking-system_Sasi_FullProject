package com.Online_Banking.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InternetLoginPage {
	//declaration of customerID
	@FindBy(xpath="//input[@name='customer_id']")
	private WebElement customeridTf;
	//initilization
	public InternetLoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	//utilization of customer id

	public WebElement getCustomeridTf() {
		return customeridTf;
	}
	//declaration of password
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordTf;
	
	//utilization of password

	public WebElement getPasswordTf() {
		return passwordTf;
	}
	//declaration of login button
	@FindBy(xpath="//input[@name='login-btn']")
	private WebElement loginBtn;
	
	//utilization

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	//business libraries
	public void Internet_LoginPage(String customerId,String customerpassword) {
		customeridTf.sendKeys(customerId);
		passwordTf.sendKeys(customerpassword);
		loginBtn.click();
	}
	
	
	

}
