package com.Online_Banking.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InternetBankingRegistrationPage {
	//declaration of  account holder name
	@FindBy(xpath="//input[@name='holder_name']")
	private WebElement accountHolderNameTf;
	//Initialization of account holder name
	public InternetBankingRegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	//utilization of account holder name
	public WebElement getAccountHolderNameTf() {
		return accountHolderNameTf;
	}

	
	//declaration of  accountNumber
	
	@FindBy(xpath="//input[@placeholder='Account Number']")
	private WebElement accountNumTf;
	
	
	//utilization of accountnumber
	
	public WebElement getAccountNumTf() {
		return accountNumTf;
}
	
		//declaration for debitcard num
	@FindBy(xpath="//input[@name='dbtcard']")
	private WebElement debitCardTf;
	//utilization of debitcard num
	public WebElement getDebitCardTf() {
		return debitCardTf;
	}
	
	//declaration of debit pin num
	@FindBy(xpath="//input[@name='dbtpin']")
	private WebElement debitCardPinTf;
	//utilization of debit card
	public WebElement getDebitCardPinTf() {
		return debitCardPinTf;
	}
//	//Business library of debitcard
//	public void debitCardPinTextfield(String debitPinNum) {
//		debitCardPinTf.sendKeys(debitPinNum);
//	}
	
	//declaration of Registered mobile
	@FindBy(xpath="//input[@name='mobile']")
	private WebElement registeredMobileTf;
	//utilization of Registered mobile
	public WebElement getRegisteredMobileTf() {
		return registeredMobileTf;
		}
	//utilization of pan number
	@FindBy(xpath="//input[@name='pan_no']")
	private WebElement panNumTf;
	//utilization of pan number
	public WebElement getPanNumTf() {
		return panNumTf;
	}
	//Declaration of last Transaction
	@FindBy(xpath="//input[@name='last_trans']")
	private WebElement lastTransactionTf;
	//utilization of last tranction
	public WebElement getLastTransactionTf() {
		return lastTransactionTf;
	}
	//declaration of password
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordTf;
	//utilization of password
	public WebElement getPasswordTf() {
		return passwordTf;
	}
	//declaration of confirm password
	@FindBy(xpath="//input[@name='cnfrm_password']")
	private WebElement confirmPasswordTf;
	//utilization of confirm password
	public WebElement getConfirmPasswordTf() {
		return confirmPasswordTf;
	}
	//declaration of dateofbirth
	@FindBy(xpath="//input[@name='dob']")
	private WebElement dateOfBirthTf;
	
	
	//utilization of date of birth
	
	public WebElement getDateOfBirthTf() {
		return dateOfBirthTf;
	}
	//utilization of date of birth
	public void dateOfBirthTextField() {
		dateOfBirthTf.click();
	}
			//Declaration of submit button
		@FindBy(xpath="//input[@name='submit']")
		private WebElement submitBtn;
		
		//utilization of submit button
		public WebElement getSubmitBtn() {
			return submitBtn;
		}
	
	//Business libraries____1
	public void InternetBanking_RegistrationPage(String accountHolderName,String accountNum,String debitNum,String debitPinNum)
	{
		accountHolderNameTf.sendKeys(accountHolderName);
		accountNumTf.sendKeys(accountNum);
		debitCardTf.sendKeys(debitNum);
		debitCardPinTf.sendKeys(debitPinNum);
		
	}

	//Business libraries____2
	public void InternetBanking_RegistrationPage(String phoneNum,String panNum,String Transaction)//String password
			{
				registeredMobileTf.sendKeys(phoneNum);
				panNumTf.sendKeys(panNum);
				lastTransactionTf.sendKeys(Transaction);
				
			}
	//Business libraries____3
	public void InternetBanking_RegistrationPage(String password)
			{
			passwordTf.sendKeys(password);
			confirmPasswordTf.sendKeys(password);
			submitBtn.click();
			}
	}
