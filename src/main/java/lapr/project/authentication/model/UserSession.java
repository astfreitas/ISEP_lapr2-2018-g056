/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.authentication.model;

import java.util.List;

/**
 *
 * @author paulomaio
 */
public class UserSession
{
    private User user = null;
    
    private UserSession()
    {
    }
    
    public UserSession(User user)
    {
        if (user == null)
            throw new IllegalArgumentException("Argument cannot be null");
        this.user = user;
    }
    
    public void doLogout()
    {
        this.user = null;
    }
    
    public boolean isLoggedIn()
    {
        return this.user != null;
    }
    
    public boolean isLoggedInWithRole(String role)
    {
        if (isLoggedIn())
        {
            return this.user.hasRole(role);
        }
        return false;
    }
    
    public String getUserName()
    {
        if (isLoggedIn())
            this.user.getName();
        return null;
    }
    
    public String getUserId()
    {
        if (isLoggedIn())
            this.user.getId();
        return null;
    }
    
    public String getUserEmail()
    {
        if (isLoggedIn())
            this.user.getEmail();
        return null;
    }
    
    public List<UserRole> getUserRoles()
    {
        return this.user.getRoles();
    }
}
