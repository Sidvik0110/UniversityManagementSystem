/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityms;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author prane
 */
public class Teacher_Page extends JFrame implements ActionListener{
    
    int emp_id;
    JButton b1,b2,b3,b4;
    JLabel l2;
    Teacher_Page(int id){
        super("University Management System (Teacher): "+id);
        setSize(1920,1080);
        emp_id = id;
        ImageIcon ic = new  ImageIcon(ClassLoader.getSystemResource("universityms/icons/appback.jpg"));
        Image i3 = ic.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        setContentPane(new JLabel(icc3));
        
        l2=new JLabel("Welcome");
        l2.setBounds(800,50,500,100);
        l2.setFont(new Font("TimesRoman",Font.BOLD,80));
        add(l2);
        
        b1=new JButton("Edit your details");
        b1.setBounds(625,200,700,80);
        b1.setFont(new Font("Senserif",Font.ITALIC,50));
        b1.setForeground(Color.BLACK);
        b1.setBackground(Color.BLUE);
        add(b1);
        
        b2=new JButton("View Student Details");
        b2.setBounds(625,350,700,80);
        b2.setFont(new Font("Senserif",Font.ITALIC,50));
        b2.setForeground(Color.BLACK);
        b2.setBackground(Color.BLUE);
        add(b2);
        
        b3=new JButton("Mark student attendance");
        b3.setBounds(625,500,700,80);
        b3.setFont(new Font("Senserif",Font.ITALIC,50));
        b3.setForeground(Color.BLACK);
        b3.setBackground(Color.BLUE);
        add(b3);
        
        b4=new JButton("View your students");
        b4.setBounds(625,650,700,80);
        b4.setFont(new Font("Senserif",Font.ITALIC,50));
        b4.setForeground(Color.BLACK);
        b4.setBackground(Color.BLUE);
        add(b4);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        
        setFont(new Font("Senserif",Font.BOLD,16));
        setLayout(null);
        setVisible(false);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1)
            new Teacher_Details(emp_id).setVisible(true);
        else if(ae.getSource()==b2){
            new Teacher_Student().setVisible(true);
        }
        else if(ae.getSource()==b3)
            new Student_Attendance().setVisible(true);
        else if(ae.getSource()==b4)
            new Student_List(emp_id).setVisible(true);
    }
    
    
    
    
    public static void main(String[] args){
    }
}
