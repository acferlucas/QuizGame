package br.com.ifpe.edu.recife.quiz;

public class QuizQuestionsFactory {
    public QuizStrategy[] createQuestions(String type) {
        QuizStrategy[] questions;

        if(type.equals("regular")) {
            questions = new AnswerQuizStrategy[5];
            questions[0] = new AnswerQuizStrategy("Quanto é 1 + 0", "1");
            questions[1] = new AnswerQuizStrategy("Quanto é 1 + 1", "2");
            questions[2] = new AnswerQuizStrategy("Quanto é 3 + 1", "4");
            questions[3] = new AnswerQuizStrategy("Quanto é 2 + 1", "3");
            questions[4] = new AnswerQuizStrategy("Quanto é 4 + 4", "8");
        }else {
            questions = new MultipleChoiceQuizStrategy[5];
            String[] questionOneOptions = {"1","2", "3", "4"};

            questions[0] = new MultipleChoiceQuizStrategy("Quanto é 1 + 1",questionOneOptions, 1);
            questions[1] = new MultipleChoiceQuizStrategy("Quanto é 2 + 3",questionOneOptions, 1);
            questions[2] = new MultipleChoiceQuizStrategy("Quanto é 1 + 5",questionOneOptions, 1);
            questions[3] = new MultipleChoiceQuizStrategy("Quanto é 2 + 1",questionOneOptions, 1);
            questions[4] = new MultipleChoiceQuizStrategy("Quanto é 9 + 1",questionOneOptions, 1);
        }

        return questions;
    }
}
