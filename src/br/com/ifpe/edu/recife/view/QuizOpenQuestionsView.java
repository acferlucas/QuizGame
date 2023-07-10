package br.com.ifpe.edu.recife.view;

import br.com.ifpe.edu.recife.controller.QuizOpenQuestionsController;
import br.com.ifpe.edu.recife.quiz.QuizObserver;
import br.com.ifpe.edu.recife.quiz.QuizStrategy;

import javax.swing.*;
import java.awt.*;

public class QuizOpenQuestionsView implements QuizObserver {
    private JFrame frame;
    private JLabel titleLabel;
    private JLabel questionLabel;
    private JTextField answerTextField;
    private JButton submitButton;
    private JButton backMenuButton;

    private QuizOpenQuestionsController controller;

    public QuizOpenQuestionsView() {
        frame = new JFrame("Quiz Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 200);
        frame.setResizable(true);
        initComponents();

        frame.setLocationRelativeTo(null);
    }
    public void setController(QuizOpenQuestionsController controller) {
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

        // Botão de voltar
        backMenuButton = new JButton("Voltar");
        backMenuButton.setFont(new Font("Arial", Font.BOLD, 16));
        backMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Criação do panel para alinhar horizontalmente os botões de submit e voltar
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(submitButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPanel.add(backMenuButton);

        submitButton.addActionListener(e -> {
            String answer = answerTextField.getText();
            controller.submitAnswer(answer);
            answerTextField.setText("");
        });

        backMenuButton.addActionListener(e -> controller.handlerBackMenuButton(this.frame));

        mainPanel.add(titleLabel);
        mainPanel.add(questionLabel);
        mainPanel.add(answerTextField);
        mainPanel.add(Box.createVerticalStrut(4));
        mainPanel.add(buttonPanel); // Adiciona o panel de botões ao mainPanel

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    public void displayQuestion(String question) {
        questionLabel.setText(question);
        frame.pack();
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

    public Component getFrame() {
        return this.frame;
    }
}
