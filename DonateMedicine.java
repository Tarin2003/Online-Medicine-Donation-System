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
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Hp
 */
public class DonateMedicine extends JFrame{
      private Container c;
   
    private JLabel timel,datel,eml, med, label,title,title1,label2,label1,namel,pricel,mnfl,expl,title2,numl,typel,exel,personal,rl,ml,enamel,fl,sl,al,pl,stl,cl,n,e,c1;
    private JTextField priceltf,mnfltf,expltf,numtf,ftf,stf,atf,ptf,sttf,ctf,nf,cf,ef,medtf,timetf;
     private JButton  homepage,logout,order,donate,search, assign,executive;
     private JTable table;
     private JComboBox typetf,nameltf,enamef,etf;
     private JDateChooser datetf;
     private DefaultTableModel mode;
    private JScrollPane scroll;
    Connection con1,con2,con3,con4;
    PreparedStatement pst1,pst2,pst3,pst4;
    ResultSet rs1,rs2,rs3,rs4;
    
    String item[]={"Tablet","Syrup"};
   String uname =  UserLogin.usernametf.getText();
  String email=  UserLogin.emailtf.getText();
    DonateMedicine()
    {
        initComponents();  
        ComboBox();
        ComboBox1();
    }
   
    void initComponents()
    { 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1930, 1030);
        this.setTitle("User");
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
        
    
      order = new JButton("My Order");
     order.setFont(font1);
    order.setBounds(191, 30, 170, 80);
      order.setCursor(cursor);
        label.add(order);
      
      executive = new JButton("View Executive");
   executive.setFont(font1);
    executive.setBounds(362, 30, 250, 80);
      executive.setCursor(cursor);
        label.add(executive);
       logout = new JButton("Logout");
      logout.setFont(font1);
        logout.setBounds(613, 30, 190, 80);
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
         title1 = new JLabel("Donate Medicine");
        title1.setFont(font1);
        title1.setBounds(1, 1, 1900, 60);
        title1.setForeground(Color.BLUE);
       title1.setOpaque(true);
       title1.setBackground(Color.ORANGE);
         label1.add(title1);
          Font font3 = new Font("Arial",Font.BOLD,26);
          Font font4 = new Font("Arial",Font.BOLD,21);
         exel = new JLabel("Executive Delatils");
        exel.setFont(font3);
      exel.setBounds(2, 60, 320, 50);
        label1.add( exel);
        enamel = new JLabel("Executive Name : ");
        enamel.setFont(font4);
     enamel.setBounds(2, 120, 320, 30);
        label1.add( enamel);
        enamef = new JComboBox();
        enamef.setFont(font4);
     enamef.setBounds(200, 120, 470, 30);
   
        label1.add( enamef);
        
        eml = new JLabel("Executive Email : ");
        eml.setFont(font4);
     eml.setBounds(800, 120, 320, 30);
        label1.add(eml);
        etf = new JComboBox();
         etf .setFont(font4);
      etf .setBounds(1000, 120, 470, 30);
    
        label1.add( etf );
        pl = new JLabel("Personal Details");
        pl.setFont(font3);
     pl.setBounds(2, 180, 320, 50);
        label1.add(pl);
        n = new JLabel("Name : ");
        n.setFont(font4);
     n.setBounds(2, 240, 320, 30);
        label1.add(n);
        nf = new JTextField(uname);
        nf.setEditable(false);
      nf.setFont(font4);
        nf.setBounds(220, 240,380, 30);   
          label1.add(nf); 
          e = new JLabel("Email : ");
        e.setFont(font4);
     e.setBounds(750, 240, 320, 30);
        label1.add(e);
         ef = new JTextField(email);
      ef.setFont(font4);
        ef.setBounds(850, 240,380, 30);  
        ef.setEditable(false);
          label1.add(ef); 
           c1 = new JLabel("Contact Number : ");
        c1.setFont(font4);
     c1.setBounds(1270, 240, 320, 30);
        label1.add(c1);
         cf = new JTextField("");
      cf.setFont(font4);
        cf.setBounds(1450, 240,400, 30);   
          label1.add(cf); 
           rl = new JLabel("Residential Address ");
        rl.setFont(font3);
     rl.setBounds(2, 300, 320, 30);
        label1.add(rl);
         fl = new JLabel("Flate/Door/Block No : ");
        fl.setFont(font4);
     fl.setBounds(2, 340, 320, 30);
        label1.add(fl);
         ftf = new JTextField("");
      ftf.setFont(font4);
        ftf.setBounds(220, 340,370, 30);   
          label1.add(ftf);
          sl = new JLabel("Street/Lane : ");
        sl.setFont(font4);
    sl.setBounds(700, 340, 320, 30);
        label1.add(sl);
         stf = new JTextField("");
      stf.setFont(font4);
        stf.setBounds(850, 340,370, 30);   
          label1.add(stf);
          al = new JLabel("Area/Locality : ");
        al.setFont(font4);
    al.setBounds(1280, 340, 320, 30);
        label1.add(al);
         atf = new JTextField("");
      atf.setFont(font4);
        atf.setBounds(1450, 340,400, 30);   
          label1.add(atf);
          pl = new JLabel("Pin Code : ");
        pl.setFont(font4);
    pl.setBounds(2, 380, 320, 30);
        label1.add( pl);
          ptf = new JTextField("");
     ptf.setFont(font4);
        ptf.setBounds(220,380,370, 30);   
          label1.add(ptf);
          stl = new JLabel("State : ");
        stl.setFont(font4);
     stl.setBounds(700, 380, 320, 30);
        label1.add( stl);
          sttf = new JTextField("");
      sttf.setFont(font4);
         sttf.setBounds(850, 380,370, 30);   
          label1.add( sttf);
           cl = new JLabel("CityTown : ");
         cl.setFont(font4);
      cl.setBounds(1280, 380, 320, 30);
        label1.add(  cl);
           ctf = new JTextField("");
      ctf.setFont(font4);
          ctf.setBounds(1450, 380,400, 30);   
          label1.add(  ctf);
          med = new JLabel("Medicine Details ");
         med.setFont(font3);
     med.setBounds(2, 440, 320, 30);
        label1.add(med);
        title2 = new JLabel("Please Enter medicine Name and click the search button then Enter medicine type or number of tablet or donate time or donate date");
        title2.setFont(font4);
        title2.setBounds(280, 470, 1900, 27);
         label1.add(title2);
        namel = new JLabel("Medicine Name : ");
       namel.setFont(font4);
      namel.setBounds(2, 510, 320, 30);
        label1.add(namel); 
      nameltf = new JComboBox();
      nameltf.setFont(font4);
        nameltf.setBounds(286, 510,300, 30);   
          label1.add(nameltf); 
        search = new JButton("Search");
       search .setCursor(cursor);
         search.setFont(font3);
        search.setBounds(900, 510, 250, 30);
        label1.add( search);
     
       
         mnfl  = new JLabel("Manufacture Date : ");
        mnfl.setFont(font4);
       mnfl.setBounds(2, 570, 320, 30);
           label1.add(mnfl);
         mnfltf  = new JTextField("");
        mnfltf.setFont(font4);
       mnfltf.setBounds(286, 570, 300, 30);
      mnfltf.setEditable(false);
         label1.add(mnfltf);
        
       expl = new JLabel("Expiry Date : ");
         expl.setFont(font4);
         expl.setBounds(700,570, 320, 30);
        label1.add( expl); 
        expltf = new JTextField("");
        expltf.setFont(font4);
       expltf.setBounds(850, 570,300, 30);
        expltf.setEditable(false);
         label1.add( expltf);
        
        typel = new JLabel("Type : ");
         typel.setFont(font4);
          typel.setBounds(1280,570, 320, 30);
        label1.add( typel); 
         typetf = new JComboBox(item);
        typetf.setFont(font4);
        typetf.setBounds(1450, 570,300, 30);
         typetf.setEditable(false);
         label1.add( typetf);
       numl = new JLabel("Number of Tablet or Syrup : ");
          numl.setFont(font4);
          numl.setBounds(2,610, 320, 30);
        label1.add(  numl); 
        numtf = new JTextField("");
        numtf.setFont(font4);
       numtf.setBounds(286, 610,300, 30);
       
         label1.add(numtf);
         timel = new JLabel("Donate Time : ");
         timel.setFont(font4);
          timel.setBounds(700,610, 320, 30);
        label1.add( timel); 
        timetf = new JTextField("hh:mm a   12:30 PM");
       timetf.setFont(font4);
      timetf.setBounds(850, 610,300, 30);
       
         label1.add(timetf);
         datel = new JLabel("Donate Date : ");
         datel.setFont(font4);
          datel.setBounds(1280,610, 320, 30);
        label1.add( datel); 
        datetf = new JDateChooser();
     datetf.setFont(font4);
      datetf.setBounds(1450, 610,300, 30);
       
         label1.add(datetf);
       
          assign = new JButton("Donate Medicine");
     assign.setCursor(cursor);
       assign.setFont(font3);
     assign.setBounds(600,680,600, 40);
        label1.add( assign);  
        
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
        homepage.addActionListener(handler);
        executive.addActionListener(handler);
     order.addActionListener(handler);
    search.addActionListener(handler);
    assign.addActionListener(handler);
     logout.addActionListener(handler);
     
    
    
}
    class Handler implements ActionListener{
    public void actionPerformed(ActionEvent ae) {
        String exname = enamef.getSelectedItem().toString();
        String exemail = etf.getSelectedItem().toString();
        if(ae.getSource() ==  search)
            
        { int a=0;
        String name1 = nameltf.getSelectedItem().toString();
            if(name1.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please Enter medicine name ","Warning",JOptionPane.ERROR_MESSAGE);
            }
            
             
            else{
                  try {
            
            String sql = "SELECT `Medicine Name`,  `Manufacture Date`, `Expiry Date` FROM `buymedicine` WHERE `Medicine Name`=? ";
          
            con1 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/online medicine donation system","root", "");
            pst1 =   (PreparedStatement) con1.prepareStatement(sql);
            pst1.setString(1, name1);
          rs1 = pst1.executeQuery();
          while(rs1.next()){
         
            
             
              
              mnfltf.setText(rs1.getString("Manufacture Date"));
             
              expltf.setText(rs1.getString("Expiry Date"));
              
             a=1;
             break;
          
               
              
         
          }     
         
           con1.close();
           pst1.close();
          
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Something Error "+ex);
           
        }
                  if(a==0)
                  {
                        JOptionPane.showMessageDialog(null, "Please Enter Correct medicine name ","Warning",JOptionPane.ERROR_MESSAGE);
                  }
            }
           
        }
          if(ae.getSource() ==  assign)
            
        { String name1 = nameltf.getSelectedItem().toString();
            if(timetf.getText().isEmpty()||datetf.getDate()==null||exemail.isEmpty()|| exname.isEmpty()|| nf.getText().isEmpty() || cf.getText().isEmpty()|| ef.getText().isEmpty()||ftf.getText().isEmpty()|| stf.getText().isEmpty() || atf.getText().isEmpty()|| ptf.getText().isEmpty()|| sttf.getText().isEmpty()|| ctf.getText().isEmpty() || name1.isEmpty()  || mnfltf.getText().isEmpty() || expltf.getText().isEmpty()|| numtf.getText().isEmpty() || typetf.getSelectedItem().toString().isEmpty())
            { JOptionPane.showMessageDialog(null, "Fill up the all information  ","Warning",JOptionPane.ERROR_MESSAGE); 
               }
           else
            {
                int a =0;
                String sql1 = "SELECT * FROM `executive` WHERE `Name` =? AND `Email`=? ";
              try {
                       
                       con1 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/online medicine donation system","root", "");
                  pst1 =   (PreparedStatement) con1.prepareStatement(sql1);
                  pst1.setString(1, exname);
                  pst1.setString(2, exemail);
                 
                  rs1 = pst1.executeQuery();
 
                 while(rs1.next()){
                   
                     
                    
                   a=1;
                   break;
                   }
                  con1.close();
           
                   } catch (SQLException ex) {     
                     JOptionPane.showMessageDialog(null, "Please Correct Executive Name and Email "+ ex); 
                }
            
            
            
           
          if(a==0)
                   {
                      JOptionPane.showMessageDialog(null, "Please Correct Executive Name and Email ","Warning",JOptionPane.ERROR_MESSAGE);
                   }       
          else{ 
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
                   if(date2.after(date1) )
                    {
                       JOptionPane.showMessageDialog(null, "Please Enter Donate Date is grater than or equal current Date ");
                   } 
                   else{
        String sql = "INSERT INTO `donate medicine`(`Medicine Name`, `Manufacture Date`, `Expiry Date`, `Medicine Type`, `Number of Tablet`, `Donate Time`, `Donate Date`, `Executive Name`,`Executive Email`, `User Name`, `User Email`, `Contact Number`, `Flat No`, `Street`, `Area`, `Pin Code`, `State`, `CityTown`)" + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
          try{
              con2 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/online medicine donation system","root", "");
          
            pst2 =  (PreparedStatement) con2.prepareStatement(sql);
            pst2.setString(1, name1);
            
               
            
             pst2.setString(2, mnfltf.getText());
            pst2.setString(3, expltf.getText());
             pst2.setString(4, typetf.getSelectedItem().toString());
            pst2.setString(5, numtf.getText());
            pst2.setString(6, timetf.getText());
              pst2.setString(7, dates);
             pst2.setString(8, exname);
              pst2.setString(9, exemail);
              pst2.setString(10, nf.getText());
               pst2.setString(11, ef.getText());
                pst2.setString(12, cf.getText());
                 pst2.setString(13, ftf.getText());
                  pst2.setString(14, stf.getText());
                   pst2.setString(15, atf.getText());
                    pst2.setString(16, ptf.getText());
                     pst2.setString(17, sttf.getText());
                      pst2.setString(18, ctf.getText());
                     
            
            pst2.executeUpdate();
            con2.close();
    
            
            JOptionPane.showMessageDialog(null, "Donate Medicine successfully");
            
        }
            
          catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Donate Medicine unsuccessfully"+ex);
        }
                   }
              
    }catch(Exception ex){
            
            JOptionPane.showMessageDialog(null, "Donate Medicine unsuccessfully"+ex);
        }
              
            }
        }
            }
        }
        if(ae.getSource() ==  homepage)
            
        {
            setVisible(false);
            HomePage frame = new  HomePage();
            frame.setVisible(true);
        }
        if(ae.getSource() ==  order)
            
        {
            setVisible(false);
          MyOrder frame = new MyOrder();
          frame.setVisible(true);
         
        }
       if(ae.getSource()==executive){
           setVisible(false);
          ViewexUser frame = new  ViewexUser();
          frame.setVisible(true);
          
       }
       
       if(ae.getSource()==logout)
        {
         
          int a = JOptionPane.showConfirmDialog(null, "Are You Sure?");
          if(a==JOptionPane.YES_OPTION){
           setVisible(false); 
          UserLogin frame = new UserLogin();
          frame.setVisible(true);
          }
        }
    
   
    }
        
        } 
    
    void  ComboBox()
    {
        try{
           String sql3 = "SELECT * FROM `buymedicine` " ;
                
                con3 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/online medicine donation system","root", "");
                pst3 =   (PreparedStatement) con3.prepareStatement(sql3);
               
                rs3 = pst3.executeQuery();
                while(rs3.next()){
                    String name = rs3.getString("Medicine Name");
            
            nameltf.addItem(name);
           
                }
        }catch(Exception e)
        {
            
        }
    }
     void  ComboBox1()
    {
        try{
           String sql4 = "SELECT * FROM `executive` " ;
                
                con4 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/online medicine donation system","root", "");
                pst4 =   (PreparedStatement) con4.prepareStatement(sql4);
               
                rs4 = pst4.executeQuery();
                while(rs4.next()){
                    String name = rs4.getString("Name");
                    String email = rs4.getString("Email");
            
            enamef.addItem(name);
            etf.addItem(email);
           
                }
        }catch(Exception e)
        {
            
        }
    }
    
    
 public static void main(String[] args) {
       DonateMedicine frame = new  DonateMedicine();
        frame.setVisible(true);    
    } 
}

