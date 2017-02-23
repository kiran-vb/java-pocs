package com.sau.creditcard.poc;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class GUI{
    public static void main(String [] args){
        GUI g = new GUI();
        g.Start();
    }

    public void Start(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(640, 640);            
        JPanel panel = new JPanel();
        JPanel west = new JPanel();         
        JLabel name = new JLabel("Name: ");
        JLabel age = new JLabel("Age: ");           
        JTextField field1 = new JTextField();
        JTextField field2 = new JTextField();   
        field1.setSize(100, 150);
        west.setLayout(new BoxLayout(west, BoxLayout.Y_AXIS));
        west.add(name);
        west.add(age);      
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(field1);
        panel.add(field2);          
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.WEST, west);
        frame.setVisible(true);
    }
}