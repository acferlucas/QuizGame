package br.com.ifpe.edu.recife.quiz;

import br.com.ifpe.edu.recife.factory.MultipleChoiceQuestionsFactory;
import br.com.ifpe.edu.recife.factory.OpenQuestionsFactory;
import br.com.ifpe.edu.recife.factory.TrueOrFalseQuestionsFactory;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizQuestionsInstantiation {
    public List<QuizStrategy> createQuestions(String type) {
        try {
            List<QuizStrategy> questions = new ArrayList<>();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            switch (type) {
                case "regular" -> questions.addAll(OpenQuestionsFactory.instantiate(builder));
                case "multiple" -> questions.addAll(MultipleChoiceQuestionsFactory.instantiate(builder));
                case "trueFalse" -> questions.addAll(TrueOrFalseQuestionsFactory.instantiate(builder));
            }

            enumerateQuestions(questions);

            return questions;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    private void enumerateQuestions(List<QuizStrategy> list) {
        for (int i = 1; i < 11; i++) {
            list.get(i - 1).setQuestion(i + "- " + list.get(i - 1).getQuestion());
        }
    }
}
