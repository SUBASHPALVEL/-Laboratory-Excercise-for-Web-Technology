<%@ page import="java.sql.*" %>
<%
try {
    // Establish a connection to the MySQL database
    String url = "jdbc:mysql://localhost:3306/quiz_db";
    String username = "your_username";
    String password = "your_password";
    Connection conn = DriverManager.getConnection(url, username, password);

    // Get the contestant with the highest score
    String sql = "SELECT name, MAX(score) AS max_score FROM contestants";
    Statement statement = conn.createStatement();
    ResultSet resultSet = statement.executeQuery(sql);
    resultSet.next();
    String winnerName = resultSet.getString("name");
    int maxScore = resultSet.getInt("max_score");

    conn.close();

    out.println("<h2>Quiz Winner</h2>");
    out.println("<p>Name: " + winnerName + "</p>");
    out.println("<p>Score: " + maxScore + "</p>");
} catch (Exception e) {
    e.printStackTrace();
}
%>
