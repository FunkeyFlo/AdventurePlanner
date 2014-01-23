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
                ArrayList<String> datas = new ArrayList<>();
                String username = null, password = null, command = null;
                String line = null;

                Socket connection = server.accept();

                InputStream in = connection.getInputStream();
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(in));
                line = fromClient.readLine();

                if(line.length() < 100){

                    datas = globFunc.seperator(line, ":");
                    System.out.println(line);
                    username = datas.get(0);
                    password = datas.get(1);
                    command = datas.get(2);
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
                            case "getCampaigns":
                                {
                                    String param1 = datas.get(3);
                                    
                                    if(param1.equals("ALL")){
                                        param1 = "";
                                    }
                                    
                                    ArrayList<Campaign> campaigns = query.searchCampaigns(param1);
                                    ObjectOutputStream toClient = new ObjectOutputStream(connection.getOutputStream());
                                    toClient.writeObject(campaigns);
                                    break;
                                }
                            case "changePassword":
                                {
                                    OutputStream toClient = connection.getOutputStream();
                                    PrintStream ps = new PrintStream(toClient, true); // Second param: auto-flush on write = true
                                    
                                    String oldPassword = datas.get(3);
                                    String newPassword = datas.get(4);
                                    
                                    // check if old password matches
                                    if(globFunc.authenticate(username, oldPassword)){
                                        query.changePassword(newPassword, username);
                                        ps.println("Password has successfully been changed");
                                        break;
                                    } else {
                                        ps.println("Old password was incorrect");
                                        break;
                                    }
                                            
                                }
                            default:
                                {
                                    OutputStream toClient = connection.getOutputStream();
                                    PrintStream ps = new PrintStream(toClient, true);
                                    ps.println("You are using an old version..");
                                    sm.writeToOutput("[ERROR]\tNo command was provided by client");
                                    break;
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