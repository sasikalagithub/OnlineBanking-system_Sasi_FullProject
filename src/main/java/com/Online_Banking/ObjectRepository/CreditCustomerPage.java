package com.Online_Banking.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreditCustomerPage {
	//Declaration
	
	@FindBy(xpath="//input[@name='customer_account_no']")
	private WebElement customerAccNumTf;
	
	@FindBy(xpath="//input[@name='credit_amount']")
	private WebElement amountTf;
	
	@FindBy(xpath="//input[@name='credit_btn']")
	private WebElement creditBut;
	
	//Initialization
	
	public CreditCustomerPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	
    //declaration
	
	public WebElement getCustomerAccNumTf() {
		return customerAccNumTf;
	}

	public WebElement getAmountTf() {
		return amountTf;
	}

	public WebElement getCreditBut() {
		return creditBut;
	}
	
	//Business libraries
	
	public void creditCustomerPageDetails(String accountNumber,String amount) {
		customerAccNumTf.sendKeys(accountNumber);
		amountTf.sendKeys(amount);
		creditBut.click();
	}
}
