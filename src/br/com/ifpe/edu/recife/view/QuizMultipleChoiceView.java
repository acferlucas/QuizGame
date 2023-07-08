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
    private JRadioButton option5RadioButton;
    private JButton submitButton;
    private QuizMultipleChoiceController controller;

    public QuizMultipleChoiceView() {
        frame = new JFrame("Quiz Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 260);
        frame.setResizable(true);

        initComponents();

        frame.setLocationRelativeTo(null);
    }

    public void setController(QuizMultipleChoiceController controller) {
        this.controller = controller;
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5, 0, 5, 0);

        titleLabel = new JLabel("Bem-Vindo ao Quiz!");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        mainPanel.add(titleLabel, constraints);

        questionLabel = new JLabel();
        questionLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        constraints.gridy = 1;
        mainPanel.add(questionLabel, constraints);

        option1RadioButton = new JRadioButton();
        constraints.gridy = 2;
        mainPanel.add(option1RadioButton, constraints);

        option2RadioButton = new JRadioButton();
        constraints.gridy = 3;
        mainPanel.add(option2RadioButton, constraints);

        option3RadioButton = new JRadioButton();
        constraints.gridy = 4;
        mainPanel.add(option3RadioButton, constraints);

        option4RadioButton = new JRadioButton();
        constraints.gridy = 5;
        mainPanel.add(option4RadioButton, constraints);

        option5RadioButton = new JRadioButton();
        constraints.gridy = 6;
        mainPanel.add(option5RadioButton, constraints);

        answerButtonGroup = new ButtonGroup();
        answerButtonGroup.add(option1RadioButton);
        answerButtonGroup.add(option2RadioButton);
        answerButtonGroup.add(option3RadioButton);
        answerButtonGroup.add(option4RadioButton);
        answerButtonGroup.add(option5RadioButton);

        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 16));
        constraints.gridx = 0;
        constraints.gridy = 7;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER; // Define o alinhamento horizontal como centro
        mainPanel.add(submitButton, constraints);

        submitButton.addActionListener(e -> {
            String answer = getSelectedAnswer();
            controller.submitAnswer(answer);
            clearSelectedAnswer();
        });

        frame.add(mainPanel);
        frame.setVisible(true);
    }



    private String getSelectedAnswer() {
        if (option1RadioButton.isSelected()) {
            return "0";
        } else if (option2RadioButton.isSelected()) {
            return "1";
        } else if (option3RadioButton.isSelected()) {
            return "2";
        } else if (option4RadioButton.isSelected()) {
            return "3";
        } else if (option5RadioButton.isSelected()) {
            return "4";
        } else {
            return "nothing";
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
        option5RadioButton.setText(options[4]);
        frame.pack();
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
