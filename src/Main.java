import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.*;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String userName;


        //list of users
        ArrayList<User> userList = new ArrayList<User>();
        ArrayList<Professor> professorList = new ArrayList<Professor>();
        ArrayList<Student> studentList = new ArrayList<Student>();
        ArrayList<Management> managementList = new ArrayList<Management>();
        ArrayList<Term> termList = new ArrayList<Term>();
        ArrayList<Lesson> lessonList = new ArrayList<Lesson>();

        Management management1 = new Management("manager1");
        managementList.add(management1);
        userList.add(management1);
        boolean exit = false;

        while (!exit) {
            String[] choice = {"Management", "Professor", "Student", "Exit"};
            int choiceUser = JOptionPane.showOptionDialog(null,
                    "Choose Your Field.", "LOG IN",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, choice, 3);

            switch (choiceUser) {
                case 0:
                    userName = JOptionPane.showInputDialog("Enter Your UserName .");
                    for (Management mng : managementList)
                        if (Objects.equals(mng.getUserName(), userName)) {
                            exit = managementMenu(lessonList, mng, userList, professorList, studentList, termList);
                        }
                    break;
                case 1:
                    userName = JOptionPane.showInputDialog("Enter Your UserName .");
                    for (Professor prf : professorList)
                        if (Objects.equals(prf.getUserName(), userName)) {
                            exit = professorMenu(lessonList, prf, userList, professorList, studentList, termList);
                        }
                    break;
                case 2:
                    userName = JOptionPane.showInputDialog("Enter Your UserName .");
                    for (Student std : studentList)
                        if (Objects.equals(std.getUserName(), userName)) {
                            exit = studentMenu(lessonList, std, userList, professorList, studentList, termList);
                        }
                    break;
                case 3:
                    int mode = JOptionPane.showConfirmDialog(null, "Your are going to exit" +
                            " program");
                    if (mode == 0)
                        exit = true;
                    break;
            }// end of switch case on the menus

        }
    }


    public static boolean managementMenu(ArrayList<Lesson> lessonList, Management management, ArrayList<User> userList,
                                         ArrayList<Professor> professorList, ArrayList<Student> studentList,
                                         ArrayList<Term> termList) {
        boolean exit = false;
        while (!exit) {
            String[] choice = {"ADD Lesson", "ADD Term", "ADD Professor", "ADD Student", "Exit"};
            int whatToDo = JOptionPane.showOptionDialog(null, "What do you want to do?",
                    "Management Menu", JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, choice, 4);

            switch (whatToDo) {
                case 0:
                    management.addLesson(lessonList);
                    break;
                case 1:
                    if (lessonList.size() == 0)
                        JOptionPane.showMessageDialog(null, "No lesson Added.first add lesson",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    else
                        termList.add(management.addTerm(lessonList));
                    break;
                case 2:
                    professorList.add(management.addProfessor(professorList));
                    break;
                case 3:
                    studentList.add(management.addStudent(studentList));
                    break;
                case 4:
                    exit = true;
                    break;
            }// end of switch case on the menus
        }
        return false;
    }


    public static boolean studentMenu(ArrayList<Lesson> lessonList, Student student,
                                      ArrayList<User> userList, ArrayList<Professor> professorList,
                                      ArrayList<Student> studentList, ArrayList<Term> termList) {
        boolean exit = false;
        while (!exit) {
            String[] choice = {"Sign in Lesson", "Take Exam", "See Scores", "Exit"};
            int whatToDo = JOptionPane.showOptionDialog(null,
                    "What do you want to do?", "Student Menu",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, choice, 2);

            switch (whatToDo) {
                case 0:
                    student.signInLesson(termList);
                    break;
                case 1:
                    student.takeExam();
                    break;
                case 2:
                    student.printScores();
                    break;
                case 3:
                    exit = true;
                    break;
            }// end of switch case on the menus
        }
        return false;
    }


    public static boolean professorMenu(ArrayList<Lesson> lessonList, Professor professor,
                                        ArrayList<User> userList, ArrayList<Professor> professorList,
                                        ArrayList<Student> studentList, ArrayList<Term> termList) {
        boolean exit = false;
        while (!exit) {
            String[] choice = {"Choose Lesson", "ADD Exam", "Check Objections", "Exit"};
            int whatToDo = JOptionPane.showOptionDialog(null, "What do you want to do?",
                    "Professor Menu", JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, choice, 2);

            switch (whatToDo) {
                case 0:
                    professor.chooseLesson(termList);
                    break;
                case 1:
                    professor.addExam();
                    break;
                case 2:
                    professor.checkObjections();
                    break;
                case 3:
                    exit = true;
                    break;
            }// end of switch case on the menus
        }
        return false;
    }


}