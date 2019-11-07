package domain;

public enum Status {
    ON("online"), OFF("offline"), AW("away"),DND("do not disturb");

    private String description;

    Status(String description) {
        this.description = description;
    }

    Status() {

    }

    public String getDescription() {
        return description;
    }
}
