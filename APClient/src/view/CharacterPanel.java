/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

/**
 *
 * @author Flo
 */
public class CharacterPanel extends javax.swing.JPanel {

    /**
     * Creates new form CharacterPanel
     */
    public CharacterPanel() {
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
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        liMyCampaigns = new javax.swing.JList();
        jPanel5 = new javax.swing.JPanel();
        tfSearchCampaigns = new javax.swing.JTextField();
        btSearchCampaigns = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        lblCharacterName = new javax.swing.JLabel();
        lblEpisodeDescription1 = new javax.swing.JLabel();
        lblCharacterClass = new javax.swing.JLabel();
        lblCharacterLevel = new javax.swing.JLabel();
        lblLevel = new javax.swing.JLabel();
        imgCampaign2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        liMyEpisodes4 = new javax.swing.JList();
        lblEpisodes4 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        liMyEpisodes6 = new javax.swing.JList();
        lblEpisodes6 = new javax.swing.JLabel();

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jPanel2.setBackground(new java.awt.Color(66, 66, 66));
        jPanel2.setMinimumSize(new java.awt.Dimension(220, 159));

        jScrollPane2.setBackground(new java.awt.Color(66, 66, 66));
        jScrollPane2.setBorder(null);
        jScrollPane2.setForeground(new java.awt.Color(66, 66, 66));

        liMyCampaigns.setBackground(new java.awt.Color(66, 66, 66));
        liMyCampaigns.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        liMyCampaigns.setForeground(new java.awt.Color(204, 204, 204));
        liMyCampaigns.setSelectionBackground(new java.awt.Color(255, 127, 0));
        liMyCampaigns.setSelectionForeground(new java.awt.Color(40, 40, 40));
        liMyCampaigns.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                liMyCampaignsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(liMyCampaigns);

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));

        tfSearchCampaigns.setBackground(new java.awt.Color(102, 102, 102));
        tfSearchCampaigns.setForeground(new java.awt.Color(255, 255, 255));
        tfSearchCampaigns.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfSearchCampaigns.setBorder(null);
        tfSearchCampaigns.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfSearchCampaignsKeyPressed(evt);
            }
        });

        btSearchCampaigns.setBackground(new java.awt.Color(102, 102, 102));
        btSearchCampaigns.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search_icon.png"))); // NOI18N
        btSearchCampaigns.setBorder(null);
        btSearchCampaigns.setBorderPainted(false);
        btSearchCampaigns.setFocusPainted(false);
        btSearchCampaigns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchCampaignsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(tfSearchCampaigns)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSearchCampaigns, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(tfSearchCampaigns, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(btSearchCampaigns, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel4.add(jPanel2, gridBagConstraints);

        jScrollPane3.setBorder(null);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jPanel6.setBackground(new java.awt.Color(40, 40, 40));

        lblCharacterName.setFont(new java.awt.Font("Dialog", 1, 21)); // NOI18N
        lblCharacterName.setForeground(new java.awt.Color(255, 255, 255));
        lblCharacterName.setText("Character name");

        lblEpisodeDescription1.setForeground(new java.awt.Color(190, 190, 190));
        lblEpisodeDescription1.setText("Description");
        lblEpisodeDescription1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblCharacterClass.setForeground(new java.awt.Color(255, 127, 0));
        lblCharacterClass.setText("Character class");

        lblCharacterLevel.setFont(new java.awt.Font("Dialog", 0, 21)); // NOI18N
        lblCharacterLevel.setForeground(new java.awt.Color(255, 127, 0));
        lblCharacterLevel.setText("1");

        lblLevel.setForeground(new java.awt.Color(222, 222, 223));
        lblLevel.setText("Level");

        imgCampaign2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/knight.png"))); // NOI18N
        imgCampaign2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(66, 66, 66), 4));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgCampaign2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCharacterName)
                            .addComponent(lblCharacterClass))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                        .addComponent(lblLevel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCharacterLevel))
                    .addComponent(lblEpisodeDescription1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(lblCharacterName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCharacterClass))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblCharacterLevel)
                                .addComponent(lblLevel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEpisodeDescription1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(imgCampaign2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(40, 40, 40));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel12.setBackground(new java.awt.Color(56, 56, 56));
        jPanel12.setPreferredSize(new java.awt.Dimension(146, 202));

        jScrollPane8.setBackground(new java.awt.Color(66, 66, 66));
        jScrollPane8.setBorder(null);
        jScrollPane8.setForeground(new java.awt.Color(66, 66, 66));

        liMyEpisodes4.setBackground(new java.awt.Color(56, 56, 56));
        liMyEpisodes4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        liMyEpisodes4.setForeground(new java.awt.Color(204, 204, 204));
        liMyEpisodes4.setSelectionBackground(new java.awt.Color(255, 127, 0));
        liMyEpisodes4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                liMyEpisodes4MouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(liMyEpisodes4);

        lblEpisodes4.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        lblEpisodes4.setForeground(new java.awt.Color(255, 255, 255));
        lblEpisodes4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEpisodes4.setText("Episodes");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(lblEpisodes4, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addComponent(lblEpisodes4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8))
        );

        jPanel14.setBackground(new java.awt.Color(56, 56, 56));
        jPanel14.setPreferredSize(new java.awt.Dimension(146, 202));

        jScrollPane10.setBackground(new java.awt.Color(66, 66, 66));
        jScrollPane10.setBorder(null);
        jScrollPane10.setForeground(new java.awt.Color(66, 66, 66));

        liMyEpisodes6.setBackground(new java.awt.Color(56, 56, 56));
        liMyEpisodes6.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        liMyEpisodes6.setForeground(new java.awt.Color(204, 204, 204));
        liMyEpisodes6.setSelectionBackground(new java.awt.Color(255, 127, 0));
        liMyEpisodes6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                liMyEpisodes6MouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(liMyEpisodes6);

        lblEpisodes6.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        lblEpisodes6.setForeground(new java.awt.Color(255, 255, 255));
        lblEpisodes6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEpisodes6.setText("Campaigns");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(lblEpisodes6, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addComponent(lblEpisodes6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE))
                .addContainerGap())
        );

        jScrollPane3.setViewportView(jPanel1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(jPanel3, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void liMyCampaignsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_liMyCampaignsMouseClicked
//        if (evt.getClickCount() == 2) {
//            showSelectedCampaign(liMyCampaigns.getSelectedIndex());
//            try {
//                Campaign camp = (Campaign) liMyCampaigns.getSelectedValue();
//                getEpisodes(camp);
//            } catch (IOException ex) {
//                Logger.getLogger(Overview.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            showSelectedEpisode(0);
//        } else if (evt.getClickCount() == 3) {   // Triple-click
//        }
    }//GEN-LAST:event_liMyCampaignsMouseClicked

    private void tfSearchCampaignsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSearchCampaignsKeyPressed
//        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
//            try {
//                if(tfSearchCampaigns.getText().trim().equals("")){
//                    getMyCampaigns(GET_ALL);
//                } else {
//                    getMyCampaigns(tfSearchCampaigns.getText().trim());
//                }
//            } catch (IOException ex) {
//                Logger.getLogger(Overview.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }//GEN-LAST:event_tfSearchCampaignsKeyPressed

    private void btSearchCampaignsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchCampaignsActionPerformed
//        try {
//            if(tfSearchCampaigns.getText().trim().equals("")){
//                getMyCampaigns(GET_ALL);
//            } else {
//                getMyCampaigns(tfSearchCampaigns.getText().trim());
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(Overview.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_btSearchCampaignsActionPerformed

    private void liMyEpisodes4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_liMyEpisodes4MouseClicked
//        if (evt.getClickCount() == 2) {
//            showSelectedEpisode(liMyEpisodes.getSelectedIndex());
//        } else if (evt.getClickCount() == 3) {   // Triple-click
//            System.out.println("Jammer hoor...");
//        }
    }//GEN-LAST:event_liMyEpisodes4MouseClicked

    private void liMyEpisodes6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_liMyEpisodes6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_liMyEpisodes6MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSearchCampaigns;
    private javax.swing.JLabel imgCampaign2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel lblCharacterClass;
    private javax.swing.JLabel lblCharacterLevel;
    private javax.swing.JLabel lblCharacterName;
    private javax.swing.JLabel lblEpisodeDescription1;
    private javax.swing.JLabel lblEpisodes;
    private javax.swing.JLabel lblEpisodes1;
    private javax.swing.JLabel lblEpisodes2;
    private javax.swing.JLabel lblEpisodes3;
    private javax.swing.JLabel lblEpisodes4;
    private javax.swing.JLabel lblEpisodes5;
    private javax.swing.JLabel lblEpisodes6;
    private javax.swing.JLabel lblLevel;
    private javax.swing.JList liMyCampaigns;
    private javax.swing.JList liMyEpisodes;
    private javax.swing.JList liMyEpisodes1;
    private javax.swing.JList liMyEpisodes2;
    private javax.swing.JList liMyEpisodes3;
    private javax.swing.JList liMyEpisodes4;
    private javax.swing.JList liMyEpisodes5;
    private javax.swing.JList liMyEpisodes6;
    private javax.swing.JTextField tfSearchCampaigns;
    // End of variables declaration//GEN-END:variables
}