package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

public class DashboardPageElement extends CommonMethods {
	
	@FindBy(id="welcome")
	public WebElement welcomeLnk;
	
	@FindBy(linkText="Leave")
	public WebElement leaveLnk;
	
	@FindBy(linkText="Leave List")
	public WebElement leaveList;
	
	@FindBy(linkText = "PIM")
	public WebElement pim;
	
	@FindBy(id = "menu_pim_addEmployee")
	public WebElement addEmp;
	
	@FindBy(id = "menu_core_viewDefinedPredefinedReports")
	public WebElement reportsLink;
	
	
	public DashboardPageElement() {
		PageFactory.initElements(BaseClass.driver,this);
	}
	
	public void navigateToLeaveList() {
		click(leaveLnk);
		click(leaveList);
	}

	public void navigateToAddEmployee() {
		jsClick(pim);
		jsClick(addEmp);
	}
	public void navigateToReportsPage() {
		jsClick(pim);
		jsClick(reportsLink);
	}

}
