package stepDefinition;

	import org.junit.runner.RunWith;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

	@RunWith(Cucumber.class)
	public class stepDefinition {

	    @Given("^Delete existing record from BMT$")
	    public void delete_existing_record_from_bmt() throws Throwable {
	        System.out.println("Given condition");
	    }

	    @When("^Click on save$")
	    public void click_on_save() throws Throwable {
	    	System.out.println(" when condition");
	    }

	    @Then("^validate vehicle page$")
	    public void validate_vehicle_page() throws Throwable {
	    	System.out.println("Then condition");
	    }

	    @And("^Create record in PS BMT$")
	    public void create_record_in_ps_bmt() throws Throwable {
	    	System.out.println("And1 condition");
	    }

	    @And("^Login to FO$")
	    public void login_to_fo() throws Throwable {
	    	System.out.println("And2 condition");
	    }

	    @And("^Create fleet spec$")
	    public void create_fleet_spec() throws Throwable {
	    	System.out.println("And3 condition");
	    }

	    @And("^save and generate PDF$")
	    public void save_and_generate_pdf() throws Throwable {
	    	System.out.println("And4 condition");
	    }

	}