package osproject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class DestroyProcess extends JFrame {
    private JTextField processIdTextField;
    private JTable processDetailsTable;
    private DefaultTableModel tableModel;

    public DestroyProcess() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Destroy a Process");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        processIdTextField = new JTextField();
        processIdTextField.setPreferredSize(new Dimension(120, 30)); // Set preferred size for responsiveness
        JButton destroyButton = new JButton("Destroy");
        destroyButton.setPreferredSize(new Dimension(80, 30));

        tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        processDetailsTable = new JTable(tableModel);
        processDetailsTable.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(processDetailsTable);

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("ULTRA OPERATING SYSTEM", SwingConstants.CENTER));
        topPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(new JLabel("Enter Process ID to destroy:"));
        bottomPanel.add(processIdTextField);
        bottomPanel.add(destroyButton);

        destroyButton.addActionListener(e -> destroyProcess());

        add(topPanel, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.SOUTH);

        displayProcessDetails();
    }

    private void displayProcessDetails() {
        List<MyProcess> createdProcesses = CreateNewProcess.getCreatedProcesses();

        String[] columns = {"Process ID", "Process Name", "Arrival Time", "Burst Time"};

        tableModel.setColumnIdentifiers(columns);

        for (MyProcess process : createdProcesses) {
            Object[] rowData = {
                    process.getProcessId(),
                    process.getProcessName(),
                    process.getArrivalTime(),
                    process.getBurstTime()
            };
            tableModel.addRow(rowData);
        }
    }

    private void destroyProcess() {
        String processId = processIdTextField.getText();

        List<MyProcess> createdProcesses = CreateNewProcess.getCreatedProcesses();
        boolean removed = createdProcesses.removeIf(process -> process.getProcessId().equals(processId));

        if (removed) {
            CreateNewProcess.writeProcessesToFile(createdProcesses);
            JOptionPane.showMessageDialog(this, "Process with ID " + processId + " destroyed.", "Process Destroyed", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Process with ID " + processId + " not found.", "Process Not Found", JOptionPane.WARNING_MESSAGE);
        }

        // Update the displayed details
        updateTableModel();
    }

    private void updateTableModel() {
        tableModel.setRowCount(0);
        displayProcessDetails();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DestroyProcess().setVisible(true));
    }
}
