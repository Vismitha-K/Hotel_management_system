package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Rooms extends JFrame implements ActionListener{
    
   JTable table;
   JButton back;
   
   Rooms() {
       
       JLabel Roomno = new JLabel("Room number");
       Roomno.setBounds(10, 10, 100, 20);;
       add(Roomno);
       
       JLabel avail = new JLabel("Availability");
       avail.setBounds(120, 10, 100, 20);;
       add(avail);
       
       JLabel status = new JLabel("Status");
       status.setBounds(230, 10, 100, 20);;
       add(status);
       
       JLabel price = new JLabel("Price");
       price.setBounds(330, 10, 100, 20);;
       add(price);
       
       JLabel type = new JLabel("Bed type");
       type.setBounds(420, 10, 100, 20);;
       add(type);
        
       table = new JTable();
       table.setBounds(0, 40, 500, 400);
       add(table);
       
       try {
           Conn c = new Conn();
           String query = "select * from rooms";
           ResultSet rs = c.s.executeQuery(query);
           table.setModel(DbUtils.resultSetToTableModel(rs));
       }catch(Exception e) {
           System.out.println(e);
       }
       
       back = new JButton("Back");
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.setBounds(200, 500, 120, 30);
       back.addActionListener(this);
       add(back);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
       Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(500, 0, 600, 600);
       add(image);
        
       setLayout(null);
       setTitle("Rooms information");
       getContentPane().setBackground(Color.WHITE);
       setBounds(300, 200, 1050, 600);
       setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Reception();
    }
    
    public static void main(String[] args) {
        new Rooms();
    }
    
}
