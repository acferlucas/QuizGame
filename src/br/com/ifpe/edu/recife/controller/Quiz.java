package br.com.ifpe.edu.recife.controller;

import br.com.ifpe.edu.recife.model.QuizModel;
import br.com.ifpe.edu.recife.view.QuizMenuView;

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
        QuizOpenQuestionsView view = new QuizOpenQuestionsView();

        QuizOpenQuestionsController controller = new QuizOpenQuestionsController(model, view);
        model.registerObserver(view);



        controller.startQuiz();
        */

        QuizModel model = new QuizModel();

        QuizMenuView menuview = new QuizMenuView();
        MenuController menuController = new MenuController(model, menuview);
        menuview.setController(menuController);


       // QuizOpenQuestionsView gameView = new QuizOpenQuestionsView();
        //QuizOpenQuestionsController controller = new QuizOpenQuestionsController(model, gameView);
        //model.registerObserver(gameView);




    }
}
