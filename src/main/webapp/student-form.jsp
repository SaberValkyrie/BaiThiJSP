<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Student Form</title>
    <link type="text/css" rel="stylesheet" href="css/form.css">
    <link rel="icon" href="img/icon.png">

</head>

<body style="background-image: url('img/bookshelf.jpg');">
<br>
<br>
<br>
<c:choose>
    <c:when test="${empty student.id}">
        <form action="students?action=add" method="post">
            <h1>Add New Student:</h1>
            <label for="name">Name:</label>
            <input type="text" placeholder="Enter the student name" name="name" id="name"><br><br>
            <label for="name">Class:</label>
            <input type="text" placeholder="Enter the class student" name="classStudent" id="classStudent"><br><br>
            <label for="name">Gender:</label>
            <select name="gender" id="gender">
                <option value="Male">Male</option>
                <option value="Female">Female</option>
            </select>
            <br><br>
            <label for="name">Mark:</label>
            <input type="text" placeholder="Enter the mark student" name="mark" id="mark"><br><br>
            <label for="name">Phone:</label>
            <input type="text" placeholder="Enter the phone student" name="phone" id="phone"><br><br>
            <label for="name">Address:</label>
            <input type="text" placeholder="Enter the address" name="address" id="address"><br><br>
            <label for="name">Absent:</label>
            <input type="text" placeholder="Enter the absent" name="absent" id="absent"><br><br>
            <label for="name">Teacher:</label>
            <input type="text" placeholder="Enter the Teacher Name" name="teachername" id="teachername"><br><br>
            <input type="submit" class="button" value="Add">
            <a href="students" class="button cancel">Cancel</a>
        </form>
    </c:when>
    <c:otherwise>
        <form action="students?action=update" method="post">
            <input type="hidden" name="id" value="${student.id}">
            <h1>Edit Student:</h1>
            <label for="name">Name:</label>
            <input type="text" name="name" id="name" value="${student.name}"><br><br>
            <label for="name">Class:</label>
            <input type="text" name="classStudent" id="classStudent"  value="${student.classStudent}"><br><br>
            <label for="name">Gender:</label>
            <select name="gender" id="gender"  value="${student.gender}">
                <option value="Male">Male</option>
                <option value="Female">Female</option>
            </select>
            <label for="name">Mark:</label>
            <input type="text"  name="mark" id="mark"  value="${student.mark}"><br><br>
            <label for="name">Phone:</label>
            <input type="text" name="phone" id="phone"  value="${student.phone}"><br><br>
            <label for="name">Address:</label>
            <input type="text"  name="address" id="address"  value="${student.address}"><br><br>
            <label for="name">Absent:</label>
            <input type="text" name="absent" id="absent"  value="${student.absent}"><br><br>
            <label for="name">Teacher:</label>
            <input type="text" name="teachername" id="teachername"  value="${student.teachername}"><br><br>
            <input type="submit" class="button" value="Update">
            <a href="products" class="button">Cancel</a>
        </form>

    </c:otherwise>
</c:choose>
</body>
</html>