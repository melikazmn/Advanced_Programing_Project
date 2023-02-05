import javax.swing.*;
import java.util.Objects;

public class MultipleChoice extends Problem{


    public MultipleChoice(String title, String solution) {
        super(title, solution);
    }

    @Override
    public void printSolution(boolean validation) {
        if (validation)
            JOptionPane.showMessageDialog(null, "CORRECT:) the correct choice is "+ Integer.toString(Integer.parseInt(solution)+1)+"th choice","Print Solution",JOptionPane.PLAIN_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "WRONG:) the correct choice is "+ Integer.toString(Integer.parseInt(solution)+1)+"th choice","Print Solution",JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public String printProblem() {
        String[] choices = {"choice 1","choice 2","choice 3","choice 4"};
        String answer = Integer.toString(JOptionPane.showOptionDialog(null, title,
                "Exam", JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, choices, 0));
        return answer;
    }

    @Override
    public boolean validProblem(String answer) {
        if (answer.equals(solution))
            return true;
        else
            return false;
    }
}
