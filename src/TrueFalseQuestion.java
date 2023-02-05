import javax.swing.*;

public class TrueFalseQuestion extends Problem{
    public TrueFalseQuestion(String title, String solution) {
        super(title, solution);
    }

    @Override
    public void printSolution(boolean validation) {
        String[] choices = {"True","False"};
        if (validation)
            JOptionPane.showMessageDialog(null, "CORRECT:) the correct answer is "+choices[Integer.parseInt(solution)],"Print Solution",JOptionPane.PLAIN_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "WRONG:) the correct answer is "+choices[Integer.parseInt(solution)],"Print Solution",JOptionPane.ERROR_MESSAGE);

    }

    @Override
    public String printProblem() {
        String[] choices = {"True","False"};
        String answer = Integer.toString(JOptionPane.showOptionDialog(null, title,
                "Exam", JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, choices, 0));
        return answer;
    }

    @Override
    public boolean validProblem(String answer) {
//        return answer == solution;
        if (answer.equals(solution))
            return true;
        else
            return false;
    }
}
