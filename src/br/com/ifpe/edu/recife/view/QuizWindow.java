package br.com.ifpe.edu.recife.view;
import br.com.ifpe.edu.recife.quiz.QuizObserver;
import br.com.ifpe.edu.recife.controller.QuizController;
import br.com.ifpe.edu.recife.quiz.QuizStrategy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class QuizWindow implements QuizObserver {
    private JFrame frame;
    private JLabel questionLabel;
    private JTextField answerField;
    private JButton submitButton;
    private QuizController controller;

    public QuizWindow() {
        frame = new JFrame("Quiz Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        questionLabel = new JLabel();
        panel.add(questionLabel, BorderLayout.CENTER);

        answerField = new JTextField();
        panel.add(answerField, BorderLayout.SOUTH);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userAnswer = answerField.getText();
                controller.submitAnswer(userAnswer);
            }
        });
        panel.add(submitButton, BorderLayout.EAST);

        frame.add(panel);
        frame.setVisible(true);
    }

    public void setController(QuizController controller) {
        this.controller = controller;
    }

    public void displayQuestion(String question) {
        questionLabel.setText(question);
    }

    public void displayScore(int score) {
        JOptionPane.showMessageDialog(frame, "Quiz Completed!\nYour score: " + score);
        frame.dispose();
    }

    @Override
    public void onQuestionChanged(QuizStrategy question) {
       displayQuestion(question.getQuestion());
    }

    @Override
    public void onQuizCompleted(int score) {
        displayScore(score);
    }
}
