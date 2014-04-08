/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.awt.Color;
import java.util.*;
import javax.swing.BorderFactory;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import model.PlayerCharacter;
import view.*;

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
    
    public static void displayAddCharacters() {
        AddCharacters addCharacters = new AddCharacters();
        addCharacters.setVisible(true);
    }
    
    public static void displayOverview() {
        Overview frameOverview = new Overview();
        frameOverview.setVisible(true);
    }
    
    public static void displayCreateCampaign() {
        CreateCampaign frameCreateCampaign = new CreateCampaign();
        frameCreateCampaign.setVisible(true);
    }
    
    public static void displayChangePassword() {
        ChangePassword frameChangePassword = new ChangePassword();
        frameChangePassword.setVisible(true);
    }
    
    public static void main(String argv[]) throws Exception {
        UIManager.put("Menu.selectionBackground", Color.DARK_GRAY);
        UIManager.put("Menu.selectionForeground", Color.WHITE);
        UIManager.put("Menu.border", BorderFactory.createEmptyBorder());
        UIManager.put("PopupMenu.border", BorderFactory.createEmptyBorder());
        UIManager.put("MenuItem.selectionBackground", Color.DARK_GRAY);
        UIManager.put("MenuItem.selectionForeground", Color.WHITE);
        UIManager.put("MenuItem.background", Color.DARK_GRAY);
        UIManager.put("MenuItem.foreground", Color.WHITE);
        UIManager.put("MenuItem.acceleratorForeground", Color.WHITE);
        UIManager.put("MenuItem.acceleratorSelectionForeground", Color.WHITE);
        UIManager.put("Button.select", new java.awt.Color(255,127,0));
        UIManager.put("ComboBox.background", Color.GRAY);
        UIManager.put("ComboBox.buttonBackground", Color.GRAY);
        UIManager.put("TextField.background", new java.awt.Color(102, 102, 102));
        UIManager.put("TextField.foreground", Color.WHITE);
        UIManager.put("ScrollBar.background", new java.awt.Color(102, 102, 102));
        UIManager.put("ScrollBar.foreground", new java.awt.Color(102, 102, 102));
        UIManager.put("ScrollPane.foreground", new java.awt.Color(102, 102, 102));
        UIManager.put("ScrollPane.foreground", new java.awt.Color(102, 102, 102));
        UIManager.put("TextPane.border", BorderFactory.createEmptyBorder());
        UIManager.put("List.focusCellHighlightBorder", new java.awt.Color(255,127,0));
        UIManager.put("OptionPane.background",  new java.awt.Color(51, 51, 51));
        UIManager.put("Panel.background", new java.awt.Color(51, 51, 51));
        UIManager.put("OptionPane.messageForeground",  new java.awt.Color(255, 127, 0));

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                displayLogin();

            }
        });
    }
}