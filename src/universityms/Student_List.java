/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityms;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;  
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
/**
 *
 * @author prane
 */
public class Student_List extends JFrame implements ActionListener{
    JFrame f;
    JLabel l1,l2;
    JTextField t1,t2;
    int emp;
    JButton b1;
    
    Student_List(int emp_id){
        super("Get Student list");
        emp = emp_id;
        setLayout(null);
        setSize(900,400);
        setLocation (550,150);
        
        l1 = new JLabel("Enter Course ID");
        l1.setFont(new Font("monospaced",Font.BOLD,15));
        l1.setBounds(50,100,150,50);
        add(l1);
        
        t1=new JTextField();
        t1.setFont(new Font("monospaced",Font.BOLD,15));
        t1.setBounds(200,100,150,50);
        add(t1);
        
        l2 = new JLabel("Enter semcode");
        l2.setFont(new Font("monospaced",Font.BOLD,15));
        l2.setBounds(450,100,150,50);
        add(l2);
        
        t2=new JTextField();
        t2.setFont(new Font("monospaced",Font.BOLD,15));
        t2.setBounds(600,100,150,50);
        add(t2);
        
        b1 = new JButton("Get List");
        b1.setBounds(400,200,100,50);
        add(b1);
        b1.addActionListener(this);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String crs_id=t1.getText();
            int semcode = Integer.parseInt(t2.getText());
            String cond1 = "select * from course where crs_id='"+crs_id+"' and emp_id="+emp+";";
            String query = "select rollno,FullName from student where rollno in (select rollno from subject where sem ="+semcode+" and (s1='"+crs_id+"' or s2='"+crs_id+"'or s3='"+crs_id+"' or s4 ='"+crs_id+"' or s5='"+crs_id+"')); ";
            
            try{
                conn c1 = new conn();
                ResultSet rs = c1.s.executeQuery(cond1);
                if(rs.next()){
                    PreparedStatement stmt = conn.c.prepareStatement(query);
                    File excel = new File("C:\\Downloads\\Student_List.xls");
                    FileInputStream stream = new FileInputStream(excel);
                    Workbook workbook = new HSSFWorkbook();
                    Sheet sheet =  workbook.createSheet("Student List");
                    Row rowhead = sheet.createRow((short) 1);
                    rowhead.createCell((short)0).setCellValue("Roll No.");
                    rowhead.createCell((short)1).setCellValue("Student Name");
                    rowhead.createCell((short)2).setCellValue("Course ID: "+crs_id);
                    int i=2;
                    ResultSet rs1 = c1.s.executeQuery(query);
                    while(rs1.next()){
                        Row row = sheet.createRow((short) i);
                        row.createCell((short)0).setCellValue(rs1.getInt("rollno"));
                        row.createCell((short)1).setCellValue(rs1.getString("FullName"));
                        i++;
                    }
                    
                    FileOutputStream fileOut = new FileOutputStream("C:\\Downloads\\Student_List.xls");
                    workbook.write(fileOut);
                    fileOut.close();
                    JOptionPane.showMessageDialog(null,"List successfully generated in C:/Downloads drive");
                    
                }else{
                    JOptionPane.showMessageDialog(null,"This course is not alloted to ID: "+emp);
                }
            }
            catch(FileNotFoundException e1){
                e1.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args){
        
    }
    
}
