package br.com.ifpe.edu.recife.view;

import br.com.ifpe.edu.recife.controller.QuizMultipleChoiceController;
import br.com.ifpe.edu.recife.quiz.MultipleChoiceQuizStrategy;
import br.com.ifpe.edu.recife.quiz.QuizObserver;
import br.com.ifpe.edu.recife.quiz.QuizStrategy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizMultipleChoiceView implements QuizObserver {
    private JFrame frame;
    private JLabel titleLabel;
    private JLabel questionLabel;
    private ButtonGroup answerButtonGroup;
    private JRadioButton option1RadioButton;
    private JRadioButton option2RadioButton;
    private JRadioButton option3RadioButton;
    private JRadioButton option4RadioButton;
    private JButton submitButton;
    private QuizMultipleChoiceController controller;

    public QuizMultipleChoiceView() {
        frame = new JFrame("Quiz Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 250);
        frame.setResizable(false);

        initComponents();

        frame.setLocationRelativeTo(null);
    }

    public void setController(QuizMultipleChoiceController controller) {
        this.controller = controller;
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        titleLabel = new JLabel("Bem-Vindo ao Quiz!");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        questionLabel = new JLabel();
        questionLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        questionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        questionLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        // Create the answer radio buttons
        option1RadioButton = new JRadioButton();
        option2RadioButton = new JRadioButton();
        option3RadioButton = new JRadioButton();
        option4RadioButton = new JRadioButton();

        answerButtonGroup = new ButtonGroup();
        answerButtonGroup.add(option1RadioButton);
        answerButtonGroup.add(option2RadioButton);
        answerButtonGroup.add(option3RadioButton);
        answerButtonGroup.add(option4RadioButton);

        // Create the submit button
        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 16));
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String answer = getSelectedAnswer();
                // Process the submitted answer here
                // ...
                JOptionPane.showMessageDialog(frame, "Your answer: " + answer);
                clearSelectedAnswer();
            }
        });

        mainPanel.add(titleLabel);
        mainPanel.add(questionLabel);
        mainPanel.add(option1RadioButton);
        mainPanel.add(option2RadioButton);
        mainPanel.add(option3RadioButton);
        mainPanel.add(option4RadioButton);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(submitButton);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private String getSelectedAnswer() {
        if (option1RadioButton.isSelected()) {
            return "Option 1";
        } else if (option2RadioButton.isSelected()) {
            return "Option 2";
        } else if (option3RadioButton.isSelected()) {
            return "Option 3";
        } else if (option4RadioButton.isSelected()) {
            return "Option 4";
        } else {
            return "";
        }
    }

    private void clearSelectedAnswer() {
        answerButtonGroup.clearSelection();
    }

    public void displayQuestion(String question, String[] options) {
        questionLabel.setText(question);

        option1RadioButton.setText(options[0]);
        option2RadioButton.setText(options[1]);
        option3RadioButton.setText(options[2]);
        option4RadioButton.setText(options[3]);
    }

    public void displayScore(int score) {
        JOptionPane.showMessageDialog(frame, "Quiz Completed!\nYour score: " + score);
        frame.dispose();
    }

    @Override
    public void onQuestionChanged(QuizStrategy question) {
        displayQuestion(question.getQuestion(), ((MultipleChoiceQuizStrategy) question).getOptions());
    }

    @Override
    public void onQuizCompleted(int score) {
        displayScore(score);
    }
}
