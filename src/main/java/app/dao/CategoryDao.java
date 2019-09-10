package app.dao;

import app.entities.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {

    public static void create (Category category) {
        Connection connection = DBconnect.getDBConnect();
       // PreparedStatement preparedStatement = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO base_products.categories (name) VALUES(?);");
            preparedStatement.setString(1, category.getName());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static Category read (int id) {
        Connection connection = DBconnect.getDBConnect();
        Category category = new Category();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT categories.id, categories.name FROM base_products.categories WHERE id = ?;");
            preparedStatement.setInt(1, id);
           ResultSet resultSet = preparedStatement.executeQuery();
           if(resultSet.next()) {
               category.setId(resultSet.getInt("id"));
               category.setName(resultSet.getString("name"));
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    public static void update (Category category, int id) {

    }

    public static void delete (int id) {

    }

    public static List<Category> readAll() {
        Connection connection = DBconnect.getDBConnect();
        List<Category> categories = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM categories;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Category category = new Category();
                category.setId(resultSet.getInt("id"));
                category.setName(resultSet.getString("name"));
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

}
