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

public class edit_course extends JFrame implements ActionListener{
    JLabel l1,l2;
    JTextField t1,t2;
    JButton b1,b2;

    edit_course(){
        super("Edit course");
        setLayout(null);
        setSize(900,400);
        setLocation(550,150);

        l1 = new JLabel("Enter the course id which has to be reallocated:");
        l1.setBounds(50, 100, 400, 30);
        add(l1);
        t1 = new JTextField();
        t1.setBounds(550,100,150,30);
        add(t1);

        b1 = new JButton("Find");
        b1.setBounds( 750,100,100,30);
        b1.addActionListener(this);
        add(b1);

        l2 = new JLabel("Emp ID:");
        l2.setBounds(50,175,250,30);
        add(l2);
        t2 = new JTextField();
        t2.setBounds(550, 175, 150, 30);
        add(t2);

        b2 = new JButton("Update");
        b2.setBounds(400,250,100,50);
        b2.addActionListener(this);
        add(b2);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        int emp_id=0;
        String crs_no = t1.getText();
        if(ae.getSource()==b1){
            try{
                conn c1 = new conn();
                String q = "select * from course where crs_id='"+crs_no+"';";
                
                ResultSet rs1 = c1.s.executeQuery(q);
                if(rs1.next()){
                    t2.setText(rs1.getString("emp_id"));
                }else{
                    JOptionPane.showMessageDialog(null, "The given course id does not exist");
                }
            }catch(Exception e){
                e.printStackTrace();
            }

        }else{
            try{
                conn c1 = new conn();
                String q1 = "select * from teacher where emp_id="+Integer.parseInt(t2.getText())+";";
                ResultSet rs = c1.s.executeQuery(q1);
                if(rs.next()){
                    String q = "update course set emp_id = "+Integer.parseInt(t2.getText())+" where crs_id='"+crs_no+"';";
                    c1.s.executeUpdate(q);
                    JOptionPane.showMessageDialog(null,"Reallocated successfully.");
                }
                else
                     JOptionPane.showMessageDialog(null,"Employee ID not found.");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args){
        new edit_course();
    }
}
