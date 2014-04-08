/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.logging.*;
import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.border.EmptyBorder;
import main.RequestManager;
import main.Session;

/**
 *
 * @author Flo
 */
public class CreateCampaign extends javax.swing.JFrame {

    private RequestManager rm;
    /**
     * Creates new form CreateCampaign
     */
    public CreateCampaign() {
        initComponents();
        for (int i = 0; i < cbAccess.getComponentCount(); i++) {
            if (cbAccess.getComponent(i) instanceof JComponent) {
                ((JComponent) cbAccess.getComponent(i)).setBorder(new EmptyBorder(1,1,1,1));
            }
            if (cbAccess.getComponent(i) instanceof AbstractButton) {
                ((AbstractButton) cbAccess.getComponent(i)).setBorderPainted(false);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblCampaignName = new javax.swing.JLabel();
        lblRpgType = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        lblAccess = new javax.swing.JLabel();
        cbAccess = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tpDescription = new javax.swing.JTextPane();
        tfCampaignName = new javax.swing.JTextField();
        tfRpgType = new javax.swing.JTextField();
        btCreate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(458, 382));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        lblCampaignName.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        lblCampaignName.setForeground(new java.awt.Color(255, 127, 0));
        lblCampaignName.setText("Campaign name");

        lblRpgType.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        lblRpgType.setForeground(new java.awt.Color(255, 127, 0));
        lblRpgType.setText("RPG Type");

        lblDescription.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        lblDescription.setForeground(new java.awt.Color(255, 127, 0));
        lblDescription.setText("Description");

        lblAccess.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        lblAccess.setForeground(new java.awt.Color(255, 127, 0));
        lblAccess.setText("Access");

        cbAccess.setBackground(new java.awt.Color(102, 102, 102));
        cbAccess.setEditable(true);
        cbAccess.setForeground(new java.awt.Color(204, 204, 204));
        cbAccess.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Public", "Private" }));
        cbAccess.setFocusable(false);
        cbAccess.setOpaque(false);
        cbAccess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAccessActionPerformed(evt);
            }
        });
        cbAccess.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbAccessKeyPressed(evt);
            }
        });

        jScrollPane1.setBorder(null);

        tpDescription.setBackground(new java.awt.Color(102, 102, 102));
        tpDescription.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        tpDescription.setForeground(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(tpDescription);

        tfCampaignName.setBackground(new java.awt.Color(102, 102, 102));
        tfCampaignName.setForeground(new java.awt.Color(204, 204, 204));
        tfCampaignName.setBorder(null);
        tfCampaignName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfCampaignNameKeyPressed(evt);
            }
        });

        tfRpgType.setBackground(new java.awt.Color(102, 102, 102));
        tfRpgType.setForeground(new java.awt.Color(204, 204, 204));
        tfRpgType.setBorder(null);
        tfRpgType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfRpgTypeKeyPressed(evt);
            }
        });

        btCreate.setBackground(new java.awt.Color(102, 102, 102));
        btCreate.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btCreate.setForeground(new java.awt.Color(255, 255, 255));
        btCreate.setText("Create");
        btCreate.setBorder(null);
        btCreate.setBorderPainted(false);
        btCreate.setFocusPainted(false);
        btCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCreateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCampaignName)
                                    .addComponent(lblRpgType)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblAccess)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfCampaignName, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfRpgType, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbAccess, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 38, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblDescription)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCampaignName)
                    .addComponent(tfCampaignName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRpgType)
                    .addComponent(tfRpgType, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAccess)
                    .addComponent(cbAccess, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCreateActionPerformed
        rm = new RequestManager();
        String campaignName = tfCampaignName.getText().trim();
        Integer access = cbAccess.getSelectedIndex() + 1;
        String rpgType = tfRpgType.getText().trim();
        String description = tpDescription.getText().trim();
        rm.createCampaign(campaignName, access, rpgType, description);
    }//GEN-LAST:event_btCreateActionPerformed

    private void cbAccessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAccessActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAccessActionPerformed

    private void cbAccessKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbAccessKeyPressed
//        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
//            try {
//                doLogin();
//            } catch (IOException ex) {
//                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }//GEN-LAST:event_cbAccessKeyPressed

    private void tfCampaignNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCampaignNameKeyPressed
//        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
//            try {
//                doLogin();
//            } catch (IOException ex) {
//                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }//GEN-LAST:event_tfCampaignNameKeyPressed

    private void tfRpgTypeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfRpgTypeKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfRpgTypeKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCreate;
    private javax.swing.JComboBox cbAccess;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAccess;
    private javax.swing.JLabel lblCampaignName;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblRpgType;
    private javax.swing.JTextField tfCampaignName;
    private javax.swing.JTextField tfRpgType;
    private javax.swing.JTextPane tpDescription;
    // End of variables declaration//GEN-END:variables
}
