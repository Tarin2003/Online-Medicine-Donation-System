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
import java.sql.ResultSet;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hp
 */
public class ngodetailsadmin extends JFrame{
      private Container c;
     private JLabel title, namel,emaill,contactl,locationl,genderl,idl,passwordlabel,label,label2,title1,label1,title2,newlabel1;
    private JTextField nametf,emailtf,contacttf,locationtf,idtf,gendertf;
    private JButton  homepage, addmed,viewuser,viewngo,viewmed,addngo, logout,search;
    private DefaultTableModel mode;
    private JScrollPane scroll,scroll1;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
     private JRadioButton male,female;
      private ButtonGroup grp;
         
   
  
  ngodetailsadmin()
    {
      
        initComponents();     
    } 
    void initComponents()
    {  
   
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
      
        Font font1 = new Font("Arial",Font.BOLD,26);
         homepage = new JButton("Home Page");
        homepage.setFont(font1);
       
        homepage.setBounds(20, 30, 250, 80);
        
        homepage.setCursor(cursor);
         label.add(homepage);
    addngo = new JButton("Add NGO");
        addngo.setCursor(cursor);
        addngo.setFont(font1);
       addngo.setBounds(271, 30, 250, 80);
       label.add(addngo);
         addmed = new JButton("Add Medicine");
       addmed.setCursor(cursor);
        addmed.setFont(font1);
        addmed.setBounds(522, 30, 250, 80);
        label.add(addmed);
        
        
        viewmed = new JButton("View Medicine");
       viewmed.setCursor(cursor);
        viewmed.setFont(font1);
        viewmed.setBounds(773, 30, 250, 80);
        label.add(viewmed);
        viewuser = new JButton("View User");
       viewuser.setCursor(cursor);
        viewuser.setFont(font1);
        viewuser.setBounds(1024, 30,250, 80);
        label.add(viewuser);
       logout = new JButton("Logout");
       logout.setCursor(cursor);
        logout.setFont(font1);
        logout.setBounds(1275, 30, 250, 80);
        label.add(logout);
         
        newlabel1.setBounds(1, 260,1930,1030);
         label1.setOpaque(true);
          newlabel1.setBackground(Color.LIGHT_GRAY);
        c.add(newlabel1);
         title1 = new JLabel("View NGO");
        title1.setFont(font1);
        title1.setBounds(1, 260, 1900, 80);
        title1.setForeground(Color.BLUE);
       title1.setOpaque(true);
       title1.setBackground(Color.ORANGE);
       c.add(title1);
         title2 = new JLabel("Please ID and click the search button");
        title2.setFont(font1);
        title2.setBounds(600, 68, 1900, 27);
         newlabel1.add(title2);
        idl = new JLabel("ID");
       idl.setFont(font1);
     idl.setBounds(50, 100, 300, 40);
        label1.add(idl); 
      idtf = new JTextField("");
      idtf.setFont(font1);
        idtf.setBounds(290, 100,1400, 40); 
        idtf.setEditable(false);
          label1.add(idtf); 
        search = new JButton("Search");
       search .setCursor(cursor);
         search.setFont(font1);
        search.setBounds(1710, 100, 150, 60);
        namel = new JLabel("Name");
        namel.setFont(font1);
       namel.setBounds(50, 160, 300, 40);
       newlabel1.add(namel); 
        nametf = new JTextField("");
        nametf.setFont(font1);
        nametf.setBounds(290, 160, 1400, 40);
        newlabel1.add(nametf); 
       genderl  = new JLabel("Gender");
        genderl.setFont(font1);
       genderl.setBounds(50,220, 300, 40);
        newlabel1.add(genderl); 
        
         male = new JRadioButton("Male");
      male.setBounds(440, 220, 100, 40);
      male.setFont(font1);
     newlabel1.add(male);
       female = new JRadioButton("Female");
        female.setBounds(840, 220, 130, 40);
        female.setFont(font1);
     newlabel1.add(female);
         grp = new ButtonGroup();
          grp.add(male);
          grp.add(female);
        emaill = new JLabel("Email");
        emaill.setFont(font1);
        emaill.setBounds(50, 280, 300, 40);
       newlabel1.add(emaill); 
        emailtf = new JTextField("");
        emailtf.setFont(font1);
        emailtf.setBounds(290, 280, 1400, 40);
       newlabel1.add(emailtf);
       contactl = new JLabel("Contact Number");
       contactl.setFont(font1);
         contactl.setBounds(50, 340, 300, 40);
        newlabel1.add(contactl); 
      contacttf = new JTextField("");
        contacttf.setFont(font1);
        contacttf.setBounds(290, 340, 880, 40);
        
        newlabel1.add(contacttf);
        locationl = new JLabel("Location");
         locationl.setFont(font1);
         locationl.setBounds(50, 400, 300, 40);
       newlabel1.add( locationl); 
        locationtf = new JTextField("");
        locationtf.setFont(font1);
        locationtf.setBounds(290, 400, 1400, 40);
       newlabel1.add( locationtf); 
        label1.add( search);
        
         
          
         
        
    
}
     public static void main(String[] args) {
       ngodetailsadmin frame = new  ngodetailsadmin();
        frame.setVisible(true);    
    } 
}
    
