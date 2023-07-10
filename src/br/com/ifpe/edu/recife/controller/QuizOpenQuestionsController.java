package br.com.ifpe.edu.recife.controller;

import br.com.ifpe.edu.recife.model.QuizModel;
import br.com.ifpe.edu.recife.quiz.QuizStrategy;
import br.com.ifpe.edu.recife.view.QuizMenuView;
import br.com.ifpe.edu.recife.view.QuizOpenQuestionsView;

import javax.swing.*;

public class QuizOpenQuestionsController {
    private QuizModel model;
    private QuizOpenQuestionsView view;
    private QuizMenuView menu;
    public QuizOpenQuestionsController(QuizModel model, QuizOpenQuestionsView view, QuizMenuView menu) {
        this.menu = menu;
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
        }else {
            JOptionPane.showMessageDialog(this.view.getFrame(), "Errou!");
        }

        model.nextQuestion();
    }

    public void handlerBackMenuButton(JFrame frame) {
        frame.dispose();
        menu.open();
    }
}
