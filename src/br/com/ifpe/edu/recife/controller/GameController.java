package br.com.ifpe.edu.recife.controller;


import br.com.ifpe.edu.recife.model.QuizModel;
import br.com.ifpe.edu.recife.quiz.QuizFactory;
import br.com.ifpe.edu.recife.view.QuizGameMenu;
import br.com.ifpe.edu.recife.view.QuizGameUI;

public class GameController {
    private QuizGameMenu view;
    private QuizModel model;
    private QuizGameUI gameView;

    public GameController(QuizModel model, QuizGameMenu view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public void loadGameView() {
        this.gameView = new QuizGameUI();
        QuizController controller = new QuizController(model, this.gameView);

        model.registerObserver(this.gameView);

        view.close();
        controller.startQuiz();
    }

    public void start(boolean isTextQuizSelected, boolean isMultipleChoiceQuiz) {
        /*String quizType;
        if(isTextQuizSelected) {
            quizType = "regular";
        }else {
            quizType = "another";
        }*/

        model.setQuestions(new QuizFactory().createQuiz("regular"));
        this.loadGameView();
    }
}
