package UtilityLayer;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseLayer.BaseClass;

public class HandleAlert extends BaseClass{
	
	public static Alert alertPresent() {
		return new WebDriverWait(getDriver(),Duration.ofSeconds(30)).until(ExpectedConditions.alertIsPresent());
}
	public static void alertAccept() {
		alertPresent().accept();
	}
	
	public static void alertDismiss() {
	alertPresent().dismiss();	
	}
	public static String alertText() {
		return alertPresent().getText();
	}
	public static void alertsendkeys(String value) {
		alertPresent().sendKeys(value);
	}
	
}