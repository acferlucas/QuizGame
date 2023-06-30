package br.com.ifpe.edu.recife.controller;

import br.com.ifpe.edu.recife.model.QuizModel;
import br.com.ifpe.edu.recife.quiz.AnswerQuizStrategy;
import br.com.ifpe.edu.recife.view.QuizGameMenu;
import br.com.ifpe.edu.recife.view.QuizGameUI;
import br.com.ifpe.edu.recife.view.QuizWindow;

public class QuizControllerMain {
    public static void main(String[] args) {
        /*QuizModel model = new QuizModel();

        AnswerQuizStrategy[] questions = {
                new AnswerQuizStrategy("Quem foi pelé ?", "A"),
                new AnswerQuizStrategy("Quem foi pelé ?", "A"),
                new AnswerQuizStrategy("Quem foi pelé ?", "A"),
                new AnswerQuizStrategy("Quem foi pelé ?", "D"),
        };

        model.setQuestions(questions);
        QuizGameUI view = new QuizGameUI();

        QuizController controller = new QuizController(model, view);
        model.registerObserver(view);



        controller.startQuiz();
        */

        QuizModel model = new QuizModel();

        QuizGameMenu menuview = new QuizGameMenu();
        GameController gameController = new GameController(model, menuview);
        menuview.setController(gameController);


       // QuizGameUI gameView = new QuizGameUI();
        //QuizController controller = new QuizController(model, gameView);
        //model.registerObserver(gameView);




    }
}
