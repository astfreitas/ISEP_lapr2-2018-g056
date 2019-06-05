/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.authentication.model;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author paulomaio
 */
public class RegisterUserRoles
{
    private Set<UserRole> roles = new HashSet<>();
    
    public UserRole newUserRole(String role)
    {
        return new UserRole(role);
    }
    
    public UserRole newUserRole(String role, String description)
    {
        return new UserRole(role,description);
    }
    
    public boolean addRole(UserRole role)
    {
        if (role != null)
            return this.roles.add(role);
        return false;
    }
    
    public boolean removeRole(UserRole role)
    {
        if (role != null)
            return this.roles.remove(role);
        return false;
    }
    
    public UserRole searchRole(String role)
    {
        for(UserRole p: this.roles)
        {
            if(p.hasId(role))
                return p;
        }
        return null;
    }
    
    public boolean hasRole(String role)
    {
        UserRole papel = searchRole(role);
        if (papel != null)
            return this.roles.contains(role);
        return false;
    }
    
    public boolean hasRole(UserRole role)
    {
        return this.roles.contains(role);
    }
}
