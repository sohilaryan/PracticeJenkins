package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

public class AddEmployeePageElements extends CommonMethods {

	@FindBy(linkText = "PIM")
	public WebElement PIM;

	@FindBy(id = "menu_pim_addEmployee")
	public WebElement addEmp;

	@FindBy(name = "firstName")
	public WebElement fName;

	@FindBy(name = "middleName")
	public WebElement mName;

	@FindBy(name = "lastName")
	public WebElement lName;

	@FindBy(id = "btnSave")
	public WebElement save;

	@FindBy(xpath = "//*[@id=\"pdMainContainer\"]/div[1]/h1")
	public WebElement disp;
	
	@FindBy(id="employeeId")
	public WebElement empId;
	
	@FindBy(id="chkLogin")
	public WebElement checklogin;
	
	@FindBy(xpath="//*[@id=\"frmAddEmp\"]/fieldset/ol/li[1]/ol/li[3]/span")
	public WebElement errorMsg;	
	
	@FindBy(id="user_name")
	public WebElement usernameDet;
	
	@FindBy(id="user_password")
	public WebElement passwwordDet;
	
	@FindBy (id="re_password")
	public WebElement repasswordDet;
	
	@FindBy (id="btnSave")
	public WebElement saveEdit;
	
	
	
	
	

	public void AddEmployee(String firstName,String middleName,String lastName) {
//		click(PIM);
//		click(addEmp);
		sendText(fName, firstName);
		sendText(mName, middleName);
		sendText(lName, lastName);
		//click(save);
		
	}
      public void addEmployeeloginCredentials(String username,String password,String repassword) {
    	  sendText(usernameDet, username);
    	  sendText(passwwordDet, password);
    	  sendText(repasswordDet, repassword);
      }
	public AddEmployeePageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
//	@FindBy(id="firstName")
//	public WebElement firstName;
//	@FindBy(id="middleName")
//	public WebElement middleName;
//	@FindBy(id="lastName")
//	public WebElement lastName;
//	@FindBy(id="chkLogin")
//	public WebElement createLoginDetails;
//	@FindBy(id="user_name")
//	public WebElement username;
//	@FindBy(id="user_password")
//	public WebElement userPassword;
//	@FindBy(id="re_password")
//	public WebElement confirmUserPassword;
//	@FindBy(id="btnSave")
//	public WebElement saveBtn;
//	@FindBy(id="employeeId")
//	public WebElement empId;
//	public AddEmployeePageElements() {
//		PageFactory.initElements(driver, this);
//	}
//}

}
