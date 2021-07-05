/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityms;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author prane
 */


public class Splash extends JFrame implements Runnable{
    Thread t1;
    Splash(){
        super("University Management System");
        
        setLocation(400,150);
        setSize(1200,800);
        setLayout(new FlowLayout());
        ImageIcon c1= new ImageIcon(ClassLoader.getSystemResource("universityms/icons/First.jpg"));
        Image i1 = c1.getImage().getScaledInstance(1200, 800, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        
        JLabel m1 = new JLabel(i2);
        add(m1);
        setVisible(true);
        t1 = new Thread(this);
        t1.start();
    }
    public void run()
    {
        try{
            Thread.sleep(4000);
            this.setVisible(false);
            Login f1 = new Login();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        new Splash();
    }
}
