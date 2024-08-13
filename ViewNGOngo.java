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
public class ViewNGOngo extends JFrame{
    private Container c;
  private JTable table;
    private JLabel label,label2,title,title1,label1;
    private JButton  homepage,user,assign, logout,viwngo,viewmed,viewexecutive,collect;
     private DefaultTableModel mode;
    private JScrollPane scroll,scroll1;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
  
   
  ViewNGOngo()
    {
        initComponents();     
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
 
       
        viewmed = new JButton("View Medicine");
       viewmed.setCursor(cursor);
       viewmed.setFont(font1);
       viewmed.setBounds(201, 30, 220, 80);
       label.add(viewmed);
       user = new JButton("View user");
        user.setCursor(cursor);
        user.setFont(font1);
        user.setBounds(422, 30, 180, 80);
       label.add(user);
        assign = new JButton("Assing Executive");
       assign.setCursor(cursor);
        assign.setFont(font1);
       assign.setBounds(603, 30, 250, 80);
       label.add(assign);
      
       viewexecutive = new JButton("View Executive");
        viewexecutive.setCursor(cursor);
        viewexecutive.setFont(font1);
        viewexecutive.setBounds(854, 30, 240, 80);
       label.add(viewexecutive);
       
       collect = new JButton("View Collect Med");
       collect.setCursor(cursor);
        collect.setFont(font1);
        collect.setBounds(1095, 30, 250, 80);
        label.add(collect);
       logout = new JButton("Logout");
       logout.setCursor(cursor);
        logout.setFont(font1);
        logout.setBounds(1346, 30, 200, 80);
        label.add(logout);
                      
     label2 = new JLabel("Hi "+NGOLogin.usernametf.getText());
         
          
         label2.setBounds(1640, 30, 500, 80);
         label2.setFont(font1);
         label2.setToolTipText(NGOLogin.usernametf.getText());
         
           
         label.add(label2);
         
          title1 = new JLabel("View NGO");
        title1.setFont(font1);
        title1.setBounds(1, 260, 1900, 80);
        title1.setForeground(Color.BLUE);
       title1.setOpaque(true);
       title1.setBackground(Color.ORANGE);
       c.add(title1);
       
             
         Font font2 = new Font("Arial",Font.BOLD,18);
          Font font3 = new Font("Arial",Font.BOLD,20);
          String[] column ={"ID","Name","Email","Gender","Contact Number","Location","Admin Name","Admin Email"};
            String[] row = new String[8];
             
            JTable table = new JTable();
           
          DefaultTableModel model = new DefaultTableModel();
          model.setColumnIdentifiers(column);
          table.setModel(model);
        
          table.setFont(font2);
          table.setSelectionBackground(Color.PINK);
          table.setRowHeight(50);
            table.setEnabled(false);
          JScrollPane scroll = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
          scroll.setBounds(1, 350,1900,630);
          c.add(scroll);
       
          TableColumnModel col = table.getColumnModel();
          TableColumn c1 = col.getColumn(1);
            TableColumn c2 = col.getColumn(3);
             TableColumn c3 = col.getColumn(4);
              TableColumn c4 = col.getColumn(5);
               TableColumn c5 = col.getColumn(2);
               TableColumn c6 = col.getColumn(0);
                TableColumn c7 = col.getColumn(6);
               TableColumn c8 = col.getColumn(7);
           c1.setPreferredWidth(300);
            c2.setPreferredWidth(80);
             c3.setPreferredWidth(170);
              c4.setPreferredWidth(400);
              c5.setPreferredWidth(368);
              c6.setPreferredWidth(80);
             c7.setPreferredWidth(260);
              c8.setPreferredWidth(300);
        
          JTableHeader header = table.getTableHeader();
         
         header.setFont(font3);
        
         header.setEnabled(false);
      
        
        try {
            
            String sql = "SELECT ` ID`, `Name`, `Gender`, `Email`,  `Contact Number`, `Location`,`Admin Name`, `Admin Email` FROM `addngo` ";
          
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/online medicine donation system","root", "");
            pst =   (PreparedStatement) con.prepareStatement(sql);
          rs = pst.executeQuery();
          while(rs.next()){
           
               String n [] = {rs.getString(" ID"),rs.getString("Name"),rs.getString("Email"), rs.getString("Gender"),rs.getString("Contact Number"),rs.getString("Location"),rs.getString("Admin Name"),rs.getString("Admin Email")};
               model.addRow(n);
               
              
         
          }
         
           con.close();
           pst.close();
          
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Something Error "+ex);
           
        }
       
    Handler handler = new Handler();
        homepage.addActionListener(handler);
       
        viewmed.addActionListener(handler);
      user.addActionListener(handler);
     assign.addActionListener(handler);
      viewexecutive.addActionListener(handler);
       logout.addActionListener(handler);
       collect.addActionListener(handler);
    }

   

   
    class Handler implements ActionListener{
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() ==  homepage)
            
        {
            setVisible(false);
            HomePage frame = new  HomePage();
            frame.setVisible(true);
        }
        if(ae.getSource() ==  viewmed)
            
        {
            setVisible(false);
           ViewMedNGO frame = new   ViewMedNGO();
            frame.setVisible(true);
        }
        if(ae.getSource() ==  user)
            
        {
            setVisible(false);
          UserView frame = new UserView();
          frame.setVisible(true);
         
        }
        if(ae.getSource() ==  assign)
            
        {
            setVisible(false);
           AssignExecutive frame = new  AssignExecutive();
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
       
        
       
        else if(ae.getSource()==logout)
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
    
    public static void main(String[] args) {
       ViewNGOngo frame = new ViewNGOngo();
        
        frame.setVisible(true);
        
       
        
        
        
        
    }

}

    

    

