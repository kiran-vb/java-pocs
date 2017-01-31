package com.sau.creditcard.poc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OnlyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String pattern = "[0-9]+";
		
		// Create a Pattern object
	      Pattern r = Pattern.compile(pattern);

	      // Now create matcher object.
	      Matcher m = r.matcher("78787");
	      if (m.matches()) {
	        System.out.println("MATCH");
	      }else {
	         System.out.println("NO MATCH");
	      }

	}

}
