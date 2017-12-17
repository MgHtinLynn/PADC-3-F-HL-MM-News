package xyz.htinlynn.news.data.vo;

/**
 * Created by htinlynn on 12/17/17.
 */

public class SendToVO {
    private String sendToId;
    private String sendDate;
    private ActedUserVO actedUser;
    private ActedUserVO receivedUser;

    public String getSendToId() {
        return sendToId;
    }

    public String getSendDate() {
        return sendDate;
    }

    public ActedUserVO getActedUser() {
        return actedUser;
    }

    public ActedUserVO getReceivedUser() {
        return receivedUser;
    }
}
