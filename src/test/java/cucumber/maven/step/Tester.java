package cucumber.maven.step;

import java.util.List;
import java.util.Map;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Tester {

	@Given("^I am a \"([^\"]*)\" Tester$")
	public void I_am_a_manual_Tester(String Testtype,DataTable table)
	{
		System.out.println("----------------------------");
		List<Map<String,String>> data=table.asMaps(String.class,String.class);
		System.out.println("@Given--I am a "+Testtype+" Tester"+"Current location is:"+data.get(0).get("Location")+"-job type is:"+data.get(0).get("Jobtype"));
		System.out.println("@Given--I am a "+Testtype+" Tester"+"Current location is:"+data.get(1).get("Location")+"-job type is:"+data.get(1).get("Jobtype"));

	}
	
	@When("^i apply for job$")
	public void i_apply_for_job()
	{
		System.out.println("@When--i apply for job"); 

	}
	
	@Then("^i got (\"[a-zA-Z]{1,}\") paid job$")
	public void i_got_less_paid_job(String salary)
	{
		System.out.println("@Then--i got "+salary+" paid job"); 

	}
	
	@And("^i am (\"[a-zA-Z]{1,}\") satisfied with my salary$")
	public void i_am_not_satisfied_with_my_salary(String satisfication_type)
	{
		System.out.println("@And--i am "+satisfication_type+" satisfied with my salary"); 

	}
	
	@But("^my family (\"[a-zA-Z]{1,}\") satisfied$")
	public void my_family_still_satisfied(String family)
	{
		System.out.println("@But--my family "+family+" satisfied"); 

	}

}
