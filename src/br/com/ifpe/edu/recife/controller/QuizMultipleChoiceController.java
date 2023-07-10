package br.com.ifpe.edu.recife.controller;

import br.com.ifpe.edu.recife.model.QuizModel;
import br.com.ifpe.edu.recife.quiz.MultipleChoiceQuizStrategy;
import br.com.ifpe.edu.recife.quiz.QuizStrategy;
import br.com.ifpe.edu.recife.view.QuizMenuView;
import br.com.ifpe.edu.recife.view.QuizMultipleChoiceView;

import javax.swing.*;

public class QuizMultipleChoiceController {
    private QuizModel model;
    private QuizMultipleChoiceView view;
    private QuizMenuView menu;

    public QuizMultipleChoiceController(QuizModel model, QuizMultipleChoiceView view, QuizMenuView menu) {
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
        MultipleChoiceQuizStrategy question = (MultipleChoiceQuizStrategy) model.getCurrentQuestion();
       view.displayQuestion(question.getQuestion(), question.getOptions());
    }

    public void handlerBackMenuButton(JFrame frame) {
        frame.dispose();
        menu.open();
    }
}
