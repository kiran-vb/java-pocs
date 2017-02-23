package com.sau.creditcard.poc;

import javax.swing.JOptionPane;

public class YesRNoPopupDemo {

	public static void main(String[] args) {
		 //int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogButton = JOptionPane.YES_NO_CANCEL_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Save your Previous Note First?","FOR FAST CARD RETRIEVAL",dialogButton);
		
		if(dialogResult == JOptionPane.YES_OPTION){
		    System.out.println("YES");
		}else{
			System.out.println("No");
		}

	}

}
