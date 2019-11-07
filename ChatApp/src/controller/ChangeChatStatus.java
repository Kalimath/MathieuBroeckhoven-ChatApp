package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeChatStatus extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String newStatus = (String)request.getParameter("newStatus");
        ((Person)request.getSession().getAttribute("user")).setStatus(newStatus);
    }
}
