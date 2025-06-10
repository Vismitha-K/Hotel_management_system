
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton login, cancel;
    JTextField usernameTF;
    JPasswordField passwordTF;
    
    Login() {
        
        setLayout(null);
        
        JLabel username = new JLabel("User Name :");
        username.setBounds(40, 30, 100, 30);
        add(username);
        
        JLabel password = new JLabel("Password :");
        password.setBounds(40, 80, 100, 30);
        add(password);
        
        usernameTF = new JTextField();
        usernameTF.setBounds(150, 30, 170, 30);
        add(usernameTF);
        
        passwordTF = new JPasswordField();
        passwordTF.setBounds(150, 80, 170, 30);
        add(passwordTF);
        
        login = new JButton("Login");
        login.setBounds(60, 150, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(200, 150, 100, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 200, 200);
        add(image);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(600, 300);
        setLocation(500, 200);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == login) {
            String user = usernameTF.getText();
            String pass = passwordTF.getText();
            if(user.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter username");
            }else if(pass.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter password");
            } else {
                try {
                    Conn c = new Conn();
                    String query = "select * from login where username = '"+user+"' and password = '"+pass+"' ";
                    ResultSet rs = c.s.executeQuery(query);
                    if(rs.next()) {
                        setVisible(false);
                        new Dashboard();
                    }else{
                        JOptionPane.showMessageDialog(null, "Incorrect username or password");
                    }
                }catch(Exception e) {
                    e.printStackTrace();
                }
            }
        } else if(ae.getSource() == cancel) {
            setVisible(false);
        }
    } 
    
    public static void main(String[] args) {
        new Login();
    }
}
