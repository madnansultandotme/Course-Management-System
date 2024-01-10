import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class AllocationDeletionGUI extends JFrame {

    private JComboBox<String> allocationComboBox;
    private JButton deleteButton;
    private JLabel statusLabel;

    private Map<String, String> allocationMap;

    public AllocationDeletionGUI() {
        setTitle("Allocation Deletion - Staff/Administrator");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        // Allocation ComboBox
        add(new JLabel("Select Allocation:"));
        allocationComboBox = new JComboBox<>();
        add(allocationComboBox);

        // Empty label for spacing
        add(new JLabel());
        add(new JLabel());

        // Delete Button
        deleteButton = new JButton("Delete Allocation");
        add(deleteButton);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteAllocation();
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

    private void deleteAllocation() {
        String selectedAllocation = (String) allocationComboBox.getSelectedItem();

        if (selectedAllocation != null) {
            // Confirmation dialog
            int dialogResult = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to delete the selected allocation?", "Confirmation", JOptionPane.YES_NO_OPTION);

            if (dialogResult == JOptionPane.YES_OPTION) {
                // Delete the allocation
                allocationMap.remove(selectedAllocation);

                // Display success message
                statusLabel.setText("Allocation deleted successfully!");
            } else {
                // Display message if deletion is canceled
                statusLabel.setText("Deletion canceled.");
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
                new AllocationDeletionGUI();
            }
        });
    }
}
