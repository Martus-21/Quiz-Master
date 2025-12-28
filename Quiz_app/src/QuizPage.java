import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizPage implements ActionListener {

    String[] questions = {
            "When New Bulgarian University was founded?",
            "What is NBU’s motto?",
            "Who is the current rector of NBU?",
            "How many students are enrolled in NBU?",
            "Since 2010, NBU is the home of?",
            "NBU offers tuition in?",
    };

    String[][] answers = {
            {"1981", "1985", "1991", "1993"},
            {"Ne varietatem timeamus.", "Acta non verba.", "Sapientia potentia est.", "Fons vitae caritas."},
            {"Bogdan Bogdanov", "Milcho Leviev", "Alexander Fol", "Plamen Doynov"},
            {"Around 5000", "Around 10000", "Around 15000", "Around 20000"},
            {"The Slug Theater", "The Shark Theater", "The Parrot Theater", "The Panda Theater"},
            {"Bachelor programs", "Master programs", "Doctoral programs", "All of the above"},
    };
    char[] correctAnswers = {'C', 'A', 'D', 'B', 'A', 'D'};

    char guess;
    char answer;
    int index;
    int correct_guesses;
    int total_questions = questions.length;
    int result;
    int time = 15;
    JFrame frame = new JFrame("Quiz");
    JTextField textField = new JTextField();
    JTextArea textArea = new JTextArea();
    JButton buttonA = new JButton("Submit");
    JButton buttonB = new JButton("Submit");
    JButton buttonC = new JButton("Submit");
    JButton buttonD = new JButton("Submit");
    JLabel answerLabelA = new JLabel();
    JLabel answerLabelB = new JLabel();
    JLabel answerLabelC = new JLabel();
    JLabel answerLabelD = new JLabel();
    JLabel timeLabel = new JLabel();
    JLabel seconds_left = new JLabel();
    JTextField number_right = new JTextField();
    JTextField percentage = new JTextField();
    JButton play_again = new JButton("Main Menu");

    Timer timer = new Timer(1000, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            time--;
            seconds_left.setText("" + time);
            if (time <= 0) {
                displayAnswer();
            }
        }
    });

    public QuizPage() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 1440, 850);
        //frame.setSize(500, 500);
        frame.getContentPane().setBackground(new Color(60, 63, 65));
        frame.setLayout(null);
        frame.setResizable(true);
        ImageIcon i1 = null;
        try {
            i1 = new ImageIcon(getClass().getClassLoader().getResource("images/quiz_master.png"));
            if (i1 == null) {
                throw new Exception("Image not found");
            }
        } catch (Exception e) {
            System.err.println("Image not found: " + e.getMessage());
        }

        if (i1 != null) {
            JLabel image = new JLabel(i1);
            image.setBounds(0, 20, 1440, 227);
            frame.add(image);
        }
        textField.setBounds(120, 300, 500, 50);
        textField.setEditable(false);
        textField.setBackground(new Color(30, 30, 30));
        textField.setForeground(Color.WHITE);
        textField.setFont(new Font("Arial", Font.PLAIN, 25));
        textField.setBorder(BorderFactory.createBevelBorder(1));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);
        //textField.setText("Just a test");

        textArea.setBounds(120, 350, 500, 50);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setBackground(new Color(30, 30, 30));
        textArea.setForeground(Color.WHITE);
        textArea.setFont(new Font("Arial", Font.PLAIN, 23));
        textArea.setBorder(BorderFactory.createBevelBorder(1));
        textArea.setEditable(false);
        textArea.setText("QUESTION");

        buttonA.setBounds(120, 400, 50, 50);
        buttonA.setBorderPainted(true);
        buttonA.setFont(new Font("Arial", Font.PLAIN, 23));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        buttonB.setBounds(120, 500, 50, 50);
        buttonB.setFont(new Font("Arial", Font.PLAIN, 23));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        buttonC.setBounds(120, 600, 50, 50);
        buttonC.setFont(new Font("Arial", Font.PLAIN, 23));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        buttonD.setBounds(120, 700, 50, 50);
        buttonD.setFont(new Font("Arial", Font.PLAIN, 23));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");

        answerLabelA.setBounds(245, 380, 500, 100);
        answerLabelA.setBackground(new Color(80, 80, 80));
        answerLabelA.setForeground(Color.WHITE);
        answerLabelA.setFont(new Font("Arial", Font.PLAIN, 23));
        answerLabelA.setText("Yoo 1");

        answerLabelB.setBounds(245, 480, 500, 100);
        answerLabelB.setBackground(new Color(80, 80, 80));
        answerLabelB.setForeground(Color.WHITE);
        answerLabelB.setFont(new Font("Arial", Font.PLAIN, 23));
        answerLabelB.setText("Yoo 2");

        answerLabelC.setBounds(245, 580, 500, 100);
        answerLabelC.setBackground(new Color(80, 80, 80));
        answerLabelC.setForeground(Color.WHITE);
        answerLabelC.setFont(new Font("Arial", Font.PLAIN, 23));
        answerLabelC.setText("Yoo 3");

        answerLabelD.setBounds(245, 680, 500, 100);
        answerLabelD.setBackground(new Color(80, 80, 80));
        answerLabelD.setForeground(Color.WHITE);
        answerLabelD.setFont(new Font("Arial", Font.PLAIN, 23));
        answerLabelD.setText("Yoo 4");

        seconds_left.setBounds(1050, 670, 200, 80);
        seconds_left.setBackground(new Color(80, 80, 80));
        seconds_left.setForeground(Color.WHITE);
        seconds_left.setFont(new Font("Arial", Font.PLAIN, 40));
        //seconds_left.setBorder(BorderFactory.createBevelBorder(1));
        seconds_left.setOpaque(true);
        seconds_left.setHorizontalAlignment(JTextField.CENTER);
        seconds_left.setText(String.valueOf(time));

        timeLabel.setBounds(1050, 600, 200, 80);
        timeLabel.setBackground(new Color(80, 80, 80));
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        timeLabel.setHorizontalAlignment(JTextField.CENTER);
        timeLabel.setText("Seconds left");

        number_right.setBounds(465, 400, 400, 100);
        number_right.setBackground(new Color(80, 80, 80));
        number_right.setForeground(Color.CYAN);
        number_right.setFont(new Font("Arial", Font.PLAIN, 50));
        //number_right.setBorder(BorderFactory.createBevelBorder(1));
        number_right.setHorizontalAlignment(JTextField.CENTER);
        number_right.setEditable(false);

        percentage.setBounds(465, 520, 400, 100);
        percentage.setBackground(new Color(80, 80, 80));
        percentage.setForeground(Color.CYAN);
        percentage.setFont(new Font("Arial", Font.PLAIN, 50));
        //percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);

        play_again.setBounds(465, 640, 400, 100);
        play_again.setBackground(new Color(80, 80, 80));
        play_again.setForeground(Color.CYAN);
        play_again.setFont(new Font("Arial", Font.PLAIN, 50));
        play_again.setHorizontalAlignment(JTextField.CENTER);
        play_again.setFocusable(false);
        play_again.addActionListener(this);

        frame.add(play_again);
        frame.add(number_right);
        frame.add(percentage);
        frame.add(timeLabel);
        frame.add(seconds_left);
        frame.add(answerLabelA);
        frame.add(answerLabelB);
        frame.add(answerLabelC);
        frame.add(answerLabelD);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(textArea);
        frame.add(textField);
        frame.setVisible(true);

        nextQuestion();
    }

    public void nextQuestion() {

        if (index >= total_questions) {
            results();
        } else {
            number_right.setVisible(false);
            percentage.setVisible(false);
            play_again.setVisible(false);
            textField.setVisible(true);
            textArea.setVisible(true);
            seconds_left.setVisible(true);
            timeLabel.setVisible(true);
            buttonA.setVisible(true);
            buttonB.setVisible(true);
            buttonC.setVisible(true);
            buttonD.setVisible(true);
            textField.setText("Question: " + (index + 1));
            textArea.setText(questions[index]);
            answerLabelA.setText(answers[index][0]);
            answerLabelB.setText(answers[index][1]);
            answerLabelC.setText(answers[index][2]);
            answerLabelD.setText(answers[index][3]);
            timer.start();
        }
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttonA || e.getSource() == buttonB || e.getSource() == buttonC || e.getSource() == buttonD) {
            buttonA.setEnabled(false);
            buttonB.setEnabled(false);
            buttonC.setEnabled(false);
            buttonD.setEnabled(false);

            if (e.getSource() == buttonA) {
                answer = 'A';
            } else if (e.getSource() == buttonB) {
                answer = 'B';
            } else if (e.getSource() == buttonC) {
                answer = 'C';
            } else if (e.getSource() == buttonD) {
                answer = 'D';
            }

            if (answer == correctAnswers[index]) {
                correct_guesses++;
            }

            displayAnswer();
        }

        if (e.getSource() == play_again) {

            frame.dispose();
            new QuizLoginPage();
        }
    }

    public void displayAnswer() {

        timer.stop();
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (correctAnswers[index] != 'A') {
            answerLabelA.setForeground(new Color(255, 30, 30));
        }
        if (correctAnswers[index] != 'B') {
            answerLabelB.setForeground(new Color(255, 30, 30));
        }
        if (correctAnswers[index] != 'C') {
            answerLabelC.setForeground(new Color(255, 30, 30));
        }
        if (correctAnswers[index] != 'D') {
            answerLabelD.setForeground(new Color(255, 30, 30));
        }
        Timer pause = new Timer(2000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                answerLabelA.setForeground(Color.WHITE);
                answerLabelB.setForeground(Color.WHITE);
                answerLabelC.setForeground(Color.WHITE);
                answerLabelD.setForeground(Color.WHITE);

                answer = ' ';
                time = 15;
                seconds_left.setText(String.valueOf(time));
                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);
                index++;
                nextQuestion();
            }
        });
        pause.setRepeats(false);
        pause.start();
    }

    public void results() {

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
        number_right.setVisible(true);
        percentage.setVisible(true);
        play_again.setVisible(true);
        buttonA.setVisible(false);
        buttonB.setVisible(false);
        buttonC.setVisible(false);
        buttonD.setVisible(false);
        textField.setVisible(false);
        textArea.setVisible(false);
        seconds_left.setVisible(false);
        timeLabel.setVisible(false);

        result = (int) ((correct_guesses / (double) total_questions) * 100);

        textField.setText("Result: " + result);
        textArea.setText("");
        answerLabelA.setText("");
        answerLabelB.setText("");
        answerLabelC.setText("");
        answerLabelD.setText("");

        number_right.setText("Your result is:");
        percentage.setText(result + " %");
    }

    public static void main(String[] args) {
        new QuizPage();
    }
}