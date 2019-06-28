package models;

/* 
 * POJO for an Id object
 */
public class Id {

    private String id;
    private String name;
    private String github;
    private String userId;

    public Id(){

    }

    public Id(String name, String id, String github){
        this.id = id;
        this.name = name;
        this.github = github;
    }

    public Id(String name, String githubId) {
        id = "-";
        this.name = name;
        this.github = githubId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    @Override
    public String toString() {
        return "***************************\n"+
                "userid: "  + id + '\n' +
                "name: " + name + '\n' +
                "github: " + github + '\n';

    }
}