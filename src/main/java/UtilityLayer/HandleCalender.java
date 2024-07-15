package UtilityLayer;

import java.util.List;

import org.openqa.selenium.WebElement;

import BaseLayer.BaseClass;

public class HandleCalender extends BaseClass {
	
	public static void findExpectedMonthAndYear(WebElement actualMonthandYear , String expectedMonthAndYear,WebElement next) {
		
		while(true) {
			if(WaitClass.getText(actualMonthandYear).equalsIgnoreCase(expectedMonthAndYear)) {
				break;
			}
			else {
				WaitClass.click(next);
			}
		}
	}
	
	public static void findExpectedDate(List<WebElement>listdates,String expectedDate) {
		for(WebElement dates:listdates) {
			if(WaitClass.getText(dates).contains(expectedDate)) {
				WaitClass.click(dates);
				break;
			}
			
		}
	}
	

}
