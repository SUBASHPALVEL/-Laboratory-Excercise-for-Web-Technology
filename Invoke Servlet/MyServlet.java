import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));

        // Process the form data
        // You can perform any desired operations here

        // Send a response back to the client
        response.setContentType("text/html");
        response.getWriter().println("<h2>Thank you for submitting the form!</h2>");
        response.getWriter().println("<p>Name: " + name + "</p>");
        response.getWriter().println("<p>Age: " + age + "</p>");
    }
}
