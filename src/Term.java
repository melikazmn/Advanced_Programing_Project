import java.util.ArrayList;

public class Term {
    protected String termTitle;
    protected String scoreRegistryDate;
    protected String startTerm;
    protected String endTerm;
    protected ArrayList<Lesson> lessonsInTerm = new ArrayList<Lesson>();


    public Term(String termTitle, String scoreRegistryDate, String startTerm, String endTerm) {
        this.termTitle = termTitle;
        this.scoreRegistryDate = scoreRegistryDate;
        this.startTerm = startTerm;
        this.endTerm = endTerm;
    }

    public String getTermTitle() {
        return termTitle;
    }

    public void setTermTitle(String termTitle) {
        this.termTitle = termTitle;
    }

    public String getScoreRegistryDate() {
        return scoreRegistryDate;
    }

    public void setScoreRegistryDate(String scoreRegistryDate) {
        this.scoreRegistryDate = scoreRegistryDate;
    }

    public String getStartTerm() {
        return startTerm;
    }

    public void setStartTerm(String startTerm) {
        this.startTerm = startTerm;
    }

    public String getEndTerm() {
        return endTerm;
    }

    public void setEndTerm(String endTerm) {
        this.endTerm = endTerm;
    }

    public ArrayList<Lesson> getLessonsInTerm() {
        return lessonsInTerm;
    }

    public void setLessonsInTerm(ArrayList<Lesson> lessonsInTerm) {
        this.lessonsInTerm = lessonsInTerm;
    }
}
