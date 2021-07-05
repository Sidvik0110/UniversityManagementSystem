package universityms;

import java.awt.Choice;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.sun.javafx.collections.SetListenerHelper;

public class Student_Attendance extends JFrame implements ActionListener{
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JTextField c2,t1,t2,t3,t4,t5,t6,t7;
	JButton b1,b2;
	Choice fh,sh;
	
	Student_Attendance (){
		setLayout(new GridLayout(4,2,50,50));
		c2 = new JTextField();
		
		add(new JLabel("Enter ROLL number"));
		add(c2);
		l1=new JLabel("FIRST HALF");
		fh=new Choice();
		fh.add("PRESENT");
		fh.add("ABSENT");
		fh.add("LEAVE");
		add(l1);
		add(fh);
		
		l2=new JLabel("SECOND HALF");
		sh=new Choice();
		sh.add("PRESENT");
		sh.add("ABSENT");
		sh.add("LEAVE");
		add(l2);
		add(sh);
		
		b1=new JButton("SUBMIT");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
	
		b2=new JButton("CANCEL");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		
		add(b1);
		add(b2);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		getContentPane().setBackground(Color.WHITE);
		
		setVisible(true);
		setSize(400,450);
		setLocation(600, 200);
		
	}
	public static void main(String[] args) {
		new Student_Attendance();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
            if(e.getSource()==b1){
		String first=fh.getSelectedItem();
		String second=sh.getSelectedItem();
		String date=java.time.LocalDate.now().toString();
		String id=c2.getText();
                int RollNo = Integer.parseInt(id);
		String query="insert into university.attendence_student values("+id+", '"+date+"','"+first+"','"+second+"')"; 
		String cond1 = "select RollNo from student where RollNo="+RollNo+";";
                String cond2 = "select RollNo,datee from attendence_student where RollNo="+RollNo+" and datee ='"+date+"';";
		try
                {
                        conn c1=new conn();
                        ResultSet rs1 = c1.s.executeQuery(cond1);
                        if(rs1.next())
                        {
                            ResultSet rs2 = c1.s.executeQuery(cond2);
                            if(rs2.next())
                                JOptionPane.showMessageDialog(null,"Student's attendance recorded for the day.");
                            else
                            {   
                                c1.s.executeUpdate(query);
                                JOptionPane.showMessageDialog(null,"ATTENDANCE CONFIRMED" ); 
                                this.setVisible(false);
                            }
                        }
                        else
                            JOptionPane.showMessageDialog(null,"Roll number does not exist in database.");
		}catch(Exception ee){
			ee.printStackTrace();
		}
            }
            else
                setVisible(false);
	}

}
