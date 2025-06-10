package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Reception extends JFrame implements ActionListener{
    
    JButton customer, room, dept, employee, customerInfo, managerInfo, checkout, updateStatus, updateRoomStatus, pickup, searchRoom, logout;
    
    Reception() {
        
        setLayout(null);
        
        customer = new JButton("New Customer Info");
        customer.setBackground(Color.BLACK);
        customer.setForeground(Color.WHITE);
        customer.setBounds(10, 30, 200, 30);
        customer.addActionListener(this);
        add(customer);
        
        room = new JButton("Rooms");
        room.setBackground(Color.BLACK);
        room.setForeground(Color.WHITE);
        room.setBounds(10, 80, 200, 30);
        room.addActionListener(this);
        add(room);
        
        dept = new JButton("Department");
        dept.setBackground(Color.BLACK);
        dept.setForeground(Color.WHITE);
        dept.setBounds(10, 130, 200, 30);
        dept.addActionListener(this);
        add(dept);
        
        employee = new JButton("All Employees");
        employee.setBackground(Color.BLACK);
        employee.setForeground(Color.WHITE);
        employee.setBounds(10, 180, 200, 30);
        employee.addActionListener(this);
        add(employee);
        
        customerInfo = new JButton("Customer Info");
        customerInfo.setBackground(Color.BLACK);
        customerInfo.setForeground(Color.WHITE);
        customerInfo.setBounds(10, 230, 200, 30);
        customerInfo.addActionListener(this);
        add(customerInfo);
        
        managerInfo = new JButton("Manager Info");
        managerInfo.setBackground(Color.BLACK);
        managerInfo.setForeground(Color.WHITE);
        managerInfo.setBounds(10, 280, 200, 30);
        managerInfo.addActionListener(this);
        add(managerInfo);
        
        checkout = new JButton("Check out");
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setBounds(10, 330, 200, 30);
        checkout.addActionListener(this);
        add(checkout);
        
        updateStatus = new JButton("Update status");
        updateStatus.setBackground(Color.BLACK);
        updateStatus.setForeground(Color.WHITE);
        updateStatus.setBounds(10, 380, 200, 30);
        updateStatus.addActionListener(this);
        add(updateStatus);
        
        updateRoomStatus = new JButton("Update room status");
        updateRoomStatus.setBackground(Color.BLACK);
        updateRoomStatus.setForeground(Color.WHITE);
        updateRoomStatus.setBounds(10, 430, 200, 30);
        updateRoomStatus.addActionListener(this);
        add(updateRoomStatus);
        
        pickup = new JButton("Pick up");
        pickup.setBackground(Color.BLACK);
        pickup.setForeground(Color.WHITE);
        pickup.setBounds(10, 480, 200, 30);
        pickup.addActionListener(this);
        add(pickup);
        
        searchRoom = new JButton("Search Room");
        searchRoom.setBackground(Color.BLACK);
        searchRoom.setForeground(Color.WHITE);
        searchRoom.setBounds(10, 530, 200, 30);
        searchRoom.addActionListener(this);
        add(searchRoom);
        
        logout = new JButton("Logout");
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.setBounds(10, 580, 200, 30);
        logout.addActionListener(this);
        add(logout);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 580, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(250, 30, 500, 580);
        add(image);
        
        setTitle("Reception");
        getContentPane().setBackground(Color.WHITE);
        setBounds(350, 200, 800, 670);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == customer) {
            setVisible(false);
            new AddCustomers();
        }else if(ae.getSource() == room) {
            setVisible(false);
            new Rooms();
        }else if(ae.getSource() == dept) {
            setVisible(false);
            new Department();
        }else if(ae.getSource() == employee) {
            setVisible(false);
            new EmployeeInfo();
        }else if(ae.getSource() == customerInfo) {
            setVisible(false);
            new CustomerInfo();
        }else if(ae.getSource() == managerInfo) {
            setVisible(false);
            new ManagerInfo();
        }else if(ae.getSource() == searchRoom) {
            setVisible(false);
            new SearchRooms();
        }else if(ae.getSource() == updateStatus) {
            setVisible(false);
            new UpdateStatus();
        }else if(ae.getSource() == updateRoomStatus) {
            setVisible(false);
            new UpdateRoom();
        }else if(ae.getSource() == pickup) {
            setVisible(false);
            new Pickup();
        }else if(ae.getSource() == logout) {
            setVisible(false);
            System.exit(0);
        }else if(ae.getSource() == checkout) {
            setVisible(false);
            new Checkout();
        }
    }
    
    public static void main(String[] args) {
        new Reception();
    }
}
