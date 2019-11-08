<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="wrapper">
    <div class="chat-box">
        <div class="chat-head">
            <h4 style="color: white; font-size: 30px;">Chat Box</h4>
            <img src="images/arrow-down-32.png" title="Expand Arrow" alt="Expand Arrow" width="16" height="16" style="color: white;">
        </div>
        <div class="chat-body">
            <div class="msg-insert">
            </div>
            <div class="chat-text">
                <input type="text" class="chat" placeholder="Send">
            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
<script src="js/chat.js"></script>