package br.com.ifpe.edu.recife.quiz;

public class TrueFalseQuizStrategy implements QuizStrategy {
    private String question;
    private boolean answer;

    public TrueFalseQuizStrategy(String question, boolean answer) {
        this.question = question;
        this.answer = answer;
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public boolean checkAnswer(String userAnswer) {

        boolean userResponse = Boolean.parseBoolean(userAnswer);
        return userResponse == answer;
    }
}
