package University_Management_System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
//import com.mysql.cj.jdbc.Driver;

public class Conn {
    Connection c;
    Statement s;

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitymanagement", "root", "Suhani@123");
            s = c.createStatement();

        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found. Include it in your library path.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Connection failed. Check the output console for details.");
            e.printStackTrace();
        }
    }

    //
//        public void close() {
//            try {
//                if (s != null) s.close();
//                if (c != null) c.close();
//            } catch (SQLException e) {
//                System.err.println("Error closing resources.");
//                e.printStackTrace();
//            }
    public static void main(String[] args) {
        Conn c = new Conn();

    }
}
//}


