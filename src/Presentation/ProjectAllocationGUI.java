import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class ProjectAllocationGUI extends JFrame {

    private JComboBox<String> courseComboBox;
    private JComboBox<String> projectComboBox;
    private JButton allocateButton;
    private JTextArea resultTextArea;

    private Map<String, String> projectAllocations;

    public ProjectAllocationGUI() {
        setTitle("Project Allocation - Staff/Administrator");
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

        // Project ComboBox
        JLabel projectLabel = new JLabel("Select Project:");
        projectLabel.setBounds(20, 60, 150, 25);
        add(projectLabel);

        String[] projects = {"Project X", "Project Y", "Project Z"};
        projectComboBox = new JComboBox<>(projects);
        projectComboBox.setBounds(180, 60, 150, 25);
        add(projectComboBox);

        // Allocate Button
        allocateButton = new JButton("Allocate Project");
        allocateButton.setBounds(120, 100, 150, 30);
        add(allocateButton);
        allocateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allocateProject();
            }
        });

        // Result TextArea
        resultTextArea = new JTextArea();
        resultTextArea.setBounds(20, 150, 360, 100);
        resultTextArea.setEditable(false);
        add(resultTextArea);

        projectAllocations = new HashMap<>(); // In-memory project allocation storage

        setVisible(true);
    }

    private void allocateProject() {
        String selectedCourse = (String) courseComboBox.getSelectedItem();
        String selectedProject = (String) projectComboBox.getSelectedItem();

        // Simulate server communication or database update
        boolean projectAvailable = checkProjectAvailability(selectedProject);

        if (projectAvailable) {
            // Update course information (simulate updating a database)
            updateCourseInformation(selectedCourse, selectedProject);

            // Display success message
            resultTextArea.setText("Project allocated successfully for " + selectedCourse);
        } else {
            // Display error message for project unavailability
            resultTextArea.setText("Error: Selected project is not available for allocation.");
        }
    }

    private boolean checkProjectAvailability(String project) {
        // Simulate checking project availability
        // In a real application, you might query a database or check other constraints
        return true;
    }

    private void updateCourseInformation(String course, String project) {
        // Simulate updating course information in a database
        // In a real application, you would perform database operations here
        projectAllocations.put(course, project);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProjectAllocationGUI();
            }
        });
    }
}
