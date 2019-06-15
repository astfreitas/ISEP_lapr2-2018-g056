/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.authentication;

import lapr.project.authentication.model.UserRole;
import lapr.project.authentication.model.RegisterUserRoles;
import lapr.project.authentication.model.UserRegistry;
import lapr.project.authentication.model.UserSession;
import lapr.project.authentication.model.User;

public class AuthenticationFacade
{
    private UserSession session = null;
    
    private final RegisterUserRoles roles = new RegisterUserRoles();
    private final UserRegistry users = new UserRegistry();

    /**
     * 
     * Creates an instance of AuthenticationFacade
     * 
     */
    public AuthenticationFacade() {
    }
    
    /**
     * 
     * Registers a User's Role
     * 
     * @param role Role to be registered
     * @return The success of the operation
     */
    public boolean registerUserRole(String role)
    {
        UserRole oRole = this.roles.newUserRole(role);
        return this.roles.addRole(oRole);
    }
    
    /**
     * 
     * Register a User's Role with its description
     * 
     * @param role Role to be registered
     * @param description Role's description
     * @return The success of the operation
     */
    public boolean registerUserRole(String role, String description)
    {
        UserRole oRole = this.roles.newUserRole(role,description);
        return this.roles.addRole(oRole);
    }
    
    /**
     * 
     * Registers a User
     * 
     * @param name User's name
     * @param email User's email
     * @param password User's password
     * @return The success of the operation
     */
    public boolean registerUser(String name, String email, String password){
        User user = this.users.newUser(name,email,password);
        return this.users.addUser(user);
    }
    
    /**
     * 
     * Registers a User with a Role
     * 
     * @param name User's name
     * @param email User's email
     * @param password User's password
     * @param role User's role
     * @return The success of the operation
     */
    public boolean registerUserWithRole(String name, String email, String password, String role)
    {
        UserRole oRole = this.roles.searchRole(role);
        User user = this.users.newUser(name,email,password);
        user.addRole(oRole);
        return this.users.addUser(user);
    }
    
    /**
     * 
     * Registers a User with more than one Role
     * 
     * @param name User's name
     * @param email User's email
     * @param password User's password
     * @param roles User's roles
     * @return The success of the operation
     */
    public boolean registerUserWithRoles(String name, String email, String password, String[] roles)
    {
        User user = this.users.newUser(name,email,password);
        for (String role: roles)
        {
            UserRole oRole = this.roles.searchRole(role);
            user.addRole(oRole);
        }
        
        return this.users.addUser(user);
    }
    /**
     * 
     * Checks if a User exists
     * 
     * @param id User's email
     * @return True if the user exists
     */
    public boolean userExists(String id)
    {
        return this.users.hasUser(id);
    }
    
    /**
     * 
     * Logs in a User
     * 
     * @param id User's email
     * @param password User's password
     * @return The Users Session if its Logged. Null if the login fails.
     */
    public UserSession doLogin(String id, String password)
    {
        User utlz = this.users.searchUser(id);
        if (utlz != null)
        {
            if (utlz.hasPassword(password)){
                this.session = new UserSession(utlz);
            }
        }
        return getCurrentSession();
    }
    
    /**
     * 
     * Returns the instance of the User currently logged
     * 
     * @return 
     */
    public UserSession getCurrentSession()
    {
        return this.session;
    }
    
    /**
     * 
     * Logs out the currently logged User
     * 
     */
    public void doLogout()
    {
        if (this.session != null)
            this.session.doLogout();
        this.session = null;
    }
}
