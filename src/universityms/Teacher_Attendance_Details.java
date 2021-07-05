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

public class Teacher_Attendance_Details extends JFrame implements ActionListener {
	JLabel l1, l2, l3, l4, l5, l6, l7;
	JTextField t1, t2, t3, t4;
	JButton b1;

	Teacher_Attendance_Details() {
		super("View Teacher's Attendance");
		setLayout(null);
		setSize(500, 500);
		setLocation(700, 300);
		l1 = new JLabel("EMP ID");
		l2 = new JLabel("DATE");
		l3 = new JLabel("FIRST HALF");
		l4 = new JLabel("SECOND HALF");
		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		t4 = new JTextField();
		b1 = new JButton("FIND");
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(t1);
		add(t2);
		add(t3);
		add(t4);
		add(b1);
		l1.setBounds(50, 65, 170, 20);
		t1.setBounds(140, 65, 170, 20);
		l2.setBounds(50, 125, 170, 20);
		t2.setBounds(140, 125, 170, 20);
		b1.setBounds(175, 200, 100, 30);
		l3.setBounds(50, 270, 170, 20);
		t3.setBounds(140, 270, 170, 20);
		l4.setBounds(50, 310, 170, 20);
		t4.setBounds(140, 310, 170, 20);
                t3.setEditable(false);
                t4.setEditable(false);
		b1.addActionListener(this);
	}

	public static void main(String[] args) {
		new Teacher_Attendance_Details().setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int j = 0;
		String roll = t1.getText();
		String date = t2.getText();
		String query = "SELECT * from attendence_teacher where emp_id =" + Integer.parseInt(roll) + " and datee='" + date + "';";

		try {
			conn c1 = new conn();
			ResultSet rs = c1.s.executeQuery(query);
			if(rs.next()) {
				t3.setText(rs.getString("first_half"));
				t4.setText(rs.getString("second_half"));
			}
                        else{
                            JOptionPane.showMessageDialog(null,"Could not find the entry");
                            setVisible(true);
                        }
		} catch (Exception ee) {
		}

	}

}
