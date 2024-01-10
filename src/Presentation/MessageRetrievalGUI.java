import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MessageRetrievalGUI extends JFrame {

    private JTextArea messageTextArea;

    private List<String> messages;

    public MessageRetrievalGUI() {
        setTitle("Message Retrieval - User (Student or Teacher)");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Message TextArea
        messageTextArea = new JTextArea();
        messageTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(messageTextArea);
        add(scrollPane, BorderLayout.CENTER);

        // Get Messages Button
        JButton getMessagesButton = new JButton("Get Messages");
        add(getMessagesButton, BorderLayout.SOUTH);
        getMessagesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getMessages();
            }
        });

        messages = new ArrayList<>(); // In-memory message storage
        initializeSampleData();

        setVisible(true);
    }

    private void getMessages() {
        // Clear previous messages
        messageTextArea.setText("");

        // Display messages in the TextArea
        for (String message : messages) {
            messageTextArea.append(message + "\n");
        }
    }

    private void initializeSampleData() {
        // Sample messages
        messages.add("Class rescheduled to tomorrow at 10 AM.");
        messages.add("Meeting canceled for this week.");
        messages.add("New assignment posted. Check the course website for details.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MessageRetrievalGUI();
            }
        });
    }
}
