package br.com.ifpe.edu.recife.view;

import br.com.ifpe.edu.recife.controller.MenuController;

import javax.swing.*;
import java.awt.*;

public class QuizMenuView {
    private JFrame frame;
    private JLabel titleLabel;
    private JLabel optionLabel;
    private JButton textQuizButton;
    private JButton multipleChoiceQuizButton;
    private JButton trueFalseQuizButton;
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
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        titleLabel = new JLabel("Bem-Vindo ao Quiz Game !");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        optionLabel = new JLabel("Selecione um o tipo de quiz abaixo :");
        optionLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        optionLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        textQuizButton = new JButton("Perguntas e respostas");
        textQuizButton.setFont(new Font("Arial", Font.PLAIN, 16));
        textQuizButton.addActionListener(e -> controller.start("regular"));

        multipleChoiceQuizButton = new JButton("Multipla Escolha");
        multipleChoiceQuizButton.setFont(new Font("Arial", Font.PLAIN, 16));
        multipleChoiceQuizButton.addActionListener(e -> controller.start("multiple"));

        trueFalseQuizButton = new JButton("Verdadeiro e falso");
        trueFalseQuizButton.setFont(new Font("Arial", Font.PLAIN, 16));
        trueFalseQuizButton.addActionListener(e -> controller.start("trueFalse"));

        mainPanel.add(titleLabel);
        mainPanel.add(optionLabel);
        mainPanel.add(textQuizButton);
        mainPanel.add(multipleChoiceQuizButton);
        mainPanel.add(trueFalseQuizButton);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    public void close() {
        this.frame.setVisible(false);
    }

    public void open() {
        this.frame.setVisible(true);
    }
}
