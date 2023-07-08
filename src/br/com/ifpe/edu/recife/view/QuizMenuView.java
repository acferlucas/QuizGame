package br.com.ifpe.edu.recife.view;

import br.com.ifpe.edu.recife.controller.MenuController;

import javax.swing.*;
import java.awt.*;

public class QuizMenuView {
    private JFrame frame;
    private JLabel titleLabel;
    private JLabel optionLabel;
    private JButton submitButton;
    private JCheckBox multipleChoiceQuizCheckBox;
    private JCheckBox textQuizCheckBox;
    private JCheckBox trueFalseQuizCheckBox;

    private MenuController controller;

    public QuizMenuView() {
        frame = new JFrame("Quiz Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 280);
        frame.setResizable(false);
        initComponents();
        frame.setLocationRelativeTo(null);
    }

    public void setController(MenuController controller) {
        this.controller = controller;
    }

    public void initComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        titleLabel = new JLabel("Bem-Vindo ao Quiz Game !");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        optionLabel = new JLabel("Selecione um o tipo de quiz abaixo :");
        optionLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        optionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        optionLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        textQuizCheckBox = new JCheckBox("Perguntas e respostas");
        textQuizCheckBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        textQuizCheckBox.setFont(new Font("Arial", Font.PLAIN, 16));

        multipleChoiceQuizCheckBox = new JCheckBox("Multipla Escolha");
        multipleChoiceQuizCheckBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        multipleChoiceQuizCheckBox.setFont(new Font("Arial", Font.PLAIN, 16));

        trueFalseQuizCheckBox = new JCheckBox("Verdadeiro e falso");
        trueFalseQuizCheckBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        trueFalseQuizCheckBox.setFont(new Font("Arial", Font.PLAIN, 16));

        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 16));
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.addActionListener(e -> {
            boolean  isTextQuizSelected = textQuizCheckBox.isSelected();
            boolean isMultipleChoiceQuiz = multipleChoiceQuizCheckBox.isSelected();
            boolean isTrueFalseQuiz = trueFalseQuizCheckBox.isSelected();

            controller.start(isTextQuizSelected, isMultipleChoiceQuiz, isTrueFalseQuiz);
        });

        mainPanel.add(titleLabel);
        mainPanel.add(optionLabel);
        mainPanel.add(textQuizCheckBox);
        mainPanel.add(multipleChoiceQuizCheckBox);
        mainPanel.add(trueFalseQuizCheckBox);
        mainPanel.add(Box.createVerticalStrut(4));
        mainPanel.add(submitButton);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    public void close() {
        this.frame.dispose();
    }
}
