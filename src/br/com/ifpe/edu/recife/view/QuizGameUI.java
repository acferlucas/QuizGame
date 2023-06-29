package br.com.ifpe.edu.recife.view;
import br.com.ifpe.edu.recife.quiz.QuizObserver;
import br.com.ifpe.edu.recife.controller.QuizController;
import br.com.ifpe.edu.recife.quiz.QuizStrategy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizGameUI implements QuizObserver {
    private JFrame frame;
    private JLabel titleLabel;
    private JLabel questionLabel;
    private JTextField answerTextField;
    private JButton submitButton;

    private QuizController controller;

    public QuizGameUI() {
        frame = new JFrame("Quiz Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 200);
        frame.setResizable(false);
        initComponents();
        //frame.pack();
        frame.setLocationRelativeTo(null);
    }
    public void setController(QuizController controller) {
        this.controller = controller;
    }

    private void initComponents() {
        // Criação do main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Label com o titulo do app
        titleLabel = new JLabel("Bem-Vindo ao Quiz !");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        // Label que vai receber a pergunta
        questionLabel = new JLabel();
        questionLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        questionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        questionLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        // Input para a resposta do usuario
        answerTextField = new JTextField();
        answerTextField.setFont(new Font("Arial", Font.PLAIN, 16));
        answerTextField.setMaximumSize(new Dimension(300, 30));
        answerTextField.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Botão de submit
        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 16));
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String answer = answerTextField.getText();
                controller.submitAnswer(answer);

                answerTextField.setText("");
            }
        });

        // Montando tudo dentro do panel
        mainPanel.add(titleLabel);
        mainPanel.add(questionLabel);
        mainPanel.add(answerTextField);
        mainPanel.add(Box.createVerticalStrut(4));
        mainPanel.add(submitButton);

        // Add the main panel to the frame's content pane
        frame.add(mainPanel);
        frame.setVisible(true);
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
