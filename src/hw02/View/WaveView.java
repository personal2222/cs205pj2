/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw02.View;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author zf002
 */
public class WaveView extends javax.swing.JFrame {

    /**
     * Creates new form WaveView
     */
    public WaveView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.ButtonGroup buttonGroup1 = new javax.swing.ButtonGroup();
        javax.swing.JPanel buttonPanel = new javax.swing.JPanel();
        rdbtnTimeView = new javax.swing.JRadioButton();
        rdbtnFreqView = new javax.swing.JRadioButton();
        javax.swing.JPanel leftPanel = new javax.swing.JPanel();
        javax.swing.JPanel jPanel2 = new javax.swing.JPanel();
        javax.swing.JLabel labelLeftPanel = new javax.swing.JLabel();
        scrpanLeft = new javax.swing.JScrollPane();
        waveFormComponent1 = new hw02.View.WaveFormComponent();
        javax.swing.JPanel rightPanel = new javax.swing.JPanel();
        javax.swing.JPanel jPanel6 = new javax.swing.JPanel();
        javax.swing.JLabel labelRightPanel = new javax.swing.JLabel();
        scrpanRight = new javax.swing.JScrollPane();
        waveFormComponent2 = new hw02.View.WaveFormComponent();
        genMeunBar = new javax.swing.JMenuBar();
        fileMeun = new javax.swing.JMenu();
        newMeunItem = new javax.swing.JMenuItem();
        openMeunItem = new javax.swing.JMenuItem();
        exitMeunItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WaveViewer");
        setBackground(new java.awt.Color(0, 0, 0));

        buttonPanel.setLayout(new java.awt.GridLayout(0, 1));

        buttonGroup1.add(rdbtnTimeView);
        rdbtnTimeView.setText("Time view");
        rdbtnTimeView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtnTimeViewActionPerformed(evt);
            }
        });
        buttonPanel.add(rdbtnTimeView);

        buttonGroup1.add(rdbtnFreqView);
        rdbtnFreqView.setText("Freq. view");
        rdbtnFreqView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtnFreqViewActionPerformed(evt);
            }
        });
        buttonPanel.add(rdbtnFreqView);

        leftPanel.setAutoscrolls(true);
        leftPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel2.setLayout(new java.awt.GridLayout(0, 1));

        labelLeftPanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLeftPanel.setText("Left Channel");
        jPanel2.add(labelLeftPanel);

        scrpanLeft.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrpanLeft.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrpanLeft.setViewportView(waveFormComponent1);
        scrpanLeft.setWheelScrollingEnabled(false);

        waveFormComponent1.setAutoscrolls(true);
        scrpanLeft.setViewportView(waveFormComponent1);

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
            .addComponent(scrpanLeft)
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrpanLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel6.setLayout(new java.awt.GridLayout(0, 1));

        labelRightPanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRightPanel.setText("Right Channel");
        jPanel6.add(labelRightPanel);

        scrpanRight.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrpanRight.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrpanRight.setViewportView(waveFormComponent2);

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                .addGap(19, 19, 19))
            .addComponent(scrpanRight)
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrpanRight, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                .addContainerGap())
        );

        fileMeun.setText("File");

        newMeunItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newMeunItem.setText("New");
        fileMeun.add(newMeunItem);

        openMeunItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openMeunItem.setText("Open");
        fileMeun.add(openMeunItem);

        exitMeunItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        exitMeunItem.setText("Exit");
        exitMeunItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMeunItemActionPerformed(evt);
            }
        });
        fileMeun.add(exitMeunItem);

        genMeunBar.add(fileMeun);

        setJMenuBar(genMeunBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(leftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(rightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMeunItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMeunItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exitMeunItemActionPerformed

    private void rdbtnTimeViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtnTimeViewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbtnTimeViewActionPerformed

    private void rdbtnFreqViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtnFreqViewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbtnFreqViewActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WaveView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(WaveView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(WaveView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(WaveView.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WaveView().setVisible(true);
            }
        });
    }

    public JMenuItem getExitMeunItem() {
        return exitMeunItem;
    }

    public JMenu getFileMeun() {
        return fileMeun;
    }

    public JMenuBar getGenMeunBar() {
        return genMeunBar;
    }

    public JMenuItem getNewMeunItem() {
        return newMeunItem;
    }

    public JMenuItem getOpenMeunItem() {
        return openMeunItem;
    }

    public JRadioButton getRdbtnFreqView() {
        return rdbtnFreqView;
    }

    public JRadioButton getRdbtnTimeView() {
        return rdbtnTimeView;
    }

    public JScrollPane getScrpanLeft() {
        return scrpanLeft;
    }

    public JScrollPane getScrpanRight() {
        return scrpanRight;
    }

    public WaveFormComponent getWaveFormComponent1() {
        return waveFormComponent1;
    }

    public WaveFormComponent getWaveFormComponent2() {
        return waveFormComponent2;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem exitMeunItem;
    private javax.swing.JMenu fileMeun;
    private javax.swing.JMenuBar genMeunBar;
    private javax.swing.JMenuItem newMeunItem;
    private javax.swing.JMenuItem openMeunItem;
    private javax.swing.JRadioButton rdbtnFreqView;
    private javax.swing.JRadioButton rdbtnTimeView;
    private javax.swing.JScrollPane scrpanLeft;
    private javax.swing.JScrollPane scrpanRight;
    private hw02.View.WaveFormComponent waveFormComponent1;
    private hw02.View.WaveFormComponent waveFormComponent2;
    // End of variables declaration//GEN-END:variables
}
