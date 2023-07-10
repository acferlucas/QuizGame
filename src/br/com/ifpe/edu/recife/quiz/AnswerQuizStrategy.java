package br.com.ifpe.edu.recife.quiz;

public class AnswerQuizStrategy implements QuizStrategy{
    private String question;

    private String answer;

    public AnswerQuizStrategy(String question, String answer) {
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
        return userAnswer.equalsIgnoreCase(answer);
    }
}
