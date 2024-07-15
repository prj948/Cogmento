package StepDefination;

import java.util.List;

import org.testng.Assert;

import BaseLayer.BaseClass;
import PageLayer.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginPageTest extends BaseClass {
	public static LoginPage login;

	@Given("User is on LoginPage using {string} browser")
	public void user_is_on_login_page_using_browser(String browsername) {
		BaseClass.initilization(browsername);
	}

	@When("User enters Valid username and Password")
	public void user_enters_valid_username_and_password(DataTable dataTable) {

		login = new LoginPage();
		List<List<String>> list =dataTable.asLists();
		String uName=list.get(0).get(0);
		String pWord=list.get(0).get(1);
		login = new LoginPage();
		login.userEntersValidUsernameAndPassword(uName, pWord);


	}

	@When("User should click on LoginButton")
	public void user_should_click_on_login_button() {
		login.userClickonLoginButton();
	}

	@Given("User is on HomePage and Validate Title HomePage")
	public void user_is_on_home_page_and_validate_title_ig_home_page() {
		login.userisOnHomePageAndValidateTitleHomePage();
		String actualTitle = getDriver().getTitle();
		Assert.assertEquals(actualTitle.contains("cognmento"), true);
	}

	@Given("user Validate Url of HomePage")
	public void user_validate_url_of_home_page() {
		login.userValidateUrlOfHomePage();
		String actualurl = getDriver().getCurrentUrl();
		Assert.assertEquals(actualurl.contains("congmento"), true);

	}

	@Given("user Validate Logo of HomePage")
	public void user_validate_logo_of_home_page() {
		login.userValidateLogoOfHomePage();
	}

}
