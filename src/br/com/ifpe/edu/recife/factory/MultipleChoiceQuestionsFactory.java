package br.com.ifpe.edu.recife.factory;

import br.com.ifpe.edu.recife.quiz.MultipleChoiceQuizStrategy;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MultipleChoiceQuestionsFactory {

    public static List<MultipleChoiceQuizStrategy> instantiate(DocumentBuilder builder) throws IOException, SAXException {
        Document document = builder.parse("src/br/com/ifpe/edu/recife/MultipleChoiceQuestions.xml");

        NodeList statement = document.getElementsByTagName("statement");
        NodeList options = document.getElementsByTagName("options");
        NodeList answer = document.getElementsByTagName("answerIndex");

        List<MultipleChoiceQuizStrategy> questions = new ArrayList<>();
        List<String> optionList;

        for (int i = 0; i < statement.getLength(); i++) {
            Node statementNode = statement.item(i);
            Node optionNode = options.item(i);
            Node answerNode = answer.item(i);

            optionList = Arrays.asList(optionNode.getTextContent().split(";"));

            questions.add(new MultipleChoiceQuizStrategy(statementNode.getTextContent()
                    , optionList.toArray(new String[0]), Integer.parseInt(answerNode.getTextContent())));
        }
        Collections.shuffle(questions);
        return questions;
    }
}
