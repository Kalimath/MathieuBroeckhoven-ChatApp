package controller;

import domain.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddFriend extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Person person = (Person) request.getSession().getAttribute("user");
        String newFriend  = request.getParameter("newFriend");
        try {
            if (!getPersonService().getAllFriends(person.getUserId()).contains(getPersonService().getPerson(newFriend))) {
                getPersonService().addFriend(person.getUserId(), newFriend);
            }
        } catch (Exception e) {
            System.out.println("no person with that name");
        }
    }
}
