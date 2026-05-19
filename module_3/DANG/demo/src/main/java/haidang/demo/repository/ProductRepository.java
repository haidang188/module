package haidang.demo.repository;

import haidang.demo.model.Category;
import haidang.demo.model.Product;
import haidang.demo.ultis.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static final String SELECT_ALL = "select p.id, p.name, p.price, p.quantity, " +
            "c.id as category_id, c.name as category_name " +
            "from products p " +
            "join category c on p.category_id = c.id";
    private static final String SEARCH_SQL = "select p.id, p.name, p.price, p.quantity, " +
            "c.id as category_id, c.name as category_name " +
            "from products p " +
            "join category c on p.category_id = c.id " +
            "where p.name like ? or c.name like ?";
    private static final String FIND_BY_ID = "select p.id, p.name, p.price, p.quantity, " +
            "c.id as category_id, c.name as category_name " +
            "from products p " +
            "join category c on p.category_id = c.id " +
            "where p.id = ?";
    private static final String FIND_BY_CATEGORY = "select * from products where category_id = ?";
    private static final String INSERT_SQL = "insert into products(name, price, quantity, category_id) values (?, ?, ?, ?)";
        private static final String UPDATE_SQL = "update products set name = ?, price = ?, quantity = ?, category_id = ? where id = ?";
    private static final String DELETE_SQL = "delete from products where id = ?";

    @Override
    public List<Product> findAll() {
        List<Product> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("category_id"));
                category.setName(rs.getString("category_name"));
                Product product = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getBigDecimal("price"),
                        rs.getInt("quantity"),
                        category
                );
                list.add(product);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Product> search(String keyword) {
        List<Product> listProducts = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(SEARCH_SQL)) {
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("category_id"));
                category.setName(rs.getString("category_name"));
                Product p = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getBigDecimal("price"),
                        rs.getInt("quantity"),
                        category
                );
                listProducts.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listProducts;
    }

    @Override
    public Product findById(int id) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("category_id"));
                category.setName(rs.getString("category_name"));
                return new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getBigDecimal("price"),
                        rs.getInt("quantity"),
                        category

                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insert(Product product) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {

            ps.setString(1, product.getName());
            ps.setBigDecimal(2, product.getPrice());
            ps.setInt(3, product.getQuantity());
            ps.setInt(4, product.getCategory().getId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Product product) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {

            ps.setString(1, product.getName());
            ps.setBigDecimal(2, product.getPrice());
            ps.setInt(3, product.getQuantity());
            ps.setInt(4, product.getCategory().getId());
            ps.setInt(5, product.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


