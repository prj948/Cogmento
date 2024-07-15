package UtilityLayer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import BaseLayer.BaseClass;

public class HandleWindows extends BaseClass {
	
	public static void handleWindowOrTab(int windownumber) {
		
		Set<String> listwindow=getDriver().getWindowHandles();
	ArrayList<String> arrayList=new ArrayList<String>();
	
	Iterator<String> it=listwindow.iterator();
	
	while(it.hasNext()) {
		String windowid=it.next();
		arrayList.add(windowid);
	}
	
	getDriver().switchTo().window(arrayList.get(windownumber));
	}
	
	
	
	public static void handlewindoeORTabByLoop(String parentID) {
		
		Set<String>listwindow=getDriver().getWindowHandles();
		String secondwWindow=null;
		for(String abc:listwindow) {
			if(!abc.equals(parentID)) {
				secondwWindow=abc;
			}
		}
		
		getDriver().switchTo().window(secondwWindow);
		}
	

public static void  handlewindoeORTabByArrayList(int index) {
	Set<String>listwinow=getDriver().getWindowHandles();
	ArrayList<String>arr=new ArrayList<String>(listwinow);
	
	getDriver().switchTo().window(arr.get(index));
}
	
}

