
package online.medicine.donation.system;


import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class HomePage extends JFrame {
   private JLabel title,imglabel,label,l;
   private JButton homepage,logout,ngo,user,executive,admin;
    private JPanel panel1;
    private Container c;
    private ImageIcon icon;
    private Cursor cursor;
   
  
    HomePage()
    {
        initComponents();  
       
        
    } 
    void initComponents()
    { 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1930, 1030);
        this.setTitle("Online Medicine Donation System");
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
        cursor = new Cursor(Cursor.HAND_CURSOR);
        Font font1 = new Font("Arial",Font.BOLD,24);
         homepage = new JButton("Home Page");
        homepage.setFont(font1);
        homepage.setBackground(Color.LIGHT_GRAY);
        homepage.setBounds(20, 30, 200, 80);
        
        homepage.setCursor(cursor);
         label.add(homepage);
    
       admin = new JButton("Admin");
       admin.setFont(font1);
        admin.setBounds(221, 30, 200, 80);
       admin.setCursor(cursor);
        label.add(admin);

       ngo = new JButton("NGO");
       ngo.setFont(font1);
       ngo.setBounds(422, 30, 200, 80);
       ngo.setCursor(cursor);
       label.add(ngo);
    
       executive = new JButton("Executive");
       executive.setFont(font1);
       executive.setBounds(623,30, 200, 80);
       executive.setCursor(cursor);
        label.add(executive);
  
        user = new JButton("User");
        user.setFont(font1);
        user.setBounds(824, 30, 200, 80);
        user.setCursor(cursor);
        label.add(user);
 
       logout = new JButton("LogOut");
       logout.setFont(font1);
        logout.setBounds(1025, 30, 200, 80);
       logout.setCursor(cursor);
        label.add(logout);
        
        
       
        JPanel panel1 = new JPanel();
        panel1.setBounds(1, 260,1930,720);
        c.add(panel1);
    
        icon = new ImageIcon(getClass().getResource("medicin.jpeg"));
        Image img = icon.getImage();
        Image newimage = img.getScaledInstance(panel1.getWidth(), panel1.getHeight(), Image.SCALE_SMOOTH);
       icon = new ImageIcon(newimage);
        imglabel = new JLabel(icon);
        panel1.add(imglabel); 
        l = new JLabel("|| Donate Medicine ||");
        l.setBounds(1100, 400, 500, 50);
       l.setFont(font);
        l.setForeground(Color.RED);
        imglabel.add(l);
        Handler handler = new Handler();
       admin.addActionListener(handler);
        ngo.addActionListener(handler);
        executive.addActionListener(handler);
      user.addActionListener(handler);
       
       logout.addActionListener(handler);
}
    class Handler implements ActionListener{
    public void actionPerformed(ActionEvent ae) {
        
           if(ae.getSource()==admin){
            
            admin.setBackground(Color.LIGHT_GRAY);
            setVisible(false);
            Login frame = new Login();
             frame.setVisible(true); 
        
    }

       if(ae.getSource()==ngo){
       
            ngo.setBackground(Color.LIGHT_GRAY);
            setVisible(false);
            NGOLogin frame = new NGOLogin();
             frame.setVisible(true); 
            
        }
       if(ae.getSource()==executive){
         setVisible(false);
            executive.setBackground(Color.LIGHT_GRAY);
            ExecutiveLogin frame = new ExecutiveLogin();
             frame.setVisible(true);
       }
    
       
            if(ae.getSource()==user){
            
           setVisible(false);
            UserLogin frame = new UserLogin();
              frame.setVisible(true); 
          
              
              
        }
   
   if(ae.getSource()==logout){
        
                
          System.exit(0);
    }
               
        
    
    }
    };

       
    
    

         
    public static void main(String[] args) {
        HomePage  frame = new HomePage();
        frame.setVisible(true);    
    } 
}
