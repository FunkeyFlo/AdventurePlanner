/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import model.Campaign;
import model.User;
import connectivity.QueryManager;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import main.*;
import views.ServerMonitor;

/**
 *
 * @author flo
 */
public class ServerActivity implements Runnable {
    
    private QueryManager query = new QueryManager();
    private ServerMonitor sm;
    private String lastConnection = null;
    public static boolean running = false;
    private GlobalFunctions globFunc = new GlobalFunctions();
    
    public ServerActivity(ServerMonitor serverMonitor){
        sm = serverMonitor;
    }
    
    public void run() {
        try {
            startServer();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        System.out.println("Thread has been activated..");
    }
    
    public void startServer() throws IOException {
        while(true){
            ServerSocket server = new ServerSocket(1226);
            while(running) {
                String[] datas = {null, null, null};
                String username = null, password = null, command = null;
                String line = null;

                Socket connection = server.accept();

                InputStream in = connection.getInputStream();
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(in));
                line = fromClient.readLine();

                if(line.length() < 100){

                    datas = globFunc.seperator(line, ":");
                    username = datas[0];
                    password = datas[1];
                    command = datas[2];
                    if(!connection.getInetAddress().toString().equals(lastConnection)){
                        sm.writeToOutput("\n[IP]\tincomming request from: "
                                + connection.getInetAddress().toString().substring(
                                        1, connection.getInetAddress().toString().length()));
                        lastConnection = connection.getInetAddress().toString();
                    }
                    sm.writeToOutput("[SM]\t" + username + ":" + command);

                    if(globFunc.authenticate(username, password)) {
                        switch (command) {
                            case "login":
                                {
                                    OutputStream toClient = connection.getOutputStream();
                                    PrintStream ps = new PrintStream(toClient, true); // Second param: auto-flush on write = true

                                    ps.println("Login succesful!");

                                    break;
                                }
                            case "getMyInfo":
                                {
                                    OutputStream toClient = connection.getOutputStream();
                                    PrintStream ps = new PrintStream(toClient, true);

                                    User requestedUser = query.getUserData(username);
                                    String clientsUsername = requestedUser.getUsername();
                                    String clientsFirstName = requestedUser.getFirstName();
                                    String clientsLastName = requestedUser.getLastName();
                                    String clientsEmail = requestedUser.getEmail();

                                    ps.println(clientsUsername
                                            + ":" + clientsFirstName
                                            + ":" + clientsLastName
                                            + ":" + clientsEmail);

                                    break;
                                }
                            case "getMyCampaigns":
                                {
                                    System.out.println("not yet implemented");
                                    break;
                                }
                            case "getAllCampaigns":
                                {
                                    ArrayList<Campaign> campaigns = query.getCampaigns(0);
                                    
//                                    ObjectOutputStream oos = new ObjectOutputStream(
//                                            connection.getOutputStream());
                                    ObjectOutputStream objectOut = new ObjectOutputStream(
                                        new BufferedOutputStream(
                                        new FileOutputStream(
                                        "C:/Users/Flo/Documents/Adventure Planner/Campaign.bin")));
                                    
                                    objectOut.writeObject(campaigns);
                                    objectOut.flush();
                                    objectOut.close();
                                    
                                    break;
                                }
                            default:
                                {
                                    OutputStream toClient = connection.getOutputStream();
                                    PrintStream ps = new PrintStream(toClient, true);
                                    ps.println("You are using an old version..");
                                    sm.writeToOutput("[ERROR]\tNo command was provided by client");
                                }
                        }
                    } else {
                        OutputStream toClient = connection.getOutputStream();
                        PrintStream ps = new PrintStream(toClient, true); // Second param: auto-flush on write = true
                        ps.println("Authentication failed..");
                        sm.writeToOutput("[ERROR]\tAuthentication failed");
                    }
                } else {
                    OutputStream toClient = connection.getOutputStream();
                    PrintStream ps = new PrintStream(toClient, true); // Second param: auto-flush on write = true
                    ps.println("To much input");
                    sm.writeToOutput("[ALLERT]\tHACKER!!!");
                }
            }
        server.close();
        }
    }
}