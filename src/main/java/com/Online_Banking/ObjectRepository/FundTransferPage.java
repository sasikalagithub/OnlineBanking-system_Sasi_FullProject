package com.Online_Banking.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FundTransferPage {
	//declaration of fund transfer
	@FindBy(xpath="//li[text()='Fund Transfer']")
	private WebElement fundTransferBtn;
	//initialization
	public FundTransferPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//utilization of fundTransfer

	public WebElement getFundTransferBtn() {
		return fundTransferBtn;
	}
	//declaration of select benificiary
	@FindBy(xpath="//select[@name='beneficiary']")
	private WebElement selectBenificiaryDd;
	//utilization of select benificiary
	public WebElement getSelectBenificiaryDd() {
		return selectBenificiaryDd;
	}
	//business library of select benificiary
	public void selectBenificiaryDropdown() {
		selectBenificiaryDd.click();
	}
	//declaration of amount
	@FindBy(xpath="//input[@name='trnsf_amount']")
	private WebElement amountTf;
	//utilization of amount
	public WebElement getAmountTf() {
		return amountTf;
	}
	//declaration of remark
	@FindBy(xpath="//input[@name='trnsf_remark']")
	private WebElement remarkTf;
	//utilization of remark
	public WebElement getRemarkTf() {
		return remarkTf;
	}
	
    //declaration of send
	@FindBy(xpath="//input[@name='fnd_trns_btn']")
	private WebElement sendBtn;
	//utilization of send 
	public WebElement getSendBtn() {
		return sendBtn;
	}
	//business library for fundtransfer button
	public void fundTransferButton() {
		fundTransferBtn.click();
	}
	
	//business libraries
	public void Fund_TransferPage(String amount,String remark) {
		
		amountTf.sendKeys(amount);
		remarkTf.sendKeys(remark);
		sendBtn.click();
		
		
	}
	
	
	
	
	

}
