package br.com.ifpe.edu.recife.quiz;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuizQuestionsFactory {
    public List<QuizStrategy> createQuestions(String type) {
        try {
            List<QuizStrategy> questions = new ArrayList<>();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document;

            if (type.equals("regular")) {
                document = builder.parse("src/br/com/ifpe/edu/recife/Openquestions.xml");

                NodeList statement = document.getElementsByTagName("statement");
                NodeList answer = document.getElementsByTagName("answer");

                for (int i = 0; i < statement.getLength(); i++) {
                    Node statementNode = statement.item(i);
                    Node answerNode = answer.item(i);
                    questions.add(new AnswerQuizStrategy(statementNode.getTextContent(), answerNode.getTextContent()));
                }
            } else {
                document = builder.parse("src/br/com/ifpe/edu/recife/MultipleChoiceQuestions.xml");

                NodeList statement = document.getElementsByTagName("statement");
                NodeList options = document.getElementsByTagName("options");
                NodeList answer = document.getElementsByTagName("answerIndex");
                List<String> optionList;

                for (int i = 0; i < statement.getLength(); i++) {
                    Node statementNode = statement.item(i);
                    Node optionNode = options.item(i);
                    Node answerNode = answer.item(i);

                    optionList = Arrays.asList(optionNode.getTextContent().split(";"));

                    questions.add(new MultipleChoiceQuizStrategy(statementNode.getTextContent()
                            , optionList.toArray(new String[0]), Integer.parseInt(answerNode.getTextContent())));
                }
//                String[] mathQuestionOptions = {"1", "2", "3", "5"};
//                String[] geographyQuestionOptions = {"Brazil", "Paris", "Franca", "Italia"};
//
//                questions.add(new MultipleChoiceQuizStrategy("Quanto é 1 + 1", mathQuestionOptions, 1));
//                questions.add(new MultipleChoiceQuizStrategy("Quanto é 2 + 3", mathQuestionOptions, 3));
//                questions.add(new MultipleChoiceQuizStrategy("Quanto é 2 + 1", mathQuestionOptions, 2));
//                questions.add(new MultipleChoiceQuizStrategy("Em que pais nasceu o melhor jogador do mundo pelé ?", geographyQuestionOptions, 0));
//                questions.add(new MultipleChoiceQuizStrategy("Qual país é famoso pela pizza ?", geographyQuestionOptions, 3));
            }
            Collections.shuffle(questions);
            return questions;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
