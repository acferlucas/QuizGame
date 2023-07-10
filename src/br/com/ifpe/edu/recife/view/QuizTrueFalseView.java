package br.com.ifpe.edu.recife.view;

import br.com.ifpe.edu.recife.controller.QuizTrueFalseController;
import br.com.ifpe.edu.recife.quiz.QuizObserver;
import br.com.ifpe.edu.recife.quiz.QuizStrategy;

import javax.swing.*;
import java.awt.*;

public class QuizTrueFalseView implements QuizObserver {
    private JFrame frame;
    private JLabel titleLabel;
    private JLabel questionLabel;
    private ButtonGroup answerButtonGroup;
    private JRadioButton trueOption;
    private JRadioButton falseOption;
    private JButton submitButton;
    private JButton backMenuButton;
    private QuizTrueFalseController controller;

    public QuizTrueFalseView() {
        frame = new JFrame("Quiz Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 200);
        frame.setResizable(true);

        initComponents();

        frame.setLocationRelativeTo(null);
    }
    public void setController(QuizTrueFalseController controller) {
        this.controller = controller;
    }

    public void displayQuestion(String question) {
        questionLabel.setText(question);
        frame.pack();
    }

    public void initComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        titleLabel = new JLabel("Bem-Vindo ao Quiz !");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        questionLabel = new JLabel();
        questionLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        questionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        questionLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        trueOption = new JRadioButton();
        trueOption.setText("Verdadeiro");
        falseOption = new JRadioButton();
        falseOption.setText("Falso");

        JPanel radioButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Align radio buttons at the center
        radioButtonPanel.add(trueOption);
        radioButtonPanel.add(falseOption);

        answerButtonGroup = new ButtonGroup();
        answerButtonGroup.add(trueOption);
        answerButtonGroup.add(falseOption);

        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 16));
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.addActionListener(e -> {
            String answer = null;
            if (trueOption.isSelected()) {
                answer = "true";
            } else if (falseOption.isSelected()) {
                answer = "false";
            }

            controller.submitAnswer(answer);
            answerButtonGroup.clearSelection();
        });

        backMenuButton = new JButton("Voltar");
        backMenuButton.setFont(new Font("Arial", Font.BOLD, 16));
        backMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backMenuButton.addActionListener(e -> {
            controller.handlerBackMenuButton(this.frame);
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(submitButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPanel.add(backMenuButton);

        mainPanel.add(titleLabel);
        mainPanel.add(questionLabel);
        mainPanel.add(radioButtonPanel);
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(buttonPanel);

        frame.add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return this.frame;
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
