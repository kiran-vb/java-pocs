package com.sau.creditcard.poc;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Display30Seconds {
	 private static JFrame frame = new JFrame();
	public static void main(String[] args) {
		Display30Seconds dp30=new Display30Seconds();
		dp30.frame.setVisible(true);
		dp30.frame.setSize(400,100);
	
		TimerTask timerTask = new TimerTask() {
			int second = 5;
			@Override
			public void run() {
				print30Seconds();
			}

			private void print30Seconds() {
				 frame.setTitle("Application will close in " + second-- + " seconds.");
				// JOptionPane.showMessageDialog(null, "Application will close in " + second-- + " seconds.");

			}
		
		};
		  Timer timer = new Timer(true);
		  timer.scheduleAtFixedRate(timerTask, 0, 1*1000);
		   try {
	            Thread.sleep(3000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        timer.cancel();
	      frame.dispose();
	       
	}

}
