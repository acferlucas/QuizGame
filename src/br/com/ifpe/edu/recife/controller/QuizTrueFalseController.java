package br.com.ifpe.edu.recife.controller;

import br.com.ifpe.edu.recife.model.QuizModel;
import br.com.ifpe.edu.recife.quiz.MultipleChoiceQuizStrategy;
import br.com.ifpe.edu.recife.quiz.QuizStrategy;
import br.com.ifpe.edu.recife.quiz.TrueFalseQuizStrategy;
import br.com.ifpe.edu.recife.view.QuizTrueFalseView;

public class QuizTrueFalseController {
    private QuizModel model;
    private QuizTrueFalseView view;

    public QuizTrueFalseController( QuizModel model, QuizTrueFalseView view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public void submitAnswer(String userAnswer) {
        QuizStrategy question = model.getCurrentQuestion();

        boolean isCorrect = question.checkAnswer(userAnswer);
        if (isCorrect) {
            model.incrementScore();
        }

        model.nextQuestion();
    }
    public void startQuiz() {
        TrueFalseQuizStrategy question = (TrueFalseQuizStrategy) model.getCurrentQuestion();
        view.displayQuestion(question.getQuestion());
    }

}
