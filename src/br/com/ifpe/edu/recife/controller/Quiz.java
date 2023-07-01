package br.com.ifpe.edu.recife.controller;

import br.com.ifpe.edu.recife.model.QuizModel;
import br.com.ifpe.edu.recife.view.QuizMenu;

public class Quiz {
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

        QuizMenu menuview = new QuizMenu();
        MenuController menuController = new MenuController(model, menuview);
        menuview.setController(menuController);


       // QuizGameUI gameView = new QuizGameUI();
        //QuizController controller = new QuizController(model, gameView);
        //model.registerObserver(gameView);




    }
}
