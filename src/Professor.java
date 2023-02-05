import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class Professor extends User {

    ArrayList<Lesson> profLessons = new ArrayList<Lesson>();

    public Professor(String userName) {
        super(Enum.User.Professor, userName);
    }

    public void chooseLesson(ArrayList<Term> terms) {
        String[] termsTitle = new String[terms.size()];
        for (int j = 0; j < terms.size(); j++)
            termsTitle[j] = terms.get(j).getTermTitle();

        for (int j = 0; j < terms.size(); j++)
            assert termsTitle[j] != null;

        int termChosen = JOptionPane.showOptionDialog(null, "Choose a term.",
                "Add lesson for Professor", JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, termsTitle, 0);

        String[] lessonsTitle = new String[terms.get(termChosen).lessonsInTerm.size()];
        for (int j = 0; j < terms.get(termChosen).lessonsInTerm.size(); j++)
            lessonsTitle[j] = terms.get(termChosen).lessonsInTerm.get(j).getLessonTitle();
        for (int j = 0; j < terms.get(termChosen).lessonsInTerm.size(); j++)
            assert lessonsTitle[j] != null;

        int lessonChosen = JOptionPane.showOptionDialog(null, "Choose a lesson.",
                "Add lesson for Professor", JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, lessonsTitle, 0);

        if (lessonChosen != terms.get(termChosen).lessonsInTerm.size()) {//!cancel
            profLessons.add(terms.get(termChosen).lessonsInTerm.get(lessonChosen));

            terms.get(termChosen).lessonsInTerm.get(lessonChosen).reference = JOptionPane.showInputDialog("Enter the reference of the lesson.");
            int sylNum = Integer.valueOf(JOptionPane.showInputDialog("How many syllabus do you want to add?"));
            for (int j = 0; j < sylNum; j++) {
                String syla = JOptionPane.showInputDialog("Enter syllabus.");
                terms.get(termChosen).lessonsInTerm.get(lessonChosen).syllabus.add(syla);
            }
        }

    }

    public void addExam() {
        if (profLessons.size() == 0) {
            JOptionPane.showMessageDialog(null, "No lesson Added.first add lesson", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String[] choice = new String[profLessons.size()];
            for (int i = 0; i < profLessons.size(); i++)
                choice[i] = profLessons.get(i).getLessonTitle();
            for (int i = 0; i < profLessons.size(); i++)
                assert choice[i] != null;

            int whichLesson = JOptionPane.showOptionDialog(null, "Choose a lesson", "ADD EXAM", JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, choice, 3);

            ArrayList<Problem> problems = new ArrayList<Problem>();
            String exmTitle = JOptionPane.showInputDialog("Enter a title for exam.");

            int numBlankQuestion = Integer.valueOf(JOptionPane.showInputDialog("How many blank question you want to add?"));
            for (int i = 0; i < numBlankQuestion; i++) {
                String title = JOptionPane.showInputDialog("Enter a title for blank question.");
                String solution = JOptionPane.showInputDialog("Enter a solution for blank question.");
                problems.add(new BlankQuestion(title, solution));
            }
            int numDescriptiveQuestion = Integer.valueOf(JOptionPane.showInputDialog("How many Descriptive question you want to add?"));
            for (int i = 0; i < numDescriptiveQuestion; i++) {
                String title = JOptionPane.showInputDialog("Enter a title for Descriptive question.");
                String solution = JOptionPane.showInputDialog("Enter a solution for Descriptive question.");
                problems.add(new Descriptive(title, solution));
            }
            int numMultipleChoiceQuestion = Integer.valueOf(JOptionPane.showInputDialog("How many Multiple Choice question you want to add?"));
            for (int i = 0; i < numMultipleChoiceQuestion; i++) {
                String title = JOptionPane.showInputDialog("Enter a title for Multiple Choice question.");
                String solution = JOptionPane.showInputDialog("Enter a solution for Multiple Choice question.If the answer is first choice enter 0 if its the second one enter 1 ,..");
                problems.add(new MultipleChoice(title, solution));
            }
            int numTrueFalseQuestion = Integer.valueOf(JOptionPane.showInputDialog("How many True/False question you want to add?"));
            for (int i = 0; i < numTrueFalseQuestion; i++) {
                String title = JOptionPane.showInputDialog("Enter a title for TrueFalse question.");
                String solution = JOptionPane.showInputDialog("Enter a solution for TrueFalse question.If it's true enter 0 else enter 1.");
                problems.add(new TrueFalseQuestion(title, solution));
            }
            profLessons.get(whichLesson).addExam(problems, exmTitle);
        }
    }

    public void checkObjections() {
        if (profLessons.size() == 0) {
            JOptionPane.showMessageDialog(null, "No lesson and exam Added.first add lesson", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String[] choice = new String[profLessons.size()];
            for (int i = 0; i < profLessons.size(); i++)
                choice[i] = profLessons.get(i).getLessonTitle();
            for (int i = 0; i < profLessons.size(); i++)
                assert choice[i] != null;

            int whichLesson = JOptionPane.showOptionDialog(null, "Choose a lesson", "check Objections", JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, choice, 0);

            if (profLessons.get(whichLesson).examsOfLesson.size() == 0) {
                JOptionPane.showMessageDialog(null, "No Exam is added for this lesson.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String[] examTitle = new String[profLessons.get(whichLesson).examsOfLesson.size()];
                for (int j = 0; j < profLessons.get(whichLesson).examsOfLesson.size(); j++)
                    examTitle[j] = profLessons.get(whichLesson).examsOfLesson.get(j).getExamTitle();

                for (int j = 0; j < profLessons.get(whichLesson).examsOfLesson.size(); j++)
                    assert examTitle[j] != null;

                int examChosen = JOptionPane.showOptionDialog(null, "choose one exam.",
                        "check Objections", JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE, null, examTitle, 0);
                if (profLessons.get(whichLesson).examsOfLesson.get(examChosen).objections.size() == 0) {
                    JOptionPane.showMessageDialog(null, "No objection.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    String[] studentName = new String[profLessons.get(whichLesson).examsOfLesson.get(examChosen).objections.size()];
                    int j = 0;
                    for (Student stu : profLessons.get(whichLesson).examsOfLesson.get(examChosen).objections.keySet()) {
                        studentName[j] = stu.getUserName();
                    }
                    for (j = 0; j < profLessons.get(whichLesson).examsOfLesson.get(examChosen).objections.size(); j++)
                        assert studentName[j] != null;

                    int usernameChosen = JOptionPane.showOptionDialog(null, "choose one Student.",
                            "check Objections", JOptionPane.YES_NO_OPTION,
                            JOptionPane.INFORMATION_MESSAGE, null, studentName, 0);

                    Student chosenStudent = null;
                    for (Student stu : profLessons.get(whichLesson).examsOfLesson.get(examChosen).objections.keySet()) {
                        if (stu.getUserName() == studentName[usernameChosen])
                            chosenStudent = stu;
                    }

                    String[] options = {"change score", "ignore"};
                    Exam exam = profLessons.get(whichLesson).examsOfLesson.get(examChosen);
                    int doWhat = JOptionPane.showOptionDialog(null, chosenStudent.getUserName() + " got this score : " +
                                    chosenStudent.scores.get(exam).toString(),
                            "check Objections", JOptionPane.YES_NO_OPTION,
                            JOptionPane.INFORMATION_MESSAGE, null, options, 0);

                    if (doWhat == 0) {
                        String newScore = JOptionPane.showInputDialog("Enter new score");
                        chosenStudent.scores.replace(profLessons.get(whichLesson).examsOfLesson.get(examChosen), Float.valueOf(newScore));
                    }
                }

            }
        }
    }

}
