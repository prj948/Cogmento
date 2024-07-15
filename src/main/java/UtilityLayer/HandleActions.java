package UtilityLayer;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import BaseLayer.BaseClass;

public class HandleActions extends BaseClass {

	public static void click(WebElement wb) {
		new Actions(getDriver()).click(WaitClass.visibilityofElement(wb)).build().perform();

	}

	public static void doubleClick(WebElement wb) {
		new Actions(getDriver()).doubleClick(WaitClass.visibilityofElement(wb)).build().perform();

	}

	public static void rightClick(WebElement wb) {
		new Actions(getDriver()).contextClick(WaitClass.visibilityofElement(wb)).build().perform();

	}

	public static void mouseOver(WebElement wb) {
		new Actions(getDriver()).moveToElement(WaitClass.visibilityofElement(wb)).build().perform();

	}
	public static void dragAndDrop(WebElement src,WebElement trg) {
		new Actions(getDriver()).dragAndDrop(WaitClass.visibilityofElement(src), WaitClass.visibilityofElement(trg)).build().perform();

	}
	
	public static void clickAndHold(WebElement wb) {
		new Actions(getDriver()).clickAndHold(WaitClass.visibilityofElement(wb)).build().perform();

	}
	public static void release(WebElement wb) {
		new Actions(getDriver()).release(WaitClass.visibilityofElement(wb)).build().perform();

	}
	public static void sendKeys(WebElement wb,String value) {
		new Actions(getDriver()).sendKeys(WaitClass.visibilityofElement(wb)).build().perform();

	}
	public static void enterUpperCase(WebElement wb,String value) {
		new Actions(getDriver()).keyDown(Keys.SHIFT).sendKeys(WaitClass.visibilityofElement(wb),value).build().perform();

	}
	
}
