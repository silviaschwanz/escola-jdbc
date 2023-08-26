package com.escola;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {
    
    private Connection connection;

    public Connection openConnection(){
        try {
            connection = DriverManager.getConnection(
               "jdbc:mysql://localhost:3320/escola_jdbc",
                "root",
                "password"
            );
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
    
}
