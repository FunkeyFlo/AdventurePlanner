/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

/**
 *
 * @author Flo
 */
public class Session {
    
    private static String currentUsername;
    private static String currentPassword;
    private static Integer currentUserId;
    private static String currentServerIp;
    private static Integer currentServerPort;
    
    public Session(){
    }
    
    public static String getCurrentUsername(){
        return currentUsername;
    }
    
    public static Integer getCurrentUserId(){
        return currentUserId;
    }
    
    public static String getCurrentPassword(){
        return currentPassword;
    }
    
    public static String getCurrentServerIp(){
        return currentServerIp;
    }
    
    public static Integer getCurrentServerPort(){
        return currentServerPort;
    }
    
    public static void setCurrentUsername(String username){
        currentUsername = username;
    }
    
    public static void setCurrentUserId(int userId){
        currentUserId = userId;
    }
    
    public static void setCurrentServerPort(int serverPort){
        currentServerPort = serverPort;
    }
    
    public static void setCurrentServerIp(String serverIp){
        currentServerIp = serverIp;
    }
    
    public static void setCurrentPassword(String password){
        currentPassword = password;
    }
}