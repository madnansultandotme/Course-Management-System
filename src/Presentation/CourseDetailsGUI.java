import javax.swing.*;
import java.awt.event.*;

public class CourseDetailsGUI {
    private JFrame frame;
    private JPanel panel;
    private JList<String> courseList;
    private JTextArea courseDetails;
    private JButton viewDetailsButton;
    private JButton logoutButton;

    public CourseDetailsGUI() {
        frame = new JFrame("Course Details");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel courseLabel = new JLabel("Available Courses:");
        courseLabel.setBounds(10, 20, 120, 25);
        panel.add(courseLabel);

        // Sample course list (Replace this with your actual course list)
        String[] courses = {"Course A", "Course B", "Course C", "Course D"};
        courseList = new JList<>(courses);
        JScrollPane courseScrollPane = new JScrollPane(courseList);
        courseScrollPane.setBounds(140, 20, 200, 150);
        panel.add(courseScrollPane);

        viewDetailsButton = new JButton("View Details");
        viewDetailsButton.setBounds(180, 180, 120, 30);
        panel.add(viewDetailsButton);

        courseDetails = new JTextArea();
        courseDetails.setEditable(false);
        JScrollPane detailsScrollPane = new JScrollPane(courseDetails);
        detailsScrollPane.setBounds(10, 220, 460, 100);
        panel.add(detailsScrollPane);

        logoutButton = new JButton("Logout");
        logoutButton.setBounds(200, 330, 100, 30);
        panel.add(logoutButton);

        viewDetailsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedCourse = courseList.getSelectedValue();
                // Fetch course details based on the selected course (Not implemented in this example)
                // For demonstration purposes, show placeholder details
                String details = "Course: " + selectedCourse + "\nDescription: Sample description for the course.";
                courseDetails.setText(details);
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform logout action (Not implemented in this example)
                // For now, simply exit the application
                frame.dispose();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CourseDetailsGUI();
            }
        });
    }
}
