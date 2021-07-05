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
public class View extends JFrame implements ActionListener{
    JFrame f;
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JButton b1,b2;
    
    View(){
        super("View registered subjects");
        
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
        
        l1=new JLabel("Enter Roll No.");
        l1.setBounds(25,80,80,20);
        t1.setBounds(125,80,100,20);
        add(l1);
        add(t1);
        
        l2 = new JLabel("Enter semcode");
        l2.setBounds(250,80,100,20);
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
        
        t3.setEditable(false);
        t4.setEditable(false);
        t5.setEditable(false);
        t6.setEditable(false);
        t7.setEditable(false);
        
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
                String cond2 = "select * from subject where RollNo="+roll_no+" and sem="+semester+";";
                
                ResultSet rs1 = c1.s.executeQuery(cond1);
                
                if(rs1.next())
                {
                    ResultSet rs2 = c1.s.executeQuery(cond2);
                    if(rs2.next())
                    {
                        t3.setText(rs2.getString("s1"));
                        t4.setText(rs2.getString("s2"));
                        t5.setText(rs2.getString("s3"));
                        t6.setText(rs2.getString("s4"));
                        t7.setText(rs2.getString("s5"));
                        add(t3);
                        add(t4);
                        add(t5);
                        add(t6);
                        add(t7);
                        add(l3);
                        add(l4);
                        add(l5);
                        add(l6);
                        add(l7);
                        SwingUtilities.updateComponentTreeUI(this);
                    }
                    else
                        JOptionPane.showMessageDialog(null,"Student has no registered courses.");
                }
                else
                    JOptionPane.showMessageDialog(null,"Roll Number does not exist");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args)
    {
        new View();
    }
    
}
