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
            String[] mathQuestionOptions = {"1","2", "3", "5"};
            String[] geographyQuestionOptions = {"Brazil","Paris", "Franca", "Italia"};

            questions[0] = new MultipleChoiceQuizStrategy("Quanto é 1 + 1",mathQuestionOptions, 1);
            questions[1] = new MultipleChoiceQuizStrategy("Quanto é 2 + 3",mathQuestionOptions, 3);
            questions[2] = new MultipleChoiceQuizStrategy("Quanto é 2 + 1",mathQuestionOptions, 2);
            questions[3] = new MultipleChoiceQuizStrategy("Em que pais nasceu o melhor jogador do mundo pelé ?",geographyQuestionOptions, 0);
            questions[4] = new MultipleChoiceQuizStrategy("Qual país é famoso pela pizza ?",geographyQuestionOptions, 3);
        }

        return questions;
    }
}
