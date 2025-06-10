package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener{
    
   JTable table;
   JButton cancel;
   
   CustomerInfo() {
       
       JLabel name = new JLabel("ID");
       name.setBounds(40, 10, 100, 20);;
       add(name);
       
       JLabel age = new JLabel("ID No.");
       age.setBounds(160, 10, 100, 20);;
       add(age);
       
       JLabel gender = new JLabel("Name");
       gender.setBounds(280, 10, 100, 20);;
       add(gender);
       
       JLabel job = new JLabel("Gender");
       job.setBounds(400, 10, 100, 20);;
       add(job);
       
       JLabel salary = new JLabel("Country");
       salary.setBounds(520, 10, 100, 20);;
       add(salary);
       
       JLabel phno = new JLabel("Room No");
       phno.setBounds(640, 10, 100, 20);;
       add(phno);
       
       JLabel email = new JLabel("Checkin Time");
       email.setBounds(760, 10, 100, 20);;
       add(email);
       
       JLabel aadhar = new JLabel("Deposit");
       aadhar.setBounds(880, 10, 100, 20);;
       add(aadhar);
        
       table = new JTable();
       table.setBounds(0, 40, 1000, 400);
       add(table);
       
       try {
           Conn c = new Conn();
           String query = "select * from customers";
           ResultSet rs = c.s.executeQuery(query);
           table.setModel(DbUtils.resultSetToTableModel(rs));
       }catch(Exception e) {
           System.out.println(e);
       }
       
       cancel = new JButton("Back");
       cancel.setBackground(Color.BLACK);
       cancel.setForeground(Color.WHITE);
       cancel.setBounds(400, 500, 120, 30);
       cancel.addActionListener(this);
       add(cancel);
       
       setLayout(null);
       setTitle("Customer information");
       getContentPane().setBackground(Color.WHITE);
       setBounds(300, 200, 1000, 600);
       setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Reception();
    }
    
    public static void main(String[] args) {
        new CustomerInfo();
    }
    
}

