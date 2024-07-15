package StepDefination;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;

import BaseLayer.BaseClass;
import PageLayer.ContactPage;
import UtilityLayer.ExcelReaderBDD;
import io.cucumber.java.en.When;

public class ContactPageTest extends BaseClass {

	protected static ContactPage contactpage;

	@When("User is on HomePage and click on contacts")
	public void user_is_on_home_page_and_click_on_contacts() {
		contactpage = new ContactPage();
		contactpage.userIsOnHomePageandClickonContacts();
	}

	@When("User is on contactPage and Validate ContactPage url contains {string}")
	public void user_is_on_contact_page_and_validate_contact_page_url_contains(String string) {
		String actualurl = getDriver().getCurrentUrl();
		Assertions.assertEquals(actualurl.contains(string), true);

	}

	@When("User click on create button")
	public void user_click_on_create_button() {
		contactpage.userClickOncreateButton();
	}

	@When("User enter contact information using {string} and {int}")
	public void user_enter_contact_information_using_and(String ContactList, Integer rownum) throws IOException {
		ExcelReaderBDD excelbdd=new ExcelReaderBDD();
		List<Map<String,String>> data=excelbdd.getAllSheetData("C:\\Users\\Pallavi\\eclipse-workspace\\FinalBDD\\src\\main\\java\\TestDataLayer\\ContactList.xlsx",ContactList);
		String Fname=data.get(rownum).get("FirstName");
		String Lname=data.get(rownum).get("LastName");
		String Mname=data.get(rownum).get("MiddleName");
		String expectedStatus=data.get(rownum).get("Status");
		String expectedCategory=data.get(rownum).get("Category");
		contactpage.userEnterContactInformation(Fname, Lname, Mname, expectedStatus, expectedCategory);
		
		
	}

	@When("User click on save button")
	public void user_click_on_save_button() {
		contactpage.userClickOnSaveButton();
	}

	@When("User will delete the created contact")
	public void user_will_delete_the_created_contact() {
		contactpage.userWillDeletetheCreatedContact();
	}

	@When("User click on profile icon")
	public void user_click_on_profile_icon() {
		contactpage.userClickOnProfileIcon();
	}

	@When("User click on Logout option")
	public void user_click_on_logout_option() {
		contactpage.userClickonLogoutOption();
	}

	@When("User close the session")
	public void user_close_the_session() {
		getDriver().close();
	}

}
