package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddRooms extends JFrame implements ActionListener{
    
    JTextField roomnoTF, priceTF;
    JComboBox availCB, cleanCB, typeCB;
    JButton Add, cancel;
    
    AddRooms() {
        
        setLayout(null);
        
        JLabel heading = new JLabel("Add Rooms");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(150, 20, 200, 20);
        add(heading);
        
        JLabel roomno = new JLabel("Room No. :");
        roomno.setFont(new Font("Tahoma", Font.PLAIN, 16));
        roomno.setBounds(60, 80, 120, 30);
        add(roomno);
        
        roomnoTF = new JTextField();
        roomnoTF.setBounds(200, 80, 150, 30);
        add(roomnoTF);
        
        JLabel availability = new JLabel("Avaialbility: ");
        availability.setFont(new Font("Tahoma", Font.PLAIN, 16));
        availability.setBounds(60, 130, 120, 30);
        add(availability);
        
        String str[] = {"Available", "Occupied"};
        availCB = new JComboBox(str);
        availCB.setBackground(Color.WHITE);
        availCB.setBounds(200, 130, 150, 30);
        add(availCB);
        
        JLabel clean = new JLabel("Cleaning Status :");
        clean.setFont(new Font("Tahoma", Font.PLAIN, 16));
        clean.setBounds(60, 180, 120, 30);
        add(clean);
        
        String str1[] = {"Cleaned", "Dirty"};
        cleanCB = new JComboBox(str1);
        cleanCB.setBackground(Color.WHITE);
        cleanCB.setBounds(200, 180, 150, 30);
        add(cleanCB);
        
        JLabel price = new JLabel("Price :");
        price.setFont(new Font("Tahoma", Font.PLAIN, 16));
        price.setBounds(60, 230, 120, 30);
        add(price);
        
        priceTF = new JTextField();
        priceTF.setBounds(200, 230, 150, 30);
        add(priceTF);
        
        JLabel bedtype = new JLabel("Bed type :");
        bedtype.setFont(new Font("Tahoma", Font.PLAIN, 16));
        bedtype.setBounds(60, 280, 120, 30);
        add(bedtype);
        
        String str2[] = {"Single bed", "Double bed"};
        typeCB = new JComboBox(str2);
        typeCB.setBackground(Color.WHITE);
        typeCB.setBounds(200, 280, 150, 30);
        add(typeCB);
        
        Add = new JButton("Add Room");
        Add.setBackground(Color.BLACK);
        Add.setForeground(Color.WHITE);
        Add.setBounds(60, 350, 130, 30);
        Add.addActionListener(this);
        add(Add);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(220, 350, 130, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 40, 500, 300);
        add(image);
        
        setTitle("Add Rooms");
        getContentPane().setBackground(Color.WHITE);
        setBounds(330, 200, 940, 470);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == Add) {
            String sroomno = roomnoTF.getText();
            String savailable = (String)availCB.getSelectedItem();
            String sclean = (String)cleanCB.getSelectedItem();
            String sprice = priceTF.getText();
            String stype = (String)typeCB.getSelectedItem();

            try {
                if (sroomno.equals("")) {
                    JOptionPane.showMessageDialog(null, "Fill all the required details");
                } else {
                    Conn c = new Conn();
                    String query = "insert into rooms values('"+sroomno+"', '"+savailable+"', '"+sclean+"', '"+sprice+"', '"+stype+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Room details saved successfully");
                    setVisible(false);
                }
            } catch (Exception  e) { 
                System.out.println(e);
            }
        }else if(ae.getSource() == cancel) {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new AddRooms();
    }
}
