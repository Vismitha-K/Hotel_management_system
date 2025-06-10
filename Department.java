package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Department extends JFrame implements ActionListener{
    
   JTable table;
   JButton back;
   
   Department() {
       
       JLabel dept = new JLabel("Department");
       dept.setBounds(180, 10, 100, 20);;
       add(dept);
       
       JLabel avail = new JLabel("Budget");
       avail.setBounds(450, 10, 100, 20);;
       add(avail);
       
        
       table = new JTable();
       table.setBounds(0, 50, 700, 350);
       add(table);
       
       try {
           Conn c = new Conn();
           String query = "select * from department";
           ResultSet rs = c.s.executeQuery(query);
           table.setModel(DbUtils.resultSetToTableModel(rs));
       }catch(Exception e) {
           System.out.println(e);
       }
       
       back = new JButton("Back");
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.setBounds(290, 400, 120, 30);
       back.addActionListener(this);
       add(back);
       
        
       setLayout(null);
       setTitle("Department information");
       getContentPane().setBackground(Color.WHITE);
       setBounds(400, 200, 700, 480);
       setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Reception();
    }
    
    public static void main(String[] args) {
        new Department();
    }
}
