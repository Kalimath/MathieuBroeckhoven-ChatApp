<%--
  Created by IntelliJ IDEA.
  User: Kalimath
  Date: 27/09/2019
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Chat"/>
</jsp:include>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Chat"/>
</jsp:include>

<main>
    <div>
        <h3>Status: </h3>
        <div id="personStatus"></div>
    </div>
    <div>
        <h3>Friends:</h3>
        <table id="friendsTable">
            <thead>
            <th>UserId</th>
            <th>Status</th>
            <%--                <th>Chat</th>--%>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
    <div>
        <p>
            <label for="newFriend">Add friend</label>
            <input type="text" id="newFriend" name="newFriend" value="bib@ucll.be">
        </p>
        <p>
            <input type="submit" id="addFriendbutton" value="add">
        </p>
    </div>
    <div>
        <p>
            <label for="newStatus">Change status</label>
            <input type="text" id="newStatus" name="newStatus" placeholder="type a new status">
        </p>
        <p>
            <input type="submit" id="changeStatusbutton" value="change">
        </p>
    </div>

    <jsp:include page="chatbox.jsp">
        <jsp:param name="title" value="Chatbox"/>
    </jsp:include>
</main>

<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Chat"/>
</jsp:include>
</body>
<script type="text/javascript" src="js/changeStatus.js"></script>
<script type="text/javascript" src="js/getChatInfo.js"></script>
<script type="text/javascript" src="js/addFriend.js"></script>
</html>
