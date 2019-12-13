package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class Users extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        String userJSON = "";
        try {
            userJSON = mapper.writeValueAsString(getPersonService().getPersons());
            response.setContentType("application/json");
            response.getWriter().write(userJSON);
        }catch (Exception e){
            userJSON = mapper.writeValueAsString(new ArrayList<String>());
            response.setContentType("application/json");
            response.getWriter().write(userJSON);
            e.printStackTrace();
        }
    }
}
