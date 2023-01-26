import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Students> italianStudents = new ArrayList<>();
        List<Students> germanStudents = new ArrayList<>();

        Connection conn = null;
        Statement ps = null;
        ResultSet rs = null;
        Statement ps1 = null;
        ResultSet rs1 = null;
        try {
            String url = "jdbc:mysql://localhost:3306/newdb";
            String user = "developer1";
            String password = "password";
            conn = DriverManager.getConnection(url, user, password);

            ps = conn.createStatement();
            String queryItalianStudents = "SELECT first_name, last_name FROM italian_students";
            rs = ps.executeQuery(queryItalianStudents);

            while (rs.next()) {
                String name = rs.getString("first_name");
                String surname = rs.getString("last_name");
                italianStudents.add(new Students(name,surname));
            }

            ps1 = conn.createStatement();
            String queryGermanStudents = "SELECT first_name, last_name FROM german_students";
            rs1 = ps.executeQuery(queryGermanStudents);

            while (rs1.next()) {
                String name = rs1.getString("first_name");
                String surname = rs1.getString("last_name");
                germanStudents.add(new Students(name,surname));
            }



        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null)
                    conn.close();
                if (ps != null)
                    ps.close();
                if (ps1 != null)
                    ps1.close();
                if (rs != null)
                    rs.close();
                if (rs1 != null)
                    rs1.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }


    }
}