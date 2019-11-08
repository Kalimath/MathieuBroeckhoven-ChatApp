package domain;

import db.message.MessageRepository;
import db.message.MessageRepositoryStub;
import domain.Message;

import java.util.ArrayList;

public class MessageService {
    private MessageRepository messageRepository = new MessageRepositoryStub();
    public ArrayList<Message> getMessages() {
        return this.messageRepository.getMessages();
    }
    public void addMessage(Message message) {
        this.messageRepository.addMessage(message);
    }
}
