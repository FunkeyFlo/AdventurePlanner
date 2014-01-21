/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import view.Login;
import view.Overview;
import java.awt.Color;
import java.util.*;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Flo
 */
public class Main {
    
    public static ArrayList<String> seperator(String sepItem, String sepChar){
        ArrayList<String> seperatedItems = new ArrayList<>();
        if (sepItem == null) {
            return seperatedItems;
        } else {

            String[] temp = sepItem.split(sepChar);

            for (int i = 0; i < temp.length; i++) {
                seperatedItems.add(temp[i]);
            }

            return seperatedItems;
        }
    }
    
    public static void displayLogin() {
        Login frameLogin = new Login();
        frameLogin.setVisible(true);
    }
    
    public static void displayOverview() {
        Overview frameOverview = new Overview();
        frameOverview.setVisible(true);
    }
    
    public static void main(String argv[]) throws Exception {
        UIManager.put("Menu.selectionBackground", Color.DARK_GRAY);
        UIManager.put("Menu.selectionForeground", Color.WHITE);
        UIManager.put("MenuItem.selectionBackground", Color.DARK_GRAY);
        UIManager.put("MenuItem.selectionForeground", Color.WHITE);
        UIManager.put("MenuItem.background", Color.DARK_GRAY);
        UIManager.put("MenuItem.foreground", Color.WHITE);
        UIManager.put("Button.select", Color.DARK_GRAY);
        UIManager.put("ComboBox.background", Color.GRAY);
        UIManager.put("ComboBox.buttonBackground", Color.GRAY);
        UIManager.put("TextField.background", new java.awt.Color(102, 102, 102));
        UIManager.put("TextField.foreground", Color.WHITE);
//        UIManager.put();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                displayLogin();

            }
        });
    }
}