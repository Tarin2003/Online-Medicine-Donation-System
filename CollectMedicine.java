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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


    
public class CollectMedicine extends JFrame{
     private Container c;
  
    private JLabel time,datel,label,expl,mnfl,typel,numl,med,label2,title,title1,title2,label1,namel,emaill,contactl,locationl, passwordl,confirml,genderl,agel,idl,eml, enamel,n;
     private JTextField nametf,emailtf,contacttf,locationtf,gendertf,agetf,idtf,enamef,etf,nf,mnfltf,expltf,typetf,numtf,timetf;
    private JButton  homepage,user, logout,search,assign,viwngo,viewuser,viewexecutive,collect,viewmedicine,donate,buymed;
    private JComboBox nameltf;
    private JDateChooser datetf;
  private Connection con,con2,con1;
   private PreparedStatement pst,pst1;
   private ResultSet rs,rs1;
    int Current_year,Current_month,Current_day;
   String uname = ExecutiveLogin.nametf.getText(); 
   String email = ExecutiveLogin.emailtf.getText(); 
  
   CollectMedicine()
    {
        initComponents();    
        ComboBox();
    }
   
    void initComponents()
    { 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1930, 1030);
        this.setTitle("Executive");
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
     assign.setBounds(191, 30, 270, 80);
       assign.setCursor(cursor);
        label.add(assign);
        viewmedicine = new JButton("View Medicine");
      viewmedicine.setFont(font1);
        viewmedicine.setBounds(462, 30, 224, 80);
      viewmedicine.setCursor(cursor);
        label.add(viewmedicine);
        viewuser = new JButton("View Buy Med");
     viewuser.setFont(font1);
        viewuser.setBounds(687, 30, 199, 80);
      viewuser.setCursor(cursor);
        label.add(viewuser);
        buymed = new JButton("Buy Medicine");
       buymed.setFont(font1);
        buymed.setBounds(887, 30, 190, 80);
       buymed.setCursor(cursor);
        label.add(buymed);
       donate = new JButton("View Donate");
      donate.setFont(font1);
        donate.setBounds(1078, 30, 180, 80);
      donate.setCursor(cursor);
        label.add(donate);

      
       
       logout = new JButton("LogOut");
       logout.setFont(font1);
        logout.setBounds(1259, 30, 120, 80);
       logout.setCursor(cursor);
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
         title1 = new JLabel("Collect Medicine");
        title1.setFont(font1);
        title1.setBounds(1, 1, 1900, 40);
        title1.setForeground(Color.BLUE);
       title1.setOpaque(true);
       title1.setBackground(Color.ORANGE);
         label1.add(title1);
         Font font3 = new Font("Arial",Font.BOLD,26);
          Font font4 = new Font("Arial",Font.BOLD,21);
         title2 = new JLabel("Please Enter medicine Name  and click the search button then enter collect date and Collect Time");
        title2.setFont(font4);
        title2.setBounds(420, 45, 1900, 27);
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
     enamel.setBounds(550, 100, 320, 30);
        label1.add( enamel);
        enamef = new JTextField(uname);  
        enamef.setFont(font4);
     enamef.setBounds(740, 100, 300, 30);
     enamef.setEditable(false);
        label1.add( enamef);
        
        eml = new JLabel("Executive Email ");
        eml.setFont(font4);
     eml.setBounds(1090, 100, 320, 30);
        label1.add(eml);
        etf = new JTextField(email);
         etf .setFont(font4);
      etf .setBounds(1280, 100, 300, 30);
      etf.setEditable(false);
        label1.add( etf );
       
        search = new JButton("Search");
       search .setCursor(cursor);
         search.setFont(font1);
        search.setBounds(700, 140, 400, 40);
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
        gendertf.setBounds(150, 260, 300, 30);
       gendertf.setEditable(false);
         label1.add(gendertf); 
          agel = new JLabel("Date of Birth ");
        agel.setFont(font4);
      agel.setBounds(550,260, 300, 30);
        label1.add(agel); 
        
        agetf = new JTextField("");
        agetf.setFont(font4);
       agetf.setBounds(700, 260,300, 30);
       agetf.setEditable(false);
         label1.add(agetf);
       
        contactl = new JLabel("Contact Number");
        contactl.setFont(font4);
        contactl.setBounds(1100, 260, 300, 30);
         label1.add(contactl); 
       contacttf = new JTextField("");
        contacttf.setFont(font4);
        contacttf.setBounds(1280, 260, 300, 30);
         contacttf.setEditable(false);
           label1.add(contacttf); 
        locationl = new JLabel("Location");
        locationl.setFont(font4);
        locationl.setBounds(2, 300, 300, 30);
        label1.add(locationl); 
        locationtf = new JTextField("");
        locationtf.setFont(font4);
        locationtf.setBounds(150,300, 300, 30);
        locationtf.setEditable(false);
        label1.add(locationtf); 
     
      datel = new JLabel("Collect Date  ");
         datel.setFont(font4);
          datel.setBounds(550,300, 320, 30);
          
        label1.add( datel); 
        datetf = new JDateChooser();
     datetf.setFont(font4);
      datetf.setBounds(700, 300,300, 30);
      
         label1.add(datetf);
          time = new JLabel("Collect Time ");
        time.setFont(font4);
          time.setBounds(1100,300, 320, 30);
          
        label1.add( time); 
        timetf = new JTextField("hh:mm a   12:30 PM");
     timetf.setFont(font4);
      timetf.setBounds(1280, 300,300, 30);
      
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
         expl.setBounds(680,400, 320, 30);
        label1.add( expl); 
        expltf = new JTextField("");
        expltf.setFont(font4);
       expltf.setBounds(900, 400,300, 30);
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
          numl.setBounds(600,440, 320, 30);
        label1.add(  numl); 
        numtf = new JTextField("");
        numtf.setFont(font4);
       numtf.setBounds(900, 440,300, 30);
       numtf.setEditable(false);
         label1.add(numtf);
          user = new JButton("Collect Medicine");
      user .setCursor(cursor);
         user.setFont(font1);
      user.setBounds(580,520,600, 60);
        label1.add(user);  
        
       timetf.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent fe) {
                if(timetf.getText().equals("hh:mm a   12:30 PM")){
                    timetf.setText(null);
                    timetf.requestFocus();
                }
                            }
          @Override
            public void focusLost(FocusEvent fe) {
                if(timetf.getText().length()==0){
                timetf.setText("hh:mm a   12:30 PM");
                }
            }
            
         
     }); 
       
    Handler handler = new Handler();
    search.addActionListener(handler);
    assign.addActionListener(handler);
        homepage.addActionListener(handler);
         viewmedicine.addActionListener(handler);
         viewuser.addActionListener(handler);
       buymed .addActionListener(handler);
         donate.addActionListener(handler);
     
    
      user.addActionListener(handler);
       logout.addActionListener(handler);
       
    }
    class Handler implements ActionListener{
    public void actionPerformed(ActionEvent ae) {
      
        String name = nameltf.getSelectedItem().toString();
        
          if(ae.getSource()==search){
              
              int a=0;
        if(name.isEmpty()|| enamef.getText().isEmpty()|| etf.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please Enter medicine name or Executive Name or Executive Email ","Warning",JOptionPane.ERROR_MESSAGE);
            }
       
        else{
            try {
            
            String sql = "SELECT `Medicine Name`, `Manufacture Date`, `Expiry Date`, `Medicine Type`, `Number of Tablet` FROM `donate medicine` WHERE `Medicine Name`=?" ;
          
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/online medicine donation system","root", "");
            pst =   (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, name);
           
            
          rs = pst.executeQuery();
          while(rs.next()){
         
            mnfltf.setText(rs.getString("Manufacture Date"));
             expltf.setText(rs.getString("Expiry Date"));
           typetf.setText(rs.getString("Medicine Type"));
           numtf.setText(rs.getString("Number of Tablet"));
           
           
            
          a=1;
          break;
              
              
         
          }     
         
           con.close();
           pst.close();
          
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Something Error "+ex);
           
        }
            if(a==0){
                  JOptionPane.showMessageDialog(null, "Please Enter Correct medicine name","Warning",JOptionPane.ERROR_MESSAGE);
            }
            if(ae.getSource()==search)
            {
                
                 try {
            
            String sql = "SELECT `Gender`, `Date of Birth`, `Contact Number`, `Location` FROM `executive`  WHERE `Name`=? AND `Email`=?" ;
          
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/online medicine donation system","root", "");
            pst =   (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, enamef.getText());
           pst.setString(2, etf.getText());
            
          rs = pst.executeQuery();
          while(rs.next()){
         
           
            gendertf.setText(rs.getString("Gender"));
             agetf.setText(rs.getString("Date of Birth")); 
             contacttf.setText(rs.getString("Contact Number"));
             locationtf.setText(rs.getString("Location"));
         
              
         
          }     
         
           con.close();
           pst.close();
          
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Something Error ");
           
        }
                 
            }
            }
        
           
        }
          if(ae.getSource()==user)
          {
              
              int b=0;
             
              if(datetf.getDate()==null || timetf.getText().isEmpty()||agetf.getText().isEmpty()||gendertf.getText().isEmpty()||contacttf.getText().isEmpty()||locationtf.getText().isEmpty()||name.isEmpty()|| enamef.getText().isEmpty()|| etf.getText().isEmpty()|| mnfltf.getText().isEmpty() || expltf.getText().isEmpty()|| numtf.getText().isEmpty() || typetf.getText().isEmpty())
              {
                  JOptionPane.showMessageDialog(null, "Fill up the all information  ","Warning",JOptionPane.ERROR_MESSAGE);
              }
             
               if(datetf.getDate()!=null || !timetf.getText().isEmpty())
              {
                  SimpleDateFormat dateformat1 = new SimpleDateFormat("YYYY-MM-dd");
             
            SimpleDateFormat dateformat2 = new SimpleDateFormat("hh:mm a");
             
                  
       
      
             
                try{
                   
               
                 Date date = new Date();
       DateFormat dateformat = new SimpleDateFormat("dd-MM-YYYY");
      
       String current = dateformat.format(date);
         String dates = dateformat.format(datetf.getDate());
         
         String times =timetf.getText();
                  Date date1 = dateformat1.parse(dates);
                  
                   
                   Date date2 = dateformat1.parse(current);
                
           
             Date time1 = dateformat2.parse(times);
                   if(date2.before(date1))
                    {
                       JOptionPane.showMessageDialog(null, "Please Enter Collect Date  is less than or equal current Date ");
                   }
              
                   else{
                 
                    String sql = "INSERT INTO `collect medicine`(`Executive Name`, `Executive Email`, `Gender`, `Date of Birth`, `Contact Number`, `Location`, `Medicine Name`, `Manufacture Date`, `Expiry Date`, `Medicine Type`, `Number of Tablet`, `Collect Date`,`Collect Time`)" + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
          try{
              con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/online medicine donation system","root", "");
          
            pst =  (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, enamef.getText());
            pst.setString(2, etf.getText());
             pst.setString(3, gendertf.getText());
             pst.setString(4, agetf.getText());
             pst.setString(5, contacttf.getText());
             pst.setString(6, locationtf.getText());
             pst.setString(7, name);
             pst.setString(8, mnfltf.getText());
             pst.setString(9, expltf.getText());
             pst.setString(10, typetf.getText());
             pst.setString(11, numtf.getText());
             pst.setString(12, dates);
             pst.setString(13, timetf.getText());
            
             
            
                     
            
            pst.executeUpdate();
            con.close();
    
            
            JOptionPane.showMessageDialog(null, "Collect Medicine successfully");
            
        }
                         
            
          catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Collect Medicine unsuccessfully");
        }
                   }
                 
    } catch (Exception ex) {
            
            JOptionPane.showMessageDialog(null, "Collect Medicine unsuccessfully");
        }
            }
          }
       
              
          
        
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
    
   
    
    void  ComboBox()
    {
        try{
           String sql1 = "SELECT * FROM `donate medicine` " ;
                
                con1 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/online medicine donation system","root", "");
                pst1 =   (PreparedStatement) con1.prepareStatement(sql1);
               
                rs1 = pst1.executeQuery();
                while(rs1.next()){
                    String name= rs1.getString("Medicine Name");
            
           nameltf.addItem(name);
           
                }
        }catch(Exception e)
        {
            
        }
    }
    
    public static void main(String[] args) {
      CollectMedicine frame = new CollectMedicine ();
        
        frame.setVisible(true);
        
       
        
        
        
        
    }
    }

    

    

