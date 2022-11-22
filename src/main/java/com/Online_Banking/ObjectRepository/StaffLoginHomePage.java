package com.Online_Banking.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffLoginHomePage {
	//declaration
	@FindBy(xpath="//input[@value='View Active Customer']")
	private WebElement viewActiveCustomerLk;
	
	@FindBy(xpath="//input[@value='Approve Pending Account']")
	private WebElement approvePendingAccountLk;
	
	@FindBy(xpath="//input[@value='Delete Customer A/c']")
	private WebElement DeleteCustomerAccountLk;
	
	@FindBy(xpath="//input[@value='Credit Customer']")
	private WebElement creditCustomerAccount;
	
	@FindBy(xpath="//input[@value='View Customer by A/c No']")
	private WebElement viewCustomerByAccountNumber;
	
	//Initialization
	public StaffLoginHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}
	//uilization

	public WebElement getViewActiveCustomerLk() {
		return viewActiveCustomerLk;
	}

	public WebElement getApprovePendingAccountLk() {
		return approvePendingAccountLk;
	}

	public WebElement getDeleteCustomerAccountLk() {
		return DeleteCustomerAccountLk;
	}

	public WebElement getCreditCustomerAccount() {
		return creditCustomerAccount;
	}

	public WebElement getViewCustomerByAccountNumber() {
		return viewCustomerByAccountNumber;
	}
	//business libraries
	
	public void  DeleteCustomerAccountLink() {
		DeleteCustomerAccountLk.click();
	}
	
	
	public void  approvePendingAccountLink() {
		approvePendingAccountLk.click();
	}
		public void  creditCustomerAccountLink() {
			creditCustomerAccount.click();
		}
		public void  viewCustomerByAccountNumberLink() {
			viewCustomerByAccountNumber.click();
		}
		
		public void  viewActiveCustomerLink() {
			viewActiveCustomerLk.click();
		}
	}
	
	


