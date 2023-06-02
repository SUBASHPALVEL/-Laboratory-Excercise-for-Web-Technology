<!DOCTYPE html>
<html>
<head>
    <title>Mark List</title>
</head>
<body>
    <h1>Mark List</h1>
    <table>
        <tr>
            <th>Student ID</th>
            <th>Name</th>
            <th>Subject</th>
            <th>Marks</th>
        </tr>
        <% 
        List<Student> studentList = (List<Student>) request.getAttribute("studentList");
        for (Student student : studentList) {
        %>
        <tr>
            <td>${student.getId()}</td>
            <td>${student.getName()}</td>
            <td>${student.getSubject()}</td>
            <td>${student.getMarks()}</td>
        </tr>
        <% 
        }
        %>
    </table>
</body>
</html>
