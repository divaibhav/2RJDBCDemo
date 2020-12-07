/*
 *  Created by IntelliJ IDEA.
 *  User: Vaibhav
 *  Date: 07-Dec-20
 *  Time: 11:32 AM
 */
package jdbcoperations;

import java.sql.*;

public class JDBCOperations {
    public static void main(String[] args) {
        //update
        try {
            int rows = updateData(30,"ravi112@gmail.com");
            System.out.println("no of rows affected = " + rows);
            rows = deleteData(1);
            System.out.println("no of rows affected = " + rows);
            //select
            ResultSet rs = selectData();
            //processing result set
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    //connection
    public static Connection getDbConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/secr";
        String user = "root";
        String pass = "";
        Connection con  = DriverManager.getConnection(url, user, pass);
        return con;
    }
    //select
    public static ResultSet selectData() throws SQLException {
        Connection con = getDbConnection();
        Statement stmt = con.createStatement();
        String sql = "SELECT * FROM info";
        ResultSet rs = stmt.executeQuery(sql);
        return rs;

    }
    //delete on the basis of rollno
    public static int deleteData(int rollNo) throws SQLException {
        Connection con = getDbConnection();
        String sql = "DELETE FROM info WHERE rollno = ?;";
        PreparedStatement pstmt = con.prepareStatement(sql);
        //setting parameter
        pstmt.setInt(1, rollNo);

        int rows = pstmt.executeUpdate();
        return rows;
    }

    //update on the basis of roll number
    public static int updateData(int rollno, String updateEmail) throws SQLException {
        Connection con = getDbConnection();
        String sql = "UPDATE info SET email = ? WHERE rollno = ?;";
        PreparedStatement pstmt = con.prepareStatement(sql);
        //setting parameters
        pstmt.setString(1, updateEmail);
        pstmt.setInt(2, rollno);
        int rows = pstmt.executeUpdate();
        return rows;
    }
}
