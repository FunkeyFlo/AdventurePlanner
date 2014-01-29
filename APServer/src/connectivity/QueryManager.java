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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Flo
 */
public class QueryManager {
    
    private final DatabaseManager db = new DatabaseManager();
    public final int DEFAULT_INCORRECT_LOGIN = 0;
    public PreparedStatement preparedStatement = null;
    
//-----USER-QUERIES-------------------------------------------------------------
    public User getUserData(String username) {
        User user = new User();
        try {
            db.openConnection();
            preparedStatement = db.connection.prepareStatement("SELECT * FROM "
                    + "`users` WHERE `username`= ? LIMIT 1");
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
        }
        finally
        {
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
    
    public boolean checkUsernameAvailibility(String username){
        boolean available = false;
        try {
            db.openConnection();
            preparedStatement = db.connection.prepareStatement("SELECT `username`"
                    + "FROM `users` WHERE `username` = ? LIMIT 1");
            preparedStatement.setString(1, username);
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                available = false;
            } else {
                available = true;
            }
        } catch(SQLException ex) {
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
                    + "SET `password` = ? WHERE `username` = ? LIMIT 1");
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
    public ArrayList<Campaign> searchCampaigns(String searchArg) {
        ArrayList<Campaign> campaigns = new ArrayList<>();
        try {
            db.openConnection();
            preparedStatement = db.connection.prepareStatement("SELECT * FROM "
                    + "`campaigns` WHERE `name` LIKE ? ORDER BY `name`");
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
        }
        finally
        {
            db.closeConnection();
        }
        return campaigns;
    }
    
    public ArrayList<Campaign> searchMyCampaigns(int userId, String searchArg) {
        ArrayList<Campaign> campaigns = new ArrayList<>();
        try {
            db.openConnection();
            preparedStatement = db.connection.prepareStatement(""
                    + "SELECT campaigns.id, campaigns.name, campaigns.access,"
                        + "campaigns.rpg_type, campaigns.description "
                    + "FROM campaigns "
                    + "JOIN users_has_campaigns "
                    + "ON campaigns.id = users_has_campaigns.campaigns_id "
                    + "WHERE users_has_campaigns.users_id = ? "
                    + "AND campaigns.name LIKE ? "
                    + "ORDER BY campaigns.name");
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
        }
        finally
        {
            db.closeConnection();
        }
        return campaigns;
    }
    
//-----EPISODE-QUERIES----------------------------------------------------------
    public ArrayList<Episode> getEpisodes(int campaignId) {
        ArrayList<Episode> episodes = new ArrayList<>();
        try {
            db.openConnection();
            preparedStatement = db.connection.prepareStatement("SELECT * FROM "
                    + "`episodes` WHERE `campaigns_id` = ? ORDER BY `order_number`");
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
        }
        finally
        {
            db.closeConnection();
        }
        return episodes;
    }
}