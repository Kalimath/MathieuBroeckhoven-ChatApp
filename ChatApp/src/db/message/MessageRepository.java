package db.message;

import domain.Message;

import java.util.ArrayList;

public interface MessageRepository {
    ArrayList<Message> getMessages();
    void addMessage(Message message);
}
