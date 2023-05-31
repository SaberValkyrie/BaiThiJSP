<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student</title>

    <link type="text/css" rel="stylesheet" href="css/list.css">
    <link rel="icon" href="img/icon.png">

</head>
<body>
<div class="containerimg" style="background-image: url('img/book.png');">

    <h2>Student Infomation</h2>
    <p>This is my list book</p>
    <a href="students?action=new" class="highlight">Add New Student</a>



</div>


<br>
<form method="get" action="students">
    <input type="hidden" name="action"  value="search">
    <input type="text" name="searchItem" placeholder="Search Student Name,Teacher Name or Class Name.">
    <button type="submit" class="search-button"><img src="img/lens.png" alt="Search"></button>

</form>
<a href="students?action=grade" class="grade-button">Student Grade</a>


<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Class</th>
        <th>Gender</th>
        <th>Mark</th>
        <th>Phone</th>
        <th>Address</th>
        <th>Absent</th>
        <th>Teacher Name</th>
        <th>Action</th>


    </tr>
    </thead>
    <tbody>
    <c:choose>
        <c:when test="${empty studentList}">

        </c:when>
        <c:otherwise>
            <c:forEach var="student" items="${studentList}">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.classStudent}</td>
                    <td>${student.gender}</td>
                    <td>${student.mark}</td>
                    <td>${student.phone}</td>
                    <td>${student.address}</td>
                    <td>${student.absent}</td>
                    <td>${student.teachername}</td>
                    <td class="actions">
                        <div class="action-buttons">
                            <a href="students?action=edit&id=${student.id}" class="button">Edit</a>
                            <a href="students?action=delete&id=${student.id}" class="button" onclick="return confirm('Are you sure you want to delete this Student?')">Delete</a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </c:otherwise>
    </c:choose>
    </tbody>
</table>
</body>
</html>
