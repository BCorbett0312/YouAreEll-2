package models;

/* 
 * POJO for an Message object
 */
public class Message {
    private String sequence;
    private String timestamp;
    private String fromid;
    private String toid;
    private String message;

    public Message (String sequence, String timestamp, String fromid, String toid, String message ){
        this.sequence = sequence;
        this.timestamp = timestamp;
        this.fromid = fromid;
        this.toid = toid;
        this.message = message;
    }

    public Message (String message, String fromId, String toId) {
        this.sequence = "-";
        this.fromid = fromId;
        this.toid = toId;
        this.message = message;
    }

    public Message(String message, String fromid){
        this.fromid = fromid;
        this.message = message;

    }

    public Message(){

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

    public String getFromid() {
        return fromid;
    }

    public void setFromid(String fromid) {
        this.fromid = fromid;
    }

    public String getToid() {
        return toid;
    }

    public void setToid(String toid) {
        this.toid = toid;
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
                "fromid: " + fromid + '\n' +
                "toid: " + toid + '\n' +
                "message: " + message + '\n';
    }
}