import javax.swing.*;
import java.awt.event.*;

public class CourseAllocationGUI {
    private JFrame frame;
    private JPanel panel;
    private JComboBox<String> courseList;
    private JTextField teacherIDField;
    private JTextArea messageArea;

    public CourseAllocationGUI() {
        frame = new JFrame("Course Allocation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);

        panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel courseLabel = new JLabel("Select Course:");
        courseLabel.setBounds(10, 20, 120, 25);
        panel.add(courseLabel);

        // Sample course list (Replace this with your actual course list)
        String[] courses = {"Course 1", "Course 2", "Course 3"};
        courseList = new JComboBox<>(courses);
        courseList.setBounds(140, 20, 200, 25);
        panel.add(courseList);

        JLabel teacherIDLabel = new JLabel("Teacher ID:");
        teacherIDLabel.setBounds(10, 60, 120, 25);
        panel.add(teacherIDLabel);

        teacherIDField = new JTextField();
        teacherIDField.setBounds(140, 60, 200, 25);
        panel.add(teacherIDField);

        JLabel messageLabel = new JLabel("Message:");
        messageLabel.setBounds(10, 100, 120, 25);
        panel.add(messageLabel);

        messageArea = new JTextArea();
        messageArea.setBounds(140, 100, 300, 100);
        messageArea.setLineWrap(true);
        panel.add(messageArea);

        JButton allocateButton = new JButton("Allocate");
        allocateButton.setBounds(200, 220, 100, 30);
        panel.add(allocateButton);

        allocateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedCourse = (String) courseList.getSelectedItem();
                String teacherID = teacherIDField.getText();
                String message = messageArea.getText();

                // Perform allocation logic here (Not implemented in this simplified example)
                // It should include validation, sending notifications, etc.
                // For now, display a message indicating the allocation process
                JOptionPane.showMessageDialog(frame, "Course: " + selectedCourse +
                        "\nTeacher ID: " + teacherID + "\nMessage: " + message +
                        "\nAllocation process would be performed here.");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CourseAllocationGUI();
            }
        });
    }
}
