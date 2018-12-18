package cucumber.maven.step;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.selenium.core.WebConnector;

public class LoginTest {

WebConnector connector=new WebConnector();

@Given("^I open \"([^\"]*)\" on \"([^\"]*)\"$")
public void I_open(String url, String Browser)
{
	System.out.println("@Given--- URL is "+ url+ "browser is"+ Browser);
	connector.openBrowser(Browser, url);
}

@And("^I enter \"([^\"]*)\" as \"([^\"]*)\"$")
public void I_enter(String Object, String value)
{
	System.out.println("@And--- entering  "+ Object +"as a value"+ value);
	connector.type(Object, value);
}

@And("^I click \"([^\"]*)\" button$")
public void I_click(String Object)
{
	System.out.println("@And--- click "+ Object);
	connector.click(Object);
	
}

@Then("^login should be \"([^\"]*)\"$")
public void I_Login(String expectedresult)
{
	System.out.println("@Then--- login "+ expectedresult);
	
}
}
