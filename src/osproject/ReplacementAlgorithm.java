package osproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class ReplacementAlgorithm extends JFrame {

    private JTextField fifoTextField, lruTextField;
    private JButton fifoButton, lruButton;
    private JLabel fifoLabel, lruLabel, fifoResultLabel, lruResultLabel;

    private LinkedList<Integer> fifoPageQueue;
    private int[] lruPageArray;
    private int lruIndex;

    public ReplacementAlgorithm() {
        initComponents();
        fifoPageQueue = new LinkedList<>();
        lruPageArray = new int[3]; // Assuming a page frame size of 3 for LRU
        lruIndex = 0;
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Replacement Algorithm");
        setResizable(false);

        fifoLabel = new JLabel("Enter reference string for FIFO:");
        lruLabel = new JLabel("Enter reference string for LRU:");
        fifoTextField = new JTextField();
        lruTextField = new JTextField();
        fifoButton = new JButton("Run FIFO Algorithm");
        lruButton = new JButton("Run LRU Algorithm");
        fifoResultLabel = new JLabel("FIFO Results: ");
        lruResultLabel = new JLabel("LRU Results: ");

        fifoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runFIFOAlgorithm();
            }
        });

        lruButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runLRUAlgorithm();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(fifoLabel)
                                        .addComponent(fifoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fifoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fifoResultLabel)
                                        .addComponent(lruLabel)
                                        .addComponent(lruTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lruButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lruResultLabel))
                                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(fifoLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fifoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fifoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fifoResultLabel)
                                .addGap(30, 30, 30)
                                .addComponent(lruLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lruTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lruButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lruResultLabel)
                                .addGap(50, 50, 50))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void runFIFOAlgorithm() {
        String input = fifoTextField.getText();
        String[] references = input.split(",");
        int frameSize = 3; // Adjust the frame size as needed
        int pageFaults = 0;
        int hits = 0;
        LinkedList<Integer> fifoQueue = new LinkedList<>();

        for (String reference : references) {
            int pageNumber = Integer.parseInt(reference);

            if (!fifoQueue.contains(pageNumber)) {
                if (fifoQueue.size() < frameSize) {
                    fifoQueue.add(pageNumber);
                } else {
                    fifoQueue.poll(); // Remove the first element (oldest)
                    fifoQueue.add(pageNumber);
                }
                pageFaults++;
            } else {
                hits++;
            }
        }

        fifoResultLabel.setText("FIFO Results: Hits: " + hits + ", Misses: " + (references.length - hits) + ", Page Faults: " + pageFaults);
    }

    private void runLRUAlgorithm() {
        String input = lruTextField.getText();
        String[] references = input.split(",");
        int frameSize = 3; // Adjust the frame size as needed
        int pageFaults = 0;
        int hits = 0;

        LinkedList<Integer> lruList = new LinkedList<>();

        for (String reference : references) {
            int pageNumber = Integer.parseInt(reference);

            if (!lruList.contains(pageNumber)) {
                if (lruList.size() < frameSize) {
                    lruList.add(pageNumber);
                } else {
                    lruList.removeFirst(); // Remove the least recently used element
                    lruList.add(pageNumber);
                }
                pageFaults++;
            } else {
                hits++;
                lruList.remove((Integer) pageNumber); // Move the accessed page to the end
                lruList.add(pageNumber);
            }
        }

        lruResultLabel.setText("LRU Results: Hits: " + hits + ", Misses: " + (references.length - hits) + ", Page Faults: " + pageFaults);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReplacementAlgorithm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new ReplacementAlgorithm().setVisible(true);
        });
    }
}




