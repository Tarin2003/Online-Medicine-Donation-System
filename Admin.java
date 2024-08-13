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
import javax.swing.JPanel;
import javax.swing.JScrollPane;



/**
 *
 * @author Hp
 */
public class Admin   extends JFrame {
    private JLabel label,title,label1,label2,label3;
   private  JPanel panel;
    private JButton homepage, addmed,viewuser,viewngo,viewmed,addngo, logout;
   private Container c;
   Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Admin()
    {
        initComponents();     
    } 
   
    void initComponents()
    {  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1930, 1030);
        this.setTitle("Admin");
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
        homepage.setBackground(Color.LIGHT_GRAY);
        homepage.setBounds(20, 30, 200, 80);
        
        homepage.setCursor(cursor);
         label.add(homepage);
    
       
       
     
       
        addngo = new JButton("Add NGO");
        addngo.setCursor(cursor);
        addngo.setFont(font1);
       addngo.setBounds(221, 30, 200, 80);
       label.add(addngo);
        
         addmed = new JButton("Add Medicine");
       addmed.setCursor(cursor);
        addmed.setFont(font1);
        addmed.setBounds(422, 30, 250, 80);
        label.add(addmed);
        
        viewngo = new JButton("View NGO");
       viewngo.setCursor(cursor);
        viewngo.setFont(font1);
        viewngo.setBounds(673, 30, 200, 80);
       label.add(viewngo);
        viewmed = new JButton("View Medicine");
       viewmed.setCursor(cursor);
        viewmed.setFont(font1);
        viewmed.setBounds(874, 30,250, 80);
        label.add(viewmed);
        viewuser = new JButton("View User");
       viewuser.setCursor(cursor);
        viewuser.setFont(font1);
        viewuser.setBounds(1125, 30, 200, 80);
        label.add(viewuser);
       logout = new JButton("Logout");
       logout.setCursor(cursor);
        logout.setFont(font1);
        logout.setBounds(1326, 30,200, 80);
        label.add(logout);
    
              
         label1 = new JLabel("Welcome "+Login.usernametf.getText());
         label1.setBounds(100, 500, 1900, 200);
        
         Font font2 = new Font("Arial",Font.BOLD,50);
           label1.setFont(font2);
         c.add(label1);
          
          label2 = new JLabel("Hi "+Login.usernametf.getText());
         
          
         label2.setBounds(1660, 30, 500, 80);
         label2.setFont(font1);
         label2.setToolTipText(Login.usernametf.getText());
         
           
         label.add(label2);
               
              
         
          
         
        
        Handler handler = new Handler();
        homepage.addActionListener(handler);
        addngo.addActionListener(handler);
        addmed.addActionListener(handler);
       viewngo.addActionListener(handler);
       viewmed.addActionListener(handler);
       viewuser.addActionListener(handler);
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
        else if(ae.getSource() ==  addngo)
            
        {
           setVisible(false); 
           AddNGO frame = new  AddNGO();
            frame.setVisible(true);
        }
        else if(ae.getSource() ==  addmed)
            
        {
            setVisible(false);
           AddMedicine frame = new  AddMedicine();
            frame.setVisible(true);
        }
        else if(ae.getSource() ==  viewngo)
            
        {
            setVisible(false);
          ViewNGO frame = new  ViewNGO();
            frame.setVisible(true);
           
        }
        else if(ae.getSource() ==  viewmed)
            
        {
           setVisible(false); 
          ViewMedicine frame = new  ViewMedicine();
            frame.setVisible(true);
        }
        else if(ae.getSource() ==  viewuser)
            
        {
            setVisible(false);
           ViewUser frame = new  ViewUser();
            frame.setVisible(true);
        }
        else if(ae.getSource()==logout)
        {
         
          int a = JOptionPane.showConfirmDialog(null, "Are You Sure?");
          if(a==JOptionPane.YES_OPTION){
           setVisible(false);
          Login frame = new Login();
          frame.setVisible(true);
          }
        }
    }
   
    };
public static void main(String[] args) {
        Admin  frame = new Admin();
         
        frame.setVisible(true);
        
        
    }

}

    

