import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ResultTreeType;

import java.sql.*;

public class MyMainApp {

    public static void main(String[] args) {
        Connection connection = DbConnection.createConnection();

        if (connection != null) {
            System.out.println("Prisijungeme");

            try {
                Statement st = connection.createStatement();

                ResultSet resultSet = st.executeQuery("SELECT * FROM student");
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String surname = resultSet.getString("surname");
                    String phone = resultSet.getString("phone");
                    String email = resultSet.getString("email");
                    System.out.println(id + " " + name + " " + surname + " " + " " + phone + " " + email);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void insertNewStudent(Connection connection, String name, String surname, String email,
                                         String phone) {

        if (connection != null) {
            try {
                String sql = "insert into students(name, surname, phone, email)values(?, ?, ?, ?)";
                PreparedStatement st = connection.prepareStatement(sql);
                st.setString(1, name);
                st.setString(2, surname);
                st.setString(3, phone);
                st.setString(4, email);
                st.execute();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    private static void updateStudent(Connection connection, int id, String name) {
        if (connection != null) {
            try {
                PreparedStatement st = connection.prepareStatement("update student set name=? where id=?");
                st.setString(1, name);
                st.setInt(2, id);
                st.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
