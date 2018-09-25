package rest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoService {

    private Connection connection;

    StudentDaoService() {
        connection = DbConnection.createConnection();
        if (connection == null) {
            throw new IllegalArgumentException("Ei nera connectiono");
        }
    }

    protected List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student");
            while (resultSet.next()) {
                students.add(selectStudentData(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    protected Student getStudent(int id) {
        Student student = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from student where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            student = selectStudentData(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    private Student selectStudentData(ResultSet resultSet) {
        Student student = null;
        try {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            String email = resultSet.getString("email");
            String phone = resultSet.getString("phone");
            student = new Student(id, name, surname, email, phone);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }


    public void createStudent(Student st) {
        try {
            String sql = "insert into student(NAME, SURNAME, PHONE, EMAIL)values(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, st.getName());
            preparedStatement.setString(2, st.getLastName());
            preparedStatement.setString(3, st.getPhone());
            preparedStatement.setString(4, st.getEmail());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from student where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateStudent(Student student) {
        String sql = "update student set NAME = ?,Surname = ?, Email = ?, Phone = ? where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setString(4, student.getPhone());
            preparedStatement.setInt(5, student.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
