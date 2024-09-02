import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class wordCounter extends JFrame implements ActionListener {

    //GUI Components
    private JTextArea wordTextarea;
    private JLabel wordCountLabel;
    private JButton countButton;

    public wordCounter() {

        //Set the JFrame
        setTitle("Word Counter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 200, 450, 300);
        setLocationRelativeTo(null);

        //Initialize Components
        wordTextarea =  new JTextArea();
        wordCountLabel = new JLabel("Word Count: 0");
        countButton = new JButton("Count");

        //Set layout and add the components
        setLayout(new BorderLayout());
        countButton.setBackground(Color.GRAY);
        countButton.setFont(new Font("Arial", Font.BOLD,15));
        countButton.setPreferredSize(new Dimension(40,40));
        wordTextarea.setLineWrap(true);
        wordTextarea.setWrapStyleWord(true);
        wordCountLabel.setFont(new Font("Arial", Font.BOLD,15));
        wordCountLabel.setForeground(Color.pink);

        JScrollPane scrollPane = new JScrollPane(wordTextarea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        add(scrollPane, BorderLayout.CENTER);
        add(wordCountLabel, BorderLayout.SOUTH);
        add(countButton, BorderLayout.NORTH);

        //Add Action Listener to the button
        countButton.addActionListener(this);
    }


    //Action event handler
    @Override
    public void actionPerformed(ActionEvent e) {

        String word = wordTextarea.getText();
        int count = countWords(word);
        wordCountLabel.setText("Word Count: " + count);

    }

    //Method to count words
    private int countWords(String word) {
        if (word == null || word.isEmpty()){
            return 0;
        }

        String[] text = word.trim().split("\\s+");
        return text.length;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new wordCounter().setVisible(true);
        });
    }
}
