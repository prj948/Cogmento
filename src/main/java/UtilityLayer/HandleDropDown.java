package UtilityLayer;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseLayer.BaseClass;

public class HandleDropDown extends BaseClass {

	public static void selectByVisibleText(WebElement wb, String value) {
		new Select(WaitClass.visibilityofElement(wb)).selectByVisibleText(value);
	}

	public static void selectByValue(WebElement wb, String value) {
		new Select(WaitClass.visibilityofElement(wb)).selectByValue(value);
	}

	public static void selectByIndex(WebElement wb, int index) {
		new Select(WaitClass.visibilityofElement(wb)).selectByIndex(index);
	}

	public static WebElement geFirstSelectedOption(WebElement wb) {
		return new Select(WaitClass.visibilityofElement(wb)).getFirstSelectedOption();
	}

	public static void getOptions(WebElement wb) {
		List<WebElement> ls = new Select(WaitClass.visibilityofElement(wb)).getOptions();
		for (WebElement abc : ls) {
			System.out.println(abc.getText());
		}
	}

	public static int dropDownSize(WebElement wb) {
		return new Select(WaitClass.visibilityofElement(wb)).getOptions().size();

	}
	
	
public static void dropdownWithoutSelecttag(WebElement wb, List<WebElement> listValue,String expectedValue) {
	WaitClass.click(wb);
	new WebDriverWait(getDriver(),Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfAllElements(listValue));
	for(WebElement list:listValue) {
		String abc=list.getText();
		if(abc.equalsIgnoreCase(expectedValue)) {
			WaitClass.click(list);
			break;
		}
		
	
		
	}
}

}
