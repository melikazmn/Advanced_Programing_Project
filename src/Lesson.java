import java.util.ArrayList;

public class Lesson {
    protected String lessonTitle;
    protected String reference;
    protected ArrayList<String> syllabus = new ArrayList<String>();
    protected String midtermDate;
    protected String finalDate;
    protected ArrayList<Term> termsIn = new ArrayList<Term>();
    protected ArrayList<Exam> examsOfLesson = new ArrayList<Exam>();

    public Lesson(String lessonTitle, String midtermDate, String finalDate) {
        this.lessonTitle = lessonTitle;
        this.midtermDate = midtermDate;
        this.finalDate = finalDate;
    }

    public String getLessonTitle() {
        return lessonTitle;
    }

    public void setLessonTitle(String lessonTitle) {
        this.lessonTitle = lessonTitle;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public ArrayList<String> getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(ArrayList<String> syllabus) {
        this.syllabus = syllabus;
    }

    public String getMidtermDate() {
        return midtermDate;
    }

    public void setMidtermDate(String midtermDate) {
        this.midtermDate = midtermDate;
    }

    public String getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(String finalDate) {
        this.finalDate = finalDate;
    }

    public void addExam(ArrayList<Problem> problems,String exmTitle){
        examsOfLesson.add(new Exam(exmTitle,problems,this));
    }
}
