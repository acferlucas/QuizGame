package br.com.ifpe.edu.recife.factory;

import br.com.ifpe.edu.recife.quiz.AnswerQuizStrategy;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OpenQuestionsFactory {

    protected OpenQuestionsFactory() {
    }

    public static List<AnswerQuizStrategy> instantiate(DocumentBuilder builder) throws IOException, SAXException {
        Document document = builder.parse("src/br/com/ifpe/edu/recife/Openquestions.xml");

        NodeList statement = document.getElementsByTagName("statement");
        NodeList answer = document.getElementsByTagName("answer");

        List<AnswerQuizStrategy> questions = new ArrayList<>();
        for (int i = 0; i < statement.getLength(); i++) {
            Node statementNode = statement.item(i);
            Node answerNode = answer.item(i);
            questions.add(new AnswerQuizStrategy(statementNode.getTextContent(), answerNode.getTextContent()));
        }
        Collections.shuffle(questions);
        return questions;
    }
}
