public abstract class Problem {
    protected String title;
    protected String solution;

    public Problem(String title, String solution) {
        this.title = title;
        this.solution = solution;
    }

    public abstract void printSolution(boolean validation);
    public abstract String printProblem();
    public abstract boolean validProblem(String answer);

}
