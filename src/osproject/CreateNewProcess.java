package osproject;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateNewProcess extends JFrame {
    private JTextField processIdTextField;
    private JTextField processNameTextField;
    private JComboBox<String> processStateComboBox;
    private JComboBox<String> priorityComboBox;
    private JTextField arrivalTimeTextField;
    private JTextField burstTimeTextField;
    private JButton createButton;
    private JButton resetButton;

    // Add a static list to store created processes
    private static List<MyProcess> createdProcesses = new ArrayList<>();

    public static void writeProcessesToFile(List<MyProcess> processes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("processes.txt"))) {
            for (MyProcess process : processes) {
                writer.write(process.getProcessId() + ","
                        + process.getProcessName() + ","
                        + process.getProcessState() + ","
                        + process.getPriority() + ","
                        + process.getArrivalTime() + ","
                        + process.getBurstTime());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }
    }

    public CreateNewProcess() {
        initComponents();
        customizeInterface();
    }

    public static List<MyProcess> getCreatedProcesses() {
        return createdProcesses;
    }

    private void initComponents() {
        setTitle("Create a Process");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(8, 2));

        processIdTextField = new JTextField();
        processIdTextField.setEditable(false);
        processNameTextField = new JTextField();
        processStateComboBox = new JComboBox<>(new String[]{"New", "Running", "Ready", "Terminated", "Waiting"});
        priorityComboBox = new JComboBox<>(new String[]{"High", "Medium", "Low"});
        arrivalTimeTextField = new JTextField();
        burstTimeTextField = new JTextField();

        createButton = new JButton("CREATE");
        resetButton = new JButton("RESET");

        createButton.addActionListener(e -> createMyProcess());
        resetButton.addActionListener(e -> resetFields());

        add(new JLabel("Process ID:"));
        add(processIdTextField);
        add(new JLabel("Process Name:"));
        add(processNameTextField);
        add(new JLabel("Process State:"));
        add(processStateComboBox);
        add(new JLabel("Choose Process Priority:"));
        add(priorityComboBox);
        add(new JLabel("Enter Arrival Time:"));
        add(arrivalTimeTextField);
        add(new JLabel("Enter Burst Time:"));
        add(burstTimeTextField);
        add(createButton);
        add(resetButton);

        generateProcessId();
    }

    private void customizeInterface() {
        getContentPane().setBackground(new Color(255, 255, 255));
        processIdTextField.setBackground(new Color(255, 255, 255));
        processNameTextField.setBackground(new Color(255, 255, 255));
        arrivalTimeTextField.setBackground(new Color(255, 255, 255));
        burstTimeTextField.setBackground(new Color(255, 255, 255));

        processStateComboBox.setBackground(new Color(227, 227, 227));
        priorityComboBox.setBackground(new Color(227, 227, 227));

        createButton.setBackground(new Color(227, 227, 227));
        resetButton.setBackground(new Color(227, 227, 227));
    }

    private void generateProcessId() {
        processIdTextField.setText("P" + getNextProcessId());
    }

    private int getNextProcessId() {
        return createdProcesses.size() + 1;
    }

    private void createMyProcess() {
        String processName = processNameTextField.getText();
        String processState = processStateComboBox.getSelectedItem().toString();
        String priority = priorityComboBox.getSelectedItem().toString();
        String arrivalTime = arrivalTimeTextField.getText();
        String burstTime = burstTimeTextField.getText();


        MyProcess myProcess = new MyProcess(processIdTextField.getText(), processName, processState, priority, arrivalTime, burstTime);

        createdProcesses.add(myProcess); // Add the created process to the list

        JOptionPane.showMessageDialog(this, "Process created:\n" + myProcess.toString(), "Process Created", JOptionPane.INFORMATION_MESSAGE);
        dispose();

    }

    private void resetFields() {
        processNameTextField.setText("");
        processStateComboBox.setSelectedIndex(0);
        priorityComboBox.setSelectedIndex(0);
        arrivalTimeTextField.setText("");
        burstTimeTextField.setText("");

        generateProcessId();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CreateNewProcess().setVisible(true));
    }
}
