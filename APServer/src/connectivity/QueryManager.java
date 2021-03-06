/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectivity;

import model.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Flo
 */
public class QueryManager {

    public final String SUCCESS = "success";
    public final String FAILED = "failed";
    private final DatabaseManager db = new DatabaseManager();
    public final int DEFAULT_INCORRECT_LOGIN = 0;
    public final int NO_ID_CREATED = 0;
    public PreparedStatement preparedStatement = null;

//-----USER-QUERIES-------------------------------------------------------------
    public User getUserData(String username) {
        User user = new User();
        try {
            db.openConnection();
            preparedStatement = db.connection.prepareStatement("SELECT *"
                    + "FROM `users`"
                    + "WHERE `username`= ?"
                    + "LIMIT 1");
            preparedStatement.setString(1, username);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                user.setUserId(result.getInt("id"));
                user.setUsername(result.getString("username"));
                user.setFirstName(result.getString("first_name"));
                user.setLastName(result.getString("last_name"));
                user.setPassword(result.getString("password"));
                user.setIncorrectLogin(result.getInt("incorrect_login"));
                user.setEmail(result.getString("email"));
            }
        } catch (SQLException e) {
            System.out.println(db.SQL_EXCEPTION + e.getMessage());
        } finally {
            db.closeConnection();
        }
        return user;
    }

    public User getUserData(int userId) {
        User user = new User();
        try {
            db.openConnection();
            preparedStatement = db.connection.prepareStatement("SELECT *"
                    + "FROM `users`"
                    + "WHERE `username`= ?"
                    + "LIMIT 1");
            preparedStatement.setInt(1, userId);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                user.setUserId(result.getInt("id"));
                user.setUsername(result.getString("username"));
                user.setFirstName(result.getString("first_name"));
                user.setLastName(result.getString("last_name"));
                user.setPassword(result.getString("password"));
                user.setIncorrectLogin(result.getInt("incorrect_login"));
                user.setEmail(result.getString("email"));
            }
        } catch (SQLException e) {
            System.out.println(db.SQL_EXCEPTION + e.getMessage());
        } finally {
            db.closeConnection();
        }
        return user;
    }

    public void createUser(String username, String password, String firstName,
            String lastName, String email) {
        try {
            db.openConnection();
            password = BCrypt.hashpw(password, BCrypt.gensalt());
            preparedStatement = db.connection.prepareStatement("INSERT INTO "
                    + "`users`(`username`, `password`, `first_name`, `last_name`,"
                    + "`email`, `incorrect_login`)"
                    + "VALUES (?,?,?,?,?,?)");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, firstName);
            preparedStatement.setString(4, lastName);
            preparedStatement.setString(5, email);
            preparedStatement.setInt(6, DEFAULT_INCORRECT_LOGIN);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection();
        }
    }

    public boolean checkUsernameAvailibility(String username) {
        boolean available = false;
        try {
            db.openConnection();
            preparedStatement = db.connection.prepareStatement("SELECT `username`"
                    + "FROM `users`"
                    + "WHERE `username` = ?"
                    + "LIMIT 1");
            preparedStatement.setString(1, username);
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                available = false;
            } else {
                available = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QueryManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection();
        }
        return available;
    }

    public void changePassword(String password, String username) {
        try {
            password = BCrypt.hashpw(password, BCrypt.gensalt());
            db.openConnection();
            preparedStatement = db.connection.prepareStatement("UPDATE `users`"
                    + "SET `password` = ?"
                    + "WHERE `username` = ?"
                    + "LIMIT 1");
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection();
        }
    }

//-----CAMPAIGN-QUERIES---------------------------------------------------------
    public int createCampaign(String name, int access, String rpgType, String description) {
        int campaignId = NO_ID_CREATED;
        try {
            db.openConnection();
            preparedStatement = db.connection.prepareStatement("INSERT INTO `campaigns`"
                    + "(`name`, `access`, `rpg_type`, `description`)"
                    + "VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, access);
            preparedStatement.setString(3, rpgType);
            preparedStatement.setString(4, description);
            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            rs.next();
            campaignId = rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(QueryManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection();
        }
        return campaignId;
    }

    public void linkCampaignToUser(int campaignId, int userId, int role) {
        try {
            db.openConnection();
            preparedStatement = db.connection.prepareStatement("INSERT INTO `users_has_campaigns`"
                    + "(`campaigns_id`, `users_id`, `role`)"
                    + "VALUES (?,?,?)");
            preparedStatement.setInt(1, campaignId);
            preparedStatement.setInt(2, userId);
            preparedStatement.setInt(3, role);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection();
        }
    }

    public ArrayList<Campaign> searchCampaigns(String searchArg) {
        ArrayList<Campaign> campaigns = new ArrayList<>();
        try {
            db.openConnection();
            preparedStatement = db.connection.prepareStatement("SELECT *"
                    + "FROM `campaigns`"
                    + "WHERE `name`"
                    + "LIKE ?"
                    + "ORDER BY `name`");
            preparedStatement.setString(1, '%' + searchArg + '%');
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                campaigns.add(new Campaign(result.getInt("id"),
                        result.getInt("access"),
                        result.getString("name"),
                        result.getString("rpg_type"),
                        result.getString("description")));
            }
        } catch (SQLException e) {
            System.out.println(db.SQL_EXCEPTION + e.getMessage());
        } finally {
            db.closeConnection();
        }
        return campaigns;
    }

    public ArrayList<Campaign> searchMyCampaigns(int userId, String searchArg) {
        ArrayList<Campaign> campaigns = new ArrayList<>();
        try {
            db.openConnection();
            preparedStatement = db.connection.prepareStatement(""
                    + "SELECT `campaigns`.`id`, `campaigns`.`name`, `campaigns`.`access`, "
                    + "`campaigns`.`rpg_type`, `campaigns`.`description` "
                    + "FROM `campaigns` "
                    + "JOIN `users_has_campaigns` "
                    + "ON `campaigns`.`id` = `users_has_campaigns`.`campaigns_id` "
                    + "WHERE `users_has_campaigns`.`users_id` = ? "
                    + "AND `campaigns`.`name` LIKE ? "
                    + "ORDER BY `campaigns`.`name`");
            preparedStatement.setInt(1, userId);
            preparedStatement.setString(2, '%' + searchArg + '%');
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                campaigns.add(new Campaign(result.getInt("id"),
                        result.getInt("access"),
                        result.getString("name"),
                        result.getString("rpg_type"),
                        result.getString("description")));
            }
        } catch (SQLException e) {
            System.out.println(db.SQL_EXCEPTION + e.getMessage());
        } finally {
            db.closeConnection();
        }
        return campaigns;
    }

//-----EPISODE-QUERIES----------------------------------------------------------
    public int createEpisode(String name, String description, String date,
            int orderNumber, int campaignId, int dmId) {
        int episodeId = NO_ID_CREATED;
        try {
            db.openConnection();
            preparedStatement = db.connection.prepareStatement("INSERT INTO `episodes`"
                    + "(`name`, `description`, `date`, `order_number`,"
                    + "`campaigns_id`, `users_id`)"
                    + "VALUES (?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, description);
            preparedStatement.setString(3, date);
            preparedStatement.setInt(4, orderNumber);
            preparedStatement.setInt(5, campaignId);
            preparedStatement.setInt(6, dmId);
            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            rs.next();
            episodeId = rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(QueryManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection();
        }
        return episodeId;
    }

    public ArrayList<Episode> getEpisodes(int campaignId) {
        ArrayList<Episode> episodes = new ArrayList<>();
        try {
            db.openConnection();
            preparedStatement = db.connection.prepareStatement("SELECT * "
                    + "FROM `episodes` "
                    + "WHERE `campaigns_id` = ? "
                    + "ORDER BY `order_number`");
            preparedStatement.setInt(1, campaignId);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                episodes.add(new Episode(result.getInt("id"),
                        result.getInt("campaigns_id"),
                        result.getInt("users_id"),
                        result.getInt("order_number"),
                        result.getString("name"),
                        result.getString("description"),
                        result.getString("date")));
            }
        } catch (SQLException e) {
            System.out.println(db.SQL_EXCEPTION + e.getMessage());
        } finally {
            db.closeConnection();
        }
        return episodes;
    }

//-----CHARACTER-QUERIES--------------------------------------------------------
    public int createCharacter(PlayerCharacter character) {
        int characterId = NO_ID_CREATED;
        try {
            db.openConnection();
            preparedStatement = db.connection.prepareStatement("INSERT INTO characters "
                    + "(`name`, `description`, `class`, `race`, `level`, `gender`, `users_id`)"
                    + "VALUES (?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, character.getName());
            preparedStatement.setString(2, character.getDescription());
            preparedStatement.setString(3, character.getClassType());
            preparedStatement.setString(4, character.getRace());
            preparedStatement.setInt(5, character.getLevel());
            preparedStatement.setString(6, character.getGender());
            preparedStatement.setInt(7, character.getUserId());
            preparedStatement.executeUpdate();
            
            ResultSet rs = preparedStatement.getGeneratedKeys();
            rs.next();
            characterId = rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(QueryManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection();
        }
        return characterId;
    }

    public ArrayList<PlayerCharacter> getMyCharacters(int campaignId) {
        ArrayList<PlayerCharacter> characters = new ArrayList<>();
        try {
            db.openConnection();
            preparedStatement = db.connection.prepareStatement("SELECT * "
                    + "FROM `characters` "
                    + "WHERE `users_id` = ? "
                    + "ORDER BY `name`");
            preparedStatement.setInt(1, campaignId);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                characters.add(new PlayerCharacter(result.getInt("id"),
                        result.getInt("level"),
                        result.getInt("users_id"),
                        result.getString("name"),
                        result.getString("gender"),
                        result.getString("class"),
                        result.getString("race"),
                        result.getString("description")));
            }
        } catch (SQLException e) {
            System.out.println(db.SQL_EXCEPTION + e.getMessage());
        } finally {
            db.closeConnection();
        }
        return characters;
    }
    
    public boolean checkCharacterOwnership(int userId, int characterId) {
        boolean value = false;
        try {
            db.openConnection();
            preparedStatement = db.connection.prepareStatement("SELECT * "
                    + "FROM `characters` "
                    + "WHERE `id` = ? "
                    + "AND `users_id` = ?");
            preparedStatement.setInt(1, characterId);
            preparedStatement.setInt(2, userId);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                value = true;
            }
        } catch (SQLException e) {
            System.out.println(db.SQL_EXCEPTION + e.getMessage());
        } finally {
            db.closeConnection();
        }
        return value;
    }
    
    public void deleteCharacter(int id) {
        try {
            db.openConnection();
            preparedStatement = db.connection.prepareStatement("DELETE "
                    + "FROM `characters` "
                    + "WHERE `id` = ? ");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(db.SQL_EXCEPTION + e.getMessage());
        } finally {
            db.closeConnection();
        }
    }
    
    public void linkCharacterToEpisode(int episodeId, int characterId) {
        ;
        try {
            db.openConnection();
            preparedStatement = db.connection.prepareStatement("INSERT INTO characters_has_episodes "
                    + "(characters_id, episodes_id) "
                    + "VALUES (?,?)");
            preparedStatement.setInt(1, characterId);
            preparedStatement.setInt(2, episodeId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(db.SQL_EXCEPTION + e.getMessage());
        } finally {
            db.closeConnection();
        }
    }
    
    public ArrayList<PlayerCharacter> getCharactersForEpisode(int episodeId) {
        ArrayList<PlayerCharacter> characters = new ArrayList<>();
        try {
            db.openConnection();
            preparedStatement = db.connection.prepareStatement(""
                    + "SELECT `characters`.`id`, `characters`.`name`, "
                    + "`characters`.`description`, `characters`.`class`, "
                    + "`characters`.`race`, `characters`.`level`, "
                    + "`characters`.`users_id` "
                    + "FROM `campaigns` "
                    + "JOIN `characters_has_episodes` "
                    + "ON `characters`.`id` = `characters_has_episodes`.`characters_id` "
                    + "WHERE `characters_has_episodes`.`episodes_id` = ? "
                    + "ORDER BY `characters`.`name`");
            preparedStatement.setInt(1, episodeId);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                characters.add(new PlayerCharacter(result.getInt("id"),
                        result.getInt("level"),
                        result.getInt("users_id"),
                        result.getString("name"),
                        result.getString("gender"),
                        result.getString("class"),
                        result.getString("race"),
                        result.getString("description")));
            }
        } catch (SQLException e) {
            System.out.println(db.SQL_EXCEPTION + e.getMessage());
        } finally {
            db.closeConnection();
        }
        return characters;
    }
}