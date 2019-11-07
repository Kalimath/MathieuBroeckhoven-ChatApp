<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="topiccontainer">
    <div class="topic0">
        <h2 id="title0">Was het een interessante projectweek?</h2>
        <div id="reactions0">

        </div>
        <input type="text" id="reactor0" placeholder="name">
        <input type="text" id="reaction0" placeholder="reaction">
        <input type="number" max="10" min="0" id="rating0" value="0">
        <input type="submit" id="reactbutton0" onclick="reactSocket.send(getReaction(0));" value="react" class="button button-primary">
    </div>
    </br>
    <div class="topic1">
        <h2 id="title1">Wat ben je van plan om te doen vandaag?</h2>
        <div id="reactions1">

        </div>
        <input type="text" id="reactor1" placeholder="name">
        <input type="text" id="reaction1" placeholder="reaction">
        <input type="number" max="10" min="0" id="rating1" value="0">
        <input type="submit" id="reactbutton1" onclick="reactSocket.send(getReaction(1));" value="react" class="button button-primary">
    </div>
    </br>
    <div class="topic2">
        <h2 id="title2">Naar welke muziek ben je momenteel aan het luisteren?</h2>
        <div id="reactions2">

        </div>
        <input type="text" id="reactor2" placeholder="name">
        <input type="text" id="reaction2" placeholder="reaction">
        <input type="number" max="10" min="0" id="rating2" value="0">
        <input type="submit" id="reactbutton2" onclick="reactSocket.send(getReaction(2));" value="react" class="button button-primary">
    </div>
    </br>
    <div class="topic3">
        <h2 id="title3">Wat zijn de examenvragen voor het vak Web4?</h2>
        <div id="reactions3">

        </div>
        <input type="text" id="reactor3" placeholder="name">
        <input type="text" id="reaction3" placeholder="reaction">
        <input type="number" max="10" min="0" id="rating3" value="0">
        <input type="submit" id="reactbutton3" onclick="reactSocket.send(getReaction(3));" value="react" class="button button-primary">
    </div>
    <div class="topic4">
        <h2 id="title4">Wat zijn de examenvragen voor het vak OSA?</h2>
        <div id="reactions4">

        </div>
        <input type="text" id="reactor4" placeholder="name">
        <input type="text" id="reaction4" placeholder="reaction">
        <input type="number" max="10" min="0" id="rating4" value="0">
        <input type="submit" id="reactbutton4" onclick="reactSocket.send(getReaction(4));" value="react" class="button button-primary">
    </div>
</div>
<script src="js/blog.js"></script>