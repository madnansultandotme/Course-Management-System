import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class CourseUpdateGUI extends JFrame {

    private JComboBox<String> courseComboBox;
    private JTextField detailsField;
    private JTextField scheduleField;
    private JTextField resourcesField;
    private JButton updateButton;
    private JLabel statusLabel;

    private Map<String, Course> courseMap;

    public CourseUpdateGUI() {
        setTitle("Course Update - Staff/Administrator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2));

        // Course ComboBox
        add(new JLabel("Select Course:"));
        courseComboBox = new JComboBox<>();
        add(courseComboBox);

        // Details Field
        add(new JLabel("Course Details:"));
        detailsField = new JTextField();
        add(detailsField);

        // Schedule Field
        add(new JLabel("Course Schedule:"));
        scheduleField = new JTextField();
        add(scheduleField);

        // Resources Field
        add(new JLabel("Allocated Resources:"));
        resourcesField = new JTextField();
        add(resourcesField);

        // Empty label for spacing
        add(new JLabel());
        add(new JLabel());

        // Update Button
        updateButton = new JButton("Update Course");
        add(updateButton);
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateCourse();
            }
        });

        // Status Label
        statusLabel = new JLabel();
        add(statusLabel);

        courseMap = new HashMap<>(); // In-memory course storage
        initializeSampleData();

        updateCourseComboBox();

        setVisible(true);
    }

    private void updateCourse() {
        String selectedCourseName = (String) courseComboBox.getSelectedItem();
        Course selectedCourse = courseMap.get(selectedCourseName);

        if (selectedCourse != null) {
            // Update course details
            selectedCourse.setDetails(detailsField.getText());
            selectedCourse.setSchedule(scheduleField.getText());
            selectedCourse.setResources(resourcesField.getText());

            // Display success message
            statusLabel.setText("Course updated successfully!");
        } else {
            // Display error message if the selected course is not found
            statusLabel.setText("Error: Selected course not found.");
        }
    }

    private void initializeSampleData() {
        // Sample course data
        Course course1 = new Course("Course A", "Details A", "Schedule A", "Resources A");
        Course course2 = new Course("Course B", "Details B", "Schedule B", "Resources B");

        courseMap.put(course1.getName(), course1);
        courseMap.put(course2.getName(), course2);
    }

    private void updateCourseComboBox() {
        // Update the courseComboBox with course names
        for (String courseName : courseMap.keySet()) {
            courseComboBox.addItem(courseName);
        }
    }

    private static class Course {
        private String name;
        private String details;
        private String schedule;
        private String resources;

        public Course(String name, String details, String schedule, String resources) {
            this.name = name;
            this.details = details;
            this.schedule = schedule;
            this.resources = resources;
        }

        public String getName() {
            return name;
        }

        public String getDetails() {
            return details;
        }

        public String getSchedule() {
            return schedule;
        }

        public String getResources() {
            return resources;
        }

        public void setDetails(String details) {
            this.details = details;
        }

        public void setSchedule(String schedule) {
            this.schedule = schedule;
        }

        public void setResources(String resources) {
            this.resources = resources;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CourseUpdateGUI();
            }
        });
    }
}
