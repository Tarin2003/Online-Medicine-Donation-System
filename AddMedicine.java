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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;



import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



/**
 *
 * @author Hp
 */
public class AddMedicine extends JFrame {
     private JLabel title, mednamel,pricel,mnfl,mnfd,expl,expd,label,label2;
    private JTextField mednametf,pricetf;
    private JDateChooser  mnftf,exptf;
      private Container c;
        private JButton add,clear,back,update,delete, homepage, addmed,viewuser,viewngo,viewmed,addngo, logout;;
      private Cursor cursor;
      Connection con,con2,con1;
    PreparedStatement pst,pst2,pst1;
    ResultSet rs,rs2,rs1;
   String date1,date2;
  String name = Login.usernametf.getText();
   String email = Login.emailtf.getText();
      
  
   AddMedicine() 
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
      
        Font font1 = new Font("Arial",Font.BOLD,24);
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
        label2 = new JLabel("Hi "+name);
         
          
         label2.setBounds(1660, 30, 500, 80);
         label2.setFont(font1);
         label2.setToolTipText(name);
         
           
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
          title = new JLabel("ADD Medicine");
        title.setFont(font1);
        title.setBounds(2, 2, 1350, 60);
        title.setForeground(Color.BLUE);
       title.setOpaque(true);
       title.setBackground(Color.ORANGE);
        newlabel1.add(title);
        mednamel = new JLabel("Medicine Name");
        mednamel.setFont(font1);
       mednamel.setBounds(20, 80, 300, 40);
        newlabel1.add(mednamel); 
        mednametf = new JTextField("");
        mednametf.setFont(font1);
        mednametf.setBounds(240, 80, 880, 40);
        newlabel1.add(mednametf); 
        pricel = new JLabel("Price (10 pcs)");
       pricel.setFont(font1);
       pricel.setBounds(20, 130, 300, 40);
        newlabel1.add(pricel); 
        pricetf = new JTextField("");
        pricetf.setFont(font1);
        pricetf.setBounds(240, 130, 880, 40);
        newlabel1.add(pricetf); 
        mnfl = new JLabel("Manufacture Date");
        mnfl.setFont(font1);
        mnfl.setBounds(20,180, 300, 40);
        newlabel1.add(mnfl); 
         
        
       mnftf = new JDateChooser();
        mnftf.setFont(font1);
        mnftf.setBounds(240,180, 880, 40);
        newlabel1.add(mnftf);
        
        expl = new JLabel("Expire Date");
        expl.setFont(font1);
        expl.setBounds(20, 230, 300, 40);
        newlabel1.add(expl);
        
        exptf = new JDateChooser();
        exptf.setFont(font1);
       exptf.setBounds(240, 230, 880, 40);
        newlabel1.add(exptf); 
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
        
         clear = new JButton("Reset");
       clear .setFont(font1);
      
      clear .setBounds(1180, 290, 150, 60);
        
        clear .setCursor(cursor);
        newlabel1.add(clear );
        
         Handler handler = new Handler();
         add.addActionListener(handler);
         
         update.addActionListener(handler);
         delete.addActionListener(handler);
        clear.addActionListener(handler);
        homepage.addActionListener(handler);
       
        addngo.addActionListener(handler);
       viewngo.addActionListener(handler);
       viewmed.addActionListener(handler);
       viewuser.addActionListener(handler);
       logout.addActionListener(handler);
      
    }
    
     class Handler implements ActionListener{
    public void actionPerformed(ActionEvent ae) {
       
        if(ae.getSource() ==  add)
            
        {
            if(mednametf.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please Enter Medicine Name","Warning",JOptionPane.ERROR_MESSAGE);
            }
            else if(pricetf.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please Enter Price","Warning",JOptionPane.ERROR_MESSAGE);
            }
             else if(mnftf.getDate()==null)
            {
                JOptionPane.showMessageDialog(null, "Please Enter Manufacture Date","Warning",JOptionPane.ERROR_MESSAGE);
            }
              else if(exptf.getDate()==null)
            {
                JOptionPane.showMessageDialog(null, "Please Enter Expiry Date","Warning",JOptionPane.ERROR_MESSAGE);
            }
               else if(checkusername(mednametf.getText()))     
              {
              
                    JOptionPane.showMessageDialog(null, "This medicine already exist");
                 }
               else{
                 SimpleDateFormat d = new SimpleDateFormat("dd-MM-YYYY");
                 String date1 = d.format(mnftf.getDate());
                 String date2 = d.format(exptf.getDate());
            String sql = "INSERT INTO `addmedicine` (`Medicine Name`, `Price`, `Manufacture Date`, `Expire Date`,`Admin Name`, `Admin Email`) " + "VALUES (?,?,?, ?, ?, ?)";
        
          try{
              con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/online medicine donation system","root", "");
          
            pst =  (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, mednametf.getText());
            pst.setString(2, pricetf.getText());
            pst.setString(3,date1);
            pst.setString(4,date2);
            pst.setString(5,name);
            pst.setString(6,email);
            pst.executeUpdate();
            con.close();
    
            
            JOptionPane.showMessageDialog(null, "Medicine Added Successfully");
            
        }
          catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Medicine Added Unsuccessfully  "+ex);
        }
        
        }
        }
        if(ae.getSource()==update)
        {
            int a =0;
             if(mednametf.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please Enter Medicine Name","Warning",JOptionPane.ERROR_MESSAGE);
            }
              else if(pricetf.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please Enter Price","Warning",JOptionPane.ERROR_MESSAGE);
            }
             else if(mnftf.getDate()==null)
            {
                JOptionPane.showMessageDialog(null, "Please Enter Manufacture Date","Warning",JOptionPane.ERROR_MESSAGE);
            }
              else if(exptf.getDate()==null)
            {
                JOptionPane.showMessageDialog(null, "Please Enter Expiry Date","Warning",JOptionPane.ERROR_MESSAGE);
            }
               
             else{
                 SimpleDateFormat d = new SimpleDateFormat("dd-MM-YYYY");
                 String date1 = d.format(mnftf.getDate());
                 String date2 = d.format(exptf.getDate());
            String sql = "UPDATE `addmedicine` SET `Price`=?,`Manufacture Date`=?,`Expire Date`=? ,`Admin Name` =?, `Admin Email`=? WHERE `Medicine Name` = ?";
            try{
              con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost/online medicine donation system","root", "");
          
            pst =  (PreparedStatement) con.prepareStatement(sql);
          
            pst.setString(6, mednametf.getText());
            pst.setString(1, pricetf.getText());
            pst.setString(2, date1);
            pst.setString(3, date2);
            pst.setString(4,name);
            pst.setString(5, email);
            
            pst.executeUpdate();
            con.close();
    
            
            JOptionPane.showMessageDialog(null, "Medicine Updated Successfully");
            
        }
          catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, " Medicine Updated Unsuccessfully " +ex);
        }
            
            if(ae.getSource()==update)
            {
           a =0;
                String sql1 = "SELECT * FROM `buymedicine` WHERE `Medicine Name`=? ";
              try {
                       
                       con1 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/online medicine donation system","root", "");
                  pst1 =   (PreparedStatement) con1.prepareStatement(sql1);
                  pst1.setString(1, mednametf.getText());
                 
                 
                  rs1 = pst1.executeQuery();
 
                 while(rs1.next()){
                   
                     
                    
                   a=1;
                   break;
                   }
                  con1.close();
           
                   } catch (SQLException ex) {     
                      
                }
            
            
            
           
          if(a==0)
                   {
                      
                   }       
          else{  
              
    try{
        String sql2 = "UPDATE `buymedicine` SET `Price` =?, `Manufacture Date`=?, `Expiry Date` =? WHERE `Medicine Name`=? ";
              con2 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/online medicine donation system","root", "");
          
            pst2 =  (PreparedStatement) con2.prepareStatement(sql2);
            
          
           
          
            pst2.setString(4, mednametf.getText());
            pst2.setString(1, pricetf.getText());
            pst2.setString(2, date1);
            pst2.setString(3, date2);
            pst2.executeUpdate();
            
             pst2.executeUpdate();
            con2.close();
    
            
          
            
        }
            
          catch (SQLException ex) {
            
            
        }
              
    }
         
             }

           
        }
        }
        
        if(ae.getSource()==delete)
        {
             if(mednametf.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please Enter Medicine Name","Warning",JOptionPane.ERROR_MESSAGE);
            }
             else{
            String sql = "DELETE FROM `addmedicine` WHERE `Medicine Name`= ?";
            try{
              con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/online medicine donation system","root", "");
          
            pst =  (PreparedStatement) con.prepareStatement(sql);
          
            pst.setString(1, mednametf.getText());
            pst.executeUpdate();
            con.close();
    
            
            JOptionPane.showMessageDialog(null, "Medicine Deleted Successfully");
            
        }
          catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Medicine Deleted Unsuccessfully "+ex);
        }
            if(ae.getSource()==delete)
            {
            int a =0;
                String sql1 = "SELECT * FROM `buymedicine` WHERE `Medicine Name`=? ";
              try {
                       
                       con1 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/online medicine donation system","root", "");
                  pst1 =   (PreparedStatement) con1.prepareStatement(sql1);
                  pst1.setString(1, mednametf.getText());
                 
                 
                  rs1 = pst1.executeQuery();
 
                 while(rs1.next()){
                   
                     
                    
                   a=1;
                   break;
                   }
                  con1.close();
           
                   } catch (SQLException ex) {     
                      
                }
            
            
            
           
          if(a==0)
                   {
                      
                   }       
          else{               
    try{
        String sql2 = "DELETE FROM `buymedicine` WHERE `Medicine Name`=? ";
              con2 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/online medicine donation system","root", "");
          
            pst2 =  (PreparedStatement) con2.prepareStatement(sql2);
             pst2.setString(1, mednametf.getText());
             pst2.executeUpdate();
            con2.close();
    
            
          
            
        }
            
          catch (SQLException ex) {
            
            
        }
              
    }
         
             }

           
        }
        }
        
          
           
        
        if(ae.getSource() ==  clear)
            
        {
           mednametf.setText("");
           pricetf.setText("");
           mnftf.setDateFormatString("");
         
          exptf.setDateFormatString("");
          
        }
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
     public boolean checkusername(String medname) 
{
    boolean med = false;
     
       Connection con2=null;
    PreparedStatement pst2=null;
      ResultSet rs;
     String sql = "SELECT * FROM `addmedicine` WHERE `Medicine Name`=?";
    
          try{
              con2 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/online medicine donation system","root", "");
          
            pst2 =  (PreparedStatement) con2.prepareStatement(sql);
            pst2.setString(1, medname);
            
          
           
             rs = pst2.executeQuery();
 
                 if(rs.next()){
                   med = true;
                   
                   
                   
                 }
    
}        catch (SQLException ex) {
             Logger.getLogger(UserRegistrationForm.class.getName()).log(Level.SEVERE, null, ex);
         }
         return med  ;
         
        
 
        
          
    }
    public static void main(String[] args) {
        AddMedicine frame = new AddMedicine();
        frame.setVisible(true);
        
      
        
    }
    
}
