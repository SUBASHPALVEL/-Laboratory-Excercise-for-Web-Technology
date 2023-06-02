import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarkListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Establish database connection
        String url = "jdbc:mysql://localhost:3306/your_database_name";
        String username = "your_username";
        String password = "your_password";
        List<Student> studentList = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            // Fetch student mark data from the database
            String query = "SELECT * FROM students";
            ResultSet resultSet = statement.executeQuery(query);

            // Iterate through the result set and create Student objects
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String subject = resultSet.getString("subject");
                int marks = resultSet.getInt("marks");

                // Create Student object
                Student student = new Student(id, name, subject, marks);
                studentList.add(student);
            }

            resultSet.close();
            statement.close();
            connection.close();

            // Set the student list as a request attribute
            request.setAttribute("studentList", studentList);

            // Dispatch the request to the JSP page
            request.getRequestDispatcher("marklist.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
