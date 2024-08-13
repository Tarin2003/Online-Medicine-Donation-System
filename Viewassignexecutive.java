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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Hp
 */
public class Viewassignexecutive extends JFrame{
     private Container c;
    private JTable table;
  private JLabel label,label2,title,title1,label1;
    private JButton  homepage, assign, logout,collect,buymed,viewmedicine,donate,viewuser;
    
    private JScrollPane scroll;
   
  private Connection con;
   private PreparedStatement pst;
   private ResultSet rs;
       String uname = ExecutiveLogin.nametf.getText();  
   
 Viewassignexecutive()
    {
        initComponents();     
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
        
        viewmedicine = new JButton("View Medicine");
      viewmedicine.setFont(font1);
        viewmedicine.setBounds(191, 30, 200, 80);
      viewmedicine.setCursor(cursor);
        label.add(viewmedicine);
        viewuser = new JButton("View Buy Med");
     viewuser.setFont(font1);
        viewuser.setBounds(392, 30, 199, 80);
      viewuser.setCursor(cursor);
        label.add(viewuser);
        buymed = new JButton("Buy Medicine");
       buymed.setFont(font1);
        buymed.setBounds(592, 30, 190, 80);
       buymed.setCursor(cursor);
        label.add(buymed);
       donate = new JButton("View Donate");
      donate.setFont(font1);
        donate.setBounds(783, 30, 180, 80);
      donate.setCursor(cursor);
        label.add(donate);
collect = new JButton("Collect Medicine");
       collect.setCursor(cursor);
        collect.setFont(font1);
      collect.setBounds(964, 30, 230, 80);
       label.add(collect);
      
       
       logout = new JButton("LogOut");
       logout.setFont(font1);
        logout.setBounds(1194, 30, 120, 80);
       logout.setCursor(cursor);
        label.add(logout);
         label2 = new JLabel("Hi "+uname);
         
          
         label2.setBounds(1660, 30, 500, 80);
         label2.setFont(font1);
         label2.setToolTipText(uname);
         
           
         label.add(label2); 
         title1 = new JLabel("View Assign User");
        title1.setFont(font1);
        title1.setBounds(1, 260, 1900, 80);
        title1.setForeground(Color.BLUE);
       title1.setOpaque(true);
       title1.setBackground(Color.ORANGE);
       c.add(title1);
         
        
       
         Font font2 = new Font("Arial",Font.BOLD,18);
         Font font3 = new Font("Arial",Font.BOLD,20);
          String[] column ={"Name","Gender","Date of Birth","Email","Contact Number","Location","NGO Name","NGO Email"};
            String[] row = new String[8];
             
            JTable table = new JTable();
           
          DefaultTableModel model = new DefaultTableModel();
          model.setColumnIdentifiers(column);
          table.setModel(model);
        
          table.setFont(font2);
          table.setSelectionBackground(Color.PINK);
          table.setRowHeight(40);
          table.setEnabled(false);
          JScrollPane scroll = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
          scroll.setBounds(1, 350,1900,630);
          c.add(scroll);
         
         
          JTableHeader header = table.getTableHeader();
         
        
        header.setFont(font3);
        
         header.setEnabled(false);
          TableColumnModel col = table.getColumnModel();
          TableColumn c1 = col.getColumn(0);
            TableColumn c2 = col.getColumn(3);
             TableColumn c3 = col.getColumn(4);
             TableColumn c4 = col.getColumn(5);
              TableColumn c5 = col.getColumn(1);
               TableColumn c6 = col.getColumn(2);
             TableColumn c7 = col.getColumn(6);
               TableColumn c8 = col.getColumn(7);
             
           c1.setPreferredWidth(275);
            c2.setPreferredWidth(290);
            c3.setPreferredWidth(163);
             c4.setPreferredWidth(350);
             c5.setPreferredWidth(75);
             c6.setPreferredWidth(130);
              c7.setPreferredWidth(300);
              c8.setPreferredWidth(340);
             
      
        try {
            
            String sql = "SELECT  `Name`, `Gender`, `Date of Birth`, `Email`, `Contact Number`, `Location`,`NGO`,`NGO Email` FROM `executive` ";
          
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/online medicine donation system","root", "");
            pst =   (PreparedStatement) con.prepareStatement(sql);
          rs = pst.executeQuery();
          while(rs.next()){
         
           
               String n [] = {rs.getString("Name"), rs.getString("Gender"),rs.getString("Date of Birth"),rs.getString("Email"),rs.getString("Contact Number"),rs.getString("Location"),rs.getString("NGO"),rs.getString("NGO Email")};
               model.addRow(n);
                  
         
               
              
         
          }
         
           con.close();
           pst.close();
          
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Something Error "+ex);
           
        }
       
         Handler handler = new Handler();
        homepage.addActionListener(handler);
        viewmedicine.addActionListener(handler);
        viewuser.addActionListener(handler);
        donate.addActionListener(handler);
        collect.addActionListener(handler);
       buymed.addActionListener(handler);
       logout.addActionListener(handler);
    }
    class Handler implements ActionListener{
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() ==  homepage)
            
        {
            setVisible(false);
            HomePage frame = new  HomePage();
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
        
        if(ae.getSource() ==  collect)
            
        {
            setVisible(false);
         CollectMedicine frame = new CollectMedicine();
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
          
            
         
        
        
    
    
    public static void main(String[] args) {
    Viewassignexecutive frame = new Viewassignexecutive();
        
        frame.setVisible(true);
   
        
    }

}
    

