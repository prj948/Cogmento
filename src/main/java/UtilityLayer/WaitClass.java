package UtilityLayer;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseLayer.BaseClass;

public class WaitClass extends BaseClass{
	
	public static WebElement visibilityofElement(WebElement wb) {
		return new WebDriverWait(getDriver(),Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(wb));
	}

	public static void click(WebElement wb) {
		new WebDriverWait(getDriver(),Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(wb)).click();;
	}
	
	public static void submit(WebElement wb) {
		new WebDriverWait(getDriver(),Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(wb)).submit();
	}
	
	public static void sendKeys(WebElement wb,String value) {
		 WaitClass.visibilityofElement(wb).sendKeys(value);
	}
	public static String getText(WebElement wb) {
		return WaitClass.visibilityofElement(wb).getText();
	}
	public static String attribute(WebElement wb,String value) {
		return WaitClass.visibilityofElement(wb).getAttribute(value);	
	}
	public static void clear(WebElement wb) {
		WaitClass.visibilityofElement(wb).clear();
	}
	public static void isDisplayed(WebElement wb) {
		WaitClass.visibilityofElement(wb).isDisplayed();		
	}
	public static void isEnabled(WebElement wb) {
		WaitClass.visibilityofElement(wb).isEnabled();		
	}
	public static void isSelected(WebElement wb) {
		WaitClass.visibilityofElement(wb).isSelected();		
	}
}
