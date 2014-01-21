/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import connectivity.QueryManager;
import model.User;

/**
 *
 * @author flo
 */
public class GlobalFunctions {
    
    private QueryManager query = new QueryManager();
    
    public String[] seperator(String sepItem, String sepChar){
        String[] seperatedItems = {"", "", ""};
        if (sepItem == null) {
            return seperatedItems;
        } else {
            String[] temp = sepItem.split(sepChar);

            try{
                for (int i = 0; i < temp.length; i++) {
                    seperatedItems[i] += (temp[i]);
                }
            } catch(IndexOutOfBoundsException e) {
                System.out.println(e.toString());
            }

            return seperatedItems;
        }
    }
    
    public boolean authenticate(String username, String password) {
        User user = new User();
        try {
            user = query.getUserData(username);
            if (user.getUsername().equals(username)) {
                if (user.getPassword().equals(password)) {
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