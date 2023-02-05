import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Student extends User {

    protected ArrayList<Lesson> signedInLessons = new ArrayList<Lesson>();
    protected HashMap<Exam, Float> scores = new HashMap<Exam, Float>();

    public Student(String userName) {
        super(Enum.User.Student, userName);
    }


    public void signInLesson(ArrayList<Term> terms) {
        if (terms.size() == 0) {
            JOptionPane.showMessageDialog(null, "No Term Added.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String[] termTitle = new String[terms.size()];
            for (int i = 0; i < terms.size(); i++)
                termTitle[i] = terms.get(i).getTermTitle();
            for (int i = 0; i < terms.size(); i++)
                assert termTitle[i] != null;

            int chosenTerm = JOptionPane.showOptionDialog(null, "Choose a term", "Sign in lesson", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, termTitle, 0);

            String[] lessonsInTermTitle = new String[terms.get(chosenTerm).lessonsInTerm.size()];
            for (int i = 0; i < terms.get(chosenTerm).lessonsInTerm.size(); i++)
                lessonsInTermTitle[i] = terms.get(chosenTerm).lessonsInTerm.get(i).getLessonTitle();
            for (int i = 0; i < terms.get(chosenTerm).lessonsInTerm.size(); i++)
                assert lessonsInTermTitle[i] != null;

            int chosenLesson = JOptionPane.showOptionDialog(null, "Choose a lesson", "Sign in lesson", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, lessonsInTermTitle, 0);

            if (chosenLesson != terms.get(chosenTerm).lessonsInTerm.size()) {//!= cancel
                signedInLessons.add(terms.get(chosenTerm).lessonsInTerm.get(chosenLesson));
            }
        }
    }

    public void takeExam() {
        if (signedInLessons.size() == 0) {
            JOptionPane.showMessageDialog(null, "No lesson signed in.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String[] lessonsTitle = new String[signedInLessons.size()];
            for (int j = 0; j < signedInLessons.size(); j++)
                lessonsTitle[j] = signedInLessons.get(j).getLessonTitle();

            for (int j = 0; j < signedInLessons.size(); j++)
                assert lessonsTitle[j] != null;

            int lessonChosen = JOptionPane.showOptionDialog(null, "choose one lesson.",
                    "Take exam lessons to term", JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, lessonsTitle, 0);


            if (signedInLessons.get(lessonChosen).examsOfLesson.size() == 0) {
                JOptionPane.showMessageDialog(null, "No Exam is added for this lesson.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String[] examTitle = new String[signedInLessons.get(lessonChosen).examsOfLesson.size()];
                for (int j = 0; j < signedInLessons.get(lessonChosen).examsOfLesson.size(); j++)
                    examTitle[j] = signedInLessons.get(lessonChosen).examsOfLesson.get(j).getExamTitle();

                for (int j = 0; j < signedInLessons.get(lessonChosen).examsOfLesson.size(); j++)
                    assert examTitle[j] != null;

                int examChosen = JOptionPane.showOptionDialog(null, "choose one exam.",
                        "Take exam lessons to term", JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE, null, examTitle, 0);

                Exam exam = signedInLessons.get(lessonChosen).examsOfLesson.get(examChosen);
                Float scre = signedInLessons.get(lessonChosen).examsOfLesson.get(examChosen).takeExam();
                scores.put(exam,scre);

                String[] options = {"objection to score", "Exit"};
                int whatToDo = JOptionPane.showOptionDialog(null, "Your score is : " + scre.toString(),
                        "Score ", JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE, null, options, 1);

                if (whatToDo == 0) {//objection to score
                    String text = JOptionPane.showInputDialog("Enter your massage to your professor.");
                    signedInLessons.get(lessonChosen).examsOfLesson.get(examChosen).objections.put(this,text);
                }
            }
        }
    }

    public void printScores() {
        String[] scoresString = new String[scores.size()];

        int j = 0;
        for ( Float score : scores.values()) {
            scoresString[j] = score.toString();
            j++;
        }
        for (j = 0; j < scores.size(); j++)
            assert scoresString[j] != null;

        int scoreChosen = JOptionPane.showOptionDialog(null, "Your scores are : ",
                "Scores of exams", JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, scoresString, 0);
    }


}
