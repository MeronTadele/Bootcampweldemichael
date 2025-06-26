package org.yearup.data.mysql;
import org.springframework.stereotype.Component;
import org.yearup.data.ProductDao;import org.yearup.data.ShoppingCartDao;
import org.yearup.models.Product;
import org.yearup.models.ShoppingCart;
import org.yearup.models.ShoppingCartItem;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

@Component
public class MySqlShoppingCartDao extends MySqlDaoBase implements ShoppingCartDao {
    private ProductDao productDao;
    public MySqlShoppingCartDao(DataSource dataSource, ProductDao productDao) {
        super(dataSource);
        this.productDao = productDao;
    }
    @Override
    public ShoppingCart getByUserId(int userId) {
        String sql = "SELECT * FROM shopping_cart WHERE user_id = ?";
        ShoppingCart shoppingCart = new ShoppingCart();
        try (
                Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int productId = rs.getInt("product_id");
                    int quantity = rs.getInt("quantity");
                    Product product = productDao.getById(productId);
                    ShoppingCartItem item = new ShoppingCartItem();
                    item.setProduct(product);
                    item.setQuantity(quantity);
                    shoppingCart.add(item);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shoppingCart;
    }


    @Override
    public boolean create(int userId, int product_id) {
        String sql = "INSERT INTO shopping_cart(user_id, product_id, quantity) " +
                " VALUES (?, ?, 1);";
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1, userId);
            statement.setInt(2, product_id);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {

                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int orderId = generatedKeys.getInt(1);
                    return true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    @Override
    public boolean update(int productId, ShoppingCartItem shoppingCartItem, boolean fromAdd, int userId, int quantity) {
        String sql = "UPDATE shopping_cart" +
                " SET quantity = ? " +
                " WHERE product_id = ? AND user_id = ?;";
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            if (fromAdd) {
                statement.setInt(1, shoppingCartItem.getQuantity() + 1);
            } else {
                ;
                statement.setInt(1, quantity);
            }
            statement.setInt(2, productId);
            statement.setInt(3, userId);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    @Override
    public void delete(int user_id) {
        String sql = "DELETE FROM shopping_cart " +
                " WHERE user_id = ?;";
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, user_id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
