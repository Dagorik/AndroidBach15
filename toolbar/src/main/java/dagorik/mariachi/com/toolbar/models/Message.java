package dagorik.mariachi.com.toolbar.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Message {
    @SerializedName("seq")
    private int seq;
    @SerializedName("mid")
    private String mid;
    @SerializedName("attachments")
    private List<Attachments> attachments;

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public List<Attachments> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachments> attachments) {
        this.attachments = attachments;
    }
}
