package app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBconnect {

  private static Connection connection = null;

    public static Connection getDBConnect (){

        if (connection == null) {try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/base_products?reconnect=true&useUnicode=true&characterEncoding=UTF-8&useLegacyDatetimeCode=false&serverTimezone=UTC","root", "1111");
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
