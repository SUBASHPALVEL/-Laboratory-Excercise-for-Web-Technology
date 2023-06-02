import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveContactServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve form parameters
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String nickname = request.getParameter("nickname");

        // Store contact information in the database
        try {
            // Establish database connection
            String url = "jdbc:mysql://localhost:3306/your_database_name";
            String username = "your_username";
            String password = "your_password";
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);

            // Prepare the SQL statement
            String sql = "INSERT INTO contacts (first_name, last_name, phone_number, email_address, date_of_birth, nickname) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, phoneNumber);
            statement.setString(4, email);
            statement.setString(5, dateOfBirth);
            statement.setString(6, nickname);

            // Execute the SQL statement
            statement.executeUpdate();

            // Close resources
            statement.close();
            connection.close();

            // Redirect back to the HTML form
            response.sendRedirect("contact.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
