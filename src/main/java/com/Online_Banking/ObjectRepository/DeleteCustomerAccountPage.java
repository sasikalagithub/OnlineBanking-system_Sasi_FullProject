package com.Online_Banking.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomerAccountPage {
	
	//declaration
	@FindBy(xpath="//input[@name='Cust_ac_no']")
	private WebElement customerAccountNumberTf;
	
	@FindBy(xpath="//input[@name='Cust_ac_Id']")
	private WebElement customerIdTf;
	
	@FindBy(xpath="//input[@name='reason']")
	private WebElement reasonTf;
	
	@FindBy(xpath="//input[@name='delete']")
	private WebElement deleteBtn;

	//initilization
	
	public DeleteCustomerAccountPage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}

	
	//declaration
	

	public WebElement getCustomerAccountNumberTf() {
		return customerAccountNumberTf;
	}

	public WebElement getCustomerIdTf() {
		return customerIdTf;
	}

	public WebElement getReasonTf() {
		return reasonTf;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}
	//Business libraries
	
	public void deleteCustomerAccountPageDetails(String accountNumber,String customerId,String reason) {
		customerAccountNumberTf.sendKeys(accountNumber);
		customerIdTf.sendKeys(customerId);
		reasonTf.sendKeys(reason);
		deleteBtn.click();
		
	}
	
}
