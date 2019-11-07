<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Home" />
</jsp:include>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Blog" />
</jsp:include>
<main>
    <c:if test="${errors.size()>0 }">
        <div class="danger">
            <ul>
                <c:forEach var="error" items="${errors }">
                    <li>${error }</li>
                </c:forEach>
            </ul>
        </div>
    </c:if> <c:choose>
    <c:when test="${user!=null}">
        <p>Dag ${user.getFirstName()}</p>
        <jsp:include page="topics.jsp"/>
    </c:when>
    <c:otherwise>
        <jsp:include page="topics.jsp"/>
    </c:otherwise>
</c:choose> </main>

<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Home" />
</jsp:include>

<script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
</body>
