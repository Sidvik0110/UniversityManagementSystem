/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityms;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author prane
 */
public class Teacher_Details extends JFrame implements ActionListener{
     JFrame f;
    JLabel id;
    JLabel id1;
    JLabel id2;
    JLabel id3;
    JLabel id4;
    JLabel id5;
    JLabel id6;
    JLabel id7;
    JLabel id8;
    JLabel id9;
    JLabel id10;
    JLabel id11;
    JLabel id12;
    JLabel id15;
    JLabel lab;
    JLabel lab1;
    JLabel lab2;
    JTextField t;
    JTextField t1;
    JTextField t2;
    JTextField t3;
    JTextField t4;
    JTextField t5;
    JTextField t6;
    JTextField t7;
    JTextField t8;
    JTextField t9;
    JTextField t10;
    JTextField t11;
    JTextField t12;
    JTextField t13;
    JTextField t14;
    JButton b;
    JButton b1;
    JButton b2;
    String id_emp;
    ResultSet rs;
    int emp;
    Teacher_Details(int emp_id) {
        
        
        super("Your Details");
        emp=emp_id;
        setSize(900, 650);
        setLocation(450, 150);
        setBackground(Color.white);
        setLayout(null);
        
        id8 = new JLabel("Your Details:");
        id8.setBounds(50, 10, 500, 50);
        id8.setFont(new Font("serif", 2, 40));
        id8.setForeground(Color.black);
        add(id8);
        
        id1 = new JLabel("Employee ID");
        id1.setBounds(50, 170, 100, 30);
        id1.setFont(new Font("serif", 1, 20));
        add(id1);
        
        t1 = new JTextField();
        t1.setBounds(200, 170, 150, 30);
        add(t1);
        
        id2 = new JLabel("Name");
        id2.setBounds(400, 170, 200, 30);
        id2.setFont(new Font("serif", 1, 20));
        add(id2);
        
        t2 = new JTextField();
        t2.setBounds(600, 170, 150, 30);
        add(t2);
        id3 = new JLabel("Father's Name");
        id3.setBounds(50, 220, 100, 30);
        id3.setFont(new Font("serif", 1, 20));
        add(id3);
        
        t3 = new JTextField();
        t3.setBounds(200, 220, 150, 30);
        add(t3);
        
        id4 = new JLabel("DOB (dd/mm/yyyy)");
        id4.setBounds(400, 220, 200, 30);
        id4.setFont(new Font("serif", 1, 20));
        add(id4);
        
        t4 = new JTextField();
        t4.setBounds(600, 220, 150, 30);
        t4.setEditable(false);
        add(t4);
        
        id5 = new JLabel("Phone");
        id5.setBounds(50, 270, 100, 30);
        id5.setFont(new Font("serif", 1, 20));
        add(id5);
        
        t5 = new JTextField();
        t5.setBounds(200, 270, 150, 30);
        add(t5);
        
        id6 = new JLabel("Email ID");
        id6.setBounds(400, 270, 100, 30);
        id6.setFont(new Font("serif", 1, 20));
        add(id6);
        
        t6 = new JTextField();
        t6.setBounds(600, 270, 150, 30);
        add(t6);
        
        id7 = new JLabel("Aadhar");
        id7.setBounds(50, 320, 100, 30);
        id7.setFont(new Font("serif", 1, 20));
        add(id7);
        
        t7 = new JTextField();
        t7.setBounds(200, 320, 150, 30);
        t7.setEditable(false);
        add(t7);
        
        id9 = new JLabel("Qualification");
        id9.setBounds(400, 320, 130, 30);
        id9.setFont(new Font("serif", 1, 20));
        add(id9);
        
        t8 = new JTextField();
        t8.setBounds(600, 320, 150, 30);
        add(t8);
        
        id10 = new JLabel("Degree");
        id10.setBounds(50, 370, 130, 30);
        id10.setFont(new Font("serif", 1, 20));
        add(id10);
        
        t9 = new JTextField();
        t9.setBounds(200, 370, 150, 30);
        t9.setEditable(false);
        add(t9);
        
        id11 = new JLabel("Password");
        id11.setBounds(400, 370, 100, 30);
        id11.setFont(new Font("serif", 1, 20));
        add(id11);
        
        t10 = new JTextField();
        t10.setBounds(600, 370, 150, 30);
        add(t10);
        
        id12 = new JLabel("Address");
        id12.setBounds(50, 420, 150, 30);
        id12.setFont(new Font("serif", 1, 20));
        add(id12);
        
        t11 = new JTextField();
        t11.setBounds(200, 420, 150, 30);
        add(t11);
        
        b = new JButton("Submit");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(250, 520, 150, 40);
        add(b);
        
        b1 = new JButton("Cancel");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(450, 520, 150, 40);
        add(b1);
        b.addActionListener(this);
        b1.addActionListener(this);
        
        try{
            conn c1 = new conn();
            String query ="select * from teacher where emp_id="+emp_id+";";
            rs = c1.s.executeQuery(query); 
            rs.next();
            t1.setText(rs.getString(1));
            t2.setText(rs.getString(2));
            t3.setText(rs.getString(3));
            t4.setText(rs.getString(4));
            t5.setText(rs.getString(5));
            t6.setText(rs.getString(6));
            t7.setText(rs.getString(7));
            t8.setText(rs.getString(8));
            t9.setText(rs.getString(9));
            t10.setText(rs.getString(10));
            t11.setText(rs.getString(11));
            setVisible(true);
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    @Override
    public void actionPerformed(final ActionEvent ae) {
        if (ae.getSource() == b) {
            try {
                final conn con = new conn();
                String str = "update teacher set name='" + t2.getText() + "',fname='" + t3.getText() + "', dob='" + t4.getText() + "',phone='" + t5.getText() + "',email='" + t6.getText() + "',aadhar='" + t7.getText() + "',qual='" + t8.getText() + "',degree='" + t9.getText() + "',password='" + t10.getText() + "', address= '" + t11.getText() + "' where emp_id=" + Integer.parseInt(t1.getText()) + ";";
                con.s.executeUpdate(str);
                str="update login set password='"+t10.getText()+"' where username="+emp+";";
                con.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Successfully Updated");
                setVisible(false);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (ae.getSource() == b1) {
            setVisible(false);
        }
        
    }
    
    public static void main(final String[] arg) {
    }
}
