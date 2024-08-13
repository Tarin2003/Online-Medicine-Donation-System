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
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

      
         
 
 public class JPassWoField extends JFrame{
   
    private JLabel label,title,label1,label2,label3;
   private  JPanel panel;
    private JButton homepage, addmed,viewuser,viewngo,viewmed,addngo, logout;
   private Container c;
     private JTable table;
   private DefaultTableModel mode;
    private JScrollPane scroll;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
         
   JPassWoField(){
       initComponents();
   }
    
   
    void initComponents()
    {  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1930, 1030);
        this.setTitle("Admin");
        c = this.getContentPane();
        c.setLayout(null);
        this.setResizable(false);
         c.setBackground(Color.GRAY);
         
         
    
      Font font1 = new Font("Arial",Font.BOLD,24);
     Font font2 = new Font("Arial",Font.BOLD,22);
       
          String[] column ={"Medicine Name","Price","Manufacture Date","Expire Date"};
            String[] row = new String[4];
             
           JTable table = new JTable();
           
          DefaultTableModel model = new DefaultTableModel();
          model.setColumnIdentifiers(column);
          table.setModel(model);
        
          table.setFont(font2);
          table.setSelectionBackground(Color.PINK);
          table.setRowHeight(40);
          
          JScrollPane scroll = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
          scroll.setBounds(1, 130,1900,700);
          c.add(scroll);
         
         
          JTableHeader header = table.getTableHeader();
         
         header.setFont(font1);
        
         header.setEnabled(false);
      
        
        try {
            
            String sql = "SELECT * FROM `addmedicine` ";
          
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/online medicine donation system","root", "");
            pst =   (PreparedStatement) con.prepareStatement(sql);
          rs = pst.executeQuery();
          while(rs.next()){
           
               String n [] = {rs.getString("Medicine Name"), rs.getString("Price"),rs.getString("Manufacture Date"),rs.getString("Expire Date")};
               model.addRow(n);
              
         
          }
         
           con.close();
           pst.close();
          
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Something Error "+ex);
           
        }

    }  
         
      public static void main(String[] args) {
        JPassWoField f = new JPassWoField();
        f.setVisible(true); 


}
}

    


    

    
 