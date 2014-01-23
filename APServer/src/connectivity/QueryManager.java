/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connectivity;

import model.Campaign;
import model.User;
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
    public final int MAX_INCORRECT_LOGINS = 3;
    public PreparedStatement preparedStatement = null;
    
    // USER QUERIES ------------------------------------------------------------
    public User getUserData(String username) {
        User user = new User();
        try {
            db.openConnection();
            preparedStatement = db.connection.prepareStatement("SELECT * FROM "
                    + "`user` WHERE `username`= ?");
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
    
    public void changePassword(String password, String username) {
        try {
            db.openConnection();
            preparedStatement = db.connection.prepareStatement("UPDATE `user`"
                    + "SET `password` = ? WHERE `username` = ?");
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection();
        }
    }
    
    // CAMPAIGN QUERIES --------------------------------------------------------
    public ArrayList<Campaign> searchCampaigns(String searchArg) {
        ArrayList<Campaign> campaigns = new ArrayList<>();
        try {
            db.openConnection();
            preparedStatement = db.connection.prepareStatement("SELECT * FROM "
                    + "`campaign` WHERE `name` LIKE ? ORDER BY `name`");
            preparedStatement.setString(1, '%' + searchArg + '%');
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                campaigns.add(new Campaign(result.getInt("id"),
                    result.getInt("access"),
                    result.getString("name"),
                    result.getString("rpg_name"),
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
}