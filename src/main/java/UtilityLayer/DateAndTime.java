package UtilityLayer;

import java.text.SimpleDateFormat;
import java.util.Date;

import BaseLayer.BaseClass;

public class DateAndTime extends BaseClass {

	public static String captureYear() {
		return new SimpleDateFormat("yyyy").format(new Date());
	}

	public static String captureMonthAndYear() {
		return new SimpleDateFormat("MMyyyy").format(new Date());
	}

	public static String caputreCurrentDatehAndTime() {
		return new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
		
	}
}
