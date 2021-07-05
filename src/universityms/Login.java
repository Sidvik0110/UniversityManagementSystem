/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityms;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author prane
 */
public class Login extends JFrame implements ActionListener{
    
    JFrame f;
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;
    
    Login(){
        super("Login");
        
        setBackground(Color.WHITE);
         setLayout(null);
         
         l1 = new JLabel("Username");
         l1.setBounds(40,20,100,30);
         add(l1);
         
         l2 = new JLabel("Password");
         l2.setBounds(40,70,100,30);
         add(l2);
         
         t1=new JTextField();
         t1.setBounds(150,20,150,30);
         add(t1);
         
         t2 = new JPasswordField();
         t2.setBounds(150,70,150,30);
         add(t2);
         
         ImageIcon c1= new ImageIcon(ClassLoader.getSystemResource("universityms/icons/second.jpg"));
         Image i1 = c1.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);
         ImageIcon i2 = new ImageIcon(i1);
         JLabel l3 = new JLabel(i2);
         l3.setBounds(350,20,150,150);
         add(l3);
         
         b1 = new JButton("Login");
         b1.setBounds(40,140,120,30);
         b1.setFont(new Font("serif",Font.BOLD,15));
         b1.addActionListener(this);
         b1.setBackground(Color.BLACK);
         b1.setForeground(Color.WHITE);
         add(b1);
         
         b2 = new JButton("Cancel");
         b2.setBounds(180,140,120,30);
         b2.setFont(new Font("serif",Font.BOLD,15));
         b2.addActionListener(this);
         b2.setBackground(Color.BLACK);
         b2.setForeground(Color.WHITE);
         add(b2);
         
         getContentPane().setBackground(Color.WHITE);
         
         setVisible(true);
         setSize(600,300);
         setLocation(500,300);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                conn c1 = new conn();
                String u = t1.getText();
                int username = Integer.parseInt(u);
                String v = t2.getText();
                
                String q = "select * from login where username="+username+" and password='"+v+"';";
            
                ResultSet rs = c1.s.executeQuery(q);
                if(rs.next()){
                    if(username==0){
                        setVisible(false);
                        new Admin().setVisible(true);
                    }
                    else{
                        setVisible(false);
                        new Teacher_Page(username).setVisible(true);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                    setVisible(false);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==b2){
            System.exit(0);
        }
    }
    public static void main(String[] args){
        Login l = new Login();
    }
}
 