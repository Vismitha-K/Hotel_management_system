
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class AddEmployee extends JFrame implements ActionListener{
    
    JLabel name, age, gender, job, salary, phone, email, aadhar;
    JButton submit;
    JRadioButton maleRB, femaleRB;
    JComboBox jobCB;
    JTextField nameTF, ageTF, salaryTF, phoneTF, emailTF, aadharTF;
    
    AddEmployee() {
        
        setLayout(null);
        
        name = new JLabel("Name :");
        name.setFont(new Font("Tahoma", Font.PLAIN, 14));
        name.setBounds(60, 30, 120, 30);
        add(name);
        
        nameTF = new JTextField();
        nameTF.setBounds(200, 30, 150, 30);
        add(nameTF);
        
        age = new JLabel("Age :");
        age.setFont(new Font("Tahoma", Font.PLAIN, 14));
        age.setBounds(60, 80, 120, 30);
        add(age);
        
        ageTF = new JTextField();
        ageTF.setBounds(200, 80, 150, 30);
        add(ageTF);
        
        gender = new JLabel("Gender :");
        gender.setFont(new Font("Tahoma", Font.PLAIN, 14));
        gender.setBounds(60, 130, 120, 30);
        add(gender);
        
        maleRB = new JRadioButton("Male");
        maleRB.setFont(new Font("Tahoma", Font.PLAIN, 14));
        maleRB.setBackground(Color.WHITE);
        maleRB.setBounds(200, 130, 70, 30);
        add(maleRB);
        
        femaleRB = new JRadioButton("Female");
        femaleRB.setFont(new Font("Tahoma", Font.PLAIN, 14));
        femaleRB.setBackground(Color.WHITE);
        femaleRB.setBounds(280, 130, 70, 30);
        add(femaleRB);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(maleRB);
        bg.add(femaleRB);
        
        job = new JLabel("Job :");
        job.setFont(new Font("Tahoma", Font.PLAIN, 14));
        job.setBounds(60, 180, 120, 30);
        add(job);
        
        String str[] = {"Front dest clerk", "Porters", "Housekeeping", "Manager", "Waiter/Waitress", "Chef", "Kitchen staff", "Room service", "Drivers", "Luggage service", "Security Department"};
        jobCB = new JComboBox(str);
        jobCB.setBackground(Color.WHITE);
        jobCB.setBounds(200, 180, 150, 30);
        add(jobCB);
        
        salary = new JLabel("Salary :");
        salary.setFont(new Font("Tahoma", Font.PLAIN, 14));
        salary.setBounds(60, 230, 120, 30);
        add(salary);
        
        salaryTF = new JTextField();
        salaryTF.setBounds(200, 230, 150, 30);
        add(salaryTF);
        
        phone = new JLabel("Phone No. :");
        phone.setFont(new Font("Tahoma", Font.PLAIN, 14));
        phone.setBounds(60, 280, 120, 30);
        add(phone);
        
        phoneTF = new JTextField();
        phoneTF.setBounds(200, 280, 150, 30);
        add(phoneTF);
        
        email = new JLabel("E-mail :");
        email.setFont(new Font("Tahoma", Font.PLAIN, 14));
        email.setBounds(60, 330, 120, 30);
        add(email);
        
        emailTF = new JTextField();
        emailTF.setBounds(200, 330, 150, 30);
        add(emailTF);
        
        aadhar = new JLabel("Aadhar No. :");
        aadhar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        aadhar.setBounds(60, 380, 120, 30);
        add(aadhar);
        
        aadharTF = new JTextField();
        aadharTF.setBounds(200, 380, 150, 30);
        add(aadharTF);
        
        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(200, 430, 150, 30);
        submit.addActionListener(this);
        add(submit);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/employees.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 60, 450, 370);
        add(image);
        
        setTitle("Employee Details");
        getContentPane().setBackground(Color.WHITE);
        setBounds(350, 200, 900, 540);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String sname = nameTF.getText();
        String sage = ageTF.getText();
        String ssalary = salaryTF.getText();
        String sphone = phoneTF.getText();
        String semail = emailTF.getText();
        String saadhar = aadharTF.getText();
        String sgender = null;
        if(maleRB.isSelected()) {
            sgender = "Male";
        }else if(femaleRB.isSelected()) {
            sgender = "Female";
        }
        String sjob = (String)jobCB.getSelectedItem();
        
        try {
            if (sname.equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the required details");
            } else {
                Conn c = new Conn();
                String query = "insert into employees values('"+sname+"', '"+sage+"', '"+sgender+"', '"+sjob+"', '"+ssalary+"', '"+sphone+"', '"+semail+"', '"+saadhar+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee details saved successfully");
                setVisible(false);
            }
        } catch (Exception  e) { 
            System.out.println(e);
        }
        
    }
    
    public static void main(String[] args) {
        new AddEmployee();
    }
}
