package db.message;

import domain.Message;

import java.util.ArrayList;

public class MessageRepositoryStub implements MessageRepository {
    private ArrayList<Message> messages = new ArrayList<>();

    public ArrayList<Message> getMessages() {
        return this.messages;
    }

    public void addMessage(Message message) {
        messages.add(message);
    }
}
