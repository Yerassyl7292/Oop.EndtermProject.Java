package kz.aitu.oop.endterm.database;

import java.sql.*;

public class PostgreSqlDB implements IDB {

    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:postgresql://localhost:5432/DataStoreForEndtermOOP";
        try {
            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "123");
            return con;
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }
}