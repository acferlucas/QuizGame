package br.com.ifpe.edu.recife.quiz;

public interface QuizStrategy {
    String getQuestion();
    boolean checkAnswer(String userAnswer);
}
