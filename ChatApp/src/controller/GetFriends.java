package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetFriends extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Person user = (Person) request.getSession().getAttribute("user");
        ObjectMapper mapper = new ObjectMapper();
        String userJSON = "";
        try {
            userJSON = mapper.writeValueAsString(getPersonService().getAllFriends(user.getUserId()));
            response.setContentType("application/json");
            response.getWriter().write(userJSON);
            System.out.println(userJSON);
        }catch (Exception e){
            userJSON = mapper.writeValueAsString(new ArrayList<String>());
            response.setContentType("application/json");
            response.getWriter().write(userJSON);
            System.out.println(userJSON);
            e.printStackTrace();
        }
    }
}
