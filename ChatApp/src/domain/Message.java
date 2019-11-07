package domain;

public class Message implements Comparable{
    private String sender;
    private String receiver;
    private String message;
    private int volgnummer = 0;

    public Message(String sender, String receiver, String message, int volgnummer) {
        setSender(sender);
        setReceiver(receiver);
        setMessage(message);
        setVolgnummer(volgnummer);
    }

    public void setSender(String sender) {
        if (sender != null) {
            this.sender = sender;
        }
    }

    public void setReceiver(String receiver) {
        if (receiver != null) {
            this.receiver = receiver;
        }
    }

    public void setMessage(String message) {
        if (message != null) {
            this.message = message;
        }
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setVolgnummer(int volgnummer) {
        this.volgnummer = volgnummer;
    }

    public int getVolgnummer() {
        return this.volgnummer;
    }

    @Override
    public int compareTo(Object m) {
        int compareVolgnummer=((Message) m).getVolgnummer();
        return this.volgnummer-compareVolgnummer;
    }
}
