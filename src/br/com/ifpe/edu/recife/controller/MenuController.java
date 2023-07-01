package br.com.ifpe.edu.recife.controller;


import br.com.ifpe.edu.recife.model.QuizModel;
import br.com.ifpe.edu.recife.quiz.QuizQuestionsFactory;
import br.com.ifpe.edu.recife.view.QuizMenu;
import br.com.ifpe.edu.recife.view.QuizGameUI;
import br.com.ifpe.edu.recife.view.QuizMultipleChoiceView;

public class MenuController {
    private QuizMenu view;
    private QuizModel model;
    private QuizGameUI gameView;
    private QuizMultipleChoiceView quizMultipleChoiceView;

    public MenuController(QuizModel model, QuizMenu view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public void loadGameView(String quizType) {
        if(quizType.equals("regular")) {
            this.gameView = new QuizGameUI();
            QuizController controller = new QuizController(model, this.gameView);
            model.registerObserver(this.gameView);
            controller.startQuiz();

        }else if (quizType.equals("multiple")) {
            this.quizMultipleChoiceView = new QuizMultipleChoiceView();
           QuizMultipleChoiceController quizMultipleChoiceController = new QuizMultipleChoiceController(model, quizMultipleChoiceView);
            model.registerObserver(this.gameView);
            quizMultipleChoiceController.startQuiz();
        }else {
            System.out.println("default option selected");
        }

        view.close();
    }

    public void start(boolean isTextQuizSelected, boolean isMultipleChoiceQuiz) {
        String quizType;

        if(isTextQuizSelected) {
            quizType = "regular";
        }else if(isMultipleChoiceQuiz) {
            quizType = "multiple";
        }else {
            quizType = "default";
        }

        model.setQuestions(new QuizQuestionsFactory().createQuestions(quizType));
        this.loadGameView(quizType);
    }
}
