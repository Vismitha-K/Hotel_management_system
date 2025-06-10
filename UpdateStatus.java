package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class UpdateStatus extends JFrame implements ActionListener{
    
    JButton back, check, update;
    JTextField roomnoTF, nameTF, checkinTF, depositTF, pendingTF;
    Choice cid;

    UpdateStatus() {
        
       JLabel heading = new JLabel("Update Status");
       heading.setBounds(90, 20, 200, 30);
       heading.setFont(new Font("Tahoma", Font.BOLD, 20));
       add(heading);
       
       JLabel id = new JLabel("ID: ");
       id.setBounds(30, 80, 100, 20);
       add(id);
       
       cid = new Choice();
       cid.setBounds(200, 80, 150, 20);
       add(cid);
       
       try{
           Conn c = new Conn();
           String query = "select * from customers";
           ResultSet rs = c.s.executeQuery(query);
           while(rs.next()) {
               cid.add(rs.getString("id_no"));
           }
       }catch(Exception e) {
           System.out.println(e);
       }
       
       JLabel roomno = new JLabel("Room No. :");
       roomno.setBounds(30, 120, 100, 20);
       add(roomno);
       
       roomnoTF = new JTextField();
       roomnoTF.setBounds(200, 120, 150, 25);
       add(roomnoTF);
       
       JLabel name = new JLabel("Name :");
       name.setBounds(30, 160, 100, 20);
       add(name);
       
       nameTF = new JTextField();
       nameTF.setBounds(200, 160, 150, 25);
       add(nameTF);
       
       JLabel checkin = new JLabel("Checkin time :");
       checkin.setBounds(30, 200, 100, 20);
       add(checkin);
       
       checkinTF = new JTextField();
       checkinTF.setBounds(200, 200, 150, 25);
       add(checkinTF);
       
       JLabel deposit = new JLabel("Amount paid :");
       deposit.setBounds(30, 240, 100, 20);
       add(deposit);
       
       depositTF = new JTextField();
       depositTF.setBounds(200, 240, 150, 25);
       add(depositTF);
       
       JLabel pending = new JLabel("Pending amount :");
       pending.setBounds(30, 280, 100, 20);
       add(pending);
       
       pendingTF = new JTextField();
       pendingTF.setBounds(200, 280, 150, 25);
       add(pendingTF);
       
       check = new JButton("Check");
       check.setBackground(Color.BLACK);
       check.setForeground(Color.WHITE);
       check.setBounds(30, 340, 100, 30);
       check.addActionListener(this);
       add(check);
       
       update = new JButton("Update");
       update.setBackground(Color.BLACK);
       update.setForeground(Color.WHITE);
       update.setBounds(150, 340, 100, 30);
       update.addActionListener(this);
       add(update);
       
       back = new JButton("Back");
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.setBounds(270, 340, 100, 30);
       back.addActionListener(this);
       add(back);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
       Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(450, 50, 400, 300);
       add(image);
       
       setLayout(null);
       setTitle("Update Status");
       getContentPane().setBackground(Color.WHITE);
       setBounds(300, 200, 900, 500);
       setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == check) {
            String sid = cid.getSelectedItem();
            try {
                Conn c = new Conn();
                String query = "select * from customers where id_no = '"+sid+"'";
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()) {
                    roomnoTF.setText(rs.getString("room_no"));
                    nameTF.setText(rs.getString("name"));
                    checkinTF.setText(rs.getString("checkin_time"));
                    depositTF.setText(rs.getString("deposit"));
                }
                String query1 = "select * from rooms where roomno = '"+roomnoTF.getText()+"'";
                ResultSet rs1 = c.s.executeQuery(query1);
                while(rs1.next()) {
                    int pending = Integer.parseInt(rs1.getString("price")) - Integer.parseInt(depositTF.getText());
                    pendingTF.setText("" + pending);
                }
            }catch(Exception e) {
                System.out.println(e);
            }
        }else if(ae.getSource() == update) {
            String sroomno = roomnoTF.getText();
            String sname = nameTF.getText();
            //String scheckin = checkinTF.getText();
            String sdeposit = depositTF.getText();
            //String spending = pendingTF.getText();
            try {
                Conn c = new Conn();
                String query = "update customers set name = '"+sname+"', deposit = '"+sdeposit+"' where room_no = '"+sroomno+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Customer details updated successfully");
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
        new UpdateStatus();
    }
}
