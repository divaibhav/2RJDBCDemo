/*
 *  Created by IntelliJ IDEA.
 *  User: Vaibhav
 *  Date: 07-Dec-20
 *  Time: 11:08 AM
 */
package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
    public static void main(String[] args) {
        try {
            //step 1
            //loading driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //step 2
            //create connection
            String url = "jdbc:mysql://localhost:3306/secr";
            String user = "root";
            String pass = "";
            Connection con = DriverManager.getConnection(url, user, pass);
            //step 3
            //statement prepare
            Statement stmt = con.createStatement();
            //step 4
            //execute stmt
            // requires query or sql
            //insert data
            String sql = "INSERT INTO info (rollno, name, email) VALUES (30, 'Ravi', 'ravi@gmail.com');";
            int rows = stmt.executeUpdate(sql);
            //step 5
            System.out.println("no of rows affected = " + rows);
        }
        catch (ClassNotFoundException e){
            System.out.println(e);
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
