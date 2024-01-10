import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class AllocationUpdateGUI extends JFrame {

    private JComboBox<String> allocationComboBox;
    private JTextField updateField;
    private JButton updateButton;
    private JLabel statusLabel;

    private Map<String, String> allocationMap;

    public AllocationUpdateGUI() {
        setTitle("Allocation Update - Staff/Administrator");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        // Allocation ComboBox
        add(new JLabel("Select Allocation:"));
        allocationComboBox = new JComboBox<>();
        add(allocationComboBox);

        // Update Field
        add(new JLabel("Update Details:"));
        updateField = new JTextField();
        add(updateField);

        // Empty label for spacing
        add(new JLabel());
        add(new JLabel());

        // Update Button
        updateButton = new JButton("Update Allocation");
        add(updateButton);
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateAllocation();
            }
        });

        // Status Label
        statusLabel = new JLabel();
        add(statusLabel);

        allocationMap = new HashMap<>(); // In-memory allocation storage
        initializeSampleData();

        updateAllocationComboBox();

        setVisible(true);
    }

    private void updateAllocation() {
        String selectedAllocation = (String) allocationComboBox.getSelectedItem();

        if (selectedAllocation != null) {
            // Get the existing details for the selected allocation
            String existingDetails = allocationMap.get(selectedAllocation);

            // Confirmation dialog
            int dialogResult = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to update the selected allocation?", "Confirmation", JOptionPane.YES_NO_OPTION);

            if (dialogResult == JOptionPane.YES_OPTION) {
                // Update the allocation details
                allocationMap.put(selectedAllocation, updateField.getText());

                // Display success message
                statusLabel.setText("Allocation updated successfully!");

                // Notify affected teachers and students (in a real-world scenario, you would implement this functionality)
                // For simplicity, we just display a message here
                JOptionPane.showMessageDialog(null, "Notification sent to affected teachers and students.");
            } else {
                // Display message if update is canceled
                statusLabel.setText("Update canceled.");
            }
        } else {
            // Display error message if no allocation is selected
            statusLabel.setText("Error: No allocation selected.");
        }
    }

    private void initializeSampleData() {
        // Sample allocation data
        allocationMap.put("Allocation 1", "Details 1");
        allocationMap.put("Allocation 2", "Details 2");
        allocationMap.put("Allocation 3", "Details 3");
    }

    private void updateAllocationComboBox() {
        // Update the allocationComboBox with allocation names
        for (String allocationName : allocationMap.keySet()) {
            allocationComboBox.addItem(allocationName);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AllocationUpdateGUI();
            }
        });
    }
}

