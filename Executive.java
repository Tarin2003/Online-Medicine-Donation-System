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
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Hp
 */
public class Executive extends JFrame{
     private JLabel title,userlabel,title1,label2,label,label1;
    private JButton homepage,logout,assign,collect,buymed,viewmedicine,viewuser, donate;
   private Cursor cursor;
    private JPasswordField passwordtf;
    private JCheckBox showpasscheckbox;
    private ImageIcon icon;
    private JTextField emailtf,nametf;
    private Container c;
    private Connection con;
   private PreparedStatement pst;
   private ResultSet rs;
         
    String uname = ExecutiveLogin.nametf.getText();  
        
  
  Executive()
    {
      
        initComponents();     
    } 
    void initComponents()
    {  
   
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1930, 1030);
        this.setTitle("Executive ");
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
        
    
      assign = new JButton("View Assigned User");
     assign.setFont(font1);
     assign.setBounds(191, 30, 265, 80);
       assign.setCursor(cursor);
        label.add(assign);
        viewmedicine = new JButton("View Medicine");
      viewmedicine.setFont(font1);
        viewmedicine.setBounds(457, 30, 200, 80);
      viewmedicine.setCursor(cursor);
        label.add(viewmedicine);
        viewuser = new JButton("View Buy Med");
     viewuser.setFont(font1);
        viewuser.setBounds(658, 30, 199, 80);
      viewuser.setCursor(cursor);
        label.add(viewuser);
        buymed = new JButton("Buy Medicine");
       buymed.setFont(font1);
        buymed.setBounds(858, 30, 190, 80);
       buymed.setCursor(cursor);
        label.add(buymed);
       donate = new JButton("View Donate");
      donate.setFont(font1);
        donate.setBounds(1049, 30, 180, 80);
      donate.setCursor(cursor);
        label.add(donate);
collect = new JButton("Collect Medicine");
       collect.setCursor(cursor);
        collect.setFont(font1);
      collect.setBounds(1230, 30, 230, 80);
       label.add(collect);
      
       
       logout = new JButton("LogOut");
       logout.setFont(font1);
        logout.setBounds(1461, 30, 120, 80);
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
        
     assign.addActionListener(handler);
     viewmedicine.addActionListener(handler);
     viewuser.addActionListener(handler);
      buymed.addActionListener(handler);
      donate.addActionListener(handler);
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
        if(ae.getSource() ==  assign)
            
        {
            setVisible(false);
          Viewassignexecutive frame = new Viewassignexecutive();
          frame.setVisible(true);
         
        }
        if(ae.getSource() ==  viewmedicine)
            
        {
            setVisible(false);
          MedicineView frame = new MedicineView();
          frame.setVisible(true);
         
        }
        if(ae.getSource() ==  viewuser)
            
        {
            setVisible(false);
          User frame = new User();
          frame.setVisible(true);
         
        }
        if(ae.getSource()==buymed)
        {
             setVisible(false);
         BuyMedicine frame = new BuyMedicine();
          frame.setVisible(true);
        }
        if(ae.getSource() ==  donate)
            
        {
            setVisible(false);
          ViewDonateMedicine frame = new ViewDonateMedicine ();
          frame.setVisible(true);
         
        }
        
         if(ae.getSource()==collect)
        {
             setVisible(false);
         CollectMedicine frame = new CollectMedicine();
          frame.setVisible(true);
        }
        
       
       if(ae.getSource()==logout)
        {
         
          int a = JOptionPane.showConfirmDialog(null, "Are You Sure?");
          if(a==JOptionPane.YES_OPTION){
           setVisible(false); 
         ExecutiveLogin frame = new ExecutiveLogin();
          frame.setVisible(true);
          }
        }
    
   
    }
        
        }     
    
   
    
    
        
      

    


    

    public static void main(String[] args) {
        Executive frame = new Executive();
        frame.setVisible(true);    
    } 
}
    
    
    

