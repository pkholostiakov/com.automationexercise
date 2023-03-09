package com.automationexercise.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class Utils {

	private static String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
			  + "abcdefghijklmnopqrstuvwxyz"
	          + "0123456789";

	public static String generateMail() {
		return (RandomStringUtils.random(10,characters)+"@gmail.com");
	}
	
	public static int randomPositiveIntBelow(int number) {
		return (int)((Math.random()*number)+1);
	}
}
