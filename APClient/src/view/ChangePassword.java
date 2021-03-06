/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.*;
import javax.swing.JOptionPane;
import main.Session;

/**
 *
 * @author Flo
 */
public class ChangePassword extends javax.swing.JFrame {

    /**
     * Creates new form ChangePassword
     */
    public ChangePassword() {
        initComponents();
    }
    
    public void doChangePassword() throws IOException {
        String oldPassword = tfOldPassword.getText().trim();
        String newPassword1 = tfNewPassword1.getText().trim();
        String newPassword2 = tfNewPassword2.getText().trim();
        
        Socket connection = new Socket(Session.getCurrentServerIp(), Session.getCurrentServerPort());
        
        if(newPassword1.equals(newPassword2)){
            ArrayList<String> stream = new ArrayList<>();
        
            stream.add(Session.getCurrentUsername());
            stream.add(Session.getCurrentPassword());
            stream.add("changePassword");
            stream.add(oldPassword);
            stream.add(newPassword1);

            ObjectOutputStream toServer = new ObjectOutputStream(
                    connection.getOutputStream());
            toServer.writeObject(stream);
            
            InputStream in = connection.getInputStream();
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(in));
            
            String line = fromServer.readLine();
            System.out.println(line);
            if(line.equals("Password has successfully been changed")){
                JOptionPane.showMessageDialog(null, line, "Success!",
                                JOptionPane.NO_OPTION);
                Session.setCurrentPassword(newPassword1);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, line, "Error",
                                JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Old password fields did not match", "Error",
                                JOptionPane.ERROR_MESSAGE);
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
        lblOldPassword = new javax.swing.JLabel();
        tfOldPassword = new javax.swing.JPasswordField();
        tfNewPassword1 = new javax.swing.JPasswordField();
        lblNewPassword1 = new javax.swing.JLabel();
        tfNewPassword2 = new javax.swing.JPasswordField();
        lblNewPassword2 = new javax.swing.JLabel();
        btCommit = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adventure Planner - Change Password");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        lblOldPassword.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        lblOldPassword.setForeground(new java.awt.Color(255, 127, 0));
        lblOldPassword.setText("Typ password");

        tfOldPassword.setBackground(new java.awt.Color(102, 102, 102));
        tfOldPassword.setForeground(new java.awt.Color(204, 204, 204));
        tfOldPassword.setBorder(null);
        tfOldPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfOldPasswordKeyPressed(evt);
            }
        });

        tfNewPassword1.setBackground(new java.awt.Color(102, 102, 102));
        tfNewPassword1.setForeground(new java.awt.Color(204, 204, 204));
        tfNewPassword1.setBorder(null);
        tfNewPassword1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfNewPassword1KeyPressed(evt);
            }
        });

        lblNewPassword1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        lblNewPassword1.setForeground(new java.awt.Color(255, 127, 0));
        lblNewPassword1.setText("Typ new password");

        tfNewPassword2.setBackground(new java.awt.Color(102, 102, 102));
        tfNewPassword2.setForeground(new java.awt.Color(204, 204, 204));
        tfNewPassword2.setBorder(null);
        tfNewPassword2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfNewPassword2KeyPressed(evt);
            }
        });

        lblNewPassword2.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        lblNewPassword2.setForeground(new java.awt.Color(255, 127, 0));
        lblNewPassword2.setText("Typ new password");

        btCommit.setBackground(new java.awt.Color(102, 102, 102));
        btCommit.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btCommit.setForeground(new java.awt.Color(255, 255, 255));
        btCommit.setText("Commit");
        btCommit.setBorder(null);
        btCommit.setBorderPainted(false);
        btCommit.setFocusPainted(false);
        btCommit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCommitActionPerformed(evt);
            }
        });

        btCancel.setBackground(new java.awt.Color(102, 102, 102));
        btCancel.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btCancel.setForeground(new java.awt.Color(255, 255, 255));
        btCancel.setText("Cancel");
        btCancel.setBorder(null);
        btCancel.setBorderPainted(false);
        btCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btCancel.setFocusPainted(false);
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 192, Short.MAX_VALUE)
                        .addComponent(btCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCommit, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNewPassword1)
                            .addComponent(lblOldPassword)
                            .addComponent(lblNewPassword2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNewPassword2)
                            .addComponent(tfOldPassword)
                            .addComponent(tfNewPassword1))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfOldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOldPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNewPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNewPassword1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNewPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNewPassword2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCommit, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfOldPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfOldPasswordKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            try {
                doChangePassword();
            } catch (IOException ex) {
                Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tfOldPasswordKeyPressed

    private void tfNewPassword1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNewPassword1KeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            try {
                doChangePassword();
            } catch (IOException ex) {
                Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tfNewPassword1KeyPressed

    private void tfNewPassword2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNewPassword2KeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            try {
                doChangePassword();
            } catch (IOException ex) {
                Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tfNewPassword2KeyPressed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btCancelActionPerformed

    private void btCommitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCommitActionPerformed
        try {
            doChangePassword();
        } catch (IOException ex) {
            Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btCommitActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btCommit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblNewPassword1;
    private javax.swing.JLabel lblNewPassword2;
    private javax.swing.JLabel lblOldPassword;
    private javax.swing.JPasswordField tfNewPassword1;
    private javax.swing.JPasswordField tfNewPassword2;
    private javax.swing.JPasswordField tfOldPassword;
    // End of variables declaration//GEN-END:variables
}