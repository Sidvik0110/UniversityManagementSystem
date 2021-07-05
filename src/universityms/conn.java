/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityms;

import java.sql.*;

/**
 *
 * @author prane
 */
public class conn {
    static Connection c;
    Statement s;
    public conn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql:///University","root","");
            s=c.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
