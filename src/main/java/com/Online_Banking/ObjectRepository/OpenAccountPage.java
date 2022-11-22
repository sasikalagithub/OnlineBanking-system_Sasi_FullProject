package com.Online_Banking.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Online_Banking.Banking.GenericLibraries.WebDriver_Utility;

public class OpenAccountPage  extends WebDriver_Utility{
	
//declaration
	
	@FindBy(xpath="//input[@name='name']")
	private WebElement nameLk;
	
	@FindBy(xpath="//select[@name='gender']")
	private WebElement genderDd;
	
	@FindBy(xpath="//input[@name='mobile']")
	private WebElement mobilenumTf;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement emailIdTf;
	
	@FindBy(xpath="//input[@name='landline']")
	private WebElement landlinenumTf;
	
	@FindBy(xpath="//input[@name='dob']")
	private WebElement dateOfBirthTf;
	
	@FindBy(xpath="//input[@name='pan_no']")
	private WebElement panNumTf;
	
	@FindBy(xpath="//input[@name='citizenship']")
	private WebElement citizenshipNumTf;
	
	@FindBy(xpath="//input[@name='homeaddrs']")
	private WebElement homeAddressTa;
	
	@FindBy(xpath="//input[@name='officeaddrs']")
	private WebElement officeAddressTa;
	
	@FindBy(xpath="//select[@name='state']")
	private WebElement stateDd;
	
	@FindBy(xpath="//select[@name='city']")
	private WebElement cityDd;
	
	@FindBy(xpath="//input[@name='pin']")
	private WebElement pinCodeTf;
	
	@FindBy(xpath="//input[@name='arealoc']")
	private WebElement areTf;
	
	@FindBy(xpath="//select[@name='acctype']")
	private WebElement accountTypeDd;
	
	@FindBy(xpath="//input[@name='submit']")
	private WebElement submitBtn;
	
	//initialization
	
	public OpenAccountPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//declaration

	public WebElement getNameLk() {
		return nameLk;
	}

	public WebElement getGenderDd() {
		return genderDd;
	}

	public WebElement getMobilenumTf() {
		return mobilenumTf;
	}

	public WebElement getEmailIdTf() {
		return emailIdTf;
	}

	public WebElement getLandlinenumTf() {
		return landlinenumTf;
	}

	public WebElement getDateOfBirthTf() {
		return dateOfBirthTf;
	}

	public WebElement getPanNumTf() {
		return panNumTf;
	}

	public WebElement getCitizenshipNumTf() {
		return citizenshipNumTf;
	}

	public WebElement getHomeAddressTa() {
		return homeAddressTa;
	}

	public WebElement getOfficeAddressTa() {
		return officeAddressTa;
	}

	public WebElement getStsteDd() {
		return stateDd;
	}

	public WebElement getCityDd() {
		return cityDd;
	}

	public WebElement getPinCodeTf() {
		return pinCodeTf;
	}

	public WebElement getAreTf() {
		return areTf;
	}

	public WebElement getAccountTypeDd() {
		return accountTypeDd;
	}
	
	
	public WebElement getStateDd() {
		return stateDd;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	//Business libraries
	public void openAccountPageDetails(String name,String mobileNum,String emailId,String landLineNum,String panNum ) 
	{
		nameLk.sendKeys(name);
		mobilenumTf.sendKeys(mobileNum);
		emailIdTf.sendKeys(emailId);
		landlinenumTf.sendKeys(landLineNum);
		panNumTf.sendKeys(panNum);
	}
	public void openAccountPageDetails(String citizenShipNum,String homeAddress,String officeAddress) {	
		
		citizenshipNumTf.sendKeys(citizenShipNum);
		homeAddressTa.sendKeys(homeAddress);
		officeAddressTa.sendKeys(officeAddress);
}
public void openAccountPageDetails(String pinCode,String area) {
		pinCodeTf.sendKeys(pinCode);
		areTf.sendKeys(area);
}
		//Business libraries for dropdowns
		public void openAccountPageGenderDropdown() {	
			genderDd.click();
		
	}

		public void stateDropdown() {	
			stateDd.click();
		}
		
		public void cityDropdown() {	
			cityDd.click();
		}
		
		public void accountTypeDropdown() {	
			accountTypeDd.click();
		}
		//Business library for Date of birth
		
		public void dateOfBirth() {
			dateOfBirthTf.click();	
		}
		public void submitButton() {
			submitBtn.click();
			
		}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

