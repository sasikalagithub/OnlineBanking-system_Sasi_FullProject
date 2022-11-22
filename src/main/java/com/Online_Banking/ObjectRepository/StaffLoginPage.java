package com.Online_Banking.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffLoginPage {
	@FindBy(xpath="//input[@name='staff_id']")
	private WebElement staffIdTf;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordTf;
	
	@FindBy(xpath="//input[@name='staff_login-btn']")
	private WebElement loginBtn;
	
	
	//Initialization
	public StaffLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}
	//uilization


	public WebElement getStaffIdTf() {
		return staffIdTf;
	}


	public WebElement getPasswordTf() {
		return passwordTf;
	}


	public WebElement getLoginBtn() {
		return loginBtn;
	}
	//Business library
	
	public void staffLoginPage(String staffid,String password) {
		staffIdTf.sendKeys(staffid);
		passwordTf.sendKeys(password);
		loginBtn.click();
		
	}

}
