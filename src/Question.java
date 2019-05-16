public class Question {
    private String description;
    private String picture;
    private String answer;
    private String verb;
    private String preposition;

    public Question( String answer,String description, String picture) {
        this.description = description;
        this.picture = picture;
        this.answer = answer;
        String[] pv = answer.split(" ");
        verb=pv[0];
        preposition=pv[1];
    }

    public String getDescription() {
        return description;
    }

    public String getPicture() {
        return picture;
    }

    public String getAnswer() {
        return answer;
    }

    public String getVerb() {
        return verb;
    }

    public String getPreposition() {
        return preposition;
    }
}
