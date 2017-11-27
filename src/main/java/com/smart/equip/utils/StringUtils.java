package com.smart.equip.utils;

/*
 * To check if the response/ users  contains any numbers 
 * Version: 1.0 
 * @author Johnsy
 */


public class StringUtils {

	
	public static boolean isNumber(String str) {
		
		return str.matches("[0-9]+");
		
	}
}
