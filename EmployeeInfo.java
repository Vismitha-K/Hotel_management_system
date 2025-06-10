package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class EmployeeInfo extends JFrame implements ActionListener{
    
   JTable table;
   JButton back;
   
   EmployeeInfo() {
       
       JLabel name = new JLabel("Name");
       name.setBounds(40, 10, 100, 20);;
       add(name);
       
       JLabel age = new JLabel("Age");
       age.setBounds(160, 10, 100, 20);;
       add(age);
       
       JLabel gender = new JLabel("Gender");
       gender.setBounds(280, 10, 100, 20);;
       add(gender);
       
       JLabel job = new JLabel("Job");
       job.setBounds(400, 10, 100, 20);;
       add(job);
       
       JLabel salary = new JLabel("Salary");
       salary.setBounds(520, 10, 100, 20);;
       add(salary);
       
       JLabel phno = new JLabel("Phone No");
       phno.setBounds(640, 10, 100, 20);;
       add(phno);
       
       JLabel email = new JLabel("E-mail");
       email.setBounds(760, 10, 100, 20);;
       add(email);
       
       JLabel aadhar = new JLabel("Aadhar No");
       aadhar.setBounds(880, 10, 100, 20);;
       add(aadhar);
        
       table = new JTable();
       table.setBounds(0, 40, 1000, 400);
       add(table);
       
       try {
           Conn c = new Conn();
           String query = "select * from employees";
           ResultSet rs = c.s.executeQuery(query);
           table.setModel(DbUtils.resultSetToTableModel(rs));
       }catch(Exception e) {
           System.out.println(e);
       }
       
       back = new JButton("Back");
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.setBounds(400, 500, 120, 30);
       back.addActionListener(this);
       add(back);
       
       setLayout(null);
       setTitle("Employee information");
       getContentPane().setBackground(Color.WHITE);
       setBounds(300, 200, 1000, 600);
       setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Reception();
    }
    
    public static void main(String[] args) {
        new EmployeeInfo();
    }
    
}

