package osproject;

import java.awt.Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemoryManagement extends javax.swing.JFrame {
    private javax.swing.JButton backToMainMenuButton;
    private javax.swing.JButton pagingButton;
    private javax.swing.JButton replacementAlgorithmButton;

    public MemoryManagement() {
        initComponents();
        customizeInterface();
    }

    private void customizeInterface() {
        getContentPane().setBackground(new Color(6, 23, 105));
        backToMainMenuButton.setBackground(new Color(255, 255, 255));
        pagingButton.setBackground(new Color(227, 227, 227));
        replacementAlgorithmButton.setBackground(new Color(255, 255, 255));
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Memory Management");
        setResizable(false);

        backToMainMenuButton = new javax.swing.JButton("Back to Main Menu");
        pagingButton = new javax.swing.JButton("PAGING");
        replacementAlgorithmButton = new javax.swing.JButton("REPLACEMENT ALGORITHM");

        backToMainMenuButton.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14));
        backToMainMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToMainMenuButtonActionPerformed(evt);
            }
        });

        pagingButton.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14));
        pagingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagingButtonActionPerformed(evt);
            }
        });

        replacementAlgorithmButton.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14));
        replacementAlgorithmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                replacementAlgorithmButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(backToMainMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pagingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(replacementAlgorithmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(150, 150, 150))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(backToMainMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(pagingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(replacementAlgorithmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void backToMainMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {
        MainMenu mainMenu = new MainMenu();
        mainMenu.setVisible(true);
        dispose();
    }

    private void pagingButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // Add your logic for the PAGING module
        javax.swing.JOptionPane.showMessageDialog(null, "PAGING module clicked");
    }

    private void replacementAlgorithmButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // Open the ReplacementAlgorithm module
        ReplacementAlgorithm replacementAlgorithm = new ReplacementAlgorithm();
        replacementAlgorithm.setVisible(true);
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
            java.util.logging.Logger.getLogger(MemoryManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new MemoryManagement().setVisible(true);
        });
    }
}