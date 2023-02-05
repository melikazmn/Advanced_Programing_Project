import javax.jws.Oneway;
import java.util.ArrayList;
import java.util.HashMap;

public class Exam {
    protected String examTitle;
    protected Lesson parentLesson;
    protected ArrayList<Problem> problems = new ArrayList<Problem>();

    protected HashMap<Student,String> objections = new HashMap<Student,String>();

    public Exam(String examTitle, ArrayList<Problem> problems,Lesson parentLesson) {
        this.examTitle = examTitle;
        this.problems = problems;
        this.parentLesson = parentLesson;

    }

    public String getExamTitle() {
        return examTitle;
    }

    public void setExamTitle(String examTitle) {
        this.examTitle = examTitle;
    }

    public ArrayList<Problem> getProblems() {
        return problems;
    }

    public void setProblems(ArrayList<Problem> problems) {
        this.problems = problems;
    }

    public float takeExam(){
        float score = 0;
        for (Problem prob:problems) {
            String answer = prob.printProblem();
            prob.printSolution(prob.validProblem(answer));
            if (prob.validProblem(answer))
                score++;
        }
        score = (score*20)/problems.size();
        return score;
    }

}
