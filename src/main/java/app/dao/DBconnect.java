package app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBconnect {

  private static Connection connection = null;

    public static Connection getDBConnect (){

        if (connection == null) {try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // String dbDriver = System.getenv("dbDriver");
            String connectionUrl = System.getenv("dbConnectionUrl");
            String userName = System.getenv("dbUserName");
            String password = System.getenv("dbPassword");
            connection = DriverManager.getConnection(connectionUrl,userName,password);
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        }
        return connection;
    }

//    @Override
//    public void close() {
//        try {
//            if( connection != null ) {
//                connection.close();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
