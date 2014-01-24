package model;

/**
 *
 * @author Florentijn Cornet
 */
public class User {

    // Variable Declaration.
    private int incorrectLogin, userId;
    private String username, firstName, lastName, password, email;
    private boolean isLoggedIn = false;

    // Constructors.
    public User(){
    }
    
    public User(String firstName, String lastName, String username,
            int incorrectLogin, int userId, String email) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.incorrectLogin = incorrectLogin;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getUsername() {
        return this.username;
    }

    public int getIncorrectLogin() {
        return this.incorrectLogin;
    }

    public String getPassword() {
        return password;
    }

    public int getUserId() {
        return userId;
    }

    public void setIncorrectLogin(int incorrectLogin) {
        this.incorrectLogin = incorrectLogin;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIsLoggedIn() {
        return isLoggedIn;
    }

    public void setIsLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}