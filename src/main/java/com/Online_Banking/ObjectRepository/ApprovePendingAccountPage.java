package com.Online_Banking.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApprovePendingAccountPage {
	
	//declaration
	
	@FindBy(xpath="//input[@name='application_no']")
	private WebElement applicationNumberTf;
	
	@FindBy(xpath="//input[@name='search_application']")
	private WebElement searchBtn;
	
	@FindBy(xpath="//input[@name='approve_cust']")
	private WebElement approveBtn;
	
	//Initialization
	public ApprovePendingAccountPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	
	//utilization
	

	public WebElement getApplicationNumberTf() {
		return applicationNumberTf;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getApproveBtn() {
		return approveBtn;
	}
	
	//Business libraries
	
	public void approvePendingAccountPageDetails(String applicationNumber) throws InterruptedException
	{
		applicationNumberTf.sendKeys(applicationNumber);
		searchBtn.click();
		Thread.sleep(2000);
		approveBtn.click();
			
	}
}

	
	
	


