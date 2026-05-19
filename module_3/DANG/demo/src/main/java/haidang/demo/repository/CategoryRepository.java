package haidang.demo.repository;

import com.oracle.wls.shaded.org.apache.bcel.Repository;
import haidang.demo.model.Category;
import haidang.demo.ultis.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository implements ICategoryRepository {
    private static final String SELECT_ALL = "select * from category";
    private static final String FIND_BY_ID = "select * from category where id = ?";
    private static final String INSERT_SQL = "insert into category(name) values(?)";
    private static final String UPDATE_SQL = "update category set name = ? where id = ?";
    private static final String DELETE_SQL = "delete from category where id = ?";
    @Override
    public List<Category> findAll() {
        List<Category> listCategory = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_ALL)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Category c = new Category(
                        rs.getInt("id"),
                        rs.getString("name")
                );
                listCategory.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listCategory;
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


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public void insert(Category category) {
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {

            ps.setString(1, category.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
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
        }
        catch (SQLException e) {
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
