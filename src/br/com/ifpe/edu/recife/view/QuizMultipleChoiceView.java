package br.com.ifpe.edu.recife.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizMultipleChoiceView extends JFrame {
    private JLabel titleLabel;
    private JLabel questionLabel;
    private ButtonGroup answerButtonGroup;
    private JRadioButton option1RadioButton;
    private JRadioButton option2RadioButton;
    private JRadioButton option3RadioButton;
    private JRadioButton option4RadioButton;
    private JButton submitButton;

    public QuizMultipleChoiceView() {
        setTitle("Quiz Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        initComponents();
        pack();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        // Create the main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Create the title label
        titleLabel = new JLabel("Welcome to the Quiz Game!");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        // Create the question label
        questionLabel = new JLabel("Question: What is the capital of France?");
        questionLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        questionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        questionLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        // Create the answer radio buttons
        option1RadioButton = new JRadioButton("Option 1");
        option2RadioButton = new JRadioButton("Option 2");
        option3RadioButton = new JRadioButton("Option 3");
        option4RadioButton = new JRadioButton("Option 4");

        // Create a button group for the answer radio buttons
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
                JOptionPane.showMessageDialog(QuizMultipleChoiceView.this, "Your answer: " + answer);
                clearSelectedAnswer();
            }
        });

        // Add components to the main panel
        mainPanel.add(titleLabel);
        mainPanel.add(questionLabel);
        mainPanel.add(option1RadioButton);
        mainPanel.add(option2RadioButton);
        mainPanel.add(option3RadioButton);
        mainPanel.add(option4RadioButton);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(submitButton);

        // Add the main panel to the frame's content pane
        getContentPane().add(mainPanel);
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new QuizMultipleChoiceView().setVisible(true);
            }
        });
    }
}
