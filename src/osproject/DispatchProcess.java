package osproject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class DispatchProcess extends JFrame {
    private JTextField processIdTextField;
    private JTable processDetailsTable;
    private DefaultTableModel tableModel;

    public DispatchProcess() {
        initComponents();
    }

    private void initComponents() {
        // Set up the frame
        setTitle("Dispatch a Process");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize components
        processIdTextField = new JTextField(15); // Set the preferred columns for responsiveness
        JButton dispatchButton = new JButton("Dispatch");
        dispatchButton.setPreferredSize(new Dimension(80, 30)); // Set button size

        // Create the table and set up the model
        tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make the table non-editable
            }
        };
        processDetailsTable = new JTable(tableModel);
        processDetailsTable.getTableHeader().setReorderingAllowed(false); // Disable column reordering
        JScrollPane scrollPane = new JScrollPane(processDetailsTable);

        // Add components to the frame
        setLayout(new BorderLayout());

        // Heading
        JPanel headingPanel = new JPanel(new FlowLayout());
        headingPanel.add(new JLabel("ULTRA OPERATING SYSTEM"));
        add(headingPanel, BorderLayout.NORTH);

        // Input Panel
        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(new JLabel("Enter Process ID to dispatch:"));
        inputPanel.add(processIdTextField);
        inputPanel.add(dispatchButton);

        // Main Content
        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        // Display the details of created processes
        displayProcessDetails();

        dispatchButton.addActionListener(e -> dispatchProcess());
    }

    private void displayProcessDetails() {
        // Retrieve the list of created processes from CreateNewProcess
        List<MyProcess> createdProcesses = CreateNewProcess.getCreatedProcesses();

        // Set up table columns
        String[] columns = {"Process ID", "Process Name", "Arrival Time", "Burst Time", "Process State"};

        // Set column names
        tableModel.setColumnIdentifiers(columns);

        // Clear existing data from the table
        tableModel.setRowCount(0);

        // Add data to the table
        for (MyProcess process : createdProcesses) {
            Object[] rowData = {
                    process.getProcessId(),
                    process.getProcessName(),
                    process.getArrivalTime(),
                    process.getBurstTime(),
                    process.getProcessState()  // Display process state
            };
            tableModel.addRow(rowData);
        }
    }

    private void dispatchProcess() {
        String processId = processIdTextField.getText();

        // Find the process with the given ID and update its state to "Running"
        List<MyProcess> createdProcesses = CreateNewProcess.getCreatedProcesses();
        for (MyProcess process : createdProcesses) {
            if (process.getProcessId().equals(processId)) {
                process.setProcessState("Running");
                break;
            }
        }

        // Update the file immediately
        CreateNewProcess.writeProcessesToFile(createdProcesses);

        JOptionPane.showMessageDialog(this, "Process with ID " + processId + " dispatched.", "Process Dispatched", JOptionPane.INFORMATION_MESSAGE);

        // Update the displayed details
        displayProcessDetails();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DispatchProcess().setVisible(true));
    }
}

