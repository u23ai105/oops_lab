/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.lab;
import javax.swing.JFrame;
/**
 *
 * @author muzammilmohammad
 */
public class lab {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Digital Clock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create an instance of the date_and_time JPanel
        date_and_time d1 = new date_and_time();
        
        // Add the JPanel to the JFrame
        frame.add(d1);
        
        // Set the frame size
        frame.setSize(400, 300);
        
        // Make the frame visible
        frame.setVisible(true);
    }
}
