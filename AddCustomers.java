package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;

public class AddCustomers extends JFrame implements ActionListener{
    
    JComboBox idCB;
    JTextField idnoTF, nameTF, depositTF, countryTF;
    JRadioButton male, female; 
    Choice room; 
    JButton add, back;
    JLabel timee;
    
    AddCustomers() {
        
        JLabel heading = new JLabel("New customer form");
        heading.setBounds(100, 20, 300, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);
        
        JLabel id = new JLabel("ID :");
        id.setBounds(35, 80, 100, 25);
        id.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(id);
        
        String str[] = {"Aadhar", "Driving Licence", "Passport", "Voter ID"};
        idCB = new JComboBox(str);
        idCB.setBackground(Color.WHITE);
        idCB.setBounds(200, 80, 150, 25);
        add(idCB);
        
        JLabel idno = new JLabel("ID number:");
        idno.setBounds(35, 120, 100, 25);
        idno.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(idno);
        
        idnoTF = new JTextField();
        idnoTF.setBounds(200, 120, 150, 25);
        add(idnoTF);
        
        JLabel name = new JLabel("Name :");
        name.setBounds(35, 160, 100, 25);
        name.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(name);
        
        nameTF = new JTextField();
        nameTF.setBounds(200, 160, 150, 25);
        add(nameTF);
        
        JLabel gender = new JLabel("Gender :");
        gender.setBounds(35, 200, 100, 25);
        gender.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBackground(Color.WHITE);
        male.setBounds(200, 200, 80, 25);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBackground(Color.WHITE);
        female.setBounds(280, 200, 100, 25);
        add(female);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        
        JLabel country = new JLabel("Country :");
        country.setBounds(35, 240, 100, 25);
        country.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(country);
        
        countryTF = new JTextField();
        countryTF.setBounds(200, 240, 150, 25);
        add(countryTF);
        
        JLabel roomno = new JLabel("Room No. :");
        roomno.setBounds(35, 280, 100, 25);
        roomno.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(roomno);
        
        room = new Choice();
        room.setBounds(200, 280, 150, 25);
        add(room);
        
        try {
            Conn c = new Conn();
            String query = "select * from rooms where availability = 'Available'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                room.add(rs.getString("roomno"));
            }
        }catch(Exception e) {
            System.out.println(e);
        }
        
        JLabel time = new JLabel("Checkin time :");
        time.setBounds(35, 320, 150, 25);
        time.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(time);
        
        Date date = new Date();
        timee = new JLabel("" + date);
        timee.setBounds(200, 320, 150, 25);
        timee.setFont(new Font("Raleway", Font.PLAIN, 14));
        add(timee);
        
        JLabel deposit = new JLabel("Deposit :");
        deposit.setBounds(35, 360, 100, 25);
        deposit.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(deposit);
        
        depositTF = new JTextField();
        depositTF.setBounds(200, 360, 150, 25);
        add(depositTF);
        
        add = new JButton("Submit");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(70, 410, 100, 30);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(230, 410, 100, 30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/customers.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 400, 400);
        add(image);
        
        setLayout(null);
        setTitle("New Customer Information");
        getContentPane().setBackground(Color.WHITE);
        setBounds(350, 200, 860, 550);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == add) {
            String sid = (String)idCB.getSelectedItem();
            String sidno = idnoTF.getText();
            String sname = nameTF.getText();
            
            String sgender = null;
            if(male.isSelected()) {
                sgender = "Male";
            }else if(female.isSelected()) {
                sgender = "Female";
            }
            
            String scountry = countryTF.getText();
            String sroom = room.getSelectedItem();
            String stime = timee.getText();
            String sdeposit = depositTF.getText();
            
            try {
                if(sid.equals("") || sidno.equals("") || sname.equals("") || scountry.equals("") || sdeposit.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter all required details");
                }else {
                    Conn c = new Conn();
                    String query = "insert into customers values('"+sid+"', '"+sidno+"', '"+sname+"', '"+sgender+"', '"+scountry+"', '"+sroom+"', '"+stime+"', '"+sdeposit+"')";
                    String query1 = "update rooms set availability = 'Occupied' where roomno = '"+sroom+"'";
                    c.s.executeUpdate(query);
                    c.s.executeUpdate(query1);

                    JOptionPane.showMessageDialog(null, "Customer details added successfully");
                    setVisible(false);
                    new Reception();
                }
                
            }catch(Exception e) {
                System.out.println(e);
            }
        }else if(ae.getSource() == back) {
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String[] args) {
        new AddCustomers();
    }
}
