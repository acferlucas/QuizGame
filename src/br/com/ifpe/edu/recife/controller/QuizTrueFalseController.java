package br.com.ifpe.edu.recife.controller;

import br.com.ifpe.edu.recife.model.QuizModel;
import br.com.ifpe.edu.recife.quiz.QuizStrategy;
import br.com.ifpe.edu.recife.quiz.TrueFalseQuizStrategy;
import br.com.ifpe.edu.recife.view.QuizMenuView;
import br.com.ifpe.edu.recife.view.QuizTrueFalseView;

import javax.swing.*;

public class QuizTrueFalseController {
    private QuizModel model;
    private QuizTrueFalseView view;
    private QuizMenuView menu;

    public QuizTrueFalseController( QuizModel model, QuizTrueFalseView view, QuizMenuView menu) {
        this.menu = menu;
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public void submitAnswer(String userAnswer) {
        QuizStrategy question = model.getCurrentQuestion();

        boolean isCorrect = question.checkAnswer(userAnswer);
        if (isCorrect) {
            model.incrementScore();
        }else {
            JOptionPane.showMessageDialog(this.view.getFrame(), "Errou!");
        }

        model.nextQuestion();
    }
    public void startQuiz() {
        TrueFalseQuizStrategy question = (TrueFalseQuizStrategy) model.getCurrentQuestion();
        view.displayQuestion(question.getQuestion());
    }

    public void handlerBackMenuButton(JFrame frame) {
        frame.dispose();
        model.reset();
        menu.open();
    }
}
