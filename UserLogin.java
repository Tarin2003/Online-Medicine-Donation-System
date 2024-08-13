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
public class UserLogin extends JFrame{
    private JLabel emaillabel,passwordlabel,imglabel,title,userlabel,title1,label2,label;
    private JButton login,clear ,homepage,logout,ngo,user,executive,admin,account;
   private Cursor cursor;
    private JPasswordField passwordtf;
    private JCheckBox showpasscheckbox;
    private ImageIcon icon;
   public static JTextField emailtf,usernametf;
    private Container c;
   Connection con;
    PreparedStatement pst,pst1;
    ResultSet rs,rs1;
     
  
   UserLogin()
    {
      
        initComponents();     
    } 
    void initComponents()
    {  
   
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1930, 1030);
        this.setTitle("User Login");
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
        ngo = new JButton("NGO");
       ngo.setFont(font1);
       ngo.setBounds(422, 30, 200, 80);
       ngo.setCursor(cursor);
       label.add(ngo);
    
       admin = new JButton("Admin");
      admin.setFont(font1);
      admin.setBounds(221, 30, 200, 80);
       admin.setCursor(cursor);
        label.add(admin);
  
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
        panel1.setBounds(1, 260,1960,1030);
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
       label2.setBounds(500, 2, 1130, 900);
       label2.setOpaque(true);
       label2.setBackground(Color.LIGHT_GRAY);
        imglabel.add(label2); 
         
        title1 = new JLabel("User Login");
        title1.setFont(font1);
        title1.setBounds(2, 2,  1130, 60);
        title1.setForeground(Color.BLUE);
       title1.setOpaque(true);
       title1.setBackground(Color.ORANGE);
        label2.add(title1);
        JPanel panel2 = new JPanel();
        panel2.setBounds(450, 80,230,230);
        panel2.setBackground(Color.WHITE);
        label2.add(panel2);
          icon = new ImageIcon(getClass().getResource("login.png"));
           Image img1 = icon.getImage();
           Image newimage1 = img1.getScaledInstance(panel2.getWidth(), panel2.getHeight(), Image.SCALE_SMOOTH);
       icon = new ImageIcon(newimage1);
        imglabel = new JLabel(icon);
        panel2.add(imglabel);
           
        userlabel = new JLabel("User Name");
        userlabel.setFont(font1);
       userlabel.setBounds(40, 360, 180, 40);
        label2.add(userlabel); 
        usernametf = new JTextField("");
        usernametf.setFont(font1);
        usernametf.setBounds(180, 360, 900, 40);
        label2.add(usernametf); 
       emaillabel = new JLabel("Email");
        emaillabel.setFont(font1);
       emaillabel.setBounds(40,410, 180, 40);
        label2.add(emaillabel); 
        emailtf = new JTextField("");
        emailtf.setFont(font1);
        emailtf.setBounds(180, 410, 900, 40);
        label2.add(emailtf); 
         passwordlabel = new JLabel("Password");
        passwordlabel.setFont(font1);
         passwordlabel.setBounds(40,460, 180, 40);
        label2.add(passwordlabel); 
        passwordtf = new JPasswordField("");
        passwordtf.setFont(font1);
        passwordtf.setBounds(180, 460, 900, 40);
        passwordtf.setEchoChar('*');
        label2.add(passwordtf);
         showpasscheckbox = new JCheckBox("Show Password");
        showpasscheckbox .setBounds(200, 510, 250, 40);
         showpasscheckbox .setFont(font1);
        showpasscheckbox .setBackground(Color.LIGHT_GRAY);
        label2.add( showpasscheckbox );
      
        login = new JButton("Login");
        login.setBounds(360, 580, 150, 50);
        login.setFont(font1);
        login.setCursor(cursor);
         label2.add(login);
         clear = new JButton("Reset");
         clear .setBounds(680, 580, 150, 50);
        clear .setFont(font1);
        clear .setCursor(cursor);
         label2.add( clear );
         account = new JButton("Create New Account");
        account .setBounds(380, 680, 360, 50);
        account .setFont(font1);
        account.setBackground(Color.LIGHT_GRAY);
       account .setCursor(cursor);
         label2.add( account );
         Handler handler = new Handler();
         login.addActionListener(handler);
        showpasscheckbox.addActionListener(handler);
       clear.addActionListener(handler);
       account.addActionListener(handler);
       homepage.addActionListener(handler);
         admin.addActionListener(handler);
        ngo.addActionListener(handler);
        executive.addActionListener(handler);
     
       
       logout.addActionListener(handler);
    } 
           class Handler implements ActionListener{
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==login){
            String Email = emailtf.getText();
                String Name = usernametf.getText();
                 String Password = passwordtf.getText();
               if(Name.isEmpty())
                 {
                     JOptionPane.showMessageDialog(null, "Please Enter User Name","Warning",JOptionPane.ERROR_MESSAGE);
                 }  
            else if(Email.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Please Enter  Email","Warning",JOptionPane.ERROR_MESSAGE);
                }
                 
                  else if(Password.isEmpty())
                 {
                     JOptionPane.showMessageDialog(null, "Please Enter  Password","Warning",JOptionPane.ERROR_MESSAGE);
                 }

              else if(!Name.isEmpty()&& !Email.isEmpty()&& !Password.isEmpty()) { 
               
                     int a = 0;
                    String sql = "SELECT *  FROM `userregistration` WHERE `Name`=? AND `Email`=?  AND`Password`=?";   
                   try {
                       
                       con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/online medicine donation system","root", "");
                  pst =   (PreparedStatement) con.prepareStatement(sql);
                  pst.setString(1, Name);
                  pst.setString(2, Email);
                  pst.setString(3, Password);
                  rs = pst.executeQuery();
 
                 while(rs.next()){
                   JOptionPane.showMessageDialog(null, "User Logined Succesfully");
                    setVisible(false) ;
                   User1 frame = new User1();
                   frame.setVisible(true);
                   a=1;
                   break;
                   }
                  con.close();
           
                   } catch (SQLException ex) {     
                     JOptionPane.showMessageDialog(null, "User Logined Unsuccesfully "+ ex); 
                }
                   if(a==0)
                   {
                      JOptionPane.showMessageDialog(null, "Please Enter Correct User Name or Email or Password","Warning",JOptionPane.ERROR_MESSAGE);
                   }
              }
        
           
        }     
                   
                 
                       
           
          if(ae.getSource()==clear){
       
           emailtf.setText("");
               usernametf.setText("");
                  passwordtf.setText("");
        }
   
         if(ae.getSource()==showpasscheckbox) {
            if(showpasscheckbox.isSelected())
            {
                passwordtf.setEchoChar((char)0);
            }
            else{
                passwordtf.setEchoChar('*');
            }
            
            
        }
         if(ae.getSource()==account){
       
           
            setVisible(false);
           UserRegistrationForm frame = new UserRegistrationForm();
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
           }
    
    
        
      

    


    

    public static void main(String[] args) {
        UserLogin  frame = new UserLogin();
        frame.setVisible(true);    
    } 
}
    

