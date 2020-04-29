package org.renm;

import java.sql.*;

public class FirstJdbc {
    private final String queryString = "select * from emp";
    private Connection conn;
    private String url;
    private String username;
    private String password;

    public FirstJdbc() {
    }

    public static void main(String[] args) throws SQLException {
        FirstJdbc fj = new FirstJdbc();
        fj.run();
        
    }

    public void run() {
        System.out.println("run");
        try {
            conn = getConnection();
            System.out.println("conn:" + conn);
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        System.out.println("got connection");
        try(Statement stat = conn.createStatement()) {
            try(ResultSet rs = stat.executeQuery(queryString)){
                while(rs.next()){
                    System.out.print(rs.getInt(1) + " ");
                    System.out.print(rs.getString(2) + " ");
                    System.out.print(rs.getString(3) + " ");
                    System.out.print(rs.getInt(4) + " ");
                    System.out.print("| ");
                    System.out.print(rs.getObject(1, int.class) + " ");
                    System.out.print(rs.getObject("ename", String.class) + " ");
                    System.out.print("\n");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        url = "jdbc:mysql://192.168.241.131:3306/joy";
        username = "renming";
        password = "Ming";
        System.out.println(System.getProperty("jdbc.drivers"));
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        System.out.println("register driver success");
        return DriverManager.getConnection(url, username, password);
    }
}
