package dagorik.mariachi.com.toolbar.models;

import com.google.gson.annotations.SerializedName;

public class Messaging {
    @SerializedName("timestamp")
    private String timestamp;
    @SerializedName("sender")
    private Sender sender;
    @SerializedName("message")
    private Message message;
    @SerializedName("recipient")
    private Recipient recipient;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }
}
