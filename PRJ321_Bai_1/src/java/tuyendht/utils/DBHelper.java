/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuyendht.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Trungtuyen
 */
public class DBHelper implements Serializable{
    public static Connection makeConection() 
            throws NamingException, SQLException{
//            throws ClassNotFoundException, SQLException{
        
        Context currentContext = new InitialContext();//get OS Naming and Directory
        Context tomcatContext = (Context)currentContext.lookup("java:comp/env");
        DataSource ds = (DataSource)tomcatContext.lookup("SE140046");
        Connection con = ds.getConnection();
        
        return con;
        
//        //1. Load Driver - add driver into priject
//        
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        //2. Create connection string to DBMS
//        String url = "jdbc:sqlserver://localhost:1433;databaseName=Test_1;instanceName=SQLEXPRESS";
//        //3. Open connection
//        Connection con = DriverManager.getConnection(url, "sa", "tuyen310");
//        return con;
    }
}
