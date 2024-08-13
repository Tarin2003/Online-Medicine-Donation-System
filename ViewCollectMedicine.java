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
public class ViewCollectMedicine extends JFrame{
     private Container c;
  private JTable table;
    private JLabel label,label2,title,title1,label1;
    private JButton  homepage,user,assign, logout,viwngo,viewmed,viewexecutive,collect,view;
  private JScrollPane scroll;
   
  private Connection con;
   private PreparedStatement pst;
   private ResultSet rs;
       private String uname = NGOLogin.usernametf.getText();
 ViewCollectMedicine()
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
     
                      
        view = new JButton("View Details");
        view.setCursor(cursor);
         view.setFont(font1);
       view.setBounds(800, 910, 400, 50);
       c.add( view);
       
         title1 = new JLabel("View Collect Medicine");
        title1.setFont(font1);
        title1.setBounds(1, 260, 1900, 40);
        title1.setForeground(Color.BLUE);
       title1.setOpaque(true);
       title1.setBackground(Color.ORANGE);
         c.add(title1);
     
       Font font2 = new Font("Arial",Font.BOLD,18);
       Font font3 = new Font("Arial",Font.BOLD,20);
          String[] column ={"Medicine Name","Executive Name","Executive Email"};
            String[] row = new String[3];
             
            JTable table = new JTable();
           
          DefaultTableModel model = new DefaultTableModel();
          model.setColumnIdentifiers(column);
          table.setModel(model);
        
          table.setFont(font2);
          table.setSelectionBackground(Color.PINK);
          table.setRowHeight(40);
          table.setEnabled(false);
          JScrollPane scroll = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
          scroll.setBounds(1, 320,1900,530);
          c.add(scroll);
         
         
          JTableHeader header = table.getTableHeader();
         
        
        header.setFont(font3);
        
         header.setEnabled(false);
          
             
      
        
        try {
            
            String sql = "  SELECT `Executive Name`, `Executive Email`,`Medicine Name` FROM `collect medicine` ";
          
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/online medicine donation system","root", "");
            pst =   (PreparedStatement) con.prepareStatement(sql);
          rs = pst.executeQuery();
          while(rs.next()){
         
           
               String n [] = {rs.getString("Medicine Name"), rs.getString("Executive Name"),rs.getString("Executive Email")};
               model.addRow(n);
              
         
               
              
         
          }
         
           con.close();
           pst.close();
          
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Something Error "+ex);
           
        }
       
             
      
        
       
    Handler handler = new Handler();
        homepage.addActionListener(handler);
        viwngo.addActionListener(handler);
       viewmed.addActionListener(handler);
      user.addActionListener(handler);
      assign.addActionListener(handler);
      viewexecutive.addActionListener(handler);
     view.addActionListener(handler);
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
    
    public static void main(String[] args) {
       ViewCollectMedicine frame = new ViewCollectMedicine();
        
        frame.setVisible(true);
        
       
        
        
        
        
    }

}

    


    

    

