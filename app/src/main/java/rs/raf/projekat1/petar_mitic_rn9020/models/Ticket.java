package rs.raf.projekat1.petar_mitic_rn9020.models;

public class Ticket {

    private int id;
    private int days;
    private String title;
    private String description;
    private String type;
    private String priority;
    private String state;

    public Ticket(int id, String title, String description, String type, String priority, String state,int days) {
        this.id = id;
        this.days = days;
        this.title = title;
        this.description = description;
        this.type = type;
        this.priority = priority;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
