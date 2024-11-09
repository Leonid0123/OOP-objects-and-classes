import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class TestsJDBC {

    String url = "jdbc:h2:.\\Office";

    @Test
    public void cascadeDelete() {
        try (Connection con = DriverManager.getConnection(url)) {
            if (con != null) {
                System.out.println("Connection opened");
            } else {
                System.out.println("Failed to make connection");
            }
            assert con != null;
            removeDepartment(con, 1); //удаление отдела Accounting
            checkTabDepartment(con, 1);
            checkTabEmployee(con, 1);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    private void removeDepartment(Connection connection, int id) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM Department WHERE ID=?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    private void checkTabDepartment(Connection connection, int id) {
        try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Department WHERE ID=?")) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                Assertions.assertFalse(rs.next());
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    private void checkTabEmployee(Connection connection, int id) {
        try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Employee WHERE DepartmentID=?")) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                Assertions.assertFalse(rs.next());
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @BeforeEach
    @AfterEach
    public void checkDBTabs() {
        try (Connection con = DriverManager.getConnection(url)) {
            if (con != null) {
                System.out.println("Connection opened");
            } else {
                System.out.println("Failed to make connection");
            }
            assert con != null;
            System.out.println("Вывод таблицы Department:");
            showTabDepartment(con);
            System.out.println("Вывод таблицы Employee:");
            showTabEmployee(con);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    private static void showTabEmployee(Connection connection) throws SQLException {
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Employee")) {
            while (rs.next()) {
                System.out.println(
                        rs.getInt("ID") + "\t"
                                + rs.getString("Name") + "\t"
                                + rs.getInt("DepartmentID")
                );
            }
        }
    }

    private static void showTabDepartment(Connection connection) throws SQLException {
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Department")) {
            while (rs.next()) {
                System.out.println(
                        rs.getInt("ID") + "\t"
                                + rs.getString("Name")
                );
            }
        }
    }
}