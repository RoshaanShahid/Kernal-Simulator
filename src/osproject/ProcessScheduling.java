package osproject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProcessScheduling extends JFrame {
    private JTabbedPane tabbedPane;
    private DefaultTableModel fcfsTableModel;
    private DefaultTableModel sjfTableModel;
    private DefaultTableModel roundRobinTableModel;

    public ProcessScheduling() {
        initComponents();
    }

    private void initComponents() {
        // Set up the frame
        setTitle("Process Scheduling");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create tabbed pane
        tabbedPane = new JTabbedPane();

        // Create tabs for each scheduling algorithm
        fcfsTableModel = createTableModel();
        tabbedPane.addTab("FCFS", createTablePanel(fcfsTableModel));

        sjfTableModel = createTableModel();
        tabbedPane.addTab("SJF", createTablePanel(sjfTableModel));

        roundRobinTableModel = createTableModel();
        tabbedPane.addTab("Round Robin", createTablePanel(roundRobinTableModel));

        // Add a change listener to the tabbedPane to handle the Round Robin tab selection
        tabbedPane.addChangeListener(e -> {
            if (tabbedPane.getSelectedIndex() == 2) { // Index 2 represents the Round Robin tab
                // Calculate and display Round Robin details when the tab is selected
                roundRobinTableModel.setRowCount(0); // Clear existing data
                int timeQuantum = getTimeQuantum();
                calculateRoundRobin(CreateNewProcess.getCreatedProcesses(), roundRobinTableModel, timeQuantum);
            }
        });

        // Add components to the frame
        setLayout(new BorderLayout());
        add(tabbedPane, BorderLayout.CENTER);

        // Calculate and display scheduling details
        calculateSchedulingDetails();
    }

    private DefaultTableModel createTableModel() {
        String[] columns = {"Process ID", "Process Name", "Arrival Time", "Burst Time", "Completion Time", "Turnaround Time", "Waiting Time"};
        return new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make the table non-editable
            }
        };
    }

    private JPanel createTablePanel(DefaultTableModel tableModel) {
        JTable schedulingTable = new JTable(tableModel);
        schedulingTable.getTableHeader().setReorderingAllowed(false); // Disable column reordering
        JScrollPane scrollPane = new JScrollPane(schedulingTable);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    private void calculateSchedulingDetails() {
        // Retrieve the list of created processes from CreateNewProcess
        List<MyProcess> createdProcesses = CreateNewProcess.getCreatedProcesses();

        // Calculate and display FCFS details
        calculateFCFS(createdProcesses, fcfsTableModel);

        // Calculate and display SJF details
        calculateSJF(createdProcesses, sjfTableModel);

        // Calculate and display Round Robin details (initially with time quantum as 10)
        calculateRoundRobin(createdProcesses, roundRobinTableModel, 10);
    }

    private void calculateFCFS(List<MyProcess> processes, DefaultTableModel tableModel) {
        // Sort processes based on process ID
        Collections.sort(processes, Comparator.comparingInt(p -> Integer.parseInt(p.getProcessId().substring(1))));

        // Calculate completion time, turnaround time, and waiting time for FCFS
        int completionTime = 0;
        for (MyProcess process : processes) {
            try {
                int burstTime = Integer.parseInt(process.getBurstTime());
                completionTime = Math.max(completionTime, process.getArrivalTimeAsInt()) + burstTime;
                int turnaroundTime = completionTime - process.getArrivalTimeAsInt();
                int waitingTime = turnaroundTime - burstTime;

                // Add data to the table
                Object[] rowData = {
                        process.getProcessId(),
                        process.getProcessName(),
                        process.getArrivalTime(),
                        process.getBurstTime(),
                        completionTime,
                        turnaroundTime,
                        waitingTime
                };
                tableModel.addRow(rowData);
            } catch (NumberFormatException e) {
                // Handle invalid burst time
                JOptionPane.showMessageDialog(this, "Invalid burst time for Process " + process.getProcessId());
            }
        }
    }

    private void calculateSJF(List<MyProcess> processes, DefaultTableModel tableModel) {
        // Sort processes based on arrival time and burst time (Shortest Job First)
        Collections.sort(processes, Comparator.comparingInt(MyProcess::getArrivalTimeAsInt).thenComparingInt(p -> Integer.parseInt(p.getBurstTime())));

        // Calculate completion time, turnaround time, and waiting time for SJF
        int completionTime = 0;
        for (MyProcess process : processes) {
            try {
                int burstTime = Integer.parseInt(process.getBurstTime());
                completionTime = Math.max(completionTime, process.getArrivalTimeAsInt()) + burstTime;
                int turnaroundTime = completionTime - process.getArrivalTimeAsInt();
                int waitingTime = turnaroundTime - burstTime;

                // Add data to the table
                Object[] rowData = {
                        process.getProcessId(),
                        process.getProcessName(),
                        process.getArrivalTime(),
                        process.getBurstTime(),
                        completionTime,
                        turnaroundTime,
                        waitingTime
                };
                tableModel.addRow(rowData);
            } catch (NumberFormatException e) {
                // Handle invalid burst time
                JOptionPane.showMessageDialog(this, "Invalid burst time for Process " + process.getProcessId());
            }
        }
    }

    private void calculateRoundRobin(List<MyProcess> processes, DefaultTableModel tableModel, int timeQuantum) {
        // Sort processes based on arrival time (Round Robin)
        Collections.sort(processes, Comparator.comparingInt(MyProcess::getArrivalTimeAsInt));

        // Initialize variables for Round Robin calculation
        int currentTime = 0;
        int totalProcesses = processes.size();
        int[] remainingBurstTime = new int[totalProcesses];
        boolean[] completed = new boolean[totalProcesses];

        // Initialize arrays
        for (int i = 0; i < totalProcesses; i++) {
            remainingBurstTime[i] = Integer.parseInt(processes.get(i).getBurstTime());
            completed[i] = false;
        }

        // Check if time quantum is 0
        if (timeQuantum <= 0) {
            JOptionPane.showMessageDialog(this, "Time quantum should be greater than 0. Default time quantum will be used.");
            timeQuantum = 10; // Default time quantum
        }

        // Perform Round Robin scheduling
        while (true) {
            boolean allProcessesComplete = true;

            for (int i = 0; i < totalProcesses; i++) {
                if (!completed[i]) {
                    allProcessesComplete = false;

                    // Execute the process for the time quantum or remaining burst time, whichever is smaller
                    int executionTime = Math.min(timeQuantum, remainingBurstTime[i]);
                    currentTime += executionTime;
                    remainingBurstTime[i] -= executionTime;

                    // Check if the process is completed
                    if (remainingBurstTime[i] <= 0) {
                        completed[i] = true;

                        // Calculate turnaround time and waiting time
                        int turnaroundTime = currentTime - processes.get(i).getArrivalTimeAsInt();
                        int waitingTime = Math.max(0, turnaroundTime - Integer.parseInt(processes.get(i).getBurstTime()));

                        // Add data to the table
                        Object[] rowData = {
                                processes.get(i).getProcessId(),
                                processes.get(i).getProcessName(),
                                processes.get(i).getArrivalTime(),
                                processes.get(i).getBurstTime(),
                                currentTime,
                                turnaroundTime,
                                waitingTime
                        };
                        tableModel.addRow(rowData);
                    }
                }
            }

            // Break the loop if all processes are completed
            if (allProcessesComplete) {
                break;
            }
        }
    }



    private int getTimeQuantum() {
        // Prompt the user for the time quantum using JOptionPane
        String input = JOptionPane.showInputDialog("Enter Time Quantum for Round Robin:");
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            // Handle invalid input
            JOptionPane.showMessageDialog(this, "Invalid input. Default time quantum will be used.");
            return 10; // Default time quantum
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProcessScheduling().setVisible(true));
    }
}