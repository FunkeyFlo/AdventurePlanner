/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.swing.Box;
import javax.swing.DefaultListModel;
import main.*;
import model.*;
/**
 *
 * @author Flo
 */
public class Overview extends javax.swing.JFrame {

    private final String FAILED_AUTHENTICATION_MESSAGE = "Authentication failed..";
    private final String NOTHING = "null";
    private ArrayList<Campaign> campaigns;
    private ArrayList<Episode> episodes;
    private DefaultListModel myCampaigns = new DefaultListModel();
    private DefaultListModel myEpisodes = new DefaultListModel();
    private final String GET_ALL = "ALL";
    private final String NO_MATCHES = "no matches were found";
    
    /**
     * Creates new form Overview
     */
    public Overview() {
        initComponents();
//        overviewMenu.add(Box.createHorizontalGlue());
        
        liMyCampaigns.setModel(myCampaigns);
        liMyEpisodes.setModel(myEpisodes);
        try {
//            getMyInfo();
            getCampaigns(GET_ALL);
            setSelectedCampaign(0);
        } catch(IOException e) {
            System.out.println(e.toString());
        }
    }
    
    public void getMyInfo() throws IOException {
        Socket connection = new Socket(Session.getCurrentServerIp(),
                Session.getCurrentServerPort());
        OutputStream toServer = connection.getOutputStream();
        PrintStream ps = new PrintStream(toServer, true);
        
        ps.println((Session.getCurrentUsername() + ":"
                + Session.getCurrentPassword() + ":getMyInfo"));
        
        InputStream in = connection.getInputStream();
        BufferedReader fromServer = new BufferedReader(new InputStreamReader(in));
        String line = fromServer.readLine();
        
        connection.close();
    }
    
    public void getCampaigns(String searchArg) throws IOException {
        Socket connection = new Socket(Session.getCurrentServerIp(),
                Session.getCurrentServerPort());
        ArrayList<String> stream = new ArrayList<>();
        
        stream.add(Session.getCurrentUsername());
        stream.add(Session.getCurrentPassword());
        stream.add("getCampaigns");
        stream.add(searchArg);
        
        ObjectOutputStream toServer = new ObjectOutputStream(connection.getOutputStream());
        toServer.writeObject(stream);
        
        try {
            ObjectInputStream inStream = new ObjectInputStream(connection.getInputStream());
            campaigns = (ArrayList) inStream.readObject();
            if(campaigns.isEmpty()){
                myCampaigns.removeAllElements();
                myCampaigns.addElement(NO_MATCHES);
            } else {
                myCampaigns.removeAllElements();
            
                for (Campaign campaign : campaigns) {
                    myCampaigns.addElement(campaign);
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Overview.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        connection.close();
    }
    
    public void getEpisodes() throws IOException {
        Socket connection = new Socket(Session.getCurrentServerIp(),
                Session.getCurrentServerPort());
        ArrayList<String> stream = new ArrayList<>();
        
        Campaign camp = (Campaign) liMyCampaigns.getSelectedValue();
        String campId = camp.getId().toString();
        
        stream.add(Session.getCurrentUsername());
        stream.add(Session.getCurrentPassword());
        stream.add("getEpisodes");
        stream.add(campId);
        
        ObjectOutputStream toServer = new ObjectOutputStream(connection.getOutputStream());
        toServer.writeObject(stream);
        
        try {
            ObjectInputStream inStream = new ObjectInputStream(connection.getInputStream());
            episodes = (ArrayList) inStream.readObject();
            if(episodes.isEmpty()){
                myEpisodes.removeAllElements();
                myEpisodes.addElement(NO_MATCHES);
            } else {
                myEpisodes.removeAllElements();
            
                for (Episode episode : episodes) {
                    myEpisodes.addElement(episode);
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Overview.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        connection.close();
    }
    
    public void setSelectedCampaign(int index){
        try {
            lblCampName.setText(campaigns.get(index).getName());
            lblCampaignDescription.setText("<html>" + campaigns.get(index).getDescription()+ "</html>");
            lblRPGType.setText(campaigns.get(index).getRpgName());
            if(campaigns.get(index).getAccess() == 2){
                lblAccess.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Private 1.fw.png")));
            } else {
                lblAccess.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Open 1.fw.png")));
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.toString());
        }
    }
    
    public void setSelectedEpisode(int index){
        try {
            lblEpisodeName.setText(episodes.get(index).getName());
            lblEpisodeDescription.setText("<html>" + episodes.get(index).getDescription()+ "</html>");
            lblDmName.setText(episodes.get(index).getDmId().toString());
            lblEpisodeDate.setText(episodes.get(index).getDate());
            lblEpisodeOrderNumber.setText(episodes.get(index).getOrderNumber().toString());
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.toString());
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
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        liMyCampaigns = new javax.swing.JList();
        jPanel5 = new javax.swing.JPanel();
        tfSearchCampaigns = new javax.swing.JTextField();
        btSearchCampaigns = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        imgCampaign = new javax.swing.JLabel();
        lblCampName = new javax.swing.JLabel();
        lblCampaignDescription = new javax.swing.JLabel();
        lblRPGType = new javax.swing.JLabel();
        lblAccess = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        liMyEpisodes = new javax.swing.JList();
        lblEpisodes = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        lblDmName = new javax.swing.JLabel();
        lblEpisodeName = new javax.swing.JLabel();
        lblEpisodeDescription = new javax.swing.JLabel();
        lblEpisodeOrderNumber = new javax.swing.JLabel();
        lblEpisodeDate = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblCharacterName = new javax.swing.JLabel();
        lblEpisodeDescription1 = new javax.swing.JLabel();
        lblCharacterClass = new javax.swing.JLabel();
        lblCharacterLevel = new javax.swing.JLabel();
        lblLevel = new javax.swing.JLabel();
        imgCampaign2 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        overviewMenu = new javax.swing.JMenuBar();
        menuSettings = new javax.swing.JMenu();
        miOptions = new javax.swing.JMenuItem();
        menuAccount = new javax.swing.JMenu();
        miLogout = new javax.swing.JMenuItem();
        miChangePassword = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Adventure Planner");
        setIconImage(getToolkit().getImage(getClass().getResource("/img/account_icon.png")));
        setMinimumSize(new java.awt.Dimension(879, 499));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jPanel2.setBackground(new java.awt.Color(66, 66, 66));
        jPanel2.setMinimumSize(new java.awt.Dimension(220, 159));
        jPanel2.setPreferredSize(new java.awt.Dimension(220, 159));

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

        jButton1.setBackground(new java.awt.Color(40, 40, 40));
        jButton1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Create a new campaign");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel4.add(jPanel2, gridBagConstraints);

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setFocusable(false);
        jScrollPane1.setMinimumSize(null);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(0, 0));

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));
        jPanel6.setMinimumSize(null);

        jPanel7.setBackground(new java.awt.Color(40, 40, 40));
        jPanel7.setMinimumSize(new java.awt.Dimension(0, 173));

        imgCampaign.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/knight.png"))); // NOI18N
        imgCampaign.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(66, 66, 66), 4));

        lblCampName.setBackground(new java.awt.Color(66, 66, 66));
        lblCampName.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        lblCampName.setForeground(new java.awt.Color(255, 255, 255));
        lblCampName.setText("Campaign name");

        lblCampaignDescription.setForeground(new java.awt.Color(190, 190, 190));
        lblCampaignDescription.setText("Description");
        lblCampaignDescription.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblRPGType.setForeground(new java.awt.Color(255, 127, 0));
        lblRPGType.setText("RPG Type");

        lblAccess.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Open 2.fw.png"))); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgCampaign, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCampaignDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRPGType)
                            .addComponent(lblCampName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 253, Short.MAX_VALUE)
                        .addComponent(lblAccess)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(imgCampaign, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCampName)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(lblRPGType))
                            .addComponent(lblAccess))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCampaignDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(56, 56, 56));

        jScrollPane3.setBackground(new java.awt.Color(66, 66, 66));
        jScrollPane3.setBorder(null);
        jScrollPane3.setForeground(new java.awt.Color(66, 66, 66));

        liMyEpisodes.setBackground(new java.awt.Color(56, 56, 56));
        liMyEpisodes.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        liMyEpisodes.setForeground(new java.awt.Color(204, 204, 204));
        liMyEpisodes.setSelectionBackground(new java.awt.Color(255, 127, 0));
        liMyEpisodes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                liMyEpisodesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(liMyEpisodes);

        lblEpisodes.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        lblEpisodes.setForeground(new java.awt.Color(255, 255, 255));
        lblEpisodes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEpisodes.setText("Episodes");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(lblEpisodes, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addComponent(lblEpisodes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel9.setBackground(new java.awt.Color(40, 40, 40));
        jPanel9.setMinimumSize(null);

        lblDmName.setForeground(new java.awt.Color(255, 127, 0));
        lblDmName.setText("Dm Name");

        lblEpisodeName.setBackground(new java.awt.Color(66, 66, 66));
        lblEpisodeName.setFont(new java.awt.Font("Arial", 1, 26)); // NOI18N
        lblEpisodeName.setForeground(new java.awt.Color(255, 255, 255));
        lblEpisodeName.setText("Adventure name");

        lblEpisodeDescription.setForeground(new java.awt.Color(190, 190, 190));
        lblEpisodeDescription.setText("Description");
        lblEpisodeDescription.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblEpisodeOrderNumber.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        lblEpisodeOrderNumber.setForeground(new java.awt.Color(66, 66, 66));
        lblEpisodeOrderNumber.setText("1");

        lblEpisodeDate.setForeground(new java.awt.Color(255, 127, 0));
        lblEpisodeDate.setText("Date");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEpisodeDescription, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDmName)
                            .addComponent(lblEpisodeName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblEpisodeOrderNumber))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblEpisodeDate)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEpisodeName)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(lblDmName))
                    .addComponent(lblEpisodeOrderNumber))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEpisodeDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEpisodeDate)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(40, 40, 40));
        jPanel1.setMinimumSize(null);

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

        jScrollPane5.setBorder(null);

        jList1.setBackground(new java.awt.Color(56, 56, 56));
        jList1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 0));
        jList1.setForeground(new java.awt.Color(204, 204, 204));
        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Hordrick", "Hendrick", "Pastanza" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.setFixedCellWidth(70);
        jList1.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
        jList1.setSelectionBackground(new java.awt.Color(255, 127, 0));
        jList1.setSelectionForeground(new java.awt.Color(40, 40, 40));
        jList1.setVisibleRowCount(1);
        jScrollPane5.setViewportView(jList1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgCampaign2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCharacterName)
                            .addComponent(lblCharacterClass))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblLevel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCharacterLevel))
                    .addComponent(lblEpisodeDescription1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jScrollPane5)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblCharacterName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCharacterClass))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblCharacterLevel)
                                .addComponent(lblLevel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEpisodeDescription1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(imgCampaign2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel6);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(jPanel3, gridBagConstraints);

        overviewMenu.setBackground(new java.awt.Color(30, 30, 30));
        overviewMenu.setBorder(null);
        overviewMenu.setForeground(new java.awt.Color(51, 51, 51));
        overviewMenu.setBorderPainted(false);
        overviewMenu.setMargin(new java.awt.Insets(40, 40, 40, 40));
        overviewMenu.setMinimumSize(new java.awt.Dimension(0, 50));
        overviewMenu.setName(""); // NOI18N
        overviewMenu.setPreferredSize(new java.awt.Dimension(64, 30));

        menuSettings.setBorder(null);
        menuSettings.setForeground(new java.awt.Color(255, 127, 0));
        menuSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/settings_icon.png"))); // NOI18N
        menuSettings.setContentAreaFilled(false);
        menuSettings.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        menuSettings.setMinimumSize(new java.awt.Dimension(40, 40));
        menuSettings.setPreferredSize(new java.awt.Dimension(40, 40));

        miOptions.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.ALT_MASK));
        miOptions.setBackground(new java.awt.Color(30, 30, 30));
        miOptions.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        miOptions.setForeground(new java.awt.Color(255, 127, 0));
        miOptions.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/settings_icon.png"))); // NOI18N
        miOptions.setText("Options");
        miOptions.setBorder(null);
        miOptions.setBorderPainted(false);
        miOptions.setPreferredSize(new java.awt.Dimension(150, 42));
        miOptions.setRequestFocusEnabled(false);
        miOptions.setSelected(true);
        miOptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miOptionsActionPerformed(evt);
            }
        });
        menuSettings.add(miOptions);

        overviewMenu.add(menuSettings);

        menuAccount.setBackground(new java.awt.Color(40, 40, 40));
        menuAccount.setBorder(null);
        menuAccount.setForeground(new java.awt.Color(255, 127, 0));
        menuAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/account_icon.png"))); // NOI18N
        menuAccount.setBorderPainted(false);
        menuAccount.setMinimumSize(new java.awt.Dimension(40, 40));
        menuAccount.setPreferredSize(new java.awt.Dimension(40, 40));

        miLogout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.CTRL_MASK));
        miLogout.setBackground(new java.awt.Color(30, 30, 30));
        miLogout.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        miLogout.setForeground(new java.awt.Color(255, 127, 0));
        miLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logout_icon.png"))); // NOI18N
        miLogout.setText("Logout");
        miLogout.setBorder(null);
        miLogout.setBorderPainted(false);
        miLogout.setPreferredSize(new java.awt.Dimension(150, 42));
        miLogout.setRequestFocusEnabled(false);
        miLogout.setSelected(true);
        miLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLogoutActionPerformed(evt);
            }
        });
        menuAccount.add(miLogout);

        miChangePassword.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, java.awt.event.InputEvent.CTRL_MASK));
        miChangePassword.setBackground(new java.awt.Color(30, 30, 30));
        miChangePassword.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        miChangePassword.setForeground(new java.awt.Color(255, 127, 0));
        miChangePassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/password_icon.png"))); // NOI18N
        miChangePassword.setText("Change password");
        miChangePassword.setBorder(null);
        miChangePassword.setBorderPainted(false);
        miChangePassword.setMinimumSize(new java.awt.Dimension(200, 42));
        miChangePassword.setPreferredSize(new java.awt.Dimension(200, 42));
        miChangePassword.setRequestFocusEnabled(false);
        miChangePassword.setSelected(true);
        miChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miChangePasswordActionPerformed(evt);
            }
        });
        menuAccount.add(miChangePassword);

        overviewMenu.add(menuAccount);

        setJMenuBar(overviewMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void liMyCampaignsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_liMyCampaignsMouseClicked
        if (evt.getClickCount() == 2) {
            setSelectedCampaign(liMyCampaigns.getSelectedIndex());
            try {
                getEpisodes();
            } catch (IOException ex) {
                Logger.getLogger(Overview.class.getName()).log(Level.SEVERE, null, ex);
            }
            setSelectedEpisode(0);
        } else if (evt.getClickCount() == 3) {   // Triple-click
        }
    }//GEN-LAST:event_liMyCampaignsMouseClicked

    private void tfSearchCampaignsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSearchCampaignsKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            try {
                if(tfSearchCampaigns.getText().trim().equals("")){
                    getCampaigns(GET_ALL);
                } else {
                    getCampaigns(tfSearchCampaigns.getText().trim());
                }
            } catch (IOException ex) {
                Logger.getLogger(Overview.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tfSearchCampaignsKeyPressed

    private void btSearchCampaignsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchCampaignsActionPerformed
        try {
            if(tfSearchCampaigns.getText().trim().equals("")){
                getCampaigns(GET_ALL);
            } else {
                getCampaigns(tfSearchCampaigns.getText().trim());
            }
        } catch (IOException ex) {
            Logger.getLogger(Overview.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btSearchCampaignsActionPerformed

    private void miLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLogoutActionPerformed
        Session.setCurrentUsername(null);
        Session.setCurrentServerIp(null);
        Session.setCurrentServerPort(0);
        Session.setCurrentPassword(null);

        dispose();
        Main.displayLogin();
    }//GEN-LAST:event_miLogoutActionPerformed

    private void miChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miChangePasswordActionPerformed
        Main.displayChangePassword();
    }//GEN-LAST:event_miChangePasswordActionPerformed

    private void miOptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miOptionsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miOptionsActionPerformed

    private void liMyEpisodesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_liMyEpisodesMouseClicked
        if (evt.getClickCount() == 2) {
            setSelectedEpisode(liMyEpisodes.getSelectedIndex());
        } else if (evt.getClickCount() == 3) {   // Triple-click
        }
    }//GEN-LAST:event_liMyEpisodesMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSearchCampaigns;
    private javax.swing.JLabel imgCampaign;
    private javax.swing.JLabel imgCampaign2;
    private javax.swing.JButton jButton1;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblAccess;
    private javax.swing.JLabel lblCampName;
    private javax.swing.JLabel lblCampaignDescription;
    private javax.swing.JLabel lblCharacterClass;
    private javax.swing.JLabel lblCharacterLevel;
    private javax.swing.JLabel lblCharacterName;
    private javax.swing.JLabel lblDmName;
    private javax.swing.JLabel lblEpisodeDate;
    private javax.swing.JLabel lblEpisodeDescription;
    private javax.swing.JLabel lblEpisodeDescription1;
    private javax.swing.JLabel lblEpisodeName;
    private javax.swing.JLabel lblEpisodeOrderNumber;
    private javax.swing.JLabel lblEpisodes;
    private javax.swing.JLabel lblEpisodes1;
    private javax.swing.JLabel lblLevel;
    private javax.swing.JLabel lblRPGType;
    private javax.swing.JList liMyCampaigns;
    private javax.swing.JList liMyEpisodes;
    private javax.swing.JList liMyEpisodes1;
    private javax.swing.JMenu menuAccount;
    private javax.swing.JMenu menuSettings;
    private javax.swing.JMenuItem miChangePassword;
    private javax.swing.JMenuItem miLogout;
    private javax.swing.JMenuItem miOptions;
    private javax.swing.JMenuBar overviewMenu;
    private javax.swing.JTextField tfSearchCampaigns;
    // End of variables declaration//GEN-END:variables
}