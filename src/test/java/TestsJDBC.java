import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class TestsJDBC {

    String url = "jdbc:h2:.\\Office";

    @BeforeEach
    public void checkDBBeforeEdit() {
        try (Connection con = DriverManager.getConnection(url)) {
            if (con != null) {
                System.out.println("Connection opened");
            } else {
                System.out.println("Failed to make connection");
            }
            assert con != null;

            //Изменение таблицы Employee по работникам Ann и Pete для подготовки данных к выполнению заданий. (Только для отладки и проверки тестов)
            try (Statement statementForUpdate = con.createStatement()) {
                statementForUpdate.executeUpdate("UPDATE Employee SET DepartmentID = 1 WHERE ID = 2");
                statementForUpdate.executeUpdate("UPDATE Employee SET Name = 'pete' WHERE ID = 1");
            }

            try (Statement statement = con.createStatement();
                 ResultSet tableDepartment = statement.executeQuery("Select * from Department")) {
                //Вывод таблицы Department
                System.out.println("Вывод таблицы Department:");
                while (tableDepartment.next()) {
                    System.out.println(
                            tableDepartment.getInt("ID") + "\t"
                                    + tableDepartment.getString("Name")
                    );
                }
                System.out.println("Вывод таблицы Employee до изменений:");
                showTabEmployee(con);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Test
    public void TestOfficeDB() {
        try (Connection con = DriverManager.getConnection(url)) {
            if (con != null) {
                System.out.println("Connection opened");
            } else {
                System.out.println("Failed to make connection");
            }
            assert con != null;
            //выполнение пунктов 1-3 из задания
            findAndSetDepartment(con);
            correctNames(con);
            countITEmployees(con);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @AfterEach
    public void checkDBAfterEdit() {
        try (Connection con = DriverManager.getConnection(url)) {
            if (con != null) {
                System.out.println("Connection opened");
            } else {
                System.out.println("Failed to make connection");
            }
            assert con != null;
            System.out.println("Вывод таблицы Employee после изменений:");
            showTabEmployee(con);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    //1. Найдите ID сотрудника с именем Ann. Если такой сотрудник только один, то установите его департамент в HR.
    private static void findAndSetDepartment(Connection connection) throws SQLException {
        String query = "SELECT ID FROM Employee WHERE Name = 'Ann'";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                int id = rs.getInt("id");
                if (!rs.next()) {  // Проверяем, что только один сотрудник с таким именем
                    String update = "UPDATE Employee SET DepartmentID = 3 WHERE ID = ?";
                    try (PreparedStatement pstmt = connection.prepareStatement(update)) {
                        pstmt.setInt(1, id);
                        pstmt.executeUpdate();
                    }
                }
            }
        }
    }

    //2. Проверьте имена всех сотрудников. Если чьё-то имя написано с маленькой буквы, исправьте её на большую. Выведите на экран количество исправленных имён.
    private static void correctNames(Connection connection) throws SQLException {
        String selectQuery = "SELECT ID, Name FROM Employee";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(selectQuery)) {
            int correctionCount = 0;
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                if (Character.isLowerCase(name.charAt(0))) {
                    String correctedName = Character.toUpperCase(name.charAt(0)) + name.substring(1);
                    String update = "UPDATE Employee SET name = ? WHERE id = ?";
                    try (PreparedStatement pstmt = connection.prepareStatement(update)) {
                        pstmt.setString(1, correctedName);
                        pstmt.setInt(2, id);
                        pstmt.executeUpdate();
                        correctionCount++;
                    }
                }
            }
            System.out.println("Количество исправленных имён: " + correctionCount);
        }
    }

    //3. Выведите на экран количество сотрудников в IT-отделе
    private static void countITEmployees(Connection connection) throws SQLException {
        String query = "SELECT COUNT(*) AS count FROM Employee AS e " +
                "JOIN Department AS d ON e.DepartmentID=d.ID WHERE d.Name = 'IT'";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                int count = rs.getInt("count");
                System.out.println("Количество сотрудников в IT-отделе: " + count);
            }
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
}
