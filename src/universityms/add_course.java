/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityms;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class add_course extends JFrame implements ActionListener {
    JLabel l1,l2;
    JTextField t1,t2;
    JButton b1;

    add_course(){
        super("Add Course");
        setLayout(null);
        setSize(450,400);
        setLocation(550,150);

        l1 = new JLabel("Course ID:");
        l2 = new JLabel("Emp ID:");
        l1.setBounds(25,80,100,20);
        l2.setBounds(25,140,100,20);
        add(l1);
        add(l2);

        t1 = new JTextField();
        t2 = new JTextField();
        t1.setBounds(175,80,100,20);
        t2.setBounds(175,140,100,20);
        add(t1);
        add(t2);

        b1 = new JButton("Add");
        b1.setBounds(130,200,95,40);
        add(b1);
        b1.addActionListener(this);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        String empid,crsid;
        int emp_no,crs_no;
        try{
            conn c1 = new conn();
            empid = t2.getText();
            crsid = t1.getText();
            emp_no=Integer.parseInt(empid);
            String cond1 = "select * from teacher where emp_id="+emp_no+";";
            String cond2 = "select * from course where emp_id="+emp_no+" and crs_id='"+crsid+"';";
            ResultSet rs1 = c1.s.executeQuery(cond1);
            if(rs1.next()){
                ResultSet rs2 = c1.s.executeQuery(cond2);
                if(!rs2.next()){
                    String query = "insert into course values ('"+crsid+"',"+emp_no+");";
                    c1.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Course alloted successfully");
                }else{
                    JOptionPane.showMessageDialog(null, "Course is already alloted.");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Employee doesn't exist.");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new add_course();
    }
}