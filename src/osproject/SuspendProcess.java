package osproject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class SuspendProcess extends JFrame {
    private JTextField processIdTextField;
    private JTable processDetailsTable;
    private DefaultTableModel tableModel;

    public SuspendProcess() {
        initComponents();
    }

    private void initComponents() {
        // Set up the frame
        setTitle("Suspend a Process");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize components
        processIdTextField = new JTextField();
        processIdTextField.setPreferredSize(new Dimension(200, 30)); // Set a smaller size
        JButton suspendButton = new JButton("Suspend");
        suspendButton.setPreferredSize(new Dimension(80, 30)); // Set button size

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
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(new JLabel("Enter Process ID to suspend:"));
        topPanel.add(processIdTextField);
        topPanel.add(suspendButton);

        add(new JLabel("ULTRA OPERATING SYSTEM", SwingConstants.CENTER), BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(topPanel, BorderLayout.SOUTH);

        // Display the details of created processes
        displayProcessDetails();

        suspendButton.addActionListener(e -> suspendProcess());
    }

    private void displayProcessDetails() {
        // Clear existing rows from the table
        tableModel.setRowCount(0);

        // Retrieve the list of created processes from CreateNewProcess
        List<MyProcess> createdProcesses = CreateNewProcess.getCreatedProcesses();

        // Set up table columns
        String[] columns = {"Process ID", "Process Name", "Arrival Time", "Burst Time", "Process State"};

        // Set column names
        tableModel.setColumnIdentifiers(columns);

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

    private void suspendProcess() {
        String processId = processIdTextField.getText();

        // Find the process with the given ID and set its state to "Suspended"
        List<MyProcess> createdProcesses = CreateNewProcess.getCreatedProcesses();
        for (MyProcess process : createdProcesses) {
            if (process.getProcessId().equals(processId)) {
                process.setProcessState("Suspended");
                break;
            }
        }

        // Update the file immediately
        CreateNewProcess.writeProcessesToFile(createdProcesses);

        JOptionPane.showMessageDialog(this, "Process with ID " + processId + " suspended.", "Process Suspended", JOptionPane.INFORMATION_MESSAGE);

        // Update the displayed details
        displayProcessDetails();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SuspendProcess().setVisible(true));
    }
}

