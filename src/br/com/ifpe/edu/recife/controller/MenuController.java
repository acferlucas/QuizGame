package br.com.ifpe.edu.recife.controller;


import br.com.ifpe.edu.recife.model.QuizModel;
import br.com.ifpe.edu.recife.quiz.QuizQuestionsFactory;
import br.com.ifpe.edu.recife.view.QuizMenuView;
import br.com.ifpe.edu.recife.view.QuizOpenQuestionsView;
import br.com.ifpe.edu.recife.view.QuizMultipleChoiceView;
import br.com.ifpe.edu.recife.view.QuizTrueFalseView;

public class MenuController {
    private QuizMenuView view;
    private QuizModel model;
    private QuizOpenQuestionsView gameView;
    private QuizMultipleChoiceView quizMultipleChoiceView;
    private QuizTrueFalseView quizTrueFalseView;

    public MenuController(QuizModel model, QuizMenuView view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public void loadGameView(String quizType) {
        if(quizType.equals("regular")) {
            this.gameView = new QuizOpenQuestionsView();
            QuizOpenQuestionsController controller = new QuizOpenQuestionsController(model, this.gameView);
            model.registerObserver(this.gameView);
            controller.startQuiz();

        }else if (quizType.equals("multiple")) {
            this.quizMultipleChoiceView = new QuizMultipleChoiceView();
           QuizMultipleChoiceController quizMultipleChoiceController = new QuizMultipleChoiceController(model, quizMultipleChoiceView);
            model.registerObserver(this.quizMultipleChoiceView);
            quizMultipleChoiceController.startQuiz();
        }else if(quizType.equals("trueFalse")){
            this.quizTrueFalseView = new QuizTrueFalseView();
            QuizTrueFalseController quizTrueFalseController = new QuizTrueFalseController(model,quizTrueFalseView);
            model.registerObserver(this.quizTrueFalseView);
            quizTrueFalseController.startQuiz();
        }

        view.close();
    }

    public void start(boolean isTextQuizSelected, boolean isMultipleChoiceQuiz,  boolean isTrueFalseQuiz) {
        String quizType = null;

        if(isTextQuizSelected) {
            quizType = "regular";
        }else if(isMultipleChoiceQuiz) {
            quizType = "multiple";
        }else if(isTrueFalseQuiz) {
            quizType = "trueFalse";
        }

        if(quizType != null) {
            model.setQuestions(new QuizQuestionsFactory().createQuestions(quizType));
            this.loadGameView(quizType);
        }


    }
}
