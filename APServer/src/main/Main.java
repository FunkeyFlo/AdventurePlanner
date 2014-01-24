/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

//import connectivity.QueryManager;
//import java.io.*;
//import java.net.*;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
//import models.*;
import views.*;

/**
 *
 * @author Flo
 */
public class Main {
    private static Thread serverThread;
    private static ServerMonitor frameServerMonitor;
    
    public static void displayServerMonitor() {
        frameServerMonitor = new ServerMonitor();
        frameServerMonitor.setVisible(true);
    }
    
    public static void displayServerOptions() {
        ServerOptions frameServerOptions = new ServerOptions();
        frameServerOptions.setVisible(true);
    }
    
    public static void displayCreateUser() {
        CreateUser frameCreateUser = new CreateUser();
        frameCreateUser.setVisible(true);
    }
    
    public static void stopServer(){
        if(ServerActivity.running){
            ServerActivity.running = false;
            JOptionPane.showMessageDialog(null, "Server has succesfuly been stopped..", "Notification",
                                JOptionPane.PLAIN_MESSAGE);
        } else {
            System.out.println("Server is not running");
            JOptionPane.showMessageDialog(null, "Server is not running", "Error",
                                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void startServer(){
//        if(!ServerActivity.running){
//            ServerActivity.running = true;
//            frameServerMonitor.writeToOutput("[Startup]\tServer succesfuly started..");
//        } else {
//            System.out.println("Server is already running");
//            JOptionPane.showMessageDialog(null, "Server is already running", "Error",
//                                JOptionPane.ERROR_MESSAGE);
//        }
        try {
            ServerSettings.setServerSettings();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        serverThread.start();
    }
    
    public static void main(String args[]) throws Exception {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                displayServerMonitor();
                serverThread = new Thread(new ServerActivity(frameServerMonitor), "serverThread");
                
//                Session session = new Session();

            }
        });
    }
}