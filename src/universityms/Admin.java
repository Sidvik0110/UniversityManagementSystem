/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityms;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author prane
 */
public class Admin extends JFrame implements ActionListener{
    Admin(){
        super("University Management System");
        
        setSize(1920,1080);
        
        ImageIcon ic = new  ImageIcon(ClassLoader.getSystemResource("universityms/icons/admin.jpg"));
        Image i3 = ic.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        JLabel l1 = new JLabel(icc3);
        
        add(l1);
        
        JMenuBar mb = new JMenuBar();
        mb.setPreferredSize(new Dimension(1920,35));
        JMenu Add = new JMenu("Add");
        Add.setFont(new Font("monospaced",Font.BOLD,20));
        JMenuItem m1 = new JMenuItem("New Faculty");
        JMenuItem m2 = new JMenuItem("New Student");
        Add.setForeground(Color.BLACK);
        
        m1.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("universityms/icons/icon1.png"));
        Image image1 = icon1.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        m1.setIcon(new ImageIcon(image1));
        m1.setMnemonic('A');
        m1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
        m1.setBackground(Color.WHITE);
        Add.add(m1);
        
        m2.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("universityms/icons/icon2.png"));
        Image image2 = icon2.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        m2.setIcon(new ImageIcon(image2));
        m2.setMnemonic('B');
        m2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
        m2.setBackground(Color.WHITE);
        Add.add(m2);
        
        m1.addActionListener(this);
        m2.addActionListener(this);
        
        
        JMenu user = new JMenu("Details");
        user.setFont(new Font("monospaced",Font.BOLD,20));
        JMenuItem u1 = new JMenuItem("Student Details");
        JMenuItem u2 = new JMenuItem("Teacher Details");
        user.setForeground(Color.RED);
        
        u1.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("universityms/icons/icon3.png"));
        Image image4 = icon1.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        u1.setIcon(new ImageIcon(image4));
        u1.setMnemonic('C');
        u1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
        u1.setBackground(Color.WHITE);
        user.add(u1);
        
        u2.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("universityms/icons/icon4.jpg"));
        Image image5 = icon1.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        u2.setIcon(new ImageIcon(image5));
        u2.setMnemonic('D');
        u2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
        u2.setBackground(Color.WHITE);
        user.add(u2);
        
        u1.addActionListener(this);
        u2.addActionListener(this);
        
        JMenu attendance = new JMenu("Attendance");
        attendance.setFont(new Font("monospaced",Font.BOLD,20));
        JMenuItem a1 = new JMenuItem("Student Attendance");
        JMenuItem a2 = new JMenuItem("Teacher Attendance");
        attendance.setForeground(Color.BLACK);
        
        a1.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon23 = new ImageIcon(ClassLoader.getSystemResource("universityms/icons/icon14.jpg"));
        Image image24 = icon23.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        a1.setIcon(new ImageIcon(image24));
        a1.setMnemonic('E');
        a1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
        a1.setBackground(Color.WHITE);
        attendance.add(a1);
        
        a2.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon25 = new ImageIcon(ClassLoader.getSystemResource("universityms/icons/icon15.png"));
        Image image25 = icon25.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        a2.setIcon(new ImageIcon(image25));
        a2.setMnemonic('F');
        a2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
        a2.setBackground(Color.WHITE);
        attendance.add(a2);
        
        a1.addActionListener(this);
        a2.addActionListener(this);
        
        JMenu attendance_details = new JMenu("Attendance_Details");
        attendance_details.setFont(new Font("monospaced",Font.BOLD,20));
        JMenuItem ad1 = new JMenuItem("Student Attendance Details");
        JMenuItem ad2 = new JMenuItem("Teacher Attendance Details");
        attendance_details.setForeground(Color.RED);
        
        ad1.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon10 = new ImageIcon(ClassLoader.getSystemResource("universityms/icons/icon14.jpg"));
        Image image10 = icon10.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ad1.setIcon(new ImageIcon(image10));
        ad1.setMnemonic('G');
        ad1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
        ad1.setBackground(Color.WHITE);
        attendance_details.add(ad1);
        
        ad2.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon11 = new ImageIcon(ClassLoader.getSystemResource("universityms/icons/icon15.png"));
        Image image11 = icon11.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ad2.setIcon(new ImageIcon(image11));
        ad2.setMnemonic('H');
        ad2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
        ad2.setBackground(Color.WHITE);
        attendance_details.add(ad2);
        
        ad1.addActionListener(this);
        ad2.addActionListener(this);
        
        
        
        JMenu Fee = new JMenu("Fee");
        Fee.setFont(new Font("monospaced",Font.BOLD,20));
        JMenuItem f1 = new JMenuItem("Update Fee");
        JMenuItem f2 = new JMenuItem("View Fee Details");
        Fee.setForeground(Color.BLACK);
        
        f1.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon14 = new ImageIcon(ClassLoader.getSystemResource("universityms/icons/icon7.png"));
        Image image14 = icon14.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        f1.setIcon(new ImageIcon(image14));
        f1.setMnemonic('K');
        f1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
        f1.setBackground(Color.WHITE);
        Fee.add(f1);
        
        f2.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon15 = new ImageIcon(ClassLoader.getSystemResource("universityms/icons/icon17.png"));
        Image image15 = icon15.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        f2.setIcon(new ImageIcon(image15));
        f2.setMnemonic('L');
        f2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
        f2.setBackground(Color.WHITE);
        Fee.add(f2);
        
        f1.addActionListener(this);
        f2.addActionListener(this);
        
        JMenu Subject = new JMenu("Subjects_Registered");
        Subject.setFont(new Font("monospaced",Font.BOLD,20));
        JMenuItem sub1 = new JMenuItem("Add");
        JMenuItem sub2 = new JMenuItem("View");
        Subject.setForeground(Color.RED);
        
        sub1.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon16 = new ImageIcon(ClassLoader.getSystemResource("universityms/icons/icon2.png"));
        Image image16 = icon16.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        sub1.setIcon(new ImageIcon(image16));
        sub1.setMnemonic('M');
        sub1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
        sub1.setBackground(Color.WHITE);
        Subject.add(sub1);
        
        sub2.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon17 = new ImageIcon(ClassLoader.getSystemResource("universityms/icons/icon17.png"));
        Image image17 = icon17.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        sub2.setIcon(new ImageIcon(image17));
        sub2.setMnemonic('N');
        sub2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
        sub2.setBackground(Color.WHITE);
        Subject.add(sub2);
        
        sub1.addActionListener(this);
        sub2.addActionListener(this);
        
        JMenu Marks = new JMenu("Marks");
        Marks.setFont(new Font("monospaced",Font.BOLD,20));
        JMenuItem M1 = new JMenuItem("Add Student Marks");
        JMenuItem M2 = new JMenuItem("View Student Marks");
        Marks.setForeground(Color.BLACK);
        
        M1.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon18 = new ImageIcon(ClassLoader.getSystemResource("universityms/icons/icon17.png"));
        Image image18 = icon18.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        M1.setIcon(new ImageIcon(image18));
        M1.setMnemonic('O');
        M1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
        M1.setBackground(Color.WHITE);
        Marks.add(M1);
        
        M2.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon19 = new ImageIcon(ClassLoader.getSystemResource("universityms/icons/icon17.png"));
        Image image19 = icon19.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        M2.setIcon(new ImageIcon(image19));
        M2.setMnemonic('P');
        M2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
        M2.setBackground(Color.WHITE);
        Marks.add(M2);
        
        M1.addActionListener(this);
        M2.addActionListener(this);
        
        JMenu Course = new JMenu("Course");
        Course.setFont(new Font("monospaced",Font.BOLD,20));
        JMenuItem C1 = new JMenuItem("Add a course");
        JMenuItem C2 = new JMenuItem("Edit a course");
        Course.setForeground(Color.RED);
        
        C1.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon20 = new ImageIcon(ClassLoader.getSystemResource("universityms/icons/icon17.png"));
        Image image20 = icon20.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        C1.setIcon(new ImageIcon(image20));
        C1.setMnemonic('Q');
        C1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
        C1.setBackground(Color.WHITE);
        Course.add(C1);
        
        C2.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon21 = new ImageIcon(ClassLoader.getSystemResource("universityms/icons/icon17.png"));
        Image image21 = icon21.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        C2.setIcon(new ImageIcon(image21));
        C2.setMnemonic('R');
        C2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
        C2.setBackground(Color.WHITE);
        Course.add(C2);
        
        C1.addActionListener(this);
        C2.addActionListener(this);
        
        
        JMenu exit = new JMenu("Exit");
        exit.setFont(new Font("monospaced",Font.BOLD,20));
        JMenuItem ex = new JMenuItem("Exit");
        exit.setForeground(Color.BLACK);
        
        ex.setFont(new Font("monospace",Font.BOLD,16));
        ImageIcon icon22 = new ImageIcon(ClassLoader.getSystemResource("universityms/icons/icon12.png"));
        Image image22 = icon22.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ex.setIcon(new ImageIcon(image20));
        ex.setMnemonic('S');
        ex.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
        ex.setBackground(Color.WHITE);
        exit.add(ex);
        ex.addActionListener(this);
        
        mb.add(Add);
        mb.add(user);
        mb.add(attendance);
        mb.add(attendance_details);
        mb.add(Fee);
        mb.add(Subject);
        mb.add(Marks);
        mb.add(Course);
        mb.add(exit);
        
        setJMenuBar(mb);
        
        setFont(new Font("Senserif",Font.BOLD,25));
        setLayout(new FlowLayout());
        setVisible(false);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        String msg = ae.getActionCommand();
        if(msg.equals("New Faculty"))
            new New_Faculty().setVisible(true);
        else if(msg.equals("New Student"))
            new New_Student().setVisible(true);
        else if(msg.equals("Student Details"))
            new Student().setVisible(true);
        else if(msg.equals("Teacher Details"))
            new Teacher().setVisible(true);
        else if(msg.equals("Student Attendance"))
            new Student_Attendance().setVisible(true);
        else if(msg.equals("Teacher Attendance"))
            new Teacher_Attendance().setVisible(true);
        else if(msg.equals("Student Attendance Details"))
            new Student_Attendance_Details().setVisible(true);
        else if(msg.equals("Teacher Attendance Details"))
            new Teacher_Attendance_Details().setVisible(true);
        else if(msg.equals("Update Fee"))
            new Update_Fee().setVisible(true);
        else if(msg.equals("View Fee Details"))
            new View_Fee().setVisible(true);
        else if(msg.equals("Add"))
            new Add().setVisible(true);
        else if(msg.equals("View"))
            new View().setVisible(true);
        else if(msg.equals("Add Student Marks"))
            new add_marks().setVisible(true);
        else if(msg.equals("View Student Marks"))
            new view_marks().setVisible(true);
        else if(msg.equals("Add a course"))
            new add_course().setVisible(true);
        else if(msg.equals("Edit a course"))
            new edit_course().setVisible(true);
        else if(msg.equals("Exit"))
            System.exit(0);
        
        
    }
    public static void main(String[] args){
        new Admin().setVisible(true);
    }
}
