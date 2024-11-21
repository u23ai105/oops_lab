package QuizApp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuizApp extends JFrame implements ActionListener {
    private JLabel questionLabel;
    private JRadioButton[] options;
    private ButtonGroup group;
    private JButton submitButton, nextButton, finishButton;
    private int currentQuestion = 0, score = 0;

    // Array of questions
    private final String[] questions = {
        "1. What is the capital of France?",
        "2. Which programming language is known as platform-independent?",
        "3. What is the largest planet in our solar system?",
        "4. Who developed the theory of relativity?"
    };

    // Array of options for each question
    private final String[][] optionsData = {
        {"Berlin", "Madrid", "Paris", "Rome"},
        {"C", "Python", "Java", "Assembly"},
        {"Earth", "Jupiter", "Mars", "Saturn"},
        {"Newton", "Einstein", "Galileo", "Tesla"}
    };

    // Array of correct answers
    private final int[] correctAnswers = {2, 2, 1, 1}; // Indices of correct options

    public QuizApp() {
        // Set up the frame
        setTitle("Quiz Application");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Question panel
        JPanel questionPanel = new JPanel(new BorderLayout());
        questionLabel = new JLabel(questions[currentQuestion], JLabel.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        questionPanel.add(questionLabel, BorderLayout.CENTER);

        // Options panel
        JPanel optionsPanel = new JPanel(new GridLayout(4, 1));
        options = new JRadioButton[4];
        group = new ButtonGroup();

        for (int i = 0; i < options.length; i++) {
            options[i] = new JRadioButton();
            group.add(options[i]);
            optionsPanel.add(options[i]);
        }
        loadQuestion(); // Load the first question

        // Buttons panel
        JPanel buttonPanel = new JPanel();
        submitButton = new JButton("Submit");
        nextButton = new JButton("Next");
        finishButton = new JButton("Finish");

        submitButton.addActionListener(this);
        nextButton.addActionListener(this);
        finishButton.addActionListener(this);

        nextButton.setEnabled(false);
        finishButton.setEnabled(false);

        buttonPanel.add(submitButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(finishButton);

        // Add panels to the frame
        add(questionPanel, BorderLayout.NORTH);
        add(optionsPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void loadQuestion() {
        questionLabel.setText(questions[currentQuestion]);
        for (int i = 0; i < options.length; i++) {
            options[i].setText(optionsData[currentQuestion][i]);
        }
        group.clearSelection();
    }

    private boolean isOptionSelected() {
        for (JRadioButton option : options) {
            if (option.isSelected()) {
                return true;
            }
        }
        return false;
    }

    private int getSelectedOptionIndex() {
        for (int i = 0; i < options.length; i++) {
            if (options[i].isSelected()) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            if (!isOptionSelected()) {
                JOptionPane.showMessageDialog(this, "Please select an option before submitting!");
                return;
            }

            int selectedOption = getSelectedOptionIndex();
            if (selectedOption == correctAnswers[currentQuestion]) {
                score++;
            }

            submitButton.setEnabled(false);
            nextButton.setEnabled(currentQuestion < questions.length - 1);
            finishButton.setEnabled(currentQuestion == questions.length - 1);
        } else if (e.getSource() == nextButton) {
            currentQuestion++;
            loadQuestion();
            submitButton.setEnabled(true);
            nextButton.setEnabled(false);
        } else if (e.getSource() == finishButton) {
            JOptionPane.showMessageDialog(this, "Quiz Finished! Your score: " + score + "/" + questions.length);
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(QuizApp::new);
    }
}