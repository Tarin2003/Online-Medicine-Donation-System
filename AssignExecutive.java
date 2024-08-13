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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Hp
 */
public class AssignExecutive extends JFrame{
    private Container c;
  
    private JLabel label,label2,title,title1,label1,namel,emaill,contactl,locationl, passwordl,confirml,genderl,agel,idl,title2;
     private JTextField nametf,emailtf,contacttf,locationtf,gendertf,agetf;
    private JButton  homepage,user, logout,search,assign,viewexecutive,viwngo,viewmed,collect,delete,update;
    private JComboBox idtf;
  private Connection con,con2,con1;
   private PreparedStatement pst,pst2,pst1;
   private ResultSet rs,rs2,rs1;
    private String uname = NGOLogin.usernametf.getText();
    private String email = NGOLogin.emailtf.getText();
   private String n;
 AssignExecutive()
    {
        initComponents();  
        ComboBox();
    }
   
    void initComponents()
    { 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1930, 1030);
        this.setTitle("Assign Executive");
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
       label.add(viwngo);
       
       viewmed = new JButton("View Medicine");
       viewmed.setCursor(cursor);
        viewmed.setFont(font1);
       viewmed.setBounds(382, 30, 220, 80);
       label.add(viewmed);
       
       user = new JButton("View user");
        user.setCursor(cursor);
        user.setFont(font1);
        user.setBounds(603, 30, 180, 80);
       label.add(user);
        
       viewexecutive = new JButton("View Executive");
        viewexecutive.setCursor(cursor);
        viewexecutive.setFont(font1);
        viewexecutive.setBounds(784, 30, 240, 80);
       label.add(viewexecutive);
       
       collect = new JButton("View Collect Med");
       collect.setCursor(cursor);
        collect.setFont(font1);
        collect.setBounds(1025, 30, 250, 80);
        label.add(collect);
        
       logout = new JButton("Logout");
       logout.setCursor(cursor);
        logout.setFont(font1);
        logout.setBounds(1276, 30, 140, 80);
        label.add(logout);
                      
        label2 = new JLabel("Hi "+uname);
         
          
         label2.setBounds(1660, 30, 500, 80);
         label2.setFont(font1);
         label2.setToolTipText(uname);
         
           
         label.add(label2);       
      
       
          label1 = new JLabel();
         label1.setBounds(1, 260,1930,1030);
         label1.setOpaque(true);
          label1.setBackground(Color.LIGHT_GRAY);
        c.add(  label1);
         title1 = new JLabel("Assign Executive");
        title1.setFont(font1);
        title1.setBounds(1, 1, 1900, 60);
        title1.setForeground(Color.BLUE);
       title1.setOpaque(true);
       title1.setBackground(Color.ORANGE);
         label1.add(title1);
         title2 = new JLabel("Please Enter ID and click the search button");
        title2.setFont(font1);
        title2.setBounds(600, 68, 1900, 27);
         label1.add(title2);
        idl = new JLabel("ID");
        idl.setFont(font1);
       idl.setBounds(50, 100, 300, 40);
        label1.add(idl); 
       idtf = new JComboBox();
       idtf.setFont(font1);
        idtf.setBounds(260, 100,1400, 40);   
          label1.add(idtf); 
        search = new JButton("Search");
       search .setCursor(cursor);
         search.setFont(font1);
        search.setBounds(1710, 100, 150, 60);
        label1.add( search);
       namel = new JLabel("Name");
        namel.setFont(font1);
       namel.setBounds(50, 160, 300, 40);
         label1.add(namel); 
        nametf = new JTextField("");
        nametf.setFont(font1);
        nametf.setBounds(260, 160, 1400, 40);
        nametf.setEditable(false);
          label1.add(nametf); 
         genderl  = new JLabel("Gender");
        genderl.setFont(font1);
       genderl.setBounds(50, 220, 300, 40);
           label1.add(genderl);
         gendertf  = new JTextField("");
        gendertf.setFont(font1);
       gendertf.setBounds(260, 220, 1400, 40);
       gendertf.setEditable(false);
         label1.add(gendertf);
        
       agel = new JLabel("Date of Birth");
        agel.setFont(font1);
        agel.setBounds(50,280, 300, 40);
        label1.add(agel); 
        agetf = new JTextField("");
        agetf.setFont(font1);
       agetf.setBounds(260, 280,1400, 40);
       agetf.setEditable(false);
         label1.add(agetf);
        emaill = new JLabel("Email");
        emaill.setFont(font1);
        emaill.setBounds(50, 340, 300, 40);
         label1.add(emaill); 
        emailtf = new JTextField("");
        emailtf.setFont(font1);
        emailtf.setBounds(260, 340, 1400, 40);
         emailtf.setEditable(false);
        label1.add(emailtf); 
        contactl = new JLabel("Contact Number");
        contactl.setFont(font1);
        contactl.setBounds(50, 400, 300, 40);
         label1.add(contactl); 
       contacttf = new JTextField("");
        contacttf.setFont(font1);
        contacttf.setBounds(260, 400, 1400, 40);
         contacttf.setEditable(false);
           label1.add(contacttf); 
        locationl = new JLabel("Location");
        locationl.setFont(font1);
        locationl.setBounds(50, 460, 300, 40);
        label1.add(locationl); 
        locationtf = new JTextField("");
        locationtf.setFont(font1);
        locationtf.setBounds(260,460, 1400, 40);
        locationtf.setEditable(false);
        label1.add(locationtf); 
     
      
       
          assign = new JButton("Assign Executive");
       assign .setCursor(cursor);
         assign.setFont(font1);
       assign.setBounds(200,580,400, 60);
        label1.add( assign);  
         update= new JButton("Update");
       update .setCursor(cursor);
         update.setFont(font1);
       update.setBounds(650,580,400, 60);
        label1.add(update);  
        delete = new JButton("Delete");
        delete .setCursor(cursor);
          delete.setFont(font1);
        delete.setBounds(1100,580,400, 60);
        label1.add(  delete);  
        
        
        
       
    Handler handler = new Handler();
    search.addActionListener(handler);
    assign.addActionListener(handler);
        homepage.addActionListener(handler);
        viwngo.addActionListener(handler);
        viewmed.addActionListener(handler);
      user.addActionListener(handler);
     viewexecutive.addActionListener(handler);
      update.addActionListener(handler);
      delete.addActionListener(handler);
       logout.addActionListener(handler);
       collect.addActionListener(handler);
    }
    class Handler implements ActionListener{
    public void actionPerformed(ActionEvent ae) {
        String id = idtf.getSelectedItem().toString();
         if(ae.getSource() ==  search)
          
        { 
            int a =0;
            if(id.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please Enter ID","Warning",JOptionPane.ERROR_MESSAGE);
            }
            else{
                  try {
            
            String sql = "SELECT  `Name`, `Gender`, `Date of Birth`, `Email`, `Contact Number`, `Location`,`Password`  FROM `userregistration` WHERE `ID`=? ";
          
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/online medicine donation system","root", "");
            pst =   (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, id);
          rs = pst.executeQuery();
          while(rs.next()){
         
            
              nametf.setText(rs.getString("Name"));
              
              gendertf.setText(rs.getString("Gender"));
             
              agetf.setText(rs.getString("Date of Birth"));
              
             emailtf.setText(rs.getString("Email")); 
            
             contacttf.setText(rs.getString("Contact Number"));
            
             locationtf.setText(rs.getString("Location"));
             n = rs.getString("Password");
          
               a =1;
               break;
              
         
          }     
         
           con.close();
           pst.close();
          
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Something Error "+ex);
           
        }
                  if(a==0)
                  {
                        JOptionPane.showMessageDialog(null, "Please Enter Correct ID ","Warning",JOptionPane.ERROR_MESSAGE);
                  }
            }
           
        }
            
        if(ae.getSource() ==  assign)
            
        {
            if(id.isEmpty()|| nametf.getText().isEmpty() || gendertf.getText().isEmpty() || agetf.getText().isEmpty() || emailtf.getText().isEmpty()||contacttf.getText().isEmpty() || locationtf.getText().isEmpty())
            { JOptionPane.showMessageDialog(null, "Please Enter ID or name or gender or age or email or contact number or location","Warning",JOptionPane.ERROR_MESSAGE); 
               }
            else if(checkusername(nametf.getText() ,emailtf.getText()))     
              {
              
                    JOptionPane.showMessageDialog(null, "This user already assigned");
                 }
            
            else
            {
                  
                        
        String sql = "INSERT INTO `executive`(`Name`,`Gender`, `Date Of Birth`, `Email`, `Contact Number`, `Location`,`Password`, `NGO`,`NGO Email`)" + "VALUES (?,?,? ,?, ?, ?,?,?,?)";
        
          try{
              con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/online medicine donation system","root", "");
          
            pst =  (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, nametf.getText());
            
                pst.setString(2,gendertf.getText());
            
             pst.setString(3, agetf.getText());
            pst.setString(4, emailtf.getText());
            pst.setString(5, contacttf.getText());
            pst.setString(6, locationtf.getText());
          pst.setString(7, n);
           pst.setString(8, uname);
            pst.setString(9, email);
             
            pst.executeUpdate();
            con.close();
    
            
            JOptionPane.showMessageDialog(null, "Assign Executive successfully");
            
        }
            
          catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Assign Executive unsuccessfully"+ex);
        }
              
    }
        }
        if(ae.getSource()==update)
        {
            nametf.setEditable(true);
            emailtf.setEditable(true);
            gendertf.setEditable(true);
            agetf.setEditable(true);
            contacttf.setEditable(true);
            locationtf.setEditable(true);
            if(nametf.getText().isEmpty()||emailtf.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please Enter Name and Email ","Warning",JOptionPane.ERROR_MESSAGE); 
    
            }
           else if(  gendertf.getText().isEmpty() || agetf.getText().isEmpty() ||contacttf.getText().isEmpty() || locationtf.getText().isEmpty())
            { JOptionPane.showMessageDialog(null, "Please Enter   gender or Date of Birth or contact number or location","Warning",JOptionPane.ERROR_MESSAGE); 
               }
           else{
              String sql = "UPDATE `executive` SET  `Gender` =?, `Date of Birth`=?, `Contact Number`=? ,`Location`=?,`NGO`=?, `NGO Email` =? WHERE  `Name`=? AND`Email`=?";
               try{
              con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost/online medicine donation system","root", "");
          
            pst =  (PreparedStatement) con.prepareStatement(sql);
          
            pst.setString(7,nametf.getText());
            pst.setString(8,emailtf.getText());
            pst.setString(1,gendertf.getText());
            pst.setString(2,agetf.getText());
            pst.setString(3,contacttf.getText());
            pst.setString(4,locationtf.getText());
             pst.setString(5, uname);
            pst.setString(6, email);
            
            pst.executeUpdate();
            con.close();
    
            
            JOptionPane.showMessageDialog(null, "Executive Updated Successfully");
            
        }
          catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, " Executive Updated Unsuccessfully " +ex);
        }
           }
             
        }
        if(ae.getSource()==delete)
        {
            nametf.setEditable(true);
            emailtf.setEditable(true);
            gendertf.setEditable(false);
            agetf.setEditable(false);
            contacttf.setEditable(false);
            locationtf.setEditable(false);
            if(nametf.getText().isEmpty()||emailtf.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please Enter Name and Email ","Warning",JOptionPane.ERROR_MESSAGE); 
    
            }
            else{
            try{
                String sql ="DELETE FROM `executive` WHERE  `Name`=? AND`Email`=?";
              
              con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/online medicine donation system","root", "");
          
            pst =  (PreparedStatement) con.prepareStatement(sql);
          
            pst.setString(1, nametf.getText());
              pst.setString(2, emailtf.getText());
            pst.executeUpdate();
            con.close();
    
            
            JOptionPane.showMessageDialog(null, "Executive Deleted Successfully");
            
        }
          catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Executive Deleted Unsuccessfully "+ex);
        }
        
           
              
        }
        }
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
        
        if(ae.getSource() ==  viewexecutive)
            
        {
            setVisible(false);
          ViewExecutive frame = new ViewExecutive();
          frame.setVisible(true);
         
        }
        if(ae.getSource() ==  collect)
            
        {
            setVisible(false);
          ViewCollectMedicine frame = new ViewCollectMedicine ();
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
     public boolean checkusername(String username, String ema) 
{
    boolean checkuser = false;
      boolean email = false;
       Connection con2=null;
    PreparedStatement pst2=null;
      ResultSet rs;
     String sql = "SELECT * FROM `executive` WHERE `Name` =? AND `Email`=?";
    
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
     void  ComboBox()
    {
        try{
           String sql1 = "SELECT * FROM `userregistration` " ;
                
                con1 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/online medicine donation system","root", "");
                pst1 =   (PreparedStatement) con1.prepareStatement(sql1);
               
                rs1 = pst1.executeQuery();
                while(rs1.next()){
                    String id = rs1.getString("ID");
            
            idtf.addItem(id);
           
                }
        }catch(Exception e)
        {
            
        }
    }
    
    public static void main(String[] args) {
      AssignExecutive frame = new AssignExecutive();
        
        frame.setVisible(true);
        
       
        
        
        
        
    }

    
}
