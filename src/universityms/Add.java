/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityms;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author prane
 */
public class Add extends JFrame implements ActionListener{
    JFrame f;
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JButton b1,b2;
    
    Add(){
        super("Add registered subjects");
        
        setBackground(Color.WHITE);
        setLayout(null);
        setSize(800,800);
        setLocation(550,150);
        t1 = new JTextField();
	t2 = new JTextField();
        t3 = new JTextField();
	t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();
        t7 = new JTextField();
        b1= new JButton("Enter");
        b2 = new JButton("Add");
        
        l1=new JLabel("Enter Roll No.");
        l1.setBounds(25,80,80,20);
        t1.setBounds(125,80,100,20);
        add(l1);
        add(t1);
        
        l2 = new JLabel("Enter semcode");
        l2.setBounds(250,80,200,20);
        t2.setBounds(350,80,100,20);
        add(l2);
        add(t2);
        
        b1.setBounds(550,80,80,20);
        b1.addActionListener(this);
        add(b1);
        
        l3=new JLabel("Course 1");
        l3.setBounds(25,150,100,20);
        t3.setBounds(125,150,100,20);
        
        
        l4=new JLabel("Course 2");
        l4.setBounds(25,225,100,20);
        t4.setBounds(125,225,100,20);
        
        
        l5=new JLabel("Course 3");
        l5.setBounds(25,300,100,20);
        t5.setBounds(125,300,100,20);
        
        
        l6=new JLabel("Course 4");
        l6.setBounds(25,375,100,20);
        t6.setBounds(125,375,100,20);
        
        
        l7=new JLabel("Course 5");
        l7.setBounds(25,450,100,20);
        t7.setBounds(125,450,100,20);
        
        b2.setBounds(350,525,80,20);
        b2.addActionListener(this);
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        f=new JFrame();
        String roll,sem;
        int roll_no,semester; 
        if(ae.getSource()==b1)
        {
            
            try{
                conn c1 = new conn();
                roll = t1.getText();
                sem = t2.getText();
                roll_no=Integer.parseInt(roll);
                semester = Integer.parseInt(sem);
                
                String cond1 = "select RollNo from student where RollNo="+roll_no+";";
                String cond2 = "select RollNo,sem from subject where RollNo="+roll_no+" and sem="+semester+";";
                
                ResultSet rs1 = c1.s.executeQuery(cond1);
                
                if(rs1.next())
                {
                    ResultSet rs2 = c1.s.executeQuery(cond2);
                    if(rs2.next())
                        JOptionPane.showMessageDialog(null,"Record already exists.");
                    else
                    {
                        System.out.println("123");
                        add(l3);
                        add(l4);
                        add(l5);
                        add(l6);
                        add(l7);
                        add(t3);
                        add(t4);
                        add(t5);
                        add(t6);
                        add(t7);
                        add(b2);
                        SwingUtilities.updateComponentTreeUI(this);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"Roll number does not exist");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
                
        }
        else if(ae.getSource()==b2)
        {
            try{
                conn c1=new conn();
                roll = t1.getText();
                sem = t2.getText();
                roll_no=Integer.parseInt(roll);
                semester = Integer.parseInt(sem);
                        String subject1=t3.getText();
                        String subject2=t4.getText();
                        String subject3=t5.getText();
                        String subject4=t6.getText();
                        String subject5=t7.getText();
                        String sub1="select crs_id from course where crs_id='"+subject1+"';";
                        String sub2="select crs_id from course where crs_id='"+subject2+"';";
                        String sub3="select crs_id from course where crs_id='"+subject3+"';";
                        String sub4="select crs_id from course where crs_id='"+subject4+"';";
                        String sub5="select crs_id from course where crs_id='"+subject5+"';";
                        String query = "insert into subject values("+roll_no+","+semester+",'"+subject1+"','"+subject2+"','"+subject3+"','"+subject4+"','"+subject5+"');";
                        ResultSet rs3 = c1.s.executeQuery(sub1);
                        
                        
                        
                        
                        if(!rs3.next())
                        {
                            JOptionPane.showMessageDialog(null,"Course 1 is invalid");
                            return;
                        }
                        ResultSet rs4 = c1.s.executeQuery(sub2);
                        if(!rs4.next())
                        {
                            JOptionPane.showMessageDialog(null,"Course 2 is invalid");
                            return;
                        }
                        ResultSet rs5 = c1.s.executeQuery(sub3);
                        if(!rs5.next())
                        {
                            JOptionPane.showMessageDialog(null,"Course 3 is invalid");
                            return;
                        }
                        ResultSet rs6 = c1.s.executeQuery(sub4);
                        if(!rs6.next())
                        {
                            JOptionPane.showMessageDialog(null,"Course 4 is invalid");
                            return;
                        }
                        ResultSet rs7 = c1.s.executeQuery(sub5);
                        if(!rs7.next())
                        {
                            JOptionPane.showMessageDialog(null,"Course 5 is invalid");
                            return;
                        }
                        else
                        {
                            c1.s.executeUpdate(query);
                            JOptionPane.showMessageDialog(null,"Successfully registered");
                        }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args){
        new Add();
    }
            
}
