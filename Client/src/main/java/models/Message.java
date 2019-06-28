package models;

/* 
 * POJO for an Message object
 */
public class Message {
    private String sequence;
    private String timestamp;
    private String fromID;
    private String toID;
    private String message;

    public Message (String sequence, String timestamp, String fromID, String toID, String message ){
        this.sequence = sequence;
        this.timestamp = timestamp;
        this.fromID = fromID;
        this.toID = toID;
        this.message = message;
    }

    public Message (String message, String fromId, String toId) {
        this.sequence = "-";
        this.fromID = fromId;
        this.toID = toId;
        this.message = message;
    }

    public Message(String message, String fromID){
        this.fromID = fromID;
        this.message = message;

    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getFromID() {
        return fromID;
    }

    public void setFromID(String fromID) {
        this.fromID = fromID;
    }

    public String getToID() {
        return toID;
    }

    public void setToID(String toID) {
        this.toID = toID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return "***********************************************\n" +
                "sequence: " + sequence + '\n' +
                "timestamp: " + timestamp + '\n' +
                "fromID: " + fromID + '\n' +
                "toID: " + toID + '\n' +
                "message: " + message + '\n';
    }
}