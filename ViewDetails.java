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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hp
 */
public class ViewDetails extends JFrame{
     private JLabel title,userlabel,title1,label2,label,label1, timel,datel,eml, med, namel,pricel,mnfl,expl,title2,numl,typel,exel,personal,rl,ml,enamel,fl,sl,al,pl,stl,cl,n,e,c1;
    private JTextField priceltf,mnfltf,expltf,numtf,ftf,stf,atf,ptf,sttf,ctf,cf,medtf,timetf,datetf,typetf;
     private JButton  homepage,order,search, executive, logout,assign,collect,buymed,viewmedicine,viewuser, donate,view,back;
     private JTable table;
   private JComboBox nameltf,enamef,etf,ef,nf;
     private DefaultTableModel mode;
    private JScrollPane scroll;
    Container c;
    Connection con,con1;
    PreparedStatement pst,pst1;
    ResultSet rs,rs1;
   String uname = ExecutiveLogin.nametf.getText(); 
         
         
     
  
  
 ViewDetails()
    {
      
        initComponents();  
        ComboBox();
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
     assign.setBounds(191, 30, 270, 80);
       assign.setCursor(cursor);
        label.add(assign);
        viewmedicine = new JButton("View Medicine");
      viewmedicine.setFont(font1);
        viewmedicine.setBounds(462, 30, 224, 80);
      viewmedicine.setCursor(cursor);
        label.add(viewmedicine);
        viewuser = new JButton("View User");
     viewuser.setFont(font1);
        viewuser.setBounds(687, 30, 170, 80);
      viewuser.setCursor(cursor);
        label.add(viewuser);
        buymed = new JButton("Buy Medicine");
       buymed.setFont(font1);
        buymed.setBounds(858, 30, 190, 80);
       buymed.setCursor(cursor);
        label.add(buymed);
      
collect = new JButton("Collect Medicine");
       collect.setCursor(cursor);
        collect.setFont(font1);
      collect.setBounds(1049, 30, 230, 80);
       label.add(collect);
      
       
       logout = new JButton("LogOut");
       logout.setFont(font1);
        logout.setBounds(1280, 30, 120, 80);
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
        title1 = new JLabel("View Donate Medicine");
        title1.setFont(font1);
        title1.setBounds(1, 1, 1900, 40);
        title1.setForeground(Color.BLUE);
       title1.setOpaque(true);
       title1.setBackground(Color.ORANGE);
       label1.add(title1);
       Font font3 = new Font("Arial",Font.BOLD,26);
          Font font4 = new Font("Arial",Font.BOLD,21);
         title2 = new JLabel("Please Enter medicine Name or executive name or executive email or donator name or donator email and click the search button ");
        title2.setFont(font4);
        title2.setBounds(400, 45, 1900, 27);
         label1.add(title2);
           namel = new JLabel("Medicine Name : ");
       namel.setFont(font4);
      namel.setBounds(2, 100, 320, 30);
        label1.add(namel); 
      nameltf = new JComboBox();
      nameltf.setFont(font4);
        nameltf.setBounds(180, 100,300, 30);   
          label1.add(nameltf); 
        enamel = new JLabel("Executive Name : ");
        enamel.setFont(font4);
     enamel.setBounds(550, 100, 320, 30);
        label1.add( enamel);
        enamef = new JComboBox();
        enamef.setFont(font4);
     enamef.setBounds(740, 100, 300, 30);
        label1.add( enamef);
        
        eml = new JLabel("Executive Email : ");
        eml.setFont(font4);
     eml.setBounds(1090, 100, 320, 30);
        label1.add(eml);
        etf = new JComboBox();
         etf .setFont(font4);
      etf .setBounds(1280, 100, 300, 30);
        label1.add( etf );
       
        n = new JLabel("Donator Name : ");
        n.setFont(font4);
     n.setBounds(2, 140, 320, 30);
        label1.add(n);
        nf = new JComboBox();
        
      nf.setFont(font4);
        nf.setBounds(180, 140,300, 30);   
          label1.add(nf); 
          e = new JLabel("Donator Email : ");
        e.setFont(font4);
     e.setBounds(550, 140, 320, 30);
        label1.add(e);
         ef = new JComboBox();
      ef.setFont(font4);
        ef.setBounds(740, 140,300, 30);  
       
          label1.add(ef);
           search = new JButton("Search");
       search .setCursor(cursor);
         search.setFont(font3);
        search.setBounds(600, 180, 500, 40);
        label1.add( search);
        exel = new JLabel("Donator Details ");
        exel.setFont(font3);
     exel.setBounds(2, 250, 320, 30);
        label1.add (exel);
           c1 = new JLabel("Contact Number : ");
        c1.setFont(font4);
     c1.setBounds(2, 290, 320, 30);
        label1.add(c1);
         cf = new JTextField("");
      cf.setFont(font4);
     cf.setEditable(false);
        cf.setBounds(190, 290,300, 30);   
          label1.add(cf); 
           
         fl = new JLabel("Flate/Door/Block No : ");
        fl.setFont(font4);
     fl.setBounds(550, 290, 320, 30);
        label1.add(fl);
         ftf = new JTextField("");
      ftf.setFont(font4);
      ftf.setEditable(false);
        ftf.setBounds(770, 290,300, 30);   
          label1.add(ftf);
          sl = new JLabel("Street/Lane : ");
        sl.setFont(font4);
    sl.setBounds(1100, 290, 320, 30);
        label1.add(sl);
         stf = new JTextField("");
      stf.setFont(font4);
        stf.setBounds(1250, 290,300, 30);  
        stf.setEditable(false);
          label1.add(stf);
          al = new JLabel("Area/Locality : ");
        al.setFont(font4);
    al.setBounds(2, 330, 320, 30);
        label1.add(al);
         atf = new JTextField("");
      atf.setFont(font4);
        atf.setBounds(190, 330,300, 30);  
        atf.setEditable(false);
          label1.add(atf);
          pl = new JLabel("Pin Code : ");
        pl.setFont(font4);
    pl.setBounds(660, 330, 320, 30);
        label1.add( pl);
          ptf = new JTextField("");
     ptf.setFont(font4);
        ptf.setBounds(770,330,300, 30); 
        ptf.setEditable(false);
          label1.add(ptf);
          stl = new JLabel("State : ");
        stl.setFont(font4);
     stl.setBounds(1100, 330, 320, 30);
        label1.add( stl);
          sttf = new JTextField("");
      sttf.setFont(font4);
         sttf.setBounds(1250, 330,300, 30);  
         sttf.setEditable(false);
          label1.add( sttf);
           cl = new JLabel("CityTown : ");
         cl.setFont(font4);
      cl.setBounds(2, 370, 320, 30);
        label1.add(  cl);
           ctf = new JTextField("");
      ctf.setFont(font4);
          ctf.setBounds(190, 370,300, 30); 
         ctf.setEditable(false);
          label1.add(  ctf);
          med = new JLabel("Medicine Details ");
         med.setFont(font3);
     med.setBounds(2, 430, 320, 30);
        label1.add(med);
        
        
     
       
         mnfl  = new JLabel("Manufacture Date : ");
        mnfl.setFont(font4);
       mnfl.setBounds(2, 490, 320, 30);
           label1.add(mnfl);
         mnfltf  = new JTextField("");
        mnfltf.setFont(font4);
       mnfltf.setBounds(290, 490, 300, 30);
      mnfltf.setEditable(false);
         label1.add(mnfltf);
        
       expl = new JLabel("Expiry Date : ");
         expl.setFont(font4);
         expl.setBounds(630,490, 320, 30);
        label1.add( expl); 
        expltf = new JTextField("");
        expltf.setFont(font4);
       expltf.setBounds(780, 490,300, 30);
        expltf.setEditable(false);
         label1.add( expltf);
        
        typel = new JLabel("Type : ");
         typel.setFont(font4);
          typel.setBounds(1130,490, 320, 30);
        label1.add( typel); 
         typetf = new JTextField("");
        typetf.setFont(font4);
        typetf.setBounds(1280, 490,300, 30);
         typetf.setEditable(false);
         label1.add( typetf);
       numl = new JLabel("Number of Tablet or Syrup : ");
          numl.setFont(font4);
          numl.setBounds(2,530, 320, 30);
        label1.add(  numl); 
        numtf = new JTextField("");
        numtf.setFont(font4);
       numtf.setBounds(290, 530,300, 30);
       numtf.setEditable(false);
         label1.add(numtf);
         timel = new JLabel("Donate Time : ");
         timel.setFont(font4);
          timel.setBounds(630,530, 320, 30);
        label1.add( timel); 
        timetf = new JTextField("");
       timetf.setFont(font4);
      timetf.setBounds(780, 530,300, 30);
       timetf.setEditable(false);
         label1.add(timetf);
         datel = new JLabel("Donate Date : ");
         datel.setFont(font4);
          datel.setBounds(1130,530, 320, 30);
          
        label1.add( datel); 
        datetf = new JTextField("");
     datetf.setFont(font4);
      datetf.setBounds(1280, 530,300, 30);
       datetf.setEditable(false);
         label1.add(datetf);
       
          
          back= new JButton("Back");
       back.setCursor(cursor);
        back.setFont(font3);
     back.setBounds(600,620,680, 40);
        label1.add(  back);  
        
       
        Handler handler = new Handler();
        homepage.addActionListener(handler);
        search.addActionListener(handler);
     assign.addActionListener(handler);
     viewmedicine.addActionListener(handler);
     viewuser.addActionListener(handler);
      buymed.addActionListener(handler);
      
      collect.addActionListener(handler);
       logout.addActionListener(handler);
       back.addActionListener(handler);
    
    
}
      class Handler implements ActionListener{
    public void actionPerformed(ActionEvent ae) {
        String medname = nameltf.getSelectedItem().toString();
        String exname = enamef.getSelectedItem().toString();
        String exemail = etf.getSelectedItem().toString();
        String dname = nf.getSelectedItem().toString();
        String demail = ef.getSelectedItem().toString();
        if(ae.getSource()==search){
            int a=0;
        if(medname.isEmpty()|| exname.isEmpty()|| exemail.isEmpty()||dname.isEmpty()||demail.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please Enter medicine name or Executive Name or Executive Email or Donator Name or Donator Email","Warning",JOptionPane.ERROR_MESSAGE);
            }
        else{
                  try {
            
            String sql = "SELECT * FROM `donate medicine` WHERE `Medicine Name`=? AND `Executive Name`=? AND `Executive Email`=? AND `User Name`=? AND `User Email`=?";
          
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/online medicine donation system","root", "");
            pst =   (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, medname);
            pst.setString(2, exname);
            pst.setString(3, exemail);
            pst.setString(4, dname);
            pst.setString(5, demail);
          rs = pst.executeQuery();
          while(rs.next()){
         
            mnfltf.setText(rs.getString("Manufacture Date"));
             expltf.setText(rs.getString("Expiry Date"));
           typetf.setText(rs.getString("Medicine Type"));
           numtf.setText(rs.getString("Number of Tablet"));
            timetf.setText(rs.getString("Donate Time"));
           datetf.setText(rs.getString("Donate Date"));
              
             cf.setText(rs.getString("Contact Number"));
               ftf.setText(rs.getString("Flat No"));
                 stf.setText(rs.getString("Street"));
                  atf.setText(rs.getString("Area"));
                  ptf.setText(rs.getString("Pin Code"));
             sttf.setText(rs.getString("State"));
              ctf.setText(rs.getString("CityTown"));   
                      
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
                       JOptionPane.showMessageDialog(null, "Please Enter Correct medicine name or Executive Name or Executive Email or Donator Name or Donator Details ","Warning",JOptionPane.ERROR_MESSAGE);
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
        
        
         if(ae.getSource()==collect)
        {
             setVisible(false);
         CollectMedicine frame = new CollectMedicine();
          frame.setVisible(true);
        }
        
         if(ae.getSource()==back)
        {
             setVisible(false);
        ViewDonateMedicine frame = new  ViewDonateMedicine ();
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
                    String name = rs1.getString("Medicine Name");
            String exname = rs1.getString("Executive Name");
            String exemail = rs1.getString("Executive Email");
            String dname = rs1.getString("User Name");
            String demail = rs1.getString("User Email");
            nameltf.addItem(name);
            enamef.addItem(exname);
            etf.addItem(exemail);
            nf.addItem(dname);
            ef.addItem(demail);
                }
        }catch(Exception e)
        {
            
        }
    }
    
 public static void main(String[] args) {
        ViewDetails frame = new ViewDetails();
        frame.setVisible(true);    
    } 
}
    
    

