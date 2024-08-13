/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online.medicine.donation.system;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.toedter.calendar.JDateChooser;
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
import java.text.SimpleDateFormat;
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
public class UserRegistrationForm extends JFrame{
     private JLabel title,imglabel, namel,emaill,contactl,locationl, passwordl,confirml,genderl,agel,label2,title1,label;
    private JTextField nametf,emailtf,contacttf,locationtf,gendertf;
     private JDateChooser agetf;
      JPasswordField passwordtf,confirmtf;
      private Container c;
      private JButton login,clear ,homepage,logout,ngo,user,executive, register,back,reset,admin;
      private Cursor cursor;
     private ImageIcon icon;
     private JCheckBox showpasscheckbox;
      private JRadioButton male,female;
      private ButtonGroup grp;
      
      Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs;
   
       
  
  UserRegistrationForm() 
    {
        initComponents(); 
       
    } 
   
   
    void initComponents()
    { 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1930, 1030);
        this.setTitle("User Registration Form");
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
        ngo = new JButton("NGO");
       ngo.setFont(font1);
       ngo.setBounds(422, 30, 200, 80);
       ngo.setCursor(cursor);
       label.add(ngo);
    
       executive = new JButton("Executive");
       executive.setFont(font1);
       executive.setBounds(623,30, 200, 80);
       executive.setCursor(cursor);
        label.add(executive);
  
        
 
       logout = new JButton("LogOut");
       logout.setFont(font1);
        logout.setBounds(824, 30, 200, 80);
       logout.setCursor(cursor);
        label.add(logout);
        JPanel panel1 = new JPanel();
        panel1.setBounds(1, 260,1900,1380);
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
       label2.setBounds(480, 2, 1200, 1280);
       label2.setOpaque(true);
       label2.setBackground(Color.LIGHT_GRAY);
        imglabel.add(label2); 
         
        title1 = new JLabel("User Registration Form");
        title1.setFont(font1);
        title1.setBounds(2, 2,  1380, 60);
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
       namel.setBounds(20, 360, 300, 40);
        label2.add(namel); 
        nametf = new JTextField("");
        nametf.setFont(font1);
        nametf.setBounds(260, 360, 880, 40);
        label2.add(nametf); 
         genderl  = new JLabel("Gender");
        genderl.setFont(font1);
       genderl.setBounds(20, 410, 300, 40);
        label2.add(genderl); 
        male = new JRadioButton("Male");
      male.setBounds(480, 410, 100, 40);
      male.setFont(font1);
      label2.add(male);
       female = new JRadioButton("Female");
        female.setBounds(780, 410, 130, 40);
        female.setFont(font1);
      label2.add(female);
         grp = new ButtonGroup();
          grp.add(male);
          grp.add(female);
       agel = new JLabel("Date of Birth");
        agel.setFont(font1);
        agel.setBounds(20,460, 300, 40);
       label2.add(agel); 
        agetf = new JDateChooser();
        agetf.setFont(font1);
       agetf.setBounds(260, 460, 880, 40);
       label2.add(agetf);
        emaill = new JLabel("Email");
        emaill.setFont(font1);
        emaill.setBounds(20, 510, 300, 40);
       label2.add(emaill); 
        emailtf = new JTextField("");
        emailtf.setFont(font1);
        emailtf.setBounds(260, 510, 880, 40);
       label2.add(emailtf); 
        contactl = new JLabel("Contact Number");
        contactl.setFont(font1);
        contactl.setBounds(20, 560, 300, 40);
       label2.add(contactl); 
       contacttf = new JTextField("");
        contacttf.setFont(font1);
        contacttf.setBounds(260, 560, 880, 40);
        label2.add(contacttf); 
        locationl = new JLabel("Location");
        locationl.setFont(font1);
        locationl.setBounds(20, 610, 300, 40);
       label2.add(locationl); 
        locationtf = new JTextField("");
        locationtf.setFont(font1);
        locationtf.setBounds(260,610, 880, 40);
       label2.add(locationtf); 
        passwordl = new JLabel("Password");
        passwordl.setFont(font1);
        passwordl.setBounds(20, 660, 300, 40);
       label2.add(passwordl); 
         passwordtf = new JPasswordField("");
        passwordtf.setFont(font1);
        passwordtf.setBounds(260, 660, 880, 40);
         passwordtf.setEchoChar('*');
       label2.add(passwordtf); 
       confirml = new JLabel("Confirm Password");
        confirml.setFont(font1);
        confirml.setBounds(20, 710, 300, 40);
       label2.add(confirml); 
        confirmtf = new JPasswordField("");
        confirmtf.setFont(font1);
        confirmtf.setBounds(260,710, 880, 40);
         confirmtf.setEchoChar('*');
        label2.add(confirmtf); 
        showpasscheckbox = new JCheckBox("Show Password");
        showpasscheckbox .setBounds(300, 780, 250, 40);
        showpasscheckbox .setFont(font1);
       showpasscheckbox .setBackground(Color.LIGHT_GRAY);
       label2.add(showpasscheckbox );
       register = new JButton("Register");
       register.setFont(font1);
      
      register.setBounds(250, 900,700, 60);
        
        register.setCursor(cursor);
         label2.add(register);
         reset = new JButton("Reset");
       reset.setFont(font1);
      
       reset.setBounds(290, 980, 600, 60);
        
        reset.setCursor(cursor);
         label2.add(reset);
        back= new JButton("Back to Login");
       back.setFont(font1);
      
       back.setBounds(320, 1060, 500, 60);
        
        back.setCursor(cursor);
       label2.add(back);
         
         
       
         Handler handler = new Handler();
         register.addActionListener(handler);
        showpasscheckbox.addActionListener(handler);
        reset.addActionListener(handler);
        back.addActionListener(handler);
        homepage.addActionListener(handler);
         admin.addActionListener(handler);
        ngo.addActionListener(handler);
        executive.addActionListener(handler);
    
       
       logout.addActionListener(handler);
        
    }
    
     class Handler implements ActionListener{
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() ==  register){
             String p =passwordtf.getText();
          String c = confirmtf.getText();
            
            if(nametf.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please Enter Name","Warning",JOptionPane.ERROR_MESSAGE);
            }
             else if(!male.isSelected() && !female.isSelected())
            {
                JOptionPane.showMessageDialog(null, "Please Enter Gender","Warning",JOptionPane.ERROR_MESSAGE);
            }
             else if(agetf.getDate()==null)
            {
                JOptionPane.showMessageDialog(null, "Please Enter Age","Warning",JOptionPane.ERROR_MESSAGE);
            }
             else if(emailtf.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please Enter Email","Warning",JOptionPane.ERROR_MESSAGE);
            }
             
             else if(contacttf.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please Contact Number","Warning",JOptionPane.ERROR_MESSAGE);
            }
             else if(locationtf.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please Enter Location","Warning",JOptionPane.ERROR_MESSAGE);
            }
             
             else if(passwordtf.getText().isEmpty() || confirmtf.getText().isEmpty()){
                  JOptionPane.showMessageDialog(null, "Please Enter Password or Confirm Password","Warning",JOptionPane.ERROR_MESSAGE);
             }
           
               else if(checkusername(nametf.getText() ,emailtf.getText()))     
              {
              
                    JOptionPane.showMessageDialog(null, "This user name and email already exist");
                 }
            
              
             else if(!p.equals(c)){
                
               
                    JOptionPane.showMessageDialog(null, "Password and Confirm Password do not match");
                
            }
             
           else {
                  if(p.equals(c)){
                      SimpleDateFormat formate = new SimpleDateFormat("dd-MM-YY");
                       String bd = formate.format(agetf.getDate());
                      String sql = "INSERT INTO `userregistration`(`Name`,`Gender`, `Date of Birth`, `Email`, `Contact Number`, `Location`, `Password`)" + "VALUES (?,? ,?, ?, ?,?,?)";
                      
                      try{
                          con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/online medicine donation system","root", "");
                          
                          pst =  (PreparedStatement) con.prepareStatement(sql);
                          pst.setString(1, nametf.getText());
                          if(male.isSelected()){
                              pst.setString(2,male.getText());
                          }
                          else{
                              pst.setString(2,female.getText());
                          }
                          pst.setString(3, bd);
                          pst.setString(4, emailtf.getText());
                          pst.setString(5, contacttf.getText());
                          pst.setString(6, locationtf.getText());
                          pst.setString(7, passwordtf.getText());
                          pst.executeUpdate();
                          con.close();
                          
                          
                          JOptionPane.showMessageDialog(null, "User Registration successfully");
                          
                      }
                      
                      catch (SQLException ex) {
                          
                          JOptionPane.showMessageDialog(null, "User Registration unsuccessfully"+ex);
                      }
                      
                      
                  }
              }
          }
            
          
         
        if(ae.getSource() ==  reset)
            
        {
           nametf.setText("");
           grp.clearSelection();
           agetf.setDateFormatString("");
           emailtf.setText("");
           contacttf.setText("");
          locationtf.setText("");
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
            UserLogin frame = new UserLogin();
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

       if(ae.getSource()==ngo){
       
            ngo.setBackground(Color.LIGHT_GRAY);
            setVisible(false);
            NGOLogin frame = new NGOLogin();
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
     };
     
    public boolean checkusername(String username, String ema) 
{
    boolean checkuser = false;
      boolean email = false;
       Connection con2=null;
    PreparedStatement pst2=null;
      ResultSet rs;
     String sql = "SELECT * FROM `userregistration` WHERE `Name` =? AND `Email`=?";
    
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
        UserRegistrationForm frame = new UserRegistrationForm ();
        
        frame.setVisible(true);
    }   
    }

