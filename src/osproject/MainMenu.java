package osproject;

import java.awt.Color;

public class MainMenu extends javax.swing.JFrame {

    public MainMenu() {
        initComponents();
        customizeInterface();
    }

    private void customizeInterface() {
        jPanel1.setBackground(new Color(0, 7, 66));
        jLabel1.setBackground(new Color(255, 255, 255));

        processmanagementbtn.setBackground(new Color(227, 227, 227));
        memorymanagementbtn.setBackground(new Color(255, 255, 255));
        processschedulingbtn.setBackground(new Color(227, 227, 227));
        otheroperationsbtn.setBackground(new Color(255, 255, 255));
        shutdownbtn.setBackground(new Color(255, 255, 255));
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        processmanagementbtn = new javax.swing.JButton();
        memorymanagementbtn = new javax.swing.JButton();
        processschedulingbtn = new javax.swing.JButton();
        otheroperationsbtn = new javax.swing.JButton();
        shutdownbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(6, 23, 105));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 36));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ULTRA OPERATING SYSTEM");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 979, 116));

        processmanagementbtn.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14));
        processmanagementbtn.setText("PROCESS MANAGEMENT");
        processmanagementbtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        processmanagementbtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        processmanagementbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processmanagementbtnActionPerformed(evt);
            }
        });
        jPanel1.add(processmanagementbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 166, 220, 156));

        memorymanagementbtn.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14));
        memorymanagementbtn.setText("MEMORY MANAGEMENT");
        memorymanagementbtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        memorymanagementbtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        memorymanagementbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memorymanagementbtnActionPerformed(evt);
            }
        });
        jPanel1.add(memorymanagementbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 166, 220, 156));

        processschedulingbtn.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14));
        processschedulingbtn.setText("PROCESS SCHEDULING");
        processschedulingbtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        processschedulingbtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        processschedulingbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processschedulingbtnActionPerformed(evt);
            }
        });
        jPanel1.add(processschedulingbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, 220, 156));

        otheroperationsbtn.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14));
        otheroperationsbtn.setText("OTHER OPERATIONS");
        otheroperationsbtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        otheroperationsbtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        otheroperationsbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otheroperationsbtnActionPerformed(evt);
            }
        });
        jPanel1.add(otheroperationsbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 360, 220, 156));

        shutdownbtn.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14));
        shutdownbtn.setText("SHUTDOWN");
        shutdownbtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        shutdownbtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        shutdownbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shutdownbtnActionPerformed(evt);
            }
        });
        jPanel1.add(shutdownbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 560, 234, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 680));

        pack();
    }

    private void processmanagementbtnActionPerformed(java.awt.event.ActionEvent evt) {
        ProcessManagement p = new ProcessManagement();
        this.setVisible(false);
        p.setVisible(true);
    }

    private void memorymanagementbtnActionPerformed(java.awt.event.ActionEvent evt) {
        MemoryManagement m = new MemoryManagement();
        this.setVisible(false);
        m.setVisible(true);
    }

    private void processschedulingbtnActionPerformed(java.awt.event.ActionEvent evt) {
        ProcessScheduling ps = new ProcessScheduling();
        this.setVisible(false);
        ps.setVisible(true);
    }

    private void otheroperationsbtnActionPerformed(java.awt.event.ActionEvent evt) {
        // Additional operations button logic
    }

    private void shutdownbtnActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new MainMenu().setVisible(true);
        });
    }

    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton memorymanagementbtn;
    private javax.swing.JButton otheroperationsbtn;
    private javax.swing.JButton processmanagementbtn;
    private javax.swing.JButton processschedulingbtn;
    private javax.swing.JButton shutdownbtn;
}

