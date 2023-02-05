import javax.swing.*;

public class BlankQuestion extends Problem{
    public BlankQuestion(String title, String solution) {
        super(title, solution);
    }

    @Override
    public void printSolution(boolean validation) {
        if (validation)
            JOptionPane.showMessageDialog(null, "CORRECT:) by the way the complete answer is: "+solution,"Print Solution",JOptionPane.PLAIN_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "WRONG:) check the correct answer: "+solution,"Print Solution",JOptionPane.ERROR_MESSAGE);

    }

    @Override
    public String printProblem() {
        String answer = JOptionPane.showInputDialog("? blank question: " + title);
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
