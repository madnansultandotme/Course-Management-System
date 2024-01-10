import javax.swing.*;
import java.awt.event.*;

public class MessageGenerationGUI {
    private JFrame frame;
    private JPanel panel;
    private JComboBox<String> messageType;
    private JTextArea messageContent;
    private JComboBox<String> recipientType;
    private JTextField dateTimeField;
    private JTextField recipientIDField;

    public MessageGenerationGUI() {
        frame = new JFrame("Message Generation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);

        panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel messageTypeLabel = new JLabel("Message Type:");
        messageTypeLabel.setBounds(10, 20, 120, 25);
        panel.add(messageTypeLabel);

        String[] messageTypes = {"Class Reschedule/Cancellation", "Meeting Messages"};
        messageType = new JComboBox<>(messageTypes);
        messageType.setBounds(150, 20, 200, 25);
        panel.add(messageType);

        JLabel recipientLabel = new JLabel("Recipient Type:");
        recipientLabel.setBounds(10, 60, 120, 25);
        panel.add(recipientLabel);

        String[] recipientTypes = {"Students", "Teachers", "Both"};
        recipientType = new JComboBox<>(recipientTypes);
        recipientType.setBounds(150, 60, 200, 25);
        panel.add(recipientType);

        JLabel recipientIDLabel = new JLabel("Recipient ID:");
        recipientIDLabel.setBounds(10, 100, 120, 25);
        panel.add(recipientIDLabel);

        recipientIDField = new JTextField();
        recipientIDField.setBounds(150, 100, 200, 25);
        panel.add(recipientIDField);

        JLabel messageContentLabel = new JLabel("Message Content:");
        messageContentLabel.setBounds(10, 140, 120, 25);
        panel.add(messageContentLabel);

        messageContent = new JTextArea();
        messageContent.setBounds(150, 140, 400, 150);
        messageContent.setLineWrap(true);
        panel.add(messageContent);

        JLabel dateTimeLabel = new JLabel("Date & Time:");
        dateTimeLabel.setBounds(10, 300, 120, 25);
        panel.add(dateTimeLabel);

        dateTimeField = new JTextField();
        dateTimeField.setBounds(150, 300, 200, 25);
        panel.add(dateTimeField);

        JButton sendButton = new JButton("Send Message");
        sendButton.setBounds(230, 350, 150, 30);
        panel.add(sendButton);

        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedMessageType = (String) messageType.getSelectedItem();
                String selectedRecipientType = (String) recipientType.getSelectedItem();
                String recipientID = recipientIDField.getText();
                String message = messageContent.getText();
                String dateTime = dateTimeField.getText();

                // Perform recipient validation logic here (Not implemented in this simplified example)
                // Check if recipient exists; for now, simulate an invalid recipient
                boolean isValidRecipient = checkValidRecipient(recipientID);

                if (!isValidRecipient) {
                    JOptionPane.showMessageDialog(frame, "No Student or Teacher exists!");
                    return;
                }

                // Perform message generation logic here (Not implemented in this simplified example)
                // It should include validation, saving messages, sending notifications, etc.
                // For now, display a message indicating the message generation process
                JOptionPane.showMessageDialog(frame, "Message Type: " + selectedMessageType +
                        "\nRecipient Type: " + selectedRecipientType + "\nRecipient ID: " + recipientID +
                        "\nMessage: " + message + "\nDate & Time: " + dateTime +
                        "\nMessage generation process would be performed here.");
            }
        });
    }

    private boolean checkValidRecipient(String recipientID) {
        // Simulated validation - Replace this with your actual validation logic
        // For demonstration purposes, assuming if ID is not empty, it's valid
        return !recipientID.isEmpty();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MessageGenerationGUI();
            }
        });
    }
}
