package lapr.project.authentication.model;

import java.util.List;

public class UserSession {

    private User user = null;

    /**
     * 
     * Creates and instance of UserSession without parameters
     * 
     */
    private UserSession() {
    }

    /**
     * 
     * Creates an instance of User Session with parameters
     * 
     * @param user User being logged in
     */
    public UserSession(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Argument cannot be null");
        }
        this.user = user;
    }

    /**
     * 
     * Logs out the logged in User
     * 
     */
    public void doLogout() {
        this.user = null;
    }

    /**
     * 
     * Checks if the User is logged in
     * 
     * @return True if the User is logged in
     */
    public boolean isLoggedIn() {
        return this.user != null;
    }

    /**
     * 
     * Checks if the User logged in has a certain Role
     * 
     * @param role Role being looke for
     * @return True if the User has the Role
     */
    public boolean isLoggedInWithRole(String role) {
        if (isLoggedIn()) {
            return this.user.hasRole(role);
        }
        return false;
    }

    /**
     * 
     * Returns the logged in User's name
     * 
     * @return Logged in User's name
     */
    public String getUserName() {
        if (isLoggedIn()) {
            return this.user.getName();
        }
        return null;
    }

    /**
     * 
     * Returns the logged in User's email
     * 
     * @return Logged in User's email
     */
    public String getUserId() {
        if (isLoggedIn()) {
            return this.user.getId();
        }
        return null;
    }

    /**
     * 
     * Returns the logged in User's email
     * 
     * @return Logged in User's email
     */
    public String getUserEmail() {
        if (isLoggedIn()) {
            return this.user.getEmail();
        }
        return null;
    }

    /**
     * 
     * Gets all the logged in User's Roles
     * 
     * @return Logged in User's roles
     */
    public List<UserRole> getUserRoles() {
        return this.user.getRoles();
    }
}
