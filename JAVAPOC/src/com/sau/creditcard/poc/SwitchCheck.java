package com.sau.creditcard.poc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.Timer;


public class SwitchCheck {

	public static void main(String[] args) throws Exception {
		String g="";
		getTime();
		char ch='1';
	
		 switch(ch){  
		    case '1': System.out.println("1");break;
		    case '2':  System.out.println("2");break;  
		    case '3':  System.out.println("3");break;
		    default:System.out.println("no value !!1");  
		 }
		 String name="ki";
		 switch(name){  
		    case "ki": System.out.println("name starts with KI");break;
		    case "ra":  System.out.println("name starts with RA");break;  
		    case "ka": System.out.println("name starts with KA");break;
		    default:System.out.println("no value !!1");  
		 }
		 String s = getAccountNumber("rgdfgdfgdfg");
		 System.out.println(s);
	}
	
	public static String getAccountNumber(String cardNumber){
		return cardNumber.substring(6, cardNumber.length()-1);
	}
	public static void getTime() throws Exception{
	
		final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    int interval = 10000; // 1000 ms

	    new Timer(interval, new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            Calendar now = Calendar.getInstance();
	            System.out.println(dateFormat.format(now.getTime()));
	        }
	    }).start();

	   Thread.currentThread().join();
	}
	
}

