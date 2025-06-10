package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class UpdateRoom extends JFrame implements ActionListener{
    
    JButton back, check, update;
    JTextField roomnoTF, availTF, cleanTF;
    Choice cid;

    UpdateRoom() {
        
       JLabel heading = new JLabel("Update Room Status");
       heading.setBounds(90, 20, 300, 30);
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
       
       JLabel name = new JLabel("Availability :");
       name.setBounds(30, 160, 100, 20);
       add(name);
       
       availTF = new JTextField();
       availTF.setBounds(200, 160, 150, 25);
       add(availTF);
       
       JLabel checkin = new JLabel("Cleaning Status :");
       checkin.setBounds(30, 200, 100, 20);
       add(checkin);
       
       cleanTF = new JTextField();
       cleanTF.setBounds(200, 200, 150, 25);
       add(cleanTF);
       
       
       check = new JButton("Check");
       check.setBackground(Color.BLACK);
       check.setForeground(Color.WHITE);
       check.setBounds(30, 270, 100, 30);
       check.addActionListener(this);
       add(check);
       
       update = new JButton("Update");
       update.setBackground(Color.BLACK);
       update.setForeground(Color.WHITE);
       update.setBounds(150, 270, 100, 30);
       update.addActionListener(this);
       add(update);
       
       back = new JButton("Back");
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.setBounds(270, 270, 100, 30);
       back.addActionListener(this);
       add(back);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
       Image i2 = i1.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(450, 50, 400, 250);
       add(image);
       
       setLayout(null);
       setTitle("Update Room Status");
       getContentPane().setBackground(Color.WHITE);
       setBounds(300, 200, 900, 400);
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
                }
                String query1 = "select * from rooms where roomno = '"+roomnoTF.getText()+"'";
                ResultSet rs1 = c.s.executeQuery(query1);
                while(rs1.next()) {
                    availTF.setText(rs1.getString("availability"));
                    cleanTF.setText(rs1.getString("cleaning_status"));
                }
            }catch(Exception e) {
                System.out.println(e);
            }
        }else if(ae.getSource() == update) {
            String sroomno = roomnoTF.getText();
            
            String savail = availTF.getText();
            String sclean = cleanTF.getText();
            
            try {
                Conn c = new Conn();
                String query = "update rooms set availability = '"+savail+"', cleaning_status = '"+sclean+"' where roomno = '"+sroomno+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Room details updated successfully");
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
        new UpdateRoom();
    }
}
