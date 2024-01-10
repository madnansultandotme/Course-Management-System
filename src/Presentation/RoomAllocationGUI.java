import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoomAllocationGUI extends JFrame {

    private JComboBox<String> courseComboBox;
    private JComboBox<String> roomComboBox;
    private JButton allocateButton;
    private JTextArea resultTextArea;

    public RoomAllocationGUI() {
        setTitle("Room Allocation - Staff/Administrator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Course ComboBox
        JLabel courseLabel = new JLabel("Select Course:");
        courseLabel.setBounds(20, 20, 150, 25);
        add(courseLabel);

        String[] courses = {"Course A", "Course B", "Course C"};
        courseComboBox = new JComboBox<>(courses);
        courseComboBox.setBounds(180, 20, 150, 25);
        add(courseComboBox);

        // Room ComboBox
        JLabel roomLabel = new JLabel("Select Room:");
        roomLabel.setBounds(20, 60, 150, 25);
        add(roomLabel);

        String[] rooms = {"Room 101", "Room 102", "Room 103"};
        roomComboBox = new JComboBox<>(rooms);
        roomComboBox.setBounds(180, 60, 150, 25);
        add(roomComboBox);

        // Allocate Button
        allocateButton = new JButton("Allocate Room");
        allocateButton.setBounds(120, 100, 150, 30);
        add(allocateButton);
        allocateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allocateRoom();
            }
        });

        // Result TextArea
        resultTextArea = new JTextArea();
        resultTextArea.setBounds(20, 150, 360, 100);
        resultTextArea.setEditable(false);
        add(resultTextArea);

        setVisible(true);
    }

    private void allocateRoom() {
        String selectedCourse = (String) courseComboBox.getSelectedItem();
        String selectedRoom = (String) roomComboBox.getSelectedItem();

        // Simulate server communication or database update
        boolean roomAvailable = checkRoomAvailability(selectedRoom);

        if (roomAvailable) {
            // Update course information (simulate updating a database)
            updateCourseInformation(selectedCourse, selectedRoom);

            // Display success message
            resultTextArea.setText("Room allocated successfully for " + selectedCourse);
        } else {
            // Display error message for room unavailability
            resultTextArea.setText("Error: Selected room is not available at the specified time.");
        }
    }

    private boolean checkRoomAvailability(String room) {
        // Simulate checking room availability
        // In a real application, you might query a database or check other constraints
        return true;
    }

    private void updateCourseInformation(String course, String room) {
        // Simulate updating course information in a database
        // In a real application, you would perform database operations here
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RoomAllocationGUI();
            }
        });
    }
}
