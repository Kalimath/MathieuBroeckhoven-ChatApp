package db.message;

import domain.Message;

import java.util.ArrayList;

public class MessageRepositoryStub implements MessageRepository {
    private ArrayList<Message> messages = new ArrayList<>();

    public MessageRepositoryStub() {
        messages.add(new Message("bib@ucll.be","jan@ucll.be","testje eh",1));
        messages.add(new Message("jan@ucll.be","bib@ucll.be","goed eh",1));
    }



    public ArrayList<Message> getMessages() {
        return this.messages;
    }

    public void addMessage(Message message) {
        messages.add(message);
    }
}
