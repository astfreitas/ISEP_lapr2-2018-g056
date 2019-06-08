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

    public AuthenticationFacade() {
    }
    
    public boolean registerUserRole(String role)
    {
        UserRole oRole = this.roles.newUserRole(role);
        return this.roles.addRole(oRole);
    }
    
    public boolean registerUserRole(String role, String description)
    {
        UserRole oRole = this.roles.newUserRole(role,description);
        return this.roles.addRole(oRole);
    }
    
    public boolean registerUser(String name, String email, String password){
        User user = this.users.newUser(name,email,password);
        return this.users.addUser(user);
    }
    
    public boolean registerUserWithRole(String name, String email, String password, String role)
    {
        UserRole oRole = this.roles.searchRole(role);
        User user = this.users.newUser(name,email,password);
        user.addRole(oRole);
        return this.users.addUser(user);
    }
    
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
    
    public boolean userExists(String id)
    {
        return this.users.hasUser(id);
    }
    
    
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
    
    public UserSession getCurrentSession()
    {
        return this.session;
    }
    
    public void doLogout()
    {
        if (this.session != null)
            this.session.doLogout();
        this.session = null;
    }
}
