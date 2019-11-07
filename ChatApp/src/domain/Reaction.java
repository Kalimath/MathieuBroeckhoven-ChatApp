package domain;

public class Reaction {
    private String title;
    private String reactor;
    private String reaction;
    private int rating;

    public Reaction(String title, String commentor, String comment, int score) {
        setTitle(title);
        setCommentor(commentor);
        setComment(comment);
        setScore(score);
    }

    private void setScore(int score) {
        if (score > -1 && score < 11) {
            this.rating = score;
        }
    }

    private void setTitle(String t) {
        if (t != null) {
            this.title = t;
        }
    }

    private void setComment(String comment) {
        if (comment != null) {
            this.reaction = comment;
        }
    }

    private void setCommentor(String commentor) {
        if (commentor != null) {
            this.reactor = commentor;
        }
    }

    public String getTitle() {
        return title;
    }

    public String getReactor() {
        return reactor;
    }

    public String getReaction() {
        return reaction;
    }

    public int getRating() {
        return rating;
    }
}
