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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Hp
 */
public class ViewDetailsCollect extends JFrame{
    private JLabel time,label,datel,expl,mnfl,typel,numl,med,label2,title,title1,title2,label1,namel,emaill,contactl,locationl, passwordl,confirml,genderl,agel,idl,eml, enamel,n;;
    private JButton  user1,back,homepage,user,assign, logout,viwngo,viewmed,viewexecutive,collect,view,search;
            private JTextField datetf,nametf,emailtf,contacttf,locationtf,gendertf,agetf,idtf,nf,mnfltf,expltf,typetf,numtf,timetf;
            private JComboBox nameltf,enamef,etf;
  private JScrollPane scroll;
   
  private Connection con,con1;
   private PreparedStatement pst,pst1;
   private ResultSet rs,rs1;
   Container c;
    private String uname = NGOLogin.usernametf.getText();
 ViewDetailsCollect()
    {
        initComponents();
        ComboBox();
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
       
       
       logout = new JButton("Logout");
       logout.setCursor(cursor);
        logout.setFont(font1);
        logout.setBounds(1258, 30, 140, 80);
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
         title1 = new JLabel("View Collect Medicine");
        title1.setFont(font1);
        title1.setBounds(1, 1, 1900, 40);
        title1.setForeground(Color.BLUE);
       title1.setOpaque(true);
       title1.setBackground(Color.ORANGE);
         label1.add(title1);
         Font font3 = new Font("Arial",Font.BOLD,26);
          Font font4 = new Font("Arial",Font.BOLD,21);
         title2 = new JLabel("Please Enter medicine Name or Executive Name or Executive Email and click the search button ");
        title2.setFont(font4);
        title2.setBounds(400, 45, 1900, 27);
         label1.add(title2);
         namel = new JLabel("Medicine Name  ");
       namel.setFont(font4);
      namel.setBounds(2, 100, 320, 30);
        label1.add(namel); 
      nameltf = new JComboBox(); 
      nameltf.setFont(font4);
     
        nameltf.setBounds(200, 100,300, 30);   
          label1.add(nameltf); 
        enamel = new JLabel("Executive Name ");
        enamel.setFont(font4);
     enamel.setBounds(600, 100, 320, 30);
        label1.add( enamel);
        enamef = new JComboBox();  
        enamef.setFont(font4);
     enamef.setBounds(800, 100, 300, 30);
     
        label1.add( enamef);
        
        eml = new JLabel("Executive Email ");
        eml.setFont(font4);
     eml.setBounds(1180, 100, 320, 30);
        label1.add(eml);
        etf = new JComboBox();
         etf .setFont(font4);
      etf .setBounds(1380, 100, 300, 30);
     
        label1.add( etf );
       
        search = new JButton("Search");
       search .setCursor(cursor);
         search.setFont(font1);
        search.setBounds(750, 160, 400, 40);
        label1.add( search);
         n = new JLabel("Executive Details  ");
        n.setFont(font3);
     n.setBounds(2, 200, 320, 30);
        label1.add(n);
       
       genderl  = new JLabel("Gender");
        genderl.setFont(font4);
      genderl.setBounds(2, 260, 300, 30);
           label1.add(genderl);
       gendertf  = new JTextField("");
        gendertf.setFont(font4);
        gendertf.setBounds(200, 260, 300, 30);
       gendertf.setEditable(false);
         label1.add(gendertf); 
          agel = new JLabel("Date of Birth ");
        agel.setFont(font4);
      agel.setBounds(580,260, 300, 30);
        label1.add(agel); 
        
        agetf = new JTextField("");
        agetf.setFont(font4);
       agetf.setBounds(800, 260,300, 30);
       agetf.setEditable(false);
         label1.add(agetf);
       
        contactl = new JLabel("Contact Number");
        contactl.setFont(font4);
        contactl.setBounds(1220, 260, 300, 30);
         label1.add(contactl); 
       contacttf = new JTextField("");
        contacttf.setFont(font4);
        contacttf.setBounds(1400, 260, 300, 30);
         contacttf.setEditable(false);
           label1.add(contacttf); 
        locationl = new JLabel("Location");
        locationl.setFont(font4);
        locationl.setBounds(2, 300, 300, 30);
        label1.add(locationl); 
        locationtf = new JTextField("");
        locationtf.setFont(font4);
        locationtf.setBounds(200,300, 300, 30);
        locationtf.setEditable(false);
        label1.add(locationtf); 
     
      datel = new JLabel("Collect Date  ");
         datel.setFont(font4);
          datel.setBounds(580,300, 320, 30);
         
        label1.add( datel); 
        datetf = new JTextField("");
     datetf.setFont(font4);
     datetf.setEditable(false);
      datetf.setBounds(800, 300,300, 30);
      
         label1.add(datetf);
         time = new JLabel("Collect Time ");
        time.setFont(font4);
          time.setBounds(1220,300, 320, 30);
          
        label1.add( time); 
        timetf = new JTextField("");
     timetf.setFont(font4);
      timetf.setBounds(1400, 300,300, 30);
      timetf.setEditable(false);
         label1.add(timetf);
       med = new JLabel("Medicine Details ");
         med.setFont(font3);
     med.setBounds(2, 360, 320, 30);
        label1.add(med);
        
        
     
       
         mnfl  = new JLabel("Manufacture Date  ");
        mnfl.setFont(font4);
       mnfl.setBounds(2, 400, 320, 30);
           label1.add(mnfl);
         mnfltf  = new JTextField("");
        mnfltf.setFont(font4);
       mnfltf.setBounds(200, 400, 300, 30);
      mnfltf.setEditable(false);
         label1.add(mnfltf);
        
       expl = new JLabel("Expiry Date   ");
         expl.setFont(font4);
         expl.setBounds(580,400, 320, 30);
        label1.add( expl); 
        expltf = new JTextField("");
        expltf.setFont(font4);
       expltf.setBounds(860, 400,300, 30);
        expltf.setEditable(false);
         label1.add( expltf);
        
        typel = new JLabel("Type  ");
         typel.setFont(font4);
          typel.setBounds(2,440, 320, 30);
        label1.add( typel); 
         typetf = new JTextField("");
        typetf.setFont(font4);
        typetf.setBounds(200, 440,300, 30);
         typetf.setEditable(false);
         label1.add( typetf);
       numl = new JLabel("Number of Tablet or Syrup   ");
          numl.setFont(font4);
          numl.setBounds(580,440, 320, 30);
        label1.add(  numl); 
        numtf = new JTextField("");
        numtf.setFont(font4);
       numtf.setBounds(860, 440,300, 30);
       numtf.setEditable(false);
         label1.add(numtf);
          
          back= new JButton("Back");
       back.setCursor(cursor);
        back.setFont(font3);
     back.setBounds(580,560,600, 60);
        label1.add(back);  
    
Handler handler = new Handler();
        homepage.addActionListener(handler);
        viwngo.addActionListener(handler);
       viewmed.addActionListener(handler);
      user.addActionListener(handler);
     
      assign.addActionListener(handler);
      viewexecutive.addActionListener(handler);
  search.addActionListener(handler);
     back.addActionListener(handler);
       logout.addActionListener(handler);
    }
    class Handler implements ActionListener{
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==search){
            int a =0;
            String name = nameltf.getSelectedItem().toString();
            String ename = enamef.getSelectedItem().toString();
            String email = etf.getSelectedItem().toString();
            if(!name.isEmpty() || !ename.isEmpty() || !email.isEmpty() )
            {
            try {
                
                String sql = "SELECT * FROM `collect medicine` WHERE `Medicine Name`=? AND `Executive Name` =? AND `Executive Email`=?" ;
                
                con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/online medicine donation system","root", "");
                pst =   (PreparedStatement) con.prepareStatement(sql);
                pst.setString(1, name);
                
                pst.setString(2, ename);
                pst.setString(3, email);
                rs = pst.executeQuery();
                while(rs.next()){
                    gendertf.setText(rs.getString("Gender"));
                    agetf.setText(rs.getString("Date of Birth"));
                    contacttf.setText(rs.getString("Contact Number"));
                    locationtf.setText(rs.getString("Location"));
                    mnfltf.setText(rs.getString("Manufacture Date"));
                    expltf.setText(rs.getString("Expiry Date"));
                    typetf.setText(rs.getString("Medicine Type"));
                    numtf.setText(rs.getString("Number of Tablet"));
                    datetf.setText(rs.getString("Collect Date"));
                     timetf.setText(rs.getString("Collect Time"));
                    
                    
                    a=1;
                    break;
                }
                
                con.close();
                pst.close();
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Something Error "+ex);
                
            }
            if(a==0)
            {
                JOptionPane.showMessageDialog(null, "Please Correct Medicine Name or Executive Name and Email ","Warning",JOptionPane.ERROR_MESSAGE);
            }
        }
       
        else{
            JOptionPane.showMessageDialog(null, "Please Enter medicine name or Executive Name or Executive Email ","Warning",JOptionPane.ERROR_MESSAGE);   
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
           ViewMedNGO frame = new ViewMedNGO();
           frame.setVisible(true);
            
        }
        
        if(ae.getSource() ==  user)
            
        {
            setVisible(false);
          UserView frame = new UserView();
          frame.setVisible(true);
         
        }
         if(ae.getSource()==view)
        {
             setVisible(false);
        ViewDetailsCollect frame = new  ViewDetailsCollect  ();
          frame.setVisible(true);
        }
        if(ae.getSource() ==  assign)
            
        {
            setVisible(false);
           AssignExecutive frame = new  AssignExecutive();
            frame.setVisible(true);
        }
        if(ae.getSource() ==  back)
            
        {
            setVisible(false);
           ViewCollectMedicine frame = new ViewCollectMedicine();
            frame.setVisible(true);
        }
         if(ae.getSource() ==  viewexecutive)
            
        {
            setVisible(false);
          ViewExecutive frame = new ViewExecutive();
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
    void  ComboBox()
    {
        try{
           String sql1 = "SELECT * FROM `collect medicine` " ;
                
                con1 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/online medicine donation system","root", "");
                pst1 =   (PreparedStatement) con1.prepareStatement(sql1);
               
                rs1 = pst1.executeQuery();
                while(rs1.next()){
                    String name = rs1.getString("Medicine Name");
            String ename = rs1.getString("Executive Name");
            String email = rs1.getString("Executive Email");
            nameltf.addItem(name);
            enamef.addItem(ename);
            etf.addItem(email);
                }
        }catch(Exception e)
        {
            
        }
    }
    
    public static void main(String[] args) {
       ViewDetailsCollect frame = new ViewDetailsCollect();
        
        frame.setVisible(true);
        
       
        
        
        
        
    }

}

