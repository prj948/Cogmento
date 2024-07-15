package PageLayer;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;
import UtilityLayer.HandleDropDown;
import UtilityLayer.WaitClass;

public class ContactPage extends BaseClass{

	@FindBy(xpath = "//span[text()='Contacts']")
	private WebElement contact;

	@FindBy(xpath = "//button[text()='Create']")
	private WebElement newcontact;

	@FindBy(name = "first_name")
	private WebElement fname;

	@FindBy(name = "last_name")
	private WebElement lname;

	@FindBy(name = "middle_name")
	private WebElement mname;
	
	@FindBy(name="status")
	private WebElement status;
	

	@FindBy(name="category")
	private WebElement category;

	@FindBys(@FindBy(xpath="//div[@class='visible menu transition']/div[@name='status']"))
	private List<WebElement> statusdp;
	
	@FindBys(@FindBy(xpath="//div[@class='visible menu transition']/div"))
	private List<WebElement> categorydp;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	private WebElement savebtn;
	
	@FindBy(xpath="//button[@class='ui basic button item']")
	private WebElement deletebtn;

	@FindBy(xpath="//div[@class='ui basic button floating item dropdown']")
	private WebElement settingicon;

	@FindBy(xpath="//span[text()='Log Out']")
	private WebElement logoutbtn;

	
	
	public ContactPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void userIsOnHomePageandClickonContacts() {
	WaitClass.click(contact);	
	}
	
	public void userClickOncreateButton() {
		WaitClass.click(newcontact);
	}
	
	public void userEnterContactInformation(String Fname,String Lname,String Mname,String expectedStatus,String  expectedCategory) {
		WaitClass.sendKeys(fname, Fname);
		WaitClass.sendKeys(lname, Lname);
		WaitClass.sendKeys(mname, Mname);
		HandleDropDown.dropdownWithoutSelecttag(status, statusdp, expectedStatus);
		HandleDropDown.dropdownWithoutSelecttag(category, categorydp, expectedCategory);
	}
	
	public void userClickOnSaveButton() {
		WaitClass.click(savebtn);
	}
	
	public void userWillDeletetheCreatedContact() {
		WaitClass.click(deletebtn);
	}
	
	
	public void userClickOnProfileIcon() {
		WaitClass.click(settingicon);
	}
	
	public void userClickonLogoutOption() {
		WaitClass.click(logoutbtn);
	}
	
	
}
