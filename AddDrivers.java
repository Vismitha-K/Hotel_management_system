package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddDrivers extends JFrame implements ActionListener{
    
    JTextField nameTF, ageTF ,companyTF, modelTF, locationTF;
    JComboBox availCB, genderCB;
    JButton Add, cancel;
    
    AddDrivers() {
        
        setLayout(null);
        
        JLabel heading = new JLabel("Add Drivers");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(150, 20, 200, 20);
        add(heading);
        
        JLabel name = new JLabel("Name :");
        name.setFont(new Font("Tahoma", Font.PLAIN, 16));
        name.setBounds(60, 80, 120, 30);
        add(name);
        
        nameTF = new JTextField();
        nameTF.setBounds(200, 80, 150, 30);
        add(nameTF);
        
        JLabel age = new JLabel("Age : ");
        age.setFont(new Font("Tahoma", Font.PLAIN, 16));
        age.setBounds(60, 130, 120, 30);
        add(age);
        
        ageTF = new JTextField();
        ageTF.setBounds(200, 130, 150, 30);
        add(ageTF);
        
        JLabel gender = new JLabel("Gender :");
        gender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        gender.setBounds(60, 180, 120, 30);
        add(gender);
        
        String str1[] = {"Male", "Female", "Others"};
        genderCB = new JComboBox(str1);
        genderCB.setBackground(Color.WHITE);
        genderCB.setBounds(200, 180, 150, 30);
        add(genderCB);
        
        JLabel company = new JLabel("Car company :");
        company.setFont(new Font("Tahoma", Font.PLAIN, 16));
        company.setBounds(60, 230, 120, 30);
        add(company);
        
        companyTF = new JTextField();
        companyTF.setBounds(200, 230, 150, 30);
        add(companyTF);
        
        JLabel model = new JLabel("Car Model :");
        model.setFont(new Font("Tahoma", Font.PLAIN, 16));
        model.setBounds(60, 280, 120, 30);
        add(model);
        
        modelTF = new JTextField();
        modelTF.setBounds(200, 280, 150, 30);
        add(modelTF);
        
        JLabel available = new JLabel("Availability :");
        available.setFont(new Font("Tahoma", Font.PLAIN, 16));
        available.setBounds(60, 330, 120, 30);
        add(available);
        
        String str2[] = {"Available", "Busy"};
        availCB = new JComboBox(str2);
        availCB.setBackground(Color.WHITE);
        availCB.setBounds(200, 330, 150, 30);
        add(availCB);
        
        JLabel location = new JLabel("Location :");
        location.setFont(new Font("Tahoma", Font.PLAIN, 16));
        location.setBounds(60, 380, 120, 30);
        add(location);
        
        locationTF = new JTextField();
        locationTF.setBounds(200, 380, 150, 30);
        add(locationTF);
        
        Add = new JButton("Add Driver");
        Add.setBackground(Color.BLACK);
        Add.setForeground(Color.WHITE);
        Add.setBounds(60, 450, 130, 30);
        Add.addActionListener(this);
        add(Add);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(220, 450, 130, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 85, 500, 300);
        add(image);
        
        setTitle("Add Rooms");
        getContentPane().setBackground(Color.WHITE);
        setBounds(330, 200, 940, 550);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == Add) {
            String sname = nameTF.getText();
            String sage = ageTF.getText();
            String sgender = (String)genderCB.getSelectedItem();
            String scompany = companyTF.getText();
            String smodel = modelTF.getText();
            String savail = (String)availCB.getSelectedItem();
            String slocation = locationTF.getText();

            try {
                if (sname.equals("")) {
                    JOptionPane.showMessageDialog(null, "Fill all the required details");
                } else {
                    Conn c = new Conn();
                    String query = "insert into drivers values('"+sname+"', '"+sage+"', '"+sgender+"', '"+scompany+"', '"+smodel+"', '"+savail+"', '"+slocation+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Driver details saved successfully");
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
        new AddDrivers();
    }
}
