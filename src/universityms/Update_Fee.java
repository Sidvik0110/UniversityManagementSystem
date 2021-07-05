/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityms;

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
public class Update_Fee extends JFrame implements ActionListener{
    JFrame f;
    JLabel l1,l2,l3;
    JTextField t1,t2,t3;
    JButton b1;
    
    Update_Fee()
    {
        super("Update Fee");
        setLayout(null);
        setSize(500,500);
        setLocation(550,180);
        
        l1=new JLabel("Enter Roll No");
        t1=new JTextField();
        l1.setBounds(25,100,100,20);
        t1.setBounds(200,100,100,20);
        add(l1);
        add(t1);
        
        l2=new JLabel("Enter Semcode");
        t2=new JTextField();
        l2.setBounds(25,200,100,20);
        t2.setBounds(200,200,100,20);
        add(l2);
        add(t2);
        
        l3=new JLabel("Enter amount in rupees");
        t3=new JTextField();
        l3.setBounds(25,300,200,20);
        t3.setBounds(200,300,100,20);
        add(l3);
        add(t3);
        
        b1=new JButton("Update");
        b1.setBounds(200,350,80, 20);
        add(b1);
        b1.addActionListener(this);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            try{
                conn c1=new conn();
                int roll_no=Integer.parseInt(t1.getText());
                int sem = Integer.parseInt(t2.getText());
                int amount = Integer.parseInt(t3.getText());
                String q1="select * from student where RollNo="+roll_no+";";
                String q2="select * from fee where rollno="+roll_no+" and sem="+sem+";";
                String q3="insert into fee values("+roll_no+","+sem+","+amount+")";
                
                ResultSet rs1=c1.s.executeQuery(q1);
                if(rs1.next()){
                    ResultSet rs2 = c1.s.executeQuery(q2);
                    if(!rs2.next()){
                        c1.s.executeUpdate(q3);
                        JOptionPane.showMessageDialog(null,"Fee updated successfully.");
                    }
                    else
                        JOptionPane.showMessageDialog(null,"Fee,for this semester was already updated for this student.");
                }
                else
                    JOptionPane.showMessageDialog(null,"Roll number not found.");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args)
    {
        new Update_Fee();
    }
}
