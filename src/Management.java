import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Management extends User {


    public Management(String userName) {
        super(Enum.User.Management, userName);
    }

    public ArrayList<Lesson> addLesson(ArrayList<Lesson> lessons) {
        int lessonNum = Integer.parseInt(JOptionPane.showInputDialog("How many lessons do you want to add?"));
        for (int i = 0; i < lessonNum; i++) {
            String lessonTitle = JOptionPane.showInputDialog("Enter Lesson title.");
            String midtermDate = JOptionPane.showInputDialog("Enter midterm Date with dd/mm/yyyy form .");
            String finalDate = JOptionPane.showInputDialog("Enter final Date with dd/mm/yyyy form .");
            lessons.add(new Lesson(lessonTitle, midtermDate, finalDate));
        }
        return lessons;
    }

    public Term addTerm(ArrayList<Lesson> lessons) {
        ArrayList<Lesson> lessonsInTerm = new ArrayList<Lesson>();
        String termTitle = JOptionPane.showInputDialog("Enter Term Title .");
        String scoreRegistryDate = JOptionPane.showInputDialog("Enter score Registry Date with dd/mm/yyyy form .");
        String startTerm = JOptionPane.showInputDialog("Enter Start Term Date with dd/mm/yyyy form .");
        String endTerm = JOptionPane.showInputDialog("Enter End Term Date with dd/mm/yyyy form .");
        int numLessonsInTerm = Integer.parseInt(JOptionPane.showInputDialog("How many Lessons you want to add to this term?"));

        Term term = new Term(termTitle, scoreRegistryDate, startTerm, endTerm);
        //just for showing in message
        String[] lessonsTitle = new String[lessons.size()];
        for (int j = 0; j < lessons.size(); j++)
            lessonsTitle[j] = lessons.get(j).getLessonTitle();

        for (int j = 0; j < lessons.size(); j++)
            assert  lessonsTitle[j] != null;

        for (int i = 0; i < numLessonsInTerm; i++) {
            int lessonChosen = JOptionPane.showOptionDialog(null, "Each time choose one lesson.",
                    "Add lessons to term", JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, lessonsTitle, 0);

            if (lessonChosen != lessons.size()) {//==exit
                lessonsInTerm.add(lessons.get(lessonChosen));
                lessons.get(lessonChosen).termsIn.add(term);
            }
        }
        term.setLessonsInTerm(lessonsInTerm);
        return term;
    }

    public Professor addProfessor(ArrayList<Professor> professorList) {

        String profUsername = JOptionPane.showInputDialog("Enter a userName for This professor.");
        return new Professor(profUsername);
    }

    public Student addStudent(ArrayList<Student> studentList) {

        String studentUsername = JOptionPane.showInputDialog("Enter a userName for This student.");
        return new Student(studentUsername);
    }


}
