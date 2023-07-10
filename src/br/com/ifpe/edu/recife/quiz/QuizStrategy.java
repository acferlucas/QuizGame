package br.com.ifpe.edu.recife.quiz;

public interface QuizStrategy {
    String getQuestion();
    void setQuestion(String question);
    boolean checkAnswer(String userAnswer);
}
