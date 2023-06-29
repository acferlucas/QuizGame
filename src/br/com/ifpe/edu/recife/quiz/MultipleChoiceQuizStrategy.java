package br.com.ifpe.edu.recife.quiz;

public class MultipleChoiceQuizStrategy implements QuizStrategy {
    private String question;
    private String[] options;
    private int answerIndex;

    public MultipleChoiceQuizStrategy(String question, String[] options, int answerIndex) {
        this.question = question;
        this.options = options;
        this.answerIndex = answerIndex;
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public boolean checkAnswer(String userAnswer) {
        int selectedIndex = Integer.parseInt(userAnswer) - 1;
        return selectedIndex == answerIndex;
    }

    public String[] getOptions() {
        return options;
    }
}
