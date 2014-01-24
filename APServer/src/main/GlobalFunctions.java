/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import connectivity.BCrypt;
import connectivity.QueryManager;
import java.util.ArrayList;
import model.User;

/**
 *
 * @author flo
 */
public class GlobalFunctions {
    
    private QueryManager query = new QueryManager();
    
    public ArrayList<String> seperator(String sepItem, String sepChar){
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
    
    public boolean authenticate(String username, String password) {
        User user = new User();
        try {
            user = query.getUserData(username);
            if (user.getUsername().equals(username)) {
                if (BCrypt.checkpw(password, user.getPassword())) {
                    user.setIsLoggedIn(true);
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch(Exception e) {
            System.out.println("jammer hoor..");
        }
        return false;
    }
}