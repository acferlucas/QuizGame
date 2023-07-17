package br.com.ifpe.edu.recife.controller;

import br.com.ifpe.edu.recife.model.QuizModel;
import br.com.ifpe.edu.recife.view.QuizMenuView;

public class Quiz {
    public static void main(String[] args) {
        QuizModel model = new QuizModel();

        QuizMenuView menuview = new QuizMenuView();
        MenuController menuController = new MenuController(model, menuview);
        menuview.setController(menuController);
    }
}
