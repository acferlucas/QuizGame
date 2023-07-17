package br.com.ifpe.edu.recife.factory;

import br.com.ifpe.edu.recife.quiz.TrueFalseQuizStrategy;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TrueOrFalseQuestionsFactory {

    protected TrueOrFalseQuestionsFactory() {
    }

    public static List<TrueFalseQuizStrategy> instantiate(DocumentBuilder builder) throws IOException, SAXException {
        Document document = builder.parse("src/br/com/ifpe/edu/recife/TrueFalsequestions.xml");

        NodeList statement = document.getElementsByTagName("statement");
        NodeList answer = document.getElementsByTagName("answerValue");

        List<TrueFalseQuizStrategy> questions = new ArrayList<>();

        for (int i = 0; i < statement.getLength(); i++) {
            Node statementNode = statement.item(i);
            Node answerNode = answer.item(i);
            questions.add(new TrueFalseQuizStrategy(statementNode.getTextContent(), Boolean.parseBoolean(answerNode.getTextContent())));
        }
        Collections.shuffle(questions);
        return questions;
    }
}
