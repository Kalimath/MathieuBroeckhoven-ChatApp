package controller;

import domain.Person;
import domain.Role;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.server.ExportException;
import java.util.ArrayList;

public class Register extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ArrayList<String> errors = new ArrayList<>();
        String destination = "registerForm.jsp";
        try {
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String userId = request.getParameter("email");
            int age = Integer.parseInt(request.getParameter("age"));
            String gender = request.getParameter("gender");
            String password = request.getParameter("password");
            if (!password.equals(request.getParameter("passwordrepeat"))) {
                throw new IllegalArgumentException("passwords dont match");
            }
            Person user = new Person(userId, password, firstname, lastname, age, gender, Role.LID);
            getPersonService().addPerson(user);
            destination = "index.jsp";
            System.out.println(user.getUserId()+" is added to system, welcome!");
        } catch (Exception e) {
            errors.add(e.getMessage());
        }


        request.setAttribute("errors", errors);
        request.getRequestDispatcher(destination).forward(request,response);
    }
}
