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
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;


/**
 *
 * @author Hp
 */
public class AddNGO extends JFrame{
    private JLabel title, namel,emaill,contactl,locationl,genderl,idl,passwordlabel,label,label2,title1,imglabel;
    private JTextField nametf,emailtf1,contacttf,locationtf,idtf,gendertf;
      private Container c;
      private JButton add,reset,back,update,delete, homepage, addmed,viewuser,viewngo,viewmed,addngo, logout;
      private Cursor cursor;
      private JPasswordField passwordtf;
      private JRadioButton male,female;
      private ButtonGroup grp;
     
     private Connection con=null;
    private PreparedStatement pst=null;
  private ResultSet rs;
   
       
  
   AddNGO() 
    {
        initComponents(); 
       
    } 
   
   void Insert()
   {
     
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
      
        Font font1 = new Font("Arial",Font.BOLD,24);
         homepage = new JButton("Home Page");
        homepage.setFont(font1);
       
        homepage.setBounds(20, 30, 250, 80);
        
        homepage.setCursor(cursor);
         label.add(homepage);
    
         addmed = new JButton("Add Medicine");
       addmed.setCursor(cursor);
        addmed.setFont(font1);
        addmed.setBounds(271, 30, 250, 80);
        label.add(addmed);
        
        viewngo = new JButton("View NGO");
       viewngo.setCursor(cursor);
        viewngo.setFont(font1);
        viewngo.setBounds(522, 30, 250, 80);
       label.add(viewngo);
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
       
          
          label2 = new JLabel("Hi "+Login.usernametf.getText());
         
          
         label2.setBounds(1660, 30, 500, 80);
         label2.setFont(font1);
         label2.setToolTipText(Login.usernametf.getText());
         
           
         label.add(label2);
        
        
         JLabel newlabel = new JLabel();
         newlabel.setOpaque(true);
         newlabel.setBackground(Color.GRAY);
         newlabel.setBounds(1, 260,1900,780);
        c.add(newlabel);
         JLabel newlabel1 = new JLabel();
         newlabel1.setOpaque(true);
         newlabel1.setBackground(Color.LIGHT_GRAY);
         newlabel1.setBounds(300, 2,1350,780);
        newlabel.add(newlabel1);
       
           title1 = new JLabel("ADD NGO");
        title1.setFont(font1);
        title1.setBounds(2, 2, 1350, 60);
        title1.setForeground(Color.BLUE);
       title1.setOpaque(true);
       title1.setBackground(Color.ORANGE);
        newlabel1.add(title1);
       
        idl = new JLabel("ID");
       idl.setFont(font1);
        idl .setBounds(30, 80, 300, 40);
        newlabel1.add( idl ); 
         idtf = new JTextField("");
        idtf .setFont(font1);
        idtf .setBounds(240, 80, 880, 40);
       newlabel1.add(idtf ); 
        namel = new JLabel("Name");
        namel.setFont(font1);
       namel.setBounds(30, 130, 300, 40);
       newlabel1.add(namel); 
        nametf = new JTextField("");
        nametf.setFont(font1);
        nametf.setBounds(240, 130, 880, 40);
        newlabel1.add(nametf); 
       genderl  = new JLabel("Gender");
        genderl.setFont(font1);
       genderl.setBounds(30,180, 300, 40);
        newlabel1.add(genderl); 
        
         male = new JRadioButton("Male");
      male.setBounds(440, 180, 100, 40);
      male.setFont(font1);
     newlabel1.add(male);
       female = new JRadioButton("Female");
        female.setBounds(840, 180, 130, 40);
        female.setFont(font1);
     newlabel1.add(female);
         grp = new ButtonGroup();
          grp.add(male);
          grp.add(female);
        emaill = new JLabel("Email");
        emaill.setFont(font1);
        emaill.setBounds(30, 230, 300, 40);
       newlabel1.add(emaill); 
        emailtf1 = new JTextField("");
        emailtf1.setFont(font1);
        emailtf1.setBounds(240, 230, 880, 40);
       newlabel1.add(emailtf1);
       contactl = new JLabel("Contact Number");
       contactl.setFont(font1);
         contactl.setBounds(30, 280, 300, 40);
        newlabel1.add(contactl); 
      contacttf = new JTextField("");
        contacttf.setFont(font1);
        contacttf.setBounds(240, 280, 880, 40);
        
        newlabel1.add(contacttf);
        locationl = new JLabel("Location");
         locationl.setFont(font1);
         locationl.setBounds(30, 330, 300, 40);
       newlabel1.add( locationl); 
        locationtf = new JTextField("");
        locationtf.setFont(font1);
        locationtf.setBounds(240, 330, 880, 40);
       newlabel1.add( locationtf); 
       
        
        
       add = new JButton("ADD");
       add.setFont(font1);
      
       add.setBounds(1180, 80, 150, 60);
        
        add.setCursor(cursor);
        newlabel1.add(add);
          update = new JButton("Update");
       update.setFont(font1);
      
      update.setBounds(1180, 150, 150, 60);
        
        update.setCursor(cursor);
       newlabel1.add(update);
         
         delete = new JButton("Delete");
      delete.setFont(font1);
     delete.setBounds(1180, 220, 150, 60);
        
        delete.setCursor(cursor);
        newlabel1.add(delete);
        
         reset = new JButton("Reset");
      reset .setFont(font1);
      
      reset .setBounds(1180, 290, 150, 60);
        
        reset .setCursor(cursor);
        newlabel1.add(reset );
          
         Handler handler = new Handler();
         add.addActionListener(handler);
          male.addActionListener(handler);
         female.addActionListener(handler);
         update.addActionListener(handler);
         delete.addActionListener(handler);
        reset.addActionListener(handler);
        homepage.addActionListener(handler);
       
        addmed.addActionListener(handler);
       viewngo.addActionListener(handler);
       viewmed.addActionListener(handler);
       viewuser.addActionListener(handler);
       logout.addActionListener(handler);
        
       
    }
    
     class Handler implements ActionListener{
    public void actionPerformed(ActionEvent ae) {
        
             if(ae.getSource() ==  add)
        {
            if(idtf.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please Enter ID","Warning",JOptionPane.ERROR_MESSAGE);
            }
            else if(nametf.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please Enter Name","Warning",JOptionPane.ERROR_MESSAGE);
            }
             else if(!male.isSelected() && !female.isSelected())
            {
                JOptionPane.showMessageDialog(null, "Please Enter Gender","Warning",JOptionPane.ERROR_MESSAGE);
            }
             else if(emailtf1.getText().isEmpty())
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
             else if(checkusername(nametf.getText() ,emailtf1.getText()))     
              {
              
                    JOptionPane.showMessageDialog(null, "This NGO  already existe or This ID already  exist");
                 }
            
                    
             else{
           String sql = "INSERT INTO `addngo`(` ID`, `Name`, `Gender`, `Email`,  `Contact Number`, `Location`,`Admin Name`, `Admin Email`) " + "VALUES (?,?, ?, ?, ?,?,?,?)";      
          try{
              con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/online medicine donation system","root", "");
          
            pst =  (PreparedStatement) con.prepareStatement(sql);
             pst.setString(1, idtf.getText());
            pst.setString(2, nametf.getText());
             if(male.isSelected()){
             pst.setString(3, male.getText());
             }
            if(female.isSelected()){
                pst.setString(3, female.getText());
            }
            pst.setString(4, emailtf1.getText());
           
            pst.setString(5, contacttf.getText());
            pst.setString(6, locationtf.getText());
            pst.setString(7, Login.usernametf.getText());
            pst.setString(8, Login.emailtf.getText());
             pst.executeUpdate();
            con.close();
            
    
            
            JOptionPane.showMessageDialog(null, "NGO Added Successfully");
            
        }
          catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "NGO Added  Unsuccessfully  "+ex);
        }
        }
        }
          
        if(ae.getSource()==update)
        {
           if(idtf.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please Enter  ID","Warning",JOptionPane.ERROR_MESSAGE);
            }
           else if(nametf.getText().isEmpty()|| (!male.isSelected()&& !female.isSelected())|| emailtf1.getText().isEmpty()|| contacttf.getText().isEmpty() || locationtf.getText().isEmpty() )
           {
               JOptionPane.showMessageDialog(null, "Fill up all information","Warning",JOptionPane.ERROR_MESSAGE);
           }
           else{
            
            String sql = "UPDATE `addngo` SET `Name`=?,`Gender`=?,`Email`=?,`Contact Number`=?,`Location`=?,`Admin Name`=?, `Admin Email`=?  WHERE ` ID` = ?";
            try{
              con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost/online medicine donation system","root", "");
          
            pst =  (PreparedStatement) con.prepareStatement(sql);
          
            pst.setString(8,idtf.getText());
            pst.setString(1, nametf.getText());
           if(male.isSelected()){
             pst.setString(2, male.getText());
           }
            if(female.isSelected()){
                pst.setString(2, female.getText());
            }
            pst.setString(3, emailtf1.getText());
          
            pst.setString(4, contacttf.getText());
            pst.setString(5, locationtf.getText());
            pst.setString(6, Login.usernametf.getText());
            pst.setString(7, Login.emailtf.getText());
            pst.executeUpdate();
            con.close();
    
            
            JOptionPane.showMessageDialog(null, "NGO Updated Successfully");
            
        }
          catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "NGO Updated  Unsuccessfully "+ex);
        }
        }
        }
        if(ae.getSource()==delete)
        {
            if(idtf.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please Enter ID","Warning",JOptionPane.ERROR_MESSAGE);
            }
            else{
            String sql = "DELETE FROM `addngo` WHERE ` ID` = ?";
            try{
              con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/online medicine donation system","root", "");
          
            pst =  (PreparedStatement) con.prepareStatement(sql);
          
            pst.setString(1, idtf.getText());
            pst.executeUpdate();
            con.close();
    
            
            JOptionPane.showMessageDialog(null, "NGO Deleted Successfully");
            
        }
          catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "NGO Deleted Unsuccessfully "+ex);
        }
        }
        }
        
          
           
        
        if(ae.getSource() ==  reset)
            
        {
            idtf.setText("");
           nametf.setText("");
           grp.clearSelection();
           emailtf1.setText("");
           contacttf.setText("");
          locationtf.setText("");
          
        }
        if(ae.getSource() ==  homepage)
            
        {
            setVisible(false);
            HomePage frame = new  HomePage();
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
     public boolean checkusername(String username, String ema) 
{
    boolean checkuser = false;
      boolean email = false;
     
       Connection con2=null;
    PreparedStatement pst2=null;
      ResultSet rs;
     String sql = "SELECT * FROM `addngo` WHERE  `Name` = ? AND `Email`=?";
    
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
        AddNGO frame = new AddNGO();
        
        frame.setVisible(true);
        
    }
    
}
