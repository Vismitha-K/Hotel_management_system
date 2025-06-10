package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Pickup extends JFrame implements ActionListener{
    
   JTable table;
   JButton back, submit;
   Choice cartype;
   
   Pickup() {
       
       JLabel heading = new JLabel("Search Drivers");
       heading.setBounds(400, 30, 200, 30);
       heading.setFont(new Font("Tahoma", Font.BOLD, 18));
       add(heading);
       
       JLabel RoomType = new JLabel("Car Model");
       RoomType.setBounds(50, 90, 100, 30);;
       add(RoomType);
       
       cartype = new Choice();
       cartype.setBounds(150, 100, 200, 30);
       add(cartype);
       
       try{
           Conn c = new Conn();
           String query = "select * from drivers";
           ResultSet rs = c.s.executeQuery(query);
           while(rs.next()) {
               cartype.add(rs.getString("car_model"));
           }
       }catch(Exception e) {
           System.out.println(e);
       }
   
       JLabel Roomno = new JLabel("Name");
       Roomno.setBounds(50, 160, 100, 20);;
       add(Roomno);
       
       JLabel age = new JLabel("Age");
       age.setBounds(190, 160, 100, 20);;
       add(age);
       
       JLabel status = new JLabel("Gender");
       status.setBounds(320, 160, 100, 20);;
       add(status);
       
       JLabel price = new JLabel("Car company");
       price.setBounds(460, 160, 100, 20);;
       add(price);
       
       JLabel type = new JLabel("Car model");
       type.setBounds(610, 160, 100, 20);;
       add(type);
       
       JLabel avail = new JLabel("Availability");
       avail.setBounds(740, 160, 100, 20);;
       add(avail);
       
       JLabel loc = new JLabel("Location");
       loc.setBounds(900, 160, 100, 20);;
       add(loc);
        
       table = new JTable();
       table.setBounds(0, 180, 1000, 300);
       add(table);
       
       try {
           Conn c = new Conn();
           String query = "select * from drivers";
           ResultSet rs = c.s.executeQuery(query);
           table.setModel(DbUtils.resultSetToTableModel(rs));
       }catch(Exception e) {
           System.out.println(e);
       }
       
       submit = new JButton("Submit");
       submit.setBackground(Color.BLACK);
       submit.setForeground(Color.WHITE);
       submit.setBounds(300, 500, 120, 30);
       submit.addActionListener(this);
       add(submit);
       
       back = new JButton("Back");
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.setBounds(500, 500, 120, 30);
       back.addActionListener(this);
       add(back);
        
       setLayout(null);
       setTitle("Drivers information");
       getContentPane().setBackground(Color.WHITE);
       setBounds(300, 200, 1000, 600);
       setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == back) {
            setVisible(false);
            new Reception();
        }else if(ae.getSource() == submit) {
            try{
                Conn c = new Conn();
                ResultSet rs;
                String query1 = "select * from drivers where car_model = '"+cartype.getSelectedItem()+"'";
                rs = c.s.executeQuery(query1);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e) {
                System.out.println(e);
            }
        }
    }
    
    public static void main(String[] args) {
        new Pickup();
    }
    
}
