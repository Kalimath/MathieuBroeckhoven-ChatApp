package controller;

import domain.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetStatus extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {

        /*Person user = (Person) request.getSession().getAttribute("user");
        Controller.setJson();
        if (user != null) {
            Controller.setJson();
            if (getPersonService().getPerson(user.getUserId()).getStatus() != null) {
                System.out.println(toJSON(getPersonService().getPerson(user.getUserId()).getStatus()));
                return toJSON(getPersonService().getPerson(user.getUserId()).getStatus());
            } else {
                return toJSON("Offline");
            }
        } else {
            return toJSON("Offline");
        }*/
    }

    private String toJSON (String status) {
        StringBuffer json = new StringBuffer();

        json.append("{ \"status\" : \"");
        json.append(status);
        json.append("\"}");

        return json.toString();
    }
}
