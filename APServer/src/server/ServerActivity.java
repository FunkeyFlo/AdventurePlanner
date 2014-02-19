/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import model.*;
import connectivity.QueryManager;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.logging.*;
import main.GlobalFunctions;
import main.ServerSettings;
import views.ServerMonitor;

/**
 *
 * @author flo
 */
public class ServerActivity implements Runnable {

    private QueryManager query = new QueryManager();
    private CommandFunctions comFunc = new CommandFunctions();
    private ServerMonitor sm;
    private final Integer STANDARD_CAMPAIGN_CREATION_ROLE = 1;
    private String lastConnection = null;
    public static boolean running = false;
    private GlobalFunctions globFunc = new GlobalFunctions();

    public ServerActivity(ServerMonitor serverMonitor) {
        sm = serverMonitor;
    }

    public void run() {
        try {
            System.out.println("Thread has been activated..");
            startServer();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServerActivity.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void startServer() throws IOException, ClassNotFoundException {
        ServerSocket server = new ServerSocket(ServerSettings.getNetworkPort());
        sm.writeToOutput("[NETWORK]\tServer running on port: "
                + ServerSettings.getNetworkPort());
        while (true) {
            ArrayList<String> datas = new ArrayList<>();
            String username = null, password = null, command = null;
            String line = null;

            Socket connection = server.accept();

            ObjectInputStream inStream = new ObjectInputStream(
                    connection.getInputStream());
            datas = (ArrayList) inStream.readObject();

            username = datas.get(0);
            password = datas.get(1);
            command = datas.get(2);

            if (!connection.getInetAddress().toString().equals(lastConnection)) {
                sm.writeToOutput("\n[IP]\tincomming request from: "
                        + connection.getInetAddress().toString().substring(
                                1, connection.getInetAddress().toString().length()));
                lastConnection = connection.getInetAddress().toString();
            }

            sm.writeToOutput("[SM]\t" + username + ":\t" + command);

            if (comFunc.authenticate(username, password)) {
                switch (command) {
//------USER-CASES--------------------------------------------------------------
                    case "login": {
                        OutputStream toClient = connection.getOutputStream();
                        PrintStream ps = new PrintStream(toClient, true);

                        ps.println("Login succesful!");
                        break;
                    }
                    case "changePassword": {
                        OutputStream toClient = connection.getOutputStream();
                        PrintStream ps = new PrintStream(toClient, true);

                        String oldPassword = datas.get(3);
                        String newPassword = datas.get(4);

                        // check if old password matches
                        if (globFunc.authenticate(username, oldPassword)) {
                            query.changePassword(newPassword, username);
                            ps.println("Password has successfully been changed");
                            break;
                        } else {
                            ps.println("Old password was incorrect");
                            break;
                        }
                    }
                    case "getMyInfo": {
                        int userId = Integer.parseInt(datas.get(3));
                        ArrayList<String> userInfo = comFunc.getUserInfo(userId);
                        ObjectOutputStream toClient = new ObjectOutputStream(
                                connection.getOutputStream());
                        toClient.writeObject(userInfo);
                        break;
                    }
//------CAMPAIGN-CASES----------------------------------------------------------
                    case "getCampaigns": {
                        String searchArg = datas.get(3);

                        if (searchArg.equals("ALL")) {
                            searchArg = "";
                        }

                        ArrayList<Campaign> campaigns = query.searchCampaigns(searchArg);
                        ObjectOutputStream toClient = new ObjectOutputStream(
                                connection.getOutputStream());
                        toClient.writeObject(campaigns);
                        break;
                    }
                    case "getMyCampaigns": {
                        Integer userId = Integer.parseInt(datas.get(3));
                        String searchArg = datas.get(4);

                        if (searchArg.equals("ALL")) {
                            searchArg = "";
                        }

                        ArrayList<Campaign> campaigns = query.searchMyCampaigns(
                                userId, searchArg);
                        ObjectOutputStream toClient = new ObjectOutputStream(
                                connection.getOutputStream());
                        toClient.writeObject(campaigns);
                        break;
                    }
                    case "createCampaign": {
                        String campaignName = datas.get(3);
                        Integer access = Integer.parseInt(datas.get(4));
                        String rpgType = datas.get(5);
                        String description = datas.get(6);
                        Integer userId = Integer.parseInt(datas.get(7));

                        Integer campaignId = query.createCampaign(campaignName,
                                access, rpgType, description);
//                            System.out.println(campaignId);

                        query.linkCampaignToUser(campaignId, userId,
                                STANDARD_CAMPAIGN_CREATION_ROLE);

                        break;
                    }
                    case "linkUserToCampaign": {
                        Integer adminId = Integer.parseInt(datas.get(3));
                        Integer campaignId = Integer.parseInt(datas.get(4));
                        Integer userId = Integer.parseInt(datas.get(5));

                            // TODO Check if user is admin of campaign
                        // TODO Link campaign to user
                        // TODO (NTH) Adding multiple users to same campaign
                        break;
                    }
//------EPISODE-CASES-----------------------------------------------------------
                    case "getEpisodes": {
                        ArrayList<Episode> episodes = comFunc.getEpisodes(datas);
                        
                        ObjectOutputStream toClient = new ObjectOutputStream(
                                connection.getOutputStream());
                        toClient.writeObject(episodes);
                        break;
                    }
                    case "createEpisode": {
                        
                        break;
                    }
                    default: {
                        OutputStream toClient = connection.getOutputStream();
                        PrintStream ps = new PrintStream(toClient, true);
                        ps.println("You are using an old version..");
                        sm.writeToOutput("[ERROR]\tNo command was provided by client");
                        break;
                    }
                }
            } else {
                OutputStream toClient = connection.getOutputStream();
                PrintStream ps = new PrintStream(toClient, true);
                ps.println("Authentication failed..");
                sm.writeToOutput("[ERROR]\tAuthentication failed");
            }
        }
    }
}
