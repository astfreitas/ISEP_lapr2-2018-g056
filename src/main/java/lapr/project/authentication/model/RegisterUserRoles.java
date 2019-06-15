package lapr.project.authentication.model;

import java.util.HashSet;
import java.util.Set;

public class RegisterUserRoles
{
    
    private Set<UserRole> roles = new HashSet<>();

    /**
     * 
     * Creates an instance of RegisterUserRoles
     * 
     */
    public RegisterUserRoles() {
    }
    
    /**
     * 
     * Creates a new User Role
     * 
     * @param role Name of the User Role
     * @return Returns the User Role created
     */
    public UserRole newUserRole(String role)
    {
        return new UserRole(role);
    }
    
    /**
     * 
     * Creates a new User Role with description
     * 
     * @param role Name of the User Role
     * @param description User Role's description
     * @return Returns the User Role created
     */
    public UserRole newUserRole(String role, String description)
    {
        return new UserRole(role,description);
    }
    
    /**
     * 
     * Adds a User Role to the registry
     * 
     * @param role User role
     * @return The success of the operation
     */
    public boolean addRole(UserRole role)
    {
        if (role != null)
            return this.roles.add(role);
        return false;
    }
    
    /**
     * 
     * Removed a User Role from the registry
     * 
     * @param role User role
     * @return The success of the operation
     */
    public boolean removeRole(UserRole role)
    {
        if (role != null)
            return this.roles.remove(role);
        return false;
    }
    
    /**
     * 
     * Searchs a Role by its name and returns it
     * 
     * @param role Role name
     * @return User role with the name
     */
    public UserRole searchRole(String role)
    {
        for(UserRole p: this.roles)
        {
            if(p.hasId(role))
                return p;
        }
        return null;
    }

    /**
     * 
     * Sees if a role is already registered
     * 
     * @param role Role being search
     * @return True if the role exists
     */
    public boolean hasRole(UserRole role)
    {
        return this.roles.contains(role);
    }
}
