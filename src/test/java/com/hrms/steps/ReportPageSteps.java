package com.hrms.steps;

import org.junit.Assert;

import com.hrms.pages.DashboardPageElement;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.ReportsPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class ReportPageSteps extends CommonMethods {
	
	
	
	@Given("I am logged into HRMS")
	public void i_am_logged_into_HRMS() {
		
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
	}
	
	@Given("I navigated to the Reports Page")
	public void i_navigated_to_the_Reports_Page() {
	   
		   dash.navigateToReportsPage();
	}

	@When("I enter invalid {string} report")
	public void i_enter_invalid_report(String string) {
	   
	    sendText(report.searchbox, string);
	}

	@When("I click search button")
	public void i_click_search_button() {
	    click(report.searchBtn);
	}

	@Then("I see {string} message")
	public void i_see_message(String string) {
	   report.invalidSearchRst.isDisplayed();	
	   Assert.assertTrue(false);
	   
	}
	
	@When("I enter {string} report")
	public void i_enter_report(String string) {
	  
	   sendText(report.searchbox, string);
	}

	@Then("I see the search {string} is displayed")
	public void i_see_the_search_is_displayed(String string) {
	   report.validSearchRst.isDisplayed();
	}

	
}
