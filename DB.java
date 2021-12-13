/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package as;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author dell
 */
public class DB {
    private static Connection c;
    
    private static void setUpConnection()throws Exception{
            Class.forName("com.mysql.jdbc.Driver");
    c=DriverManager.getConnection("jdbc:mysql://localhost:3307/mydb", "root","1234");
    }
    public static void iud(String sql)throws Exception{
        if(c==null){ //check memory location
            setUpConnection();
        }
        c.createStatement().executeUpdate(sql);
    }
    public static ResultSet search(String sql)throws Exception{
        if(c==null){ //check memory location
            setUpConnection();
        }
        return c.createStatement().executeQuery(sql);
}
        public static Connection getDBcon()throws Exception{
        if(c==null){ //check memory location
            setUpConnection();
        }
        return c;
}
}