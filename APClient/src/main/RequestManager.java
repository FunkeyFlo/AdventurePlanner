/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.PlayerCharacter;

/**
 *
 * @author Florentijn
 */
public class RequestManager {

    public void createCampaign(String campaignName, Integer access, String rpgType, String description) {
        try (Socket connection = new Socket(Session.getCurrentServerIp(),
                Session.getCurrentServerPort())) {
            ArrayList<String> stream = new ArrayList<>();

            stream.add(Session.getCurrentUsername());
            stream.add(Session.getCurrentPassword());
            stream.add("createCampaign");
            stream.add(campaignName);
            stream.add(access.toString());
            stream.add(rpgType);
            stream.add(description);
            stream.add(Session.getCurrentUserId().toString());

            ObjectOutputStream toServer = new ObjectOutputStream(connection.getOutputStream());
            toServer.writeObject(stream);
        } catch (IOException ex) {
            Logger.getLogger(RequestManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean createCharacter(PlayerCharacter character) {
        boolean value = false;
        try (Socket connection = new Socket(Session.getCurrentServerIp(),
                Session.getCurrentServerPort())) {
            ArrayList<String> stream = new ArrayList<>();

            stream.add(Session.getCurrentUsername());
            stream.add(Session.getCurrentPassword());
            stream.add("createCharacter");

            ObjectOutputStream toServer = new ObjectOutputStream(connection.getOutputStream());
            toServer.writeObject(stream);
            toServer.flush();
            toServer.writeObject(character);
            toServer.flush();

            InputStream in = connection.getInputStream();
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(in));
            String line = fromServer.readLine();
            connection.close();

            if (line.equals("success")) {
                value = true;
            } else {
                value = false;
            }

        } catch (IOException ex) {
            Logger.getLogger(RequestManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return value;
    }

    public void deleteCharacter(Integer characterId) {
        try (Socket connection = new Socket(Session.getCurrentServerIp(),
                Session.getCurrentServerPort())) {
            ArrayList<String> stream = new ArrayList<>();

            stream.add(Session.getCurrentUsername());
            stream.add(Session.getCurrentPassword());
            stream.add("deleteCharacter");
            stream.add(characterId.toString());

            ObjectOutputStream toServer = new ObjectOutputStream(connection.getOutputStream());
            toServer.writeObject(stream);
            toServer.flush();
            connection.close();

        } catch (IOException ex) {
            Logger.getLogger(RequestManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<PlayerCharacter> getMyCharacters() {
        ArrayList<PlayerCharacter> characters = new ArrayList<>();
        try (Socket connection = new Socket(Session.getCurrentServerIp(),
                Session.getCurrentServerPort())) {
            ArrayList<String> stream = new ArrayList<>();

            stream.add(Session.getCurrentUsername());
            stream.add(Session.getCurrentPassword());
            stream.add("getMyCharacters");
            stream.add(Session.getCurrentUserId().toString());

            ObjectOutputStream toServer = new ObjectOutputStream(connection.getOutputStream());
            toServer.writeObject(stream);
            
            ObjectInputStream inStream = new ObjectInputStream(connection.getInputStream());
            characters = (ArrayList) inStream.readObject();
            
            System.out.println(characters);
            
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(RequestManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return characters;
    }

    public ArrayList<PlayerCharacter> getCharactersForEpisode(Integer episodeId) {
        ArrayList<PlayerCharacter> characters = new ArrayList<>();
        try (Socket connection = new Socket(Session.getCurrentServerIp(),
                Session.getCurrentServerPort())) {
            ArrayList<String> stream = new ArrayList<>();

            stream.add(Session.getCurrentUsername());
            stream.add(Session.getCurrentPassword());
            stream.add("deleteCharacter");
            stream.add(episodeId.toString());

            ObjectOutputStream toServer = new ObjectOutputStream(connection.getOutputStream());
            toServer.writeObject(stream);
            toServer.flush();

            ObjectInputStream inStream = new ObjectInputStream(connection.getInputStream());
            characters = (ArrayList) inStream.readObject();

        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(RequestManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return characters;
    }
}
