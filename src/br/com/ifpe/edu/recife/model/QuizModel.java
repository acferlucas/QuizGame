package br.com.ifpe.edu.recife.model;

import br.com.ifpe.edu.recife.quiz.QuizObserver;
import br.com.ifpe.edu.recife.quiz.QuizStrategy;
import br.com.ifpe.edu.recife.quiz.QuizSubject;

import java.util.Arrays;
import java.util.List;

public class QuizModel implements QuizSubject {
    private QuizStrategy[] questions;
    private QuizObserver quizObserver;
    private int score;
    private int currentQuestionIndex;

    // Constructor
    public QuizModel() {
        questions = new QuizStrategy[5];
        score = 0;
        currentQuestionIndex = 0;
    }

    public QuizStrategy[] getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuizStrategy> questions) {
        this.questions = questions.subList(0,5).toArray(new QuizStrategy[0]);
    }

    public int getScore() {
        return score;
    }

    public void incrementScore() {
        score++;
    }

    public int getCurrentQuestionIndex() {
        return currentQuestionIndex;
    }

    public QuizStrategy getCurrentQuestion() {
        return questions[currentQuestionIndex];
    }

    public void nextQuestion() {
        currentQuestionIndex++;
        notifyObserver();
    }

    @Override
    public void registerObserver(QuizObserver o) {
        this.quizObserver = o;
    }

    @Override
    public void removeObserver() {
        this.quizObserver = null;
    }

    @Override
    public void notifyObserver() {
        if (currentQuestionIndex < questions.length) {
            QuizStrategy nextQuestion = questions[currentQuestionIndex];
            quizObserver.onQuestionChanged(nextQuestion);
        } else {
            quizObserver.onQuizCompleted(score);
        }
    }
}
