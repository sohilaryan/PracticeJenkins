package com.hrms.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

public class LoginPageElements extends CommonMethods {
	
	/**
	 * @FindBy is a technique to find element and it support all locator available in the selenium 
	 */
	
	@FindBy(xpath="//div[@id='divLogo']")
	public WebElement logo;
	
	@FindBy(id="LogInPanelHeading")
	public WebElement loginLabel;
	
	@FindBy(name="txtUsername")
	public WebElement username;
	
	@FindBy(css="input#txtPassword")
	public WebElement password;
	
	@FindBy(css="input[name='Submit']")
	public WebElement loginBtn;
	
	@FindBy(id="spanMessage")
	public WebElement errText;
	
	public void login(String uid,String pwd) {
		sendText(username, uid);
		sendText(password, pwd);
		jsClick(loginBtn);
	}
	Properties prop;
	public void loginProperties() {
		String filePath = System.getProperty("user.dir")+"/src/test/resources/configs/Configuration.properties";
		
		try {
			FileInputStream fis = new FileInputStream(filePath);
			 prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		username.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		click(loginBtn);
	}
	
	
	
//	@FindBy(xpath = "//div[@id = 'divLogo']")
//	public WebElement logo;
//	@FindBy(id = "logInPanelHeading")
//	public WebElement loginLAbel;
//	@FindBy(name = "txtUsername")
//	public WebElement userName;
//	@FindBy(css = "input[id = 'txtPassword']")
//	public WebElement userPassword;
//	@FindBy(css = "input[name = 'Submit']")
//	public WebElement loginBtn;
//	@FindBy(id = "spanMessage")
//	public WebElement errText;
	
	// Once we store all element we need pageFacyory class  initializing those element
	public LoginPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
		
		
		
		
		
		
	}
	
	

}
