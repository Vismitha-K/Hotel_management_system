package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class SearchRooms extends JFrame implements ActionListener{
    
   JTable table;
   JButton back, submit;
   JCheckBox lblavail;
   JComboBox selectedType;
   
   SearchRooms() {
       
       JLabel heading = new JLabel("Search Rooms");
       heading.setBounds(400, 30, 200, 30);
       heading.setFont(new Font("Tahoma", Font.BOLD, 18));
       add(heading);
       
       JLabel RoomType = new JLabel("Bed type");
       RoomType.setBounds(50, 100, 100, 30);;
       add(RoomType);
       
       String str[] ={"Single bed","Double bed"};
       selectedType = new JComboBox(str);
       selectedType.setBounds(150, 100, 150, 30);
       selectedType.setBackground(Color.WHITE);
       add(selectedType);
       
       lblavail = new JCheckBox("Only display available");
       lblavail.setBounds(650, 100, 150, 30);
       lblavail.setBackground(Color.WHITE);
       add(lblavail);
       
       JLabel Roomno = new JLabel("Room number");
       Roomno.setBounds(50, 160, 100, 20);;
       add(Roomno);
       
       JLabel avail = new JLabel("Availability");
       avail.setBounds(270, 160, 100, 20);;
       add(avail);
       
       JLabel status = new JLabel("Status");
       status.setBounds(450, 160, 100, 20);;
       add(status);
       
       JLabel price = new JLabel("Price");
       price.setBounds(670, 160, 100, 20);;
       add(price);
       
       JLabel type = new JLabel("Bed type");
       type.setBounds(870, 160, 100, 20);;
       add(type);
        
       table = new JTable();
       table.setBounds(0, 180, 1000, 300);
       add(table);
       
       try {
           Conn c = new Conn();
           String query = "select * from rooms";
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
       setTitle("Rooms information");
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
                String query1 = "select * from rooms where bed_type = '"+selectedType.getSelectedItem()+"'";
                String query2 = "select * from rooms where availability = 'Available' AND bed_type = '"+selectedType.getSelectedItem()+"'";
                if(lblavail.isSelected()) {
                    rs = c.s.executeQuery(query2);
                }else{
                    rs = c.s.executeQuery(query1);
                }
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e) {
                System.out.println(e);
            }
        }
    }
    
    public static void main(String[] args) {
        new SearchRooms();
    }
    
}
