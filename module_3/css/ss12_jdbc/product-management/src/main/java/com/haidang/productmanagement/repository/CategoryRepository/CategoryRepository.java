package com.haidang.productmanagement.repository.CategoryRepository;

import com.haidang.productmanagement.model.Category;
import com.haidang.productmanagement.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository implements ICategoryRepository {

    private static final String SELECT_ALL = "SELECT * FROM category";
    private static final String FIND_BY_ID = "SELECT * FROM category WHERE id = ?";
    private static final String INSERT_SQL = "INSERT INTO category(name) VALUES (?)";
    private static final String UPDATE_SQL = "UPDATE category SET name=? WHERE id=?";
    private static final String DELETE_SQL = "DELETE FROM category WHERE id=?";


    @Override
    public List<Category> findAll() {
        List<Category> list = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_ALL)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Category c = new Category(
                        rs.getInt("id"),
                        rs.getString("name")
                );
                list.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Category findById(int id) {
        Category c = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(FIND_BY_ID)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                c = new Category(
                        rs.getInt("id"),
                        rs.getString("name")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return c;
    }

    @Override
    public void insert(Category category) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {

            ps.setString(1, category.getName());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Category category) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {

            ps.setString(1, category.getName());
            ps.setInt(2, category.getId());

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
