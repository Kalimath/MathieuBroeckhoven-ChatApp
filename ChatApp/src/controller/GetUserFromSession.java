package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;
import org.omg.CORBA.Request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetUserFromSession extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response){
        Person user = (Person) request.getSession().getAttribute("user");
        ObjectMapper mapper = new ObjectMapper();
        String userJSON = "";
        try {
            userJSON = mapper.writeValueAsString(user);
            response.setContentType("application/json");
            response.getWriter().write(userJSON);
            System.out.println(userJSON);
        }catch (Exception e){
            e.printStackTrace();
        }


    }


}
