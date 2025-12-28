import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizLoginPage extends JFrame implements ActionListener {
    // Components of the Form
    private Container container;
    private JLabel titleLabel;
    private JLabel userLabel;
    private JTextField userText;
    private JLabel genderLabel;
    private JRadioButton maleButton;
    private JRadioButton femaleButton;
    private ButtonGroup genderGroup;
    private JButton loginButton;
    private JButton highScoresButton;
    private JButton aboutUsButton;
    private JButton exitButton;
    private JLabel resultLabel;
    private JButton rulesButton;

    // Constructor to initialize the components
    public QuizLoginPage() {
        // Set Look and Feel for a modern look
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        setTitle("Quiz Application Login");
        setBounds(300, 90, 400, 420);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        container = getContentPane();
        container.setLayout(null);
        container.setBackground(new Color(60, 63, 65)); // Dark background

        titleLabel = new JLabel("Quiz Master 1.0");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.CYAN); // Cyan font color
        titleLabel.setSize(200, 30);
        titleLabel.setLocation(100, 20);
        container.add(titleLabel);

        userLabel = new JLabel("Username:");
        userLabel.setFont(new Font("Arial", Font.BOLD, 16));
        userLabel.setForeground(Color.WHITE); // White font color
        userLabel.setSize(100, 20);
        userLabel.setLocation(50, 70);
        container.add(userLabel);

        userText = new JTextField();
        userText.setFont(new Font("Arial", Font.PLAIN, 15));
        userText.setSize(150, 25);
        userText.setLocation(150, 70);
        container.add(userText);

        genderLabel = new JLabel("Gender:");
        genderLabel.setFont(new Font("Arial", Font.BOLD, 16));
        genderLabel.setForeground(Color.WHITE);
        genderLabel.setSize(100, 20);
        genderLabel.setLocation(50, 110);
        container.add(genderLabel);

        maleButton = new JRadioButton("Male");
        maleButton.setFont(new Font("Arial", Font.PLAIN, 15));
        maleButton.setForeground(Color.WHITE);
        maleButton.setBackground(new Color(60, 63, 65)); // Dark background
        maleButton.setSize(75, 20);
        maleButton.setLocation(150, 110);
        container.add(maleButton);

        femaleButton = new JRadioButton("Female");
        femaleButton.setFont(new Font("Arial", Font.PLAIN, 15));
        femaleButton.setForeground(Color.WHITE);
        femaleButton.setBackground(new Color(60, 63, 65)); // Dark background
        femaleButton.setSize(80, 20);
        femaleButton.setLocation(225, 110);
        container.add(femaleButton);

        genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        loginButton = createStyledButton("Start Quiz", 125, 150);
        container.add(loginButton);

        rulesButton = createStyledButton("Rules", 125, 190);
        container.add(rulesButton);

        highScoresButton = createStyledButton("Highest Scores", 125, 230);
        container.add(highScoresButton);

        aboutUsButton = createStyledButton("About Us", 125, 270);
        container.add(aboutUsButton);

        exitButton = createStyledButton("Exit", 125, 310);
        container.add(exitButton);

        resultLabel = new JLabel("");
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        resultLabel.setForeground(Color.YELLOW); // Yellow font color
        resultLabel.setSize(300, 25);
        resultLabel.setLocation(50, 350);
        container.add(resultLabel);

        setVisible(true);
    }

    private JButton createStyledButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 15));
        button.setSize(150, 30);
        button.setLocation(x, y);
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(45, 45, 45));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(true);
        button.addActionListener(this);
        return button;
    }


    // Method actionPerformed()
    // to get the action performed by the user and act accordingly
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String userTextStr = userText.getText().trim();
            if (!userTextStr.isEmpty()) {
                resultLabel.setText("Login successful!");
                dispose(); // Close the login window
                new QuizPage(); // Open the quiz page
            } else {
                resultLabel.setText("Username cannot be empty.");
            }
        } else if (e.getSource() == highScoresButton) {
            JOptionPane.showMessageDialog(this, "Highest Scores:\n1. User1 - 100\n2. User2 - 90", "Highest Scores", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == aboutUsButton) {
            JOptionPane.showMessageDialog(this, "Quiz Application\nVersion 1.0\nDeveloped by Martin Mishev", "About Us", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        } else if (e.getSource() == rulesButton) {
            JOptionPane.showMessageDialog(this, "1. There are four possibilities (A, B, C and D).\n2. You have only 15 seconds for each question.\n3. If you choose a wrong answer - it will become red.\n4. When you complete the the quiz - the results will appear.\nGood luck!", "Rules", JOptionPane.INFORMATION_MESSAGE);
        }
    }

        // Main method
        public static void main(String[] args) {
            new QuizLoginPage();
        }
    }



