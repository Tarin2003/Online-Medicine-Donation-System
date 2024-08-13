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
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Hp
 */
public class NGO extends JFrame {
     private Container c;
  
    private JLabel label,label2,title,title1,label1;
    private JButton  homepage,user,assign, logout,viwngo,viewmed,viewexecutive,collect;
  
   
  NGO()
    {
        initComponents();     
    }
   
    void initComponents()
    { 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1930, 1030);
        this.setTitle("NGO");
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
       
        homepage.setBounds(20, 30, 180, 80);
        
        homepage.setCursor(cursor);
         label.add(homepage);
  viwngo = new JButton("View NGO");
       viwngo.setCursor(cursor);
       viwngo.setFont(font1);
       viwngo.setBounds(201, 30, 180, 80);
       label.add( viwngo);
        viewmed = new JButton("View Medicine");
       viewmed.setCursor(cursor);
        viewmed.setFont(font1);
       viewmed.setBounds(382, 30, 220, 80);
       label.add(  viewmed);
       
       user = new JButton("View user");
        user.setCursor(cursor);
        user.setFont(font1);
        user.setBounds(603, 30, 180, 80);
       label.add( user);
        assign = new JButton("Assing Executive");
       assign.setCursor(cursor);
        assign.setFont(font1);
       assign.setBounds(784, 30, 250, 80);
       label.add(assign);
      
       viewexecutive = new JButton("View Executive");
        viewexecutive.setCursor(cursor);
        viewexecutive.setFont(font1);
        viewexecutive.setBounds(1035, 30, 222, 80);
       label.add(viewexecutive);
        collect = new JButton("View Collect Med");
       collect.setCursor(cursor);
        collect.setFont(font1);
        collect.setBounds(1258, 30, 250, 80);
        label.add(collect);
       
       logout = new JButton("Logout");
       logout.setCursor(cursor);
        logout.setFont(font1);
        logout.setBounds(1509, 30, 140, 80);
        label.add(logout);
                      
        
      
      label1 = new JLabel("Welcome "+NGOLogin.usernametf.getText());
         label1.setBounds(100, 500, 1900, 200);
        
         Font font2 = new Font("Arial",Font.BOLD,50);
           label1.setFont(font2);
         c.add(label1);
          
          label2 = new JLabel("Hi "+NGOLogin.usernametf.getText());
         
          
         label2.setBounds(1680, 30, 500, 80);
         label2.setFont(font1);
         label2.setToolTipText(NGOLogin.usernametf.getText());
         
           
         label.add(label2);
       
             
      
        
       
    Handler handler = new Handler();
        homepage.addActionListener(handler);
        viwngo.addActionListener(handler);
       viewmed.addActionListener(handler);
      user.addActionListener(handler);
      assign.addActionListener(handler);
      viewexecutive.addActionListener(handler);
     collect.addActionListener(handler);
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
        if(ae.getSource() ==  viwngo)
            
        {
            setVisible(false);
           ViewNGOngo frame = new   ViewNGOngo();
           frame.setVisible(true);
            
        }
         if(ae.getSource() ==  viewmed)
            
        {
            setVisible(false);
           ViewMedNGO frame = new    ViewMedNGO();
           frame.setVisible(true);
            
        }
        
        if(ae.getSource() ==  user)
            
        {
            setVisible(false);
          UserView frame = new UserView();
          frame.setVisible(true);
         
        }
        if(ae.getSource() ==  assign)
            
        {
            setVisible(false);
           AssignExecutive frame = new  AssignExecutive();
            frame.setVisible(true);
        }
         if(ae.getSource() ==  viewexecutive)
            
        {
            setVisible(false);
          ViewExecutive frame = new ViewExecutive();
          frame.setVisible(true);
         
        }
       
        
        if(ae.getSource() ==  collect)
            
        {
            setVisible(false);
          ViewCollectMedicine frame = new ViewCollectMedicine();
          frame.setVisible(true);
         
        }
        
       
       
        if(ae.getSource()==logout)
        {
         
          int a = JOptionPane.showConfirmDialog(null, "Are You Sure?");
          if(a==JOptionPane.YES_OPTION){
           setVisible(false); 
          NGOLogin frame = new NGOLogin();
          frame.setVisible(true);
          }
        }
    
   
    }
        
        }     
    
    public static void main(String[] args) {
       NGO frame = new NGO();
        
        frame.setVisible(true);
        
       
        
        
        
        
    }

}

    


    


    

