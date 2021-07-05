/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityms;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.awt.event.ActionListener;

class Student extends JFrame implements ActionListener
{
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
    
    Student() {
        super("Student Details");
        setSize(900, 650);
        setLocation(450, 150);
        setBackground(Color.white);
        setLayout(null);
        
        final JLabel l1 = new JLabel("Enter roll number to update the data of student");
        l1.setBounds(50, 100, 500, 30);
        l1.setFont(new Font("serif", 2, 20));
        add(l1);
        
        t12 = new JTextField();
        t12.setBounds(500, 100, 200, 30);
        add(t12);
        
        b2 = new JButton("Get");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(720, 100, 100, 30);
        add(b2);
        b2.addActionListener(this);
        
        id8 = new JLabel("Student Details:");
        id8.setBounds(50, 10, 500, 50);
        id8.setFont(new Font("serif", 2, 40));
        id8.setForeground(Color.black);
        add(id8);
        
        id1 = new JLabel("Roll no");
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
        add(t7);
        
        id9 = new JLabel("Degree");
        id9.setBounds(400, 320, 130, 30);
        id9.setFont(new Font("serif", 1, 20));
        add(id9);
        
        t8 = new JTextField();
        t8.setBounds(600, 320, 150, 30);
        add(t8);
        
        id10 = new JLabel("Branch");
        id10.setBounds(50, 370, 130, 30);
        id10.setFont(new Font("serif", 1, 20));
        add(id10);
        
        t9 = new JTextField();
        t9.setBounds(200, 370, 150, 30);
        add(t9);
        
        id11 = new JLabel("Class XII(%)");
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
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(final ActionEvent ae) {
        if (ae.getSource() == b) {
            try {
                final conn con = new conn();
                final String str = "update student set FullName='" + t2.getText() + "',f_name='" + t3.getText() + "', DOB='" + t4.getText() + "',phone='" + t5.getText() + "',email='" + t6.getText() + "',aadhar='" + t7.getText() + "',degree='" + t8.getText() + "',branch='" + t9.getText() + "',cls_12='" + t10.getText() + "',address='" + t11.getText() + "' where RollNo=" + Integer.parseInt(t1.getText()) + ";";
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
        if (ae.getSource() == b2) {
            try {
                final conn con = new conn();
                final String str = "select * from student where RollNo = " + Integer.parseInt(t12.getText()) + ";";
                final ResultSet rs = con.s.executeQuery(str);
                if (rs.next()) {
                    setVisible(true);
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
                }
                else
                    JOptionPane.showMessageDialog(null,"Roll number not found.");
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
            setVisible(true);
            setSize(900, 650);
            setLocation(450, 250);
        }
    }
    
    public static void main(final String[] arg) {
        new Student().setVisible(true);
    }
}
