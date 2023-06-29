package br.com.ifpe.edu.recife.controller;

import br.com.ifpe.edu.recife.model.QuizModel;
import br.com.ifpe.edu.recife.quiz.QuizStrategy;
import br.com.ifpe.edu.recife.view.QuizGameUI;

public class QuizController  {
    private QuizModel model;
    private QuizGameUI view;
    public QuizController(QuizModel model, QuizGameUI view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public void startQuiz() {
        QuizStrategy[] questions = model.getQuestions();

        System.out.println(questions[model.getCurrentQuestionIndex()]);
        view.displayQuestion(questions[model.getCurrentQuestionIndex()].getQuestion());
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
