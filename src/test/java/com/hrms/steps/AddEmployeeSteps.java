package com.hrms.steps;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import com.hrms.pages.AddEmployeePageElements;
import com.hrms.pages.DashboardPageElement;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.PersonaDetailsPageElements;
import com.hrms.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;


public class AddEmployeeSteps extends CommonMethods {

	String empId;
	
	@Given("I navigated to Add Employee Page")
	public void i_navigated_to_Add_Employee_Page() {
	   
	   dash.navigateToAddEmployee();
	}

	@When("I add {string}, {string} and {string}")
	public void i_add_and(String FirstName, String MiddleName, String LastName) {
	     
	     add.AddEmployee(FirstName, MiddleName, LastName);
	     empId=add.empId.getText();
	     
	}

	@When("I click Save")
	public void i_click_Save() {
	    
	    click(add.save);
	}

	@Then("I see Employee has been succesfully added")
	public void i_see_Employee_has_been_succesfully_added() {
	
		   Assert.assertEquals("Employee is Not being added",person.empId.getText(), empId);
	}

	@Then("I see Employee with {string}, {string} and {string} is displayed")
	public void i_see_Employee_with_and_is_displayed(String FirstName, String MiddleName, String LastName) {
		   
		   Assert.assertTrue("Text not displayed",person.empName.isDisplayed());
		   System.out.println("Employee"+FirstName+" "+MiddleName+" "+LastName+" is displayed");
	}

	@When("I delete employee id")
	public void i_delete_employee_id() {
	    
	    add.empId.clear();
	     empId=add.empId.getText();
	}

	@Then("I see employee without employee id is being added")
	public void i_see_employee_without_employee_id_is_being_added() {
	 
	  empId=person.empId.getText();
	 Assert.assertEquals("Employee is not being added", person.empId.getText(),empId);
	}

	@Then("I see required error message next to the first and last name")
	public void i_see_required_error_message_next_to_the_first_and_last_name() {
	   
	   boolean errorDisplayed=add.errorMsg.isDisplayed();
	   Assert.assertTrue(errorDisplayed);
	}

	@When("I click on create login checkbox")
	public void i_click_on_create_login_checkbox() {
	    
	    click(add.checklogin);
	}

	@When("I enter  {string},{string} and {string}")
	public void i_enter_and(String username, String password, String repassword) {
	  
	    add.addEmployeeloginCredentials("John", "John123@##", "John123@##");
	}
	@When("I enter employee details")
	public void i_enter_employee_details(DataTable empDetails) {
		
		List<Map<String,String>>empDetailList=empDetails.asMaps();
		for(Map<String,String>map:empDetailList) {
			sendText(add.fName, map.get("FirstName"));
			sendText(add.mName, map.get("MiddleName"));
			sendText(add.lName, map.get("LastName"));
		}
		
		
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	   // throw new cucumber.api.PendingException();
	}

	@When("I click on Edit")
	public void i_click_on_Edit() {
		
	 click(person.edtBttn);
	}

	@Then("I am able to modify Employee Details")
	public void i_am_able_to_modify_Employee_Details(DataTable modfDetails) throws InterruptedException {
		
		List<Map<String,String>> modifyList=modfDetails.asMaps();
		for(Map<String,String>mapModify:modifyList) {
			sendText(person.txtLicencenNo, mapModify.get("DriverLicence"));
			sendText(person.txtLicExpDate, mapModify.get("ExpirationDate"));
			Thread.sleep(2000);
			sendText(person.SSN, mapModify.get("SSN"));
			sendText(person.SIN, mapModify.get("SIN"));
			Thread.sleep(2000);
			String gender=mapModify.get("Gender");
			if(gender.equals("Male")) {
				click(person.male);
			}else {
				click(person.female);
			}
			Select select=new Select(person.martialStatus);
			select.selectByVisibleText(mapModify.get("MaritalStatus"));
			Select select2=new Select(person.Nationalty);
			select2.selectByVisibleText(mapModify.get("Nationality"));
			Thread.sleep(2000);
			sendText(person.dateofBirth, mapModify.get("DOB"));
			
			
			
		}
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	   // throw new cucumber.api.PendingException();
	}

	
	
	
	
	
	
}
