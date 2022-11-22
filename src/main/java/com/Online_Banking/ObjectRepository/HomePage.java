package com.Online_Banking.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	//declaration of open Account
@FindBy(xpath="//li[text()='Open Account']")
private WebElement openAccLink;

//initialization
public HomePage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}
//utilization of Open account
public WebElement getOpenAccLink() {
	return openAccLink;
}
//Business library of open Account
public void openAccountLink() {
	openAccLink.click();
}
//declaration of apply debit card
@FindBy(xpath="//li[text()='Apply Debit Card']")
private WebElement applyDebitLink;

//utilizationof apply debit card
public WebElement  getapplyDebitLink() {
	return applyDebitLink;
}
//Business library
	public void applyDebitCardLink() 
	{
        applyDebitLink.click();
}
	//declaration of Internet banking
@FindBy(partialLinkText ="Internet Banking")
private WebElement internetBankingLk;
//utilization of internet banking
public WebElement getInternetBankingLink()
{
	return internetBankingLk;
}
//Business library of internet Banking
public void internetBankingLink() {
	internetBankingLk.click();
}
//declaration of fundTransfer
@FindBy(xpath="//li[text()='Fund Transfer']")
private WebElement fundTransLink;

//utilization of fund transfer
public WebElement getfundTransLink() {
	return fundTransLink;
}
//Business library
public void fundTranserLink() {
	fundTransLink.click();
	
}
//declaration of register in  internet banking
@FindBy(xpath="//li[text()='Register']")
private WebElement registerLk;

//utilization of register in internet banking
public WebElement getRegisterLk() {
	return registerLk;
}
//Business library
public void registerLink() {
	registerLk.click();
}
//declaration of login i internet banking
@FindBy(xpath="//li[text()='Login ']")
private WebElement loginBt;

//utilization of  login in internet Banking

public WebElement getLoginBt() {
	return loginBt;
}
//Business library
public void loginButton() {
	loginBt.click();
}
//declaration of signin link og staff
@FindBy(xpath="//a[text()='Staff Login']")
private WebElement staffloginlk;

//utilization of stafflogin
public WebElement getStaffloginlk() {
	return staffloginlk;
}
//Business library of staff login
public void staffloginlink() {
	staffloginlk.click();
}
}
