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

/**
 *
 * @author Flo
 */
public class QueryManager {
    
    private final DatabaseManager db = new DatabaseManager();

//    private int permissionId, incorrectLogin, userId;
//    private String username, firstName, lastName, password;
//    private boolean isLoggedIn = false;
    public final int MAX_INCORRECT_LOGINS = 3;
    public PreparedStatement preparedStatement = null;
    
    public User getUserData(String username) {
        User user = new User();
        try {
            db.openConnection();
            preparedStatement = db.connection.prepareStatement("SELECT * FROM "
                    + "`user` WHERE `username`= ?");
//            System.out.println(username);
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
    
    public ArrayList<Campaign> searchCampaigns(String searchArg) {
//        if (!searchArg.equals(""))
//            searchArg = "WHERE `camp_name` LIKE '%" + searchArg + "%'";
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