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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Hp
 */
public class NGORegistration extends JFrame {
    
     private JLabel title,imglabel, namel,emaill,contactl,locationl, passwordl,confirml,label2,title1,label;
    private JTextField nametf,emailtf;
      JPasswordField passwordtf,confirmtf;
      private Container c;
      private JButton login,clear ,homepage,logout,ngo,user,executive, register,back,reset,admin;
      private Cursor cursor;
     private ImageIcon icon;
     private JCheckBox showpasscheckbox;
      private JRadioButton male,female;
      private ButtonGroup grp;
      
      Connection con2 = null;
    PreparedStatement pst2=null;
    
   
   
       
  
 NGORegistration () 
    {
        initComponents(); 
       
    } 
   
   
    void initComponents()
    { 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1930, 1030);
        this.setTitle("NGO Registration Form");
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
       
        homepage.setBounds(20, 30, 200, 80);
        
        homepage.setCursor(cursor);
         label.add(homepage);
          admin = new JButton("Admin");
       admin.setFont(font1);
        admin.setBounds(221, 30, 200, 80);
       admin.setCursor(cursor);
        label.add(admin);
    
    
      executive = new JButton("Executive");
      executive.setFont(font1);
       executive.setBounds( 422, 30, 200, 80);
       executive.setCursor(cursor);
        label.add(executive);
  
         user = new JButton("User");
     user .setFont(font1);
      user .setBounds(623,30, 200, 80);
      user .setCursor(cursor);
       label.add(user );
        
 
       logout = new JButton("LogOut");
       logout.setFont(font1);
        logout.setBounds(824, 30, 200, 80);
       logout.setCursor(cursor);
        label.add(logout);
         JPanel panel1 = new JPanel();
        panel1.setBounds(1, 260,1900,1030);
        c.add(panel1);
        JScrollPane scroll = new JScrollPane(panel1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scroll.setBounds(1, 260,1910,720);
    c.add(scroll);
    
        icon = new ImageIcon(getClass().getResource("medicin.jpeg"));
      Image img = icon.getImage();
        Image newimage = img.getScaledInstance(panel1.getWidth(), panel1.getHeight(), Image.SCALE_SMOOTH);
       icon = new ImageIcon(newimage);
        imglabel = new JLabel(icon);
         
        panel1.add(imglabel);
        
        label2 = new JLabel();
        label2.setFont(font);
       label2.setBounds(480, 2, 1200, 900);
       label2.setOpaque(true);
       label2.setBackground(Color.LIGHT_GRAY);
        imglabel.add(label2); 
         
        title1 = new JLabel("NGO Registration Form");
        title1.setFont(font1);
        title1.setBounds(2, 2,  11200, 60);
        title1.setForeground(Color.BLUE);
       title1.setOpaque(true);
       title1.setBackground(Color.ORANGE);
        label2.add(title1);
        
         JPanel panel2 = new JPanel();
        panel2.setBounds(480, 80,230,230);
        panel2.setBackground(Color.WHITE);
        label2.add(panel2);
          icon = new ImageIcon(getClass().getResource("login.png"));
           Image img1 = icon.getImage();
           Image newimage1 = img1.getScaledInstance(panel2.getWidth(), panel2.getHeight(), Image.SCALE_SMOOTH);
       icon = new ImageIcon(newimage1);
        imglabel = new JLabel(icon);
        panel2.add(imglabel);
        namel = new JLabel("User Name");
        namel.setFont(font1);
       namel.setBounds(40, 360, 180, 40);
        label2.add(namel); 
        nametf = new JTextField("");
        nametf.setFont(font1);
        nametf.setBounds(273, 360, 880, 40);
        label2.add(nametf); 
         emaill = new JLabel("Email");
        emaill.setFont(font1);
       emaill.setBounds(40,410, 180, 40);
        label2.add(emaill); 
        emailtf = new JTextField("");
        emailtf.setFont(font1);
        emailtf.setBounds(273, 410, 880, 40);
        label2.add(emailtf); 
         passwordl = new JLabel("Password");
        passwordl.setFont(font1);
         passwordl.setBounds(40,460, 180, 40);
        label2.add(passwordl); 
        passwordtf = new JPasswordField("");
        passwordtf.setFont(font1);
        passwordtf.setBounds(273, 460, 880, 40);
        passwordtf.setEchoChar('*');
        label2.add(passwordtf);
        confirml = new JLabel("Confirm Password");
        confirml.setFont(font1);
        confirml.setBounds(35, 510, 300, 40);
       label2.add(confirml); 
      confirmtf = new JPasswordField("");
        confirmtf.setFont(font1);
        confirmtf.setBounds(273, 510, 880, 40);
       confirmtf.setEchoChar('*');
       label2.add(confirmtf); 
        showpasscheckbox = new JCheckBox("Show Password");
        showpasscheckbox .setBounds(300, 560, 250, 40);
       showpasscheckbox .setFont(font1);
      showpasscheckbox .setBackground(Color.LIGHT_GRAY);
        label2.add(showpasscheckbox );
        register = new JButton(" Register");
        register.setBounds(360, 630, 150, 50);
        register.setFont(font1);
         register.setCursor(cursor);
         label2.add( register);
         reset= new JButton("Reset");
         reset .setBounds(680, 630, 150, 50);
        reset .setFont(font1);
        reset .setCursor(cursor);
         label2.add( reset );
        back= new JButton("Click Here Back to Login");
        back .setBounds(385, 720, 390, 50);
        back .setFont(font1);
      back.setBackground(Color.LIGHT_GRAY);
       back .setCursor(cursor);
         label2.add( back );
         
        Handler handler = new Handler();
         register.addActionListener(handler);
        showpasscheckbox.addActionListener(handler);
       reset.addActionListener(handler);
       back.addActionListener(handler);
      homepage.addActionListener(handler);
        admin.addActionListener(handler);
        executive.addActionListener(handler);
      user.addActionListener(handler);
       
       logout.addActionListener(handler);
       
}
     class Handler implements ActionListener{
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() ==  register){
            
            String Email = emailtf.getText();
                String Name = nametf.getText();
                 String Password = passwordtf.getText();
                  String Confirm = confirmtf.getText();
               if(Name.isEmpty())
                 {
                     JOptionPane.showMessageDialog(null, "Please Enter User Name","Warning",JOptionPane.ERROR_MESSAGE);
                 }  
            else if(Email.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Please Enter  Email","Warning",JOptionPane.ERROR_MESSAGE);
                }
                 
                
              else if(Password.isEmpty() || Confirm.isEmpty()){
                  JOptionPane.showMessageDialog(null, "Please Enter Password or Confirm Password","Warning",JOptionPane.ERROR_MESSAGE);
             }
 
              
             else if(!Password.equals(Confirm)){
                
               
                    JOptionPane.showMessageDialog(null, "Password and Confirm Password do not match");
                
            
            }
              else if(checkusername(Name,Email))     
              {
              
                    JOptionPane.showMessageDialog(null, "This user name and email already exist");
                 }
            
                   
              else if(!Name.isEmpty()&& !Email.isEmpty()){
                  if(Password.equals(Confirm)) { 
               
              String sql = "SELECT `Name`, `Email` FROM `addngo`";   
                try {
                       
                 con2= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/online medicine donation system","root", "");
                  pst2 =   (PreparedStatement) con2.prepareStatement(sql);
                  ResultSet rs = pst2.executeQuery();
        
                    int bol = 0;        
          
           
               while(rs.next()){
                    
                     String n =rs.getString("Name");
                     String e =rs.getString("Email");
                  
               if(((Name.equals(n)))&& ((Email.equals(e)))) 
                 {
                 String sql1 = "INSERT INTO `ngoregistrationform`(`User Name`, `Email`, `Password`)" + "VALUES(?,?,?)";
              
                 try{      
                con2 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/online medicine donation system","root", "");
               pst2 =   (PreparedStatement) con2.prepareStatement(sql1);
               pst2.setString(1, Name);
                pst2.setString(2, Email);
                pst2.setString(3, Password);
               
               pst2.executeUpdate();
                con2.close();
                  
               JOptionPane.showMessageDialog(null, "NGO Registration Successfully");
                 bol = 1;
                 break;
                 
               }         catch (SQLException ex) {
                              JOptionPane.showMessageDialog(null, " NGO Registration Unsuccessfully  "+ex);
                         }

                 }
               }
               if(bol==0)
               {
                   JOptionPane.showMessageDialog(null, " You Not NGO","Warning",JOptionPane.ERROR_MESSAGE);
               }
                con2.close();
                   pst2.close(); 
                   
               } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, " NGO Registration Unsuccessfully  "+ex);
                }
   
                      
             
              }
              
               
              }        
                             
        }   
              

        if(ae.getSource() ==  reset)
            
        {
           nametf.setText("");
         
           emailtf.setText("");
           
          passwordtf.setText("");
          confirmtf.setText("");
          
        }
          
    
        
           
        
        {
            if(showpasscheckbox.isSelected())
            {
                passwordtf.setEchoChar((char)0);
                 confirmtf.setEchoChar((char)0);
            }
            else{
                passwordtf.setEchoChar('*');
               confirmtf.setEchoChar('*');
            }
        }
         if(ae.getSource()==back){
       
            
            setVisible(false);
            NGOLogin frame = new NGOLogin();
             frame.setVisible(true); 
            
        }
       if(ae.getSource()==homepage){
       
            homepage.setBackground(Color.LIGHT_GRAY);
            setVisible(false);
            HomePage frame = new HomePage();
             frame.setVisible(true); 
            
        }
          if(ae.getSource()==admin){
            
            admin.setBackground(Color.LIGHT_GRAY);
            setVisible(false);
            Login frame = new Login();
             frame.setVisible(true); 
        
    }

       if(ae.getSource()==user){
       
           user.setBackground(Color.LIGHT_GRAY);
            setVisible(false);
            UserLogin frame = new UserLogin();
             frame.setVisible(true); 
            
        }
       if(ae.getSource()==executive){
         setVisible(false);
            executive.setBackground(Color.LIGHT_GRAY);
            ExecutiveLogin frame = new ExecutiveLogin();
             frame.setVisible(true);
       }
    
       
            
   
   if(ae.getSource()==logout){
        
                
          System.exit(0);
    }
               
        
    }
     }
     
     
public boolean checkusername(String username, String ema) 
{
    boolean checkuser = false;
      boolean email = false;
       Connection con2=null;
    PreparedStatement pst2=null;
      ResultSet rs;
     String sql = "SELECT * FROM `ngoregistrationform` WHERE `User Name` =? AND `Email`=?";
    
          try{
              con2 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/online medicine donation system","root", "");
          
            pst2 =  (PreparedStatement) con2.prepareStatement(sql);
            pst2.setString(1, username);
            
           pst2.setString(2, ema);
           
             rs = pst2.executeQuery();
 
                 if(rs.next()){
                    checkuser = true;
                    email = true;
                   
                   
                 }
    
}        catch (SQLException ex) {
             Logger.getLogger(UserRegistrationForm.class.getName()).log(Level.SEVERE, null, ex);
         }
         return checkuser && email  ;
         
        
}
      public static void main(String[] args) {
        NGORegistration frame = new NGORegistration();
        
        frame.setVisible(true);
    }   
    }
