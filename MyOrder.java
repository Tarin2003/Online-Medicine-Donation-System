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
public class MyOrder extends JFrame {
     private Container c;
   
    private JLabel label,title,title1,label2,label1;
     private JButton  homepage,logout,order,donate;
     private JTable table;
     private DefaultTableModel mode;
    private JScrollPane scroll;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
  
    String uname =  UserLogin.usernametf.getText();
     
        
     
    
    MyOrder()
    {
        initComponents();     
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
        
    
      
        donate = new JButton("Donate Medicine");
      donate.setFont(font1);
         donate.setBounds(191, 30, 270, 80);
       donate.setCursor(cursor);
        label.add( donate);
       logout = new JButton("Logout");
      logout.setFont(font1);
        logout.setBounds(462, 30, 190, 80);
       logout.setCursor(cursor);
        label.add(logout);
         
       
    
          
          label2 = new JLabel("Hi "+uname);
         
          
         label2.setBounds(1660, 30, 500, 80);
         label2.setFont(font1);
         label2.setToolTipText(uname);
         
           
         label.add(label2);  
          title1 = new JLabel("My Order");
        title1.setFont(font1);
        title1.setBounds(1, 260, 1900, 80);
        title1.setForeground(Color.BLUE);
       title1.setOpaque(true);
       title1.setBackground(Color.ORANGE);
       c.add(title1);
         
         
         Font font2 = new Font("Arial",Font.BOLD,18);
       Font font3 = new Font("Arial",Font.BOLD,20);
          String[] column ={"Medicine Name","Price (10 pcs)","Manufacture Date","Expiry Date"};
            String[] row = new String[4];
             
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
            TableColumn c2 = col.getColumn(1);
             TableColumn c3 = col.getColumn(2);
             TableColumn c4 = col.getColumn(3);
             
           c1.setPreferredWidth(1050);
            c2.setPreferredWidth(250);
            c3.setPreferredWidth(350);
             c4.setPreferredWidth(350);
             
      
        
        try {
            
            String sql = "SELECT * FROM `buymedicine` ";
          
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/online medicine donation system","root", "");
            pst =   (PreparedStatement) con.prepareStatement(sql);
          rs = pst.executeQuery();
          while(rs.next()){
           
               String n [] = {rs.getString("Medicine Name"), rs.getString("Price"),rs.getString("Manufacture Date"),rs.getString("Expiry Date")};
               model.addRow(n);
              
         
          }
         
           con.close();
           pst.close();
          
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Something Error "+ex);
           
        }
        Handler handler = new Handler();
        homepage.addActionListener(handler);
        
    
     donate.addActionListener(handler);
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
       
        if(ae.getSource() ==  donate)
            
        {
            setVisible(false);
          DonateMedicine frame = new DonateMedicine();
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
 public static void main(String[] args) {
        MyOrder frame = new MyOrder();
        frame.setVisible(true);    
    } 
}
    

