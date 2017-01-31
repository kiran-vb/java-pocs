package com.sau.creditcard.poc;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

public class ButtonTest {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;
   private JLabel msglabel;
   private JTextField textField;
   private int trailCount=0;

   public ButtonTest(){
      prepareGUI();
   }

   public static void main(String[] args){
	   ButtonTest  swingContainerDemo = new ButtonTest();  
      swingContainerDemo.showJFrameDemo();
   }

   private void prepareGUI(){
      mainFrame = new JFrame("Java Swing Examples");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(3, 1));
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      headerLabel = new JLabel("", JLabel.CENTER);        
      statusLabel = new JLabel("",JLabel.CENTER);    

      statusLabel.setSize(350,100);

      msglabel = new JLabel("Welcome to TutorialsPoint SWING Tutorial.", JLabel.CENTER);
      textField =  new JTextField("",JTextField.CENTER);
      textField.setSize(150, 100);
      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.add(textField);
      mainFrame.setVisible(true);  
   }

   private void showJFrameDemo(){
      headerLabel.setText("Container in action: JFrame");   

      final JFrame frame = new JFrame();
      frame.setSize(400, 100);
      frame.setLayout(new FlowLayout());       
      frame.add(msglabel);
      frame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            frame.dispose();
         }        
      });    
      JButton okButton = new JButton("Open a Frame");
      okButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
          /*  statusLabel.setText("A Frame shown to the user.");
            frame.setVisible(true);*/
        	String cardNumber =  textField.getText();
        	if(cardNumber.contains("123")){
        		trailCount++;
        		System.out.println("trailCount ::: " + trailCount);
        		if(trailCount==3){
        			JOptionPane.showMessageDialog(null, trailCount + "::: invalid input ::: " + cardNumber);
        			JOptionPane.showMessageDialog(null, "Please try after 30 seconds  !!!!!!");
        			trailCount=0;
        		    showWaitDailog();
        		}else{
        			JOptionPane.showMessageDialog(null, "invalid input ::: " + cardNumber);
        		}
        		
        	}else{
    			JOptionPane.showMessageDialog(null, trailCount + "::: Card Number is :::: " + cardNumber);
    		}
        	 
        	 
         }

		private void showWaitDailog() {
			 frame.setVisible(true);
			TimerTask timerTask = new TimerTask() {
				int second = 5;
				@Override
				public void run() {
					print30Seconds();
				}

				private void print30Seconds() {
					Calendar calendar = Calendar.getInstance();
					int seconds = calendar.get(Calendar.SECOND);
					//int minutes = calendar.get(Calendar.MINUTE);
					
					frame.setTitle("Application will close in " + second-- + " seconds.");
					// JOptionPane.showMessageDialog(null, "Application will close in " + second-- + " seconds.");

				}
			
			};
			  Timer timer = new Timer(true);
			  timer.scheduleAtFixedRate(timerTask, 0, 1*1000);
			   try {
		            Thread.sleep(5000);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		        timer.cancel();
		        frame.dispose();
		       
			
		}
      });
      controlPanel.add(okButton);
      mainFrame.setVisible(true);  
   }
}

