package com.hrms.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;



public class PersonaDetailsPageElements {
	@FindBy(xpath = "//div[@id='profile-pic']/h1")
	public WebElement empName;
	
	@FindBy(id = "personal_txtEmployeeId")
	public WebElement empId;
	
	@FindBy(id="btnSave")
	public WebElement edtBttn;
	
	@FindBy(id="personal_txtLicenNo")
	public WebElement txtLicencenNo;
	
	@FindBy(id="personal_txtLicExpDate")
	public WebElement txtLicExpDate;
	
	@FindBy (id="personal_txtNICNo")
	public WebElement SSN;
	
	@FindBy(id="personal_txtSINNo")
	public WebElement SIN;
	
	@FindBy (id="personal_optGender_1")
	public WebElement male;
	
	@FindBy (id="personal_optGender_2")
	public WebElement female;
	
	@FindBy (id="personal_cmbMarital")
     public WebElement martialStatus;
	
	@FindBy (id="personal_cmbNation")
	public WebElement Nationalty;
	
	@FindBy(id="personal_DOB")
	public WebElement dateofBirth;
	

	public PersonaDetailsPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}

	public void validationOfAddedEmployee(String name,String middleName ,String lastName) {
		String fullName = name + middleName + lastName;
		Assert.assertEquals(empName.getText(), fullName);
	}
}
