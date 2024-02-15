package osproject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PCB extends JFrame {
    private JTable pcbTable;
    private DefaultTableModel tableModel;

    public PCB() {
        initComponents();
    }

    private void initComponents() {
        // Set up the frame
        setTitle("Process Control Block (PCB)");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the table and set up the model
        tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make the table non-editable
            }
        };
        pcbTable = new JTable(tableModel);
        pcbTable.getTableHeader().setReorderingAllowed(false); // Disable column reordering
        JScrollPane scrollPane = new JScrollPane(pcbTable);

        // Add components to the frame
        setLayout(new BorderLayout());

        // Heading
        JPanel headingPanel = new JPanel(new FlowLayout());
        headingPanel.add(new JLabel("ULTRA OPERATING SYSTEM"));
        add(headingPanel, BorderLayout.NORTH);

        // Main Content
        add(scrollPane, BorderLayout.CENTER);

        // Display the initial PCB details
        displayPCB();

        // Set up a timer to refresh the PCB details every few seconds
        Timer timer = new Timer(5000, e -> displayPCB());
        timer.setRepeats(true);
        timer.start();
    }

    private void displayPCB() {
        // Retrieve the list of created processes from CreateNewProcess
        List<MyProcess> createdProcesses = CreateNewProcess.getCreatedProcesses();

        // Set up table columns
        String[] columns = {"Process ID", "Process Name", "Process State", "Process Priority"};

        // Set column names
        tableModel.setColumnIdentifiers(columns);

        // Clear existing rows in the tableModel
        tableModel.setRowCount(0);

        // Add data to the table
        for (MyProcess process : createdProcesses) {
            Object[] rowData = {
                    process.getProcessId(),
                    process.getProcessName(),
                    process.getProcessState(),
                    process.getProcessPriorityAsString() // Use the string representation of priority
            };
            tableModel.addRow(rowData);
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PCB().setVisible(true));
    }
}

