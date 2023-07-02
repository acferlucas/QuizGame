package br.com.ifpe.edu.recife.controller;

import br.com.ifpe.edu.recife.model.QuizModel;
import br.com.ifpe.edu.recife.quiz.MultipleChoiceQuizStrategy;
import br.com.ifpe.edu.recife.quiz.QuizStrategy;
import br.com.ifpe.edu.recife.view.QuizMultipleChoiceView;

public class QuizMultipleChoiceController {
    private QuizModel model;
    private QuizMultipleChoiceView view;

    public QuizMultipleChoiceController(QuizModel model, QuizMultipleChoiceView view) {
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
        MultipleChoiceQuizStrategy question = (MultipleChoiceQuizStrategy) model.getCurrentQuestion();
       view.displayQuestion(question.getQuestion(), question.getOptions());
    }

}
