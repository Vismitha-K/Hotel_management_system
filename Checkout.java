package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Checkout extends JFrame implements ActionListener{
    
    JButton check, checkOut, back;
    Choice idno;
    JLabel checkoutTF, checkinTF, roomnoTF;

    Checkout() {
        
       JLabel heading = new JLabel("Check Out");
       heading.setBounds(100, 20, 200, 30);
       heading.setFont(new Font("Tahoma", Font.BOLD, 20));
       add(heading);
       
       JLabel id = new JLabel("ID number");
       id.setBounds(30, 80, 100, 30);
       add(id);
       
       idno = new Choice();
       idno.setBounds(150, 80, 200, 30);
       add(idno);
       
       try{
           Conn c = new Conn();
           String query = "select * from customers";
           ResultSet rs = c.s.executeQuery(query);
           while(rs.next()) {
               idno.add(rs.getString("id_no"));
           }
       }catch(Exception e) {
           System.out.println(e);
       }
       
       JLabel Roomno = new JLabel("Room No. :");
       Roomno.setBounds(30, 130, 100, 20);;
       add(Roomno);
       
       roomnoTF = new JLabel();
       roomnoTF.setBounds(150, 130, 150, 20);
       add(roomnoTF);
       
       JLabel checkin = new JLabel("Check-in time :");
       checkin.setBounds(30, 180, 100, 20);;
       add(checkin);
       
       checkinTF = new JLabel();
       checkinTF.setBounds(150, 180, 200, 20);
       add(checkinTF);
       
       JLabel checkout = new JLabel("Check-out time :");
       checkout.setBounds(30, 230, 100, 20);
       add(checkout);
       
       Date date = new Date();
       checkoutTF = new JLabel(""+date);
       checkoutTF.setBounds(150, 230, 200, 20);
       add(checkoutTF);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
       Image i2 = i1.getImage().getScaledInstance(370, 250, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(380, 70, 370, 250);
       add(image);
        
       check = new JButton("Check");
       check.setBackground(Color.BLACK);
       check.setForeground(Color.WHITE);
       check.setBounds(30, 280, 100, 30);
       check.addActionListener(this);
       add(check);
        
       checkOut = new JButton("Check Out");
       checkOut.setBackground(Color.RED);
       checkOut.setForeground(Color.WHITE);
       checkOut.setBounds(150, 280, 100, 30);
       checkOut.addActionListener(this);
       add(checkOut);
       
       back = new JButton("Back");
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.setBounds(270, 280, 100, 30);
       back.addActionListener(this);
       add(back);
        
       setLayout(null);
       setTitle("Check Out");
       getContentPane().setBackground(Color.WHITE);
       setBounds(300, 200, 800, 400);
       setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == check) {
            
            try {
                Conn c = new Conn();
                String query = "select * from customers where id_no = '"+idno.getSelectedItem()+"'";
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()) {
                    roomnoTF.setText(rs.getString("room_no"));
                    checkinTF.setText(rs.getString("checkin_time"));
                }
            }catch(Exception e) {
                System.out.println(e);
            }
        }else if(ae.getSource() == checkOut) {
            String sroomno = roomnoTF.getText();
            try {
                Conn c = new Conn();
                String query1 = "delete from customers where id_no = '"+idno.getSelectedItem()+"'";
                String query2 = "update rooms set availability = 'Available' where roomno = '"+sroomno+"'";
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Check out successful");
                setVisible(false);
                new Reception();
            }catch(Exception e) {
                System.out.println(e);
            } 
        }else if(ae.getSource() == back) {
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String[] args) {
        new Checkout();
    }
}
