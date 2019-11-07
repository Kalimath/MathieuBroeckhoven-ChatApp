package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Reaction;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint(value = "/react")
public class React {
    private static final ArrayList<Reaction> reactions = new ArrayList<>();
    private static final Set<Session> sessions =  Collections.synchronizedSet(new HashSet<Session>());

    @OnOpen
    public void onOpen(Session session) {
        System.out.println(session.getId() + "connection open");
        sessions.add(session);
    }

    @OnMessage
    public void onMessage(String message) throws IOException {
        if (message != null) {
            if (message.equals("true")) {
                sendAllReactions();
            } else {
                addReaction(message);
            }
        }
    }

    private void sendAllReactions() {
        for (Session s : sessions) {

            try {
                s.getBasicRemote().sendText(toJSON(reactions));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @OnClose
    public void onClose(Session ses) {
        sessions.remove(ses);
    }

    private void addReaction(String json) throws IOException {

        JsonNode node = new ObjectMapper().readTree(json);
        try {
            reactions.add(new Reaction(node.get("title").asText("default"), node.get("reactor").asText("default"), node.get("reaction").asText("default"), node.get("rating").asInt(0)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        sendAllReactions();
        System.out.println(toJSON(reactions));
    }

    private String toJSON (ArrayList<Reaction> reac) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(reac);
            return jsonString;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

}

