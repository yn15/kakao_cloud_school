package com.rapa.common;

public class CommonUtil {
	public static String nullToValue(String ob, String value) {
		if(ob==null || ob.equals(""))
			return value;
		else
			return ob;
	}
	
	public static String nullToValue(String ob) {
		if(ob==null || ob.equals(""))
			return "0";
		else
			return ob;
	}
}
