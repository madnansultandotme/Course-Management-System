import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClashDetectionGUI extends JFrame {

    private JTextArea clashReportTextArea;

    private List<Course> courseList;

    public ClashDetectionGUI() {
        setTitle("Clash Detection - System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Clash Report TextArea
        clashReportTextArea = new JTextArea();
        clashReportTextArea.setBounds(20, 20, 360, 200);
        clashReportTextArea.setEditable(false);
        add(clashReportTextArea);

        // Detect Clashes Button
        JButton detectClashesButton = new JButton("Detect Clashes");
        detectClashesButton.setBounds(120, 230, 150, 30);
        add(detectClashesButton);
        detectClashesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                detectClashes();
            }
        });

        // Initialize sample data
        initializeSampleData();

        setVisible(true);
    }

    private void detectClashes() {
        // Simulate clash detection algorithm
        List<ClashReport> clashReports = detectClashesAlgorithm();

        // Display clash reports
        displayClashReports(clashReports);
    }

    private List<ClashReport> detectClashesAlgorithm() {
        List<ClashReport> clashReports = new ArrayList<>();

        // Simulate clash detection logic
        // In a real application, you would iterate over the course data and detect clashes

        // Sample clash report
        ClashReport sampleClashReport = new ClashReport("Course 1", "Student 1", "Teacher 1", "Time Clash");
        clashReports.add(sampleClashReport);

        return clashReports;
    }

    private void displayClashReports(List<ClashReport> clashReports) {
        // Display clash reports in the TextArea
        clashReportTextArea.setText("");

        for (ClashReport report : clashReports) {
            clashReportTextArea.append("Course: " + report.getCourse() + "\n");
            clashReportTextArea.append("Student: " + report.getStudent() + "\n");
            clashReportTextArea.append("Teacher: " + report.getTeacher() + "\n");
            clashReportTextArea.append("Nature of Clash: " + report.getClashType() + "\n");
            clashReportTextArea.append("\n-----------------------------\n\n");
        }
    }

    private void initializeSampleData() {
        // Initialize sample course data
        courseList = new ArrayList<>();
        courseList.add(new Course("Course 1", "Student 1", "Teacher 1", "Monday 9:00 AM"));
        courseList.add(new Course("Course 2", "Student 2", "Teacher 2", "Monday 9:00 AM"));
        courseList.add(new Course("Course 3", "Student 3", "Teacher 3", "Tuesday 10:00 AM"));
        courseList.add(new Course("Course 4", "Student 4", "Teacher 4", "Wednesday 2:00 PM"));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClashDetectionGUI();
            }
        });
    }

    // Sample data classes
    private static class Course {
        private String name;
        private String student;
        private String teacher;
        private String schedule;

        public Course(String name, String student, String teacher, String schedule) {
            this.name = name;
            this.student = student;
            this.teacher = teacher;
            this.schedule = schedule;
        }

        public String getName() {
            return name;
        }

        public String getStudent() {
            return student;
        }

        public String getTeacher() {
            return teacher;
        }

        public String getSchedule() {
            return schedule;
        }
    }

    private static class ClashReport {
        private String course;
        private String student;
        private String teacher;
        private String clashType;

        public ClashReport(String course, String student, String teacher, String clashType) {
            this.course = course;
            this.student = student;
            this.teacher = teacher;
            this.clashType = clashType;
        }

        public String getCourse() {
            return course;
        }

        public String getStudent() {
            return student;
        }

        public String getTeacher() {
            return teacher;
        }

        public String getClashType() {
            return clashType;
        }
    }
}
