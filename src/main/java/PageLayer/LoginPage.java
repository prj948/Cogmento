package PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;
import UtilityLayer.WaitClass;

public class LoginPage extends BaseClass {

	@FindBy(name = "email")
	private WebElement email;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(xpath = "//div[text()='Login']")
	private WebElement loginbtn;

	@FindBy(xpath = "//div[@class='header item']")
	private WebElement logo;

	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void userEntersValidUsernameAndPassword(String Email, String Password) {
		WaitClass.sendKeys(email, Email);
		WaitClass.sendKeys(password, Password);
	}

	public void userClickonLoginButton() {
		WaitClass.click(loginbtn);
	}

	public void userisOnHomePageAndValidateTitleHomePage() {
		System.out.println(getDriver().getTitle());
	}

	public void userValidateUrlOfHomePage() {
		System.out.println(getDriver().getTitle());
	}

	public void userValidateLogoOfHomePage() {
		WaitClass.isEnabled(logo);
	}
}