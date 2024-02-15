package osproject;

import javax.swing.*;
import java.awt.*;

public class ProcessManagement extends javax.swing.JFrame {
    private JButton createProcessBtn;
    private JButton destroyProcessBtn;
    private JButton suspendProcessBtn;
    private JButton resumeProcessBtn;
    private JButton blockProcessBtn;
    private JButton wakeupProcessBtn;
    private JButton dispatchProcessBtn;
    private JButton showPCBBtn;
    private JButton backToMainMenuBtn;

    public ProcessManagement() {
        initComponents();
        customizeInterface();
    }

    private void openCreateNewProcess() {
        SwingUtilities.invokeLater(() -> new CreateNewProcess().setVisible(true));
    }

    private void destroyProcessBtnActionPerformed(java.awt.event.ActionEvent evt) {
        SwingUtilities.invokeLater(() -> new DestroyProcess().setVisible(true));
    }

    private void suspendProcessBtnActionPerformed(java.awt.event.ActionEvent evt) {
        SwingUtilities.invokeLater(() -> new SuspendProcess().setVisible(true));
    }

    private void resumeProcessBtnActionPerformed(java.awt.event.ActionEvent evt) {
        SwingUtilities.invokeLater(() -> new ResumeProcess().setVisible(true));
    }

    private void blockProcessBtnActionPerformed(java.awt.event.ActionEvent evt) {
        SwingUtilities.invokeLater(() -> new BlockProcess().setVisible(true));
    }

    private void wakeupProcessBtnActionPerformed(java.awt.event.ActionEvent evt) {
    SwingUtilities.invokeLater(() -> new WakeupProcess().setVisible(true));
    }

    private void dispatchProcessBtnActionPerformed(java.awt.event.ActionEvent evt) {
        SwingUtilities.invokeLater(() -> new DispatchProcess().setVisible(true));    }

    private void showPCBBtnActionPerformed(java.awt.event.ActionEvent evt) {
        SwingUtilities.invokeLater(() -> new PCB().setVisible(true));
    }

    private void backToMainMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {
        MainMenu mainMenu = new MainMenu();
        mainMenu.setVisible(true);
        this.setVisible(false);
    }

    private void createProcessBtnActionPerformed(java.awt.event.ActionEvent evt) {
        openCreateNewProcess();
    }

    private void customizeInterface() {
        // Your existing customization code
        jPanel1.setBackground(new Color(6, 23, 105));
        jLabel1.setBackground(new Color(255, 255, 255));

        createProcessBtn.setBackground(new Color(227, 227, 227));
        destroyProcessBtn.setBackground(new Color(255, 255, 255));
        suspendProcessBtn.setBackground(new Color(227, 227, 227));
        resumeProcessBtn.setBackground(new Color(255, 255, 255));
        blockProcessBtn.setBackground(new Color(227, 227, 227));
        wakeupProcessBtn.setBackground(new Color(255, 255, 255));
        dispatchProcessBtn.setBackground(new Color(227, 227, 227));
        showPCBBtn.setBackground(new Color(255, 255, 255));
        backToMainMenuBtn.setBackground(new Color(255, 0, 0));
    }

    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        createProcessBtn = new javax.swing.JButton();
        destroyProcessBtn = new javax.swing.JButton();
        suspendProcessBtn = new javax.swing.JButton();
        resumeProcessBtn = new javax.swing.JButton();
        blockProcessBtn = new javax.swing.JButton();
        wakeupProcessBtn = new javax.swing.JButton();
        dispatchProcessBtn = new javax.swing.JButton();
        showPCBBtn = new javax.swing.JButton();
        backToMainMenuBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(6, 23, 105));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 36));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PROCESS MANAGEMENT");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 979, 116));

        createProcessBtn.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14));
        createProcessBtn.setText("Create New Process");
        createProcessBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createProcessBtnActionPerformed(evt);
            }
        });
        jPanel1.add(createProcessBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 166, 220, 50));

        destroyProcessBtn.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14));
        destroyProcessBtn.setText("Destroy a Process");
        destroyProcessBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destroyProcessBtnActionPerformed(evt);
            }
        });
        jPanel1.add(destroyProcessBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 236, 220, 50));

        suspendProcessBtn.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14));
        suspendProcessBtn.setText("Suspend a Process");
        suspendProcessBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suspendProcessBtnActionPerformed(evt);
            }
        });
        jPanel1.add(suspendProcessBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 306, 220, 50));

        resumeProcessBtn.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14));
        resumeProcessBtn.setText("Resume a Process");
        resumeProcessBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resumeProcessBtnActionPerformed(evt);
            }
        });
        jPanel1.add(resumeProcessBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 376, 220, 50));

        blockProcessBtn.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14));
        blockProcessBtn.setText("Block a Process");
        blockProcessBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blockProcessBtnActionPerformed(evt);
            }
        });
        jPanel1.add(blockProcessBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 166, 220, 50));

        wakeupProcessBtn.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14));
        wakeupProcessBtn.setText("Wakeup a Process");
        wakeupProcessBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wakeupProcessBtnActionPerformed(evt);
            }
        });
        jPanel1.add(wakeupProcessBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 236, 220, 50));

        dispatchProcessBtn.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14));
        dispatchProcessBtn.setText("Dispatch a Process");
        dispatchProcessBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispatchProcessBtnActionPerformed(evt);
            }
        });
        jPanel1.add(dispatchProcessBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 306, 220, 50));

        showPCBBtn.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14));
        showPCBBtn.setText("PCB");
        showPCBBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPCBBtnActionPerformed(evt);
            }
        });
        jPanel1.add(showPCBBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 376, 220, 50));

        backToMainMenuBtn.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14));
        backToMainMenuBtn.setText("Back to Main Menu");
        backToMainMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToMainMenuBtnActionPerformed(evt);
            }
        });
        jPanel1.add(backToMainMenuBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 480, 234, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 680));

        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new ProcessManagement().setVisible(true));
    }

   // private javax.swing.JButton backToMainMenuBtn;
   // private javax.swing.JButton blockProcessBtn;
   // private javax.swing.JButton createProcessBtn;
   // private javax.swing.JButton destroyProcessBtn;
   // private javax.swing.JButton dispatchProcessBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton memorymanagementbtn;
    private javax.swing.JButton otheroperationsbtn;
    private javax.swing.JButton processmanagementbtn;
    private javax.swing.JButton processschedulingbtn;
   // private javax.swing.JButton resumeProcessBtn;
    private javax.swing.JButton shutdownbtn;
    //private javax.swing.JButton showPCBBtn;
   // private javax.swing.JButton suspendProcessBtn;
    //private javax.swing.JButton wakeupProcessBtn;
}


