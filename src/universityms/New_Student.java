/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityms;


import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.util.Random;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

class New_Student extends JFrame implements ActionListener
{
    JFrame f;
    JLabel id;
    JLabel id1;
    JLabel id2;
    JLabel id3;
    JLabel id4;
    JLabel id5;
    JLabel id6;
    JLabel id7;
    JLabel id8;
    JLabel id9;
    JLabel id10;
    JLabel id11;
    JLabel id12;
    JLabel id15;
    JLabel id16;
    JLabel id17;
    JLabel lab;
    JLabel lab1;
    JLabel lab2;
    JTextField t;
    JTextField t1;
    JTextField t2;
    JTextField t3;
    JTextField t4;
    JTextField t5;
    JTextField t6;
    JTextField t7;
    JTextField t8;
    JTextField t9;
    JTextField t10;
    JTextField t11;
    JTextField t12;
    JTextField t13;
    JButton b;
    JButton b1;
    JButton b2;
    JButton b3;
    JComboBox<String> c1;
    JComboBox<String> c2;
    Random ran;
    long first4;
    long first;
    ResultSet rs;
    public New_Student() {
        super("New Student");
        try{
            conn c2 = new conn();
            do{
                ran = new Random();
                first4 = this.ran.nextLong() % 9000L + 1000L;
                first = Math.abs(first4);
                String f = Long.toString(first);
                int roll = Integer.parseInt("1000"+f);
                String query ="select RollNo from student where RollNo="+roll+";";
                rs = c2.s.executeQuery(query);
            }while(rs.next());
        }catch(Exception e){
            e.printStackTrace();
        }
          
    
        setBackground(Color.white);
        setLayout(null);
        
        id15 = new JLabel();
        id15.setBounds(0, 0, 900, 700);
        this.id15.setLayout(null);
        
        id8 = new JLabel("New Student Details");
        id8.setBounds(320, 30, 500, 50);
        id8.setFont(new Font("serif", 2, 25));
        id8.setForeground(Color.black);
        id15.add(id8);
        add(id15);
        
        id1 = new JLabel("Roll No");
        id1.setBounds(50, 150, 100, 30);
        id1.setFont(new Font("serif", 1, 20));
        id15.add(id1);
        
        t1 = new JTextField();
        t1.setBounds(200, 150, 150, 30);
        t1.setText("1000"+this.first);
        t1.setEditable(false);
        id15.add(t1);
        
        id2 = new JLabel("Name");
        id2.setBounds(400, 150, 200, 30);
        id2.setFont(new Font("serif", 1, 20));
        id15.add(id2);
        
        t2 = new JTextField();
        t2.setBounds(600, 150, 150, 30);
        id15.add(t2);
        
        id3 = new JLabel("Father's Name");
        id3.setBounds(50, 200, 100, 30);
        id3.setFont(new Font("serif", 1, 20));
        id15.add(id3);
        
        t3 = new JTextField();
        t3.setBounds(200, 200, 150, 30);
        id15.add(t3);
        
        id4 = new JLabel("DOB (yyyy-mm-dd)");
        id4.setBounds(400, 200, 200, 30);
        id4.setFont(new Font("serif", 1, 20));
        id15.add(id4);
        
        t4 = new JTextField();
        t4.setBounds(600, 200, 150, 30);
        id15.add(t4);
        
        id5 = new JLabel("Phone No");
        id5.setBounds(50, 250, 100, 30);
        id5.setFont(new Font("serif", 1, 20));
        id15.add(id5);
        
        t5 = new JTextField();
        t5.setBounds(200, 250, 150, 30);
        id15.add(t5);
        
        id6 = new JLabel("Email ID");
        id6.setBounds(400, 250, 100, 30);
        id6.setFont(new Font("serif", 1, 20));
        id15.add(id6);
        
        t6 = new JTextField();
        t6.setBounds(600, 250, 150, 30);
        id15.add(t6);
        
        id7 = new JLabel("Aadhar");
        id7.setBounds(50, 300, 100, 30);
        id7.setFont(new Font("serif", 1, 20));
        id15.add(id7);
        
        t7 = new JTextField();
        t7.setBounds(200, 300, 150, 30);
        id15.add(t7);
        
        lab = new JLabel("Degree");
        lab.setBounds(400, 350, 150, 30);
        lab.setFont(new Font("serif", 1, 20));
        id15.add(lab);
        final String[] degree = { "First", "Higher" };
        
        c1 = new JComboBox<>(degree);
        c1.setBackground(Color.WHITE);
        c1.setBounds(600, 350, 150, 30);
        id15.add(c1);
        
        lab2 = new JLabel("Branch");
        lab2.setBounds(50, 400, 150, 30);
        lab2.setFont(new Font("serif", 1, 20));
        id15.add(lab2);
        final String[] branch = { "Computer Science", "Electronics", "Electrical", "Mechanical", "Civil", "Chemical", "Pharmacy", };
        
        c2 = new JComboBox<>(branch);
        c2.setBackground(Color.WHITE);
        c2.setBounds(200, 400, 150, 30);
        id15.add(c2);
        
        id9 = new JLabel("Class XII(%)");
        id9.setBounds(400, 300, 130, 30);
        id9.setFont(new Font("serif", 1, 20));
        id15.add(id9);
        
        t8 = new JTextField();
        t8.setBounds(600, 300, 150, 30);
        id15.add(t8);
        
        id10 = new JLabel("Address");
        id10.setBounds(50, 350, 130, 30);
        id10.setFont(new Font("serif", 1, 20));
        id15.add(id10);
        
        t9 = new JTextField();
        t9.setBounds(200, 350, 150, 30);
        id15.add(t9);
        
        b = new JButton("Submit");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(250, 550, 150, 40);
        id15.add(b);
        
        b1 = new JButton("Cancel");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(450, 550, 150, 40);
        id15.add(b1);
        
        b.addActionListener(this);
        b1.addActionListener(this);
        setVisible(true);
        setSize(900, 700);
        setLocation(400, 150);
    }
    public void actionPerformed(final ActionEvent ae) {
        final String a = t1.getText();
        final String bb = t2.getText();
        final String c = t3.getText();
        final String d = t4.getText();
        final String e = t5.getText();
        final String ff = t6.getText();
        final String g = t7.getText();
        final String h = t8.getText();
        final String i = t9.getText();
        String l = (String)this.c1.getSelectedItem();
        String m = (String)this.c2.getSelectedItem();
        if (ae.getSource() == b) {
            try {
                final conn cc = new conn();
                final String q = "insert into student values('" + a + "','" + bb + "','" + c + "','" + d + "','" + e + "','" + ff + "','" + g + "','" + l + "','" + m + "','" + h + "','" + i + "')";
                cc.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Student Details Inserted Successfully");
                setVisible(false);
            }
            catch (Exception ee) {
                System.out.println("The error is:" + ee);
            }
        }
        else if (ae.getSource() == b1) {
            setVisible(false);
        }
    }
    
    public static void main(String[] arg) {
        new New_Student();
    }
}
