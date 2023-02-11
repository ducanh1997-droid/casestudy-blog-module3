package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

        public static Connection getConnection() {
            Connection connection = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_c10?useSSL=false",
                        "root", "12345678");
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return connection;
        }
    }

