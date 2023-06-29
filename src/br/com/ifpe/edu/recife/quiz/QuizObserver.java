package br.com.ifpe.edu.recife.quiz;

public interface QuizObserver {
    void onQuestionChanged(QuizStrategy question);
    void onQuizCompleted(int score);
}
