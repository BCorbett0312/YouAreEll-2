package models;

/* 
 * POJO for an Id object
 */
public class Id {

    private String id;
    private String name;
    private String github;

    public Id(String name, String id, String github){
        this.id = id;
        this.name = name;
        this.github = github;
    }

    public Id(String name, String githubId) {
        this.name = name;
        this.github = githubId;
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
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", github='" + github + '\'' +
                '}';
    }
}