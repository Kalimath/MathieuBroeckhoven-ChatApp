package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Message;
import domain.MessageService;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class Chat extends RequestHandler {
    MessageService messages;

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        messages = this.getMessageService();

        Person user = (Person) request.getSession().getAttribute("user");
        if (user != null && request.getParameter("chat") != null) {
            response.setContentType("application/json");
            response.getWriter().write(toJSON(getRelevantMessages(user.getUserId(), request.getParameter("chat"))));
        } else if(request.getParameter("chat") == null) {
            addMessage(request.getParameter("message"));
        }
        response.getWriter().write("200");
    }

    private ArrayList<Message> getRelevantMessages(String userId, String chat) {
        ArrayList<Message> newMessages = new ArrayList<>();

        for (Message m : messages.getMessages()) {
            if ((m.getSender().equals(userId) && m.getReceiver().equals(chat)) || (m.getSender().equals(chat) && m.getReceiver().equals(userId))) {
                newMessages.add(m);
            }
        }
        Collections.sort(newMessages);
        return newMessages;
    }

    public void addMessage(String message) throws IOException {
        JsonNode node = new ObjectMapper().readTree(message);
        ArrayList<Message> relMessages = getRelevantMessages(node.get("sender").asText(), node.get("receiver").asText());
        int biggest = 0;
        for (Message m : relMessages) {
            if (m.getVolgnummer() > biggest) {
                biggest = m.getVolgnummer();
            }
        }

        if (message != null) {
            try {
                Message m = new Message(node.get("sender").asText(), node.get("receiver").asText(), node.get("message").asText(), biggest + 1);
                messages.addMessage(m);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(this.messages.getMessages().get(0).getMessage());
    }

    private String toJSON (ArrayList<Message> m) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(m);
            return jsonString;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
