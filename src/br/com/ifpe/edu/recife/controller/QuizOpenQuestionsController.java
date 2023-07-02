package br.com.ifpe.edu.recife.controller;

import br.com.ifpe.edu.recife.model.QuizModel;
import br.com.ifpe.edu.recife.quiz.QuizStrategy;
import br.com.ifpe.edu.recife.view.QuizOpenQuestionsView;

public class QuizOpenQuestionsController {
    private QuizModel model;
    private QuizOpenQuestionsView view;
    public QuizOpenQuestionsController(QuizModel model, QuizOpenQuestionsView view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public void startQuiz() {
        view.displayQuestion(model.getCurrentQuestion().getQuestion());
    }

    public void submitAnswer(String userAnswer) {
        QuizStrategy question =  model.getCurrentQuestion();

        boolean isCorrect = question.checkAnswer(userAnswer);
        if (isCorrect) {
            model.incrementScore();
        }

        model.nextQuestion();
    }
}
