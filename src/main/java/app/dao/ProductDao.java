package app.dao;

import app.entities.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    public static void create(Product product) {

        Connection connection = DBconnect.getDBConnect();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO base_products.products (name, category_id, dateOfProduce, dateOfExpired," +
                    " amount, price, provider, nPhoneProvider, dateOfDelivery, noWarehouse, description, notes) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getCategory().getId());
            preparedStatement.setDate(3, product.getDateOfProduce());
            preparedStatement.setDate(4, product.getDateOfExpired());
            preparedStatement.setInt(5, product.getAmount());
            preparedStatement.setDouble(6, product.getPrice());
            preparedStatement.setString(7, product.getProvider());
            preparedStatement.setString(8,product.getnPhoneProvider());
            preparedStatement.setDate(9, product.getDateOfDelivery());
            preparedStatement.setString(10,product.getNoWarehouse());
            preparedStatement.setString(11,product.getDescription());
            preparedStatement.setString(12,product.getNotes());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Product read (int id) {
        Connection connection = DBconnect.getDBConnect();
        Product product = new Product();
        try {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT products.id, products.name, products.category_id, products.dateOfProduce, products.dateOfExpired," +
                " products.amount, products.price, products.provider, products.nPhoneProvider, products.dateOfDelivery, products.noWarehouse, products.description, notes FROM products WHERE id = ?;");
        preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setCategory(resultSet.getInt("category_id"));
                product.setDateOfProduce(resultSet.getDate("dateOfProduce"));
                product.setDateOfExpired(resultSet.getDate("dateOfExpired"));
                product.setAmount(resultSet.getInt("amount"));
                product.setPrice(resultSet.getDouble("price"));
                product.setProvider(resultSet.getString("provider"));
                product.setnPhoneProvider(resultSet.getString("nPhoneProvider"));
                product.setDateOfDelivery(resultSet.getDate("dateOfDelivery"));
                product.setNoWarehouse(resultSet.getString("noWarehouse"));
                product.setDescription(resultSet.getString("description"));
                product.setNotes(resultSet.getString("notes"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    return product;
}

    public static void update(Product product, int id) {
        if (read(id)!=null) {
            Connection connection = DBconnect.getDBConnect();
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = connection.prepareStatement("UPDATE products SET name = ?, category_id = ?, dateOfProduce = ?, dateOfExpired = ?, amount =?, price = ?," +
                        " provider = ?, nPhoneProvider = ?, dateOfDelivery =?, noWarehouse = ?, description =?, notes =? WHERE id = ?;");
                preparedStatement.setString(1, product.getName());
                preparedStatement.setInt(2, product.getCategory().getId());
                preparedStatement.setDate(3, product.getDateOfProduce());
                preparedStatement.setDate(4, product.getDateOfExpired());
                preparedStatement.setInt(5, product.getAmount());
                preparedStatement.setDouble(6, product.getPrice());
                preparedStatement.setString(7, product.getProvider());
                preparedStatement.setString(8,product.getnPhoneProvider());
                preparedStatement.setDate(9, product.getDateOfDelivery());
                preparedStatement.setString(10,product.getNoWarehouse());
                preparedStatement.setString(11,product.getDescription());
                preparedStatement.setString(12,product.getNotes());
                preparedStatement.setInt(13,id);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void delete (int id){
        if (read(id)!=null) {
            Connection connection = DBconnect.getDBConnect();
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = connection.prepareStatement("DELETE FROM products WHERE id=?;");
                preparedStatement.setInt(1,id);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<Product> readAll(){
        Connection connection = DBconnect.getDBConnect();
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT products.id, products.name, products.category_id, products.dateOfProduce, products.dateOfExpired," +
                    " products.amount, products.price, products.provider, products.nPhoneProvider, products.dateOfDelivery, products.noWarehouse, products.description, notes FROM products;");
                        ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setCategory(resultSet.getInt("category_id"));
                product.setDateOfProduce(resultSet.getDate("dateOfProduce"));
                product.setDateOfExpired(resultSet.getDate("dateOfExpired"));
                product.setAmount(resultSet.getInt("amount"));
                product.setPrice(resultSet.getDouble("price"));
                product.setProvider(resultSet.getString("provider"));
                product.setnPhoneProvider(resultSet.getString("nPhoneProvider"));
                product.setDateOfDelivery(resultSet.getDate("dateOfDelivery"));
                product.setNoWarehouse(resultSet.getString("noWarehouse"));
                product.setDescription(resultSet.getString("description"));
                product.setNotes(resultSet.getString("notes"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}

