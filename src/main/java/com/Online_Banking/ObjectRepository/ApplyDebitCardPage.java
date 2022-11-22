package com.Online_Banking.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplyDebitCardPage {
	//declaration of accountholdername
	@FindBy(xpath="//input[@placeholder='Account Holder Name']")
	private WebElement accountHoldreNameTf;
	
	//initialization
	public ApplyDebitCardPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
	}
	//utilization of accountholder name
	public WebElement getaccountHoldreNameTf() {
		return accountHoldreNameTf;
	}
	//Bussiness library
	public void accountHoldreNameTextField(String accountHolderName)
	{
		accountHoldreNameTf.sendKeys(accountHolderName);

	}
	//declaration of pancard
    @FindBy(xpath="//input[@placeholder='PAN']")
    private WebElement panCardTf;
    
    //utilization of pancard
  public WebElement getpanCardTf() {
	  return panCardTf;
    }
  //Business library
  public void panCardTextfield(String panNum) {
	  panCardTf.sendKeys(panNum);
	   }
  //utilization of mobile num
  @FindBy(xpath="//input[@name='mob']")
  private WebElement registeredMobieTf;
  
  //utilization of mobile num
  public WebElement getregisteredMobieTf() {
	  return registeredMobieTf;
	  
  }
  //Business library
  public void registeredMobieTextfield(String phoneNum) {
	  registeredMobieTf.sendKeys(phoneNum);
  }
  //declaration of account num
  @FindBy(xpath="//input[@name='acc_no']")
  private WebElement accountNumberTf;
//utilization of account num
public WebElement getAccountNumberTf() {
	return accountNumberTf;
}
//Business library of account num
public void accountNumberTextfield(String accountNum) {
	accountNumberTf.sendKeys(accountNum);

  }
//declaration of date of birth
@FindBy(xpath="//input[@placeholder='Date of Birth']")
private WebElement dateOfBirthTf;
//utilization of date of birth
public WebElement getdateOfBirthTf() {
	return dateOfBirthTf;
}
//business library of date of birth
public void dateOfBirthTextfield() {
	dateOfBirthTf.click();
}
//declaration of submit
@FindBy(xpath="//input[@type='submit']")
private WebElement submitBt;

//utilization of submit

public WebElement getSubmitBt() {
	return submitBt;
}
//business library
public void submitButton() {
	submitBt.click();
}

 
  }
  

