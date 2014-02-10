/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Flo
 */
public class ServerSettings {
    
    private static String dbName;
    private static String dbUser;
    private static String dbPassword;
    private static Integer networkPort;
    
    public ServerSettings(){
    }
    
    public static String getDbName(){
        return dbName;
    }
    
    public static String getDbuser(){
        return dbUser;
    }
    
    public static String getDbPassword(){
        return dbPassword;
    }
    
    public static Integer getNetworkPort(){
        return networkPort;
    }
    
    public static void setServerSettings() throws FileNotFoundException{
    
    Properties prop = new Properties();
    InputStream input = null;

        try {

                input = new FileInputStream("config.properties");

                // load a properties file
                prop.load(input);

                // get the property value and print it out
                dbName = prop.getProperty("database_name");
                dbUser = prop.getProperty("database_user");
                dbPassword = prop.getProperty("database_password");
                networkPort = Integer.parseInt(prop.getProperty("network_port"));

        } catch (IOException ex) {
                ex.printStackTrace();
        } finally {
                if (input != null) {
                        try {
                                input.close();
                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                }
        }
    }
}