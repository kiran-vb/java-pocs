package com.sau.creditcard.poc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class TimerFrame {
    private static JFrame frame = new JFrame();

    public static void main(String[] args) {
        TimerFrame timerFrame = new TimerFrame();
        timerFrame.frame.setVisible(true);
        timerFrame.frame.setSize(400,100);
        
        
        new Timer().schedule(new TimerTask(){

            int second = 10;
            @Override
            public void run() {
                frame.setTitle("Application will close in " + second-- + " seconds.");
            }   
        },0, 1000);
        
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        
    	
    	/*JOptionPane pane = new JOptionPane("Message", JOptionPane.INFORMATION_MESSAGE);
      final  JDialog dialog = pane.createDialog(null, "Title");
        dialog.setModal(false);
        dialog.setVisible(true);

        new Timer(10000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
               
            }
        }).start();*/
    	
    }
}