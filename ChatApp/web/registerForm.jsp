<%--
  Created by IntelliJ IDEA.
  User: Kalimath
  Date: 12/12/2019
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Register page" />
</jsp:include>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Home" />
</jsp:include>
<c:if test="${errors.size()>0 }">
    <div class="danger">
        <ul>
            <c:forEach var="error" items="${errors }">
                <li>${error }</li>
            </c:forEach>
        </ul>
    </div>
</c:if>
<form method="post" action="Controller?action=Register">
    <p>
        <label for="firstname">Your name </label>
        <input type="text" id="firstname" name="firstname" placeholder="jan">
    </p>
    <p>
        <label for="lastname">Your surname </label>
        <input type="text" id="lastname" name="lastname" placeholder="Verheyden">
    </p>
    <p>
        <label for="email">Your email </label>
        <input type="text" id="email" name="email" placeholder="jan@ucll.be">
    </p>
    <p>
        <label for="gender">Your Gender </label>
        <select id="gender" name="gender">
            <option value="male">male</option>
            <option value="female">female</option>
        </select>
    </p>
    <p>
        <label for="age">Your age </label>
        <input type="number" id="age" name="age" placeholder="25">
    </p>
    <p>
        <label for="password">Your password</label>
        <input type="password" id="password" name="password">
    </p>
    <p>
        <label for="passwordrepeat">Your password</label>
        <input type="password" id="passwordrepeat" name="passwordrepeat">
    </p>
    <p>
        <input type="submit" id="signup" class="button button-primary" value="Sign Up">
    </p>
</form>
</body>
</html>
