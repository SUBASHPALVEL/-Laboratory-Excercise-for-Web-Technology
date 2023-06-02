<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Grievance Portal - Save Grievance</title>
</head>
<body>
    <%
    // Retrieve form parameters
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String subject = request.getParameter("subject");
    String message = request.getParameter("message");

    // Store grievance in the database
    try {
        // Establish database connection
        String url = "jdbc:mysql://localhost:3306/your_database_name";
        String username = "your_username";
        String password = "your_password";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);

        // Prepare the SQL statement
        String sql = "INSERT INTO grievances (name, email, subject, message) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        // Set the form parameters as the statement's parameters
        statement.setString(1, name);
        statement.setString(2, email);
        statement.setString(3, subject);
        statement.setString(4, message);

        // Execute the SQL statement
        statement.executeUpdate();

        // Close resources
        statement.close();
        connection.close();

        // Display success message
        out.println("<h2>Grievance submitted successfully!</h2>");

    } catch (Exception e) {
        e.printStackTrace();
        // Display error message
        out.println("<h2>Error occurred while saving grievance.</h2>");
    }
    %>
</body>
</html>
