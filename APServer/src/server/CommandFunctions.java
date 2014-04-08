/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import connectivity.BCrypt;
import connectivity.QueryManager;
import java.util.ArrayList;
import model.Episode;
import model.PlayerCharacter;
import model.User;

/**
 *
 * @author Florentijn
 */
public class CommandFunctions {

    QueryManager QUERY = new QueryManager();

    public CommandFunctions() {
    }

    public boolean authenticate(String username, String password) {
        try {
            User user = QUERY.getUserData(username);
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
        } catch (Exception e) {
            System.out.println("jammer hoor..");
        }
        return false;
    }

    public Integer checkUserId(String username, String password) {
        Integer userId = 0;
        try {
            User user = QUERY.getUserData(username);
            if (user.getUsername().equals(username)) {
                if (BCrypt.checkpw(password, user.getPassword())) {
                    user.setIsLoggedIn(true);
                    userId = user.getUserId();
                }
            }
        } catch (Exception e) {
            System.out.println("jammer hoor..");
        }
        return userId;
    }

    public ArrayList<String> getUserInfo(int userId) {
        ArrayList<String> userInfo = new ArrayList<>();
        User requestedUser = QUERY.getUserData(userId);

        String clientsUsername = requestedUser.getUsername();
        Integer clientsUserId = requestedUser.getUserId();
        String clientsFirstName = requestedUser.getFirstName();
        String clientsLastName = requestedUser.getLastName();
        String clientsEmail = requestedUser.getEmail();

        userInfo.add(clientsUsername);
        userInfo.add(clientsUserId.toString());
        userInfo.add(clientsFirstName);
        userInfo.add(clientsLastName);
        userInfo.add(clientsEmail);

        return userInfo;
    }

//------EPISODE-COMMANDS--------------------------------------------------------
    public ArrayList<Episode> getEpisodes(ArrayList<String> datas) {
        int campaignId = Integer.parseInt(datas.get(3));

        ArrayList<Episode> episodes = QUERY.getEpisodes(campaignId);

        return episodes;
    }

//------CHARACTER-COMMANDS------------------------------------------------------
    public ArrayList<PlayerCharacter> getMyCharacters(ArrayList<String> datas) {
        int userId = Integer.parseInt(datas.get(3));

        ArrayList<PlayerCharacter> characters = QUERY.getMyCharacters(userId);

        return characters;
    }
}
