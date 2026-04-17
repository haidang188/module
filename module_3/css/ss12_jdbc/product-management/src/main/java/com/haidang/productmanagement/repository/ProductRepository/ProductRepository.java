package com.haidang.productmanagement.repository.ProductRepository;

import com.haidang.productmanagement.model.Product;
import com.haidang.productmanagement.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {

    private static final String SELECT_ALL = "SELECT * FROM products LIMIT ? OFFSET ?";
    private static final String INSERT_SQL = "INSERT INTO products(name, price, quantity, category_id) VALUES (?, ?, ?, ?)";
    private static final String DELETE_SQL = "DELETE FROM products WHERE id = ?";
    private static final String UPDATE_SQL = "UPDATE products SET name=?, price=?, quantity=?, category_id=? WHERE id=?";
    private static final String SEARCH_SQL = "SELECT p.* FROM products p JOIN category c ON p.category_id = c.id " + "WHERE p.name LIKE ? OR c.name LIKE ?";
    private static final String FIND_BY_CATEGORY = "SELECT * FROM products WHERE category_id = ?";

    @Override
    public List<Product> findAll(int limit, int offset) {
        List<Product> list = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_ALL)) {

            ps.setInt(1, limit);
            ps.setInt(2, offset);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product p = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getBigDecimal("price"),
                        rs.getInt("quantity"),
                        rs.getInt("category_id")
                );
                list.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Product> search(String keyword) {
        List<Product> list = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(SEARCH_SQL)) {

            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product p = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getBigDecimal("price"),
                        rs.getInt("quantity"),
                        rs.getInt("category_id")
                );
                list.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public void insert(Product product) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {

            ps.setString(1, product.getName());
            ps.setBigDecimal(2, product.getPrice());
            ps.setInt(3, product.getQuantity());
            ps.setInt(4, product.getCategoryId());

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
            ps.setInt(4, product.getCategoryId());
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

    @Override
    public List<Product> findByCategory(int categoryId) {
        List<Product> list = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(FIND_BY_CATEGORY)) {

            ps.setInt(1, categoryId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product p = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getBigDecimal("price"),
                        rs.getInt("quantity"),
                        rs.getInt("category_id")
                );
                list.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
