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

public class add_marks extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JButton b1,b2;

    add_marks() {
		super("Add Marks");
		setLayout(null);
		setSize(800, 800);
        setLocation(550,150);
		
        l1 = new JLabel("Roll No");
        l2 = new JLabel("Semcode");
        l1.setBounds(25,80,80,20);
        l2.setBounds(250,80,100,20);
        add(l1);
        add(l2);
        t1 = new JTextField();
        t1.setBounds(125,80,100,20);
        t2 = new JTextField();
        t2.setBounds(350,80,100,20);
        add(t1);
        add(t2);

        b1 = new JButton("Find");
        b1.setBounds(550,80,80,20);
        b1.addActionListener(this);
        add(b1);

        l3=new JLabel();
        t3=new JTextField();
        l3.setBounds(25,150,100,20);
        t3.setBounds(125,150,100,20);
        
        
        l4=new JLabel();
        t4=new JTextField();
        l4.setBounds(25,225,100,20);
        t4.setBounds(125,225,100,20);
        
        
        l5=new JLabel();
        t5=new JTextField();
        l5.setBounds(25,300,100,20);
        t5.setBounds(125,300,100,20);
        
        
        l6=new JLabel();
        t6=new JTextField();
        l6.setBounds(25,375,100,20);
        t6.setBounds(125,375,100,20);
        
        
        l7=new JLabel();
        t7=new JTextField();
        l7.setBounds(25,450,100,20);
        t7.setBounds(125,450,100,20);

        b2 = new JButton("Add");
        b2.setBounds(350,525,80,20);
        b2.addActionListener(this);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae)
    {
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
                String cond3 ="select * from marks where rollno="+roll_no+" and sem = "+semester+";";
                ResultSet rs1 = c1.s.executeQuery(cond1);
                if(rs1.next()){
                    ResultSet rs3 = c1.s.executeQuery(cond3);
                    if(!rs3.next()){
                    ResultSet rs2 = c1.s.executeQuery(cond2);
                    if(rs2.next()){
                        l3.setText(rs2.getString("s1"));
                        l4.setText(rs2.getString("s2"));
                        l5.setText(rs2.getString("s3"));
                        l6.setText(rs2.getString("s4"));
                        l7.setText(rs2.getString("s5"));
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
                    else{
                        JOptionPane.showMessageDialog(null,"Student has not registered in this particular semester.");
                    }
                    }else{
                        JOptionPane.showMessageDialog(null,"Marks already entered for this semester.");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"Roll No does not exist.");
                }
            }
            catch(Exception e){
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
                int m1 = Integer.parseInt(t3.getText());
                int m2 = Integer.parseInt(t4.getText());
                int m3 = Integer.parseInt(t5.getText());
                int m4 = Integer.parseInt(t6.getText());
                int m5 = Integer.parseInt(t7.getText());
                String query = "insert into marks values("+roll_no+","+semester+","+m1+","+m2+","+m3+","+m4+","+m5+");";
                c1.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Marks updated");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        new add_marks();
    }
}
