/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online.medicine.donation.system;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hp
 */
public class User1 extends JFrame {
     private Container c;
   
    private JLabel label,title,title1,label2,label1;
     private JButton  homepage,logout,order,donate;
  
    String uname =  UserLogin.usernametf.getText();
     
        
     
    
    User1()
    {
        initComponents();     
    }
   
    void initComponents()
    { 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1930, 1030);
        this.setTitle("User");
        c = this.getContentPane();
        c.setLayout(null);
        this.setResizable(false);
         c.setBackground(Color.GRAY);
         
         
         Font font = new Font("Arial",Font.BOLD,42);
         title = new JLabel("Online Medicine Donation System");
        title.setFont(font);
        title.setBounds(2, 2, 1930, 80);
        title.setForeground(Color.BLUE);
        title.setOpaque(true);
        title.setBackground(Color.ORANGE);
        c.add(title);
        label = new JLabel();
        label.setBounds(1, 100, 1930, 150);
        label.setOpaque(true);
        label.setBackground(Color.MAGENTA);
        c.add(label);
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
      
        Font font1 = new Font("Arial",Font.BOLD,24);
           homepage = new JButton("Home Page");
        homepage.setFont(font1);
       
        homepage.setBounds(20, 30, 170, 80);
        
        homepage.setCursor(cursor);
         label.add(homepage);
        
    
      order = new JButton("My Order");
     order.setFont(font1);
    order.setBounds(191, 30, 170, 80);
      order.setCursor(cursor);
        label.add(order);
      
        donate = new JButton("Donate Medicine");
      donate.setFont(font1);
         donate.setBounds(362, 30, 270, 80);
       donate.setCursor(cursor);
        label.add( donate);
       logout = new JButton("Logout");
      logout.setFont(font1);
        logout.setBounds(633, 30, 190, 80);
       logout.setCursor(cursor);
        label.add(logout);
         
       
     label1 = new JLabel("Welcome "+uname);
         label1.setBounds(100, 500, 1900, 200);
        
         Font font2 = new Font("Arial",Font.BOLD,50);
           label1.setFont(font2);
         c.add(label1);
          
          label2 = new JLabel("Hi "+uname);
         
          
         label2.setBounds(1660, 30, 500, 80);
         label2.setFont(font1);
         label2.setToolTipText(uname);
         
           
         label.add(label2);   
        Handler handler = new Handler();
        homepage.addActionListener(handler);
        
     order.addActionListener(handler);
     donate.addActionListener(handler);
     logout.addActionListener(handler);
    
    
}
    class Handler implements ActionListener{
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() ==  homepage)
            
        {
            setVisible(false);
            HomePage frame = new  HomePage();
            frame.setVisible(true);
        }
        if(ae.getSource() ==  order)
            
        {
            setVisible(false);
          MyOrder frame = new MyOrder();
          frame.setVisible(true);
         
        }
        if(ae.getSource() ==  donate)
            
        {
            setVisible(false);
          DonateMedicine frame = new DonateMedicine();
          frame.setVisible(true);
         
        }
       if(ae.getSource()==logout)
        {
         
          int a = JOptionPane.showConfirmDialog(null, "Are You Sure?");
          if(a==JOptionPane.YES_OPTION){
           setVisible(false); 
          UserLogin frame = new UserLogin();
          frame.setVisible(true);
          }
        }
    
   
    }
        
        }   
 public static void main(String[] args) {
        User1 frame = new User1();
        frame.setVisible(true);    
    } 
}
