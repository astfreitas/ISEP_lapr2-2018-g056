package lapr.project.authentication.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class User
{
    private String name;
    private String email;
    private String password; 
    private Set<UserRole> roles = new HashSet<>();
    
    /**
     * 
     * Creates an instance of User
     * 
     * @param name User's name
     * @param email User's email
     * @param password User's password
     */
    public User(String name, String email, String password)
    {
    
        if ( (name == null) || (email == null) || (password == null) || (name.isEmpty()) || (email.isEmpty()) || (password.isEmpty()))
            throw new IllegalArgumentException("None of the arguments can be null or empty.");
        
        this.name = name;
        this.email = email;
        this.password = password;
        
    }
    
    /**
     * 
     * Gets the User's Email
     * 
     * @return User's Email
     */
    public String getId()
    {
        return this.email;
    }
    
    /**
     * 
     * Gets the User's name
     * 
     * @return User's name
     */
    public String getName()
    {
        return this.name;
    }
    
    /**
     * 
     * Gets the User's Email
     * 
     * @return User's Email
     */
    public String getEmail()
    {
        return this.email;
    }
    
    /**
     * 
     * Checks if the User has a certain email
     * 
     * @param id Email
     * @return True if the user has the email
     */
    public boolean hasId(String id)
    {
        return this.email.equals(id);
    }
    
    /**
     * 
     * Checks if the User has a certain password
     * 
     * @param pwd Password
     * @return True if the user has the email
     */
    public boolean hasPassword(String pwd)
    {
        return this.password.equals(pwd);
    }
    
    /**
     * 
     * Adds a Role to a user
     * 
     * @param role Role to be added
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
     * Removes a Role form a user
     * 
     * @param role Role to be removed
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
     * Checks if the User has a certain Role (Instance of UserRole)
     * 
     * @param role Role being looked for
     * @return True if the User has the role
     */
    public boolean hasRole(UserRole role)
    {
        return this.roles.contains(role);
    }
    
    /**
     * 
     * Checks if the User has a certain Role (String)
     * 
     * @param role Role being looked for
     * @return True if the User has the role
     */
    public boolean hasRole(String role)
    {
        for(UserRole oRole: this.roles)
        {
            if (oRole.hasId(role))
                return true;
        }
        return false;
    }
    
    /**
     * 
     * Gets all the User's Roles
     * 
     * @return User's Roles
     */
    public List<UserRole> getRoles(){
        List<UserRole> list = new ArrayList<>();
        for(UserRole role: this.roles)
            list.add(role);
        return list;
    }

    /**
     * Determines the hashcode
     * @return Hascode
     */
    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.email);
        return hash;
    }
    
    /**
     * 
     * Compares if another object is equal to this User
     * 
     * @param o Object to compare
     * @return True if they are equal
     */
    @Override
    public boolean equals(Object o) {
        // Inspirado em https://www.sitepoint.com/implement-javas-equals-method-correctly/
        
        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        if (getClass() != o.getClass())
            return false;
        // field comparison
        User obj = (User) o;
        return Objects.equals(email, obj.email);
    }
    
    /**
     * 
     * Gets the User's info in a string
     * 
     * @return User's info
     */
    @Override
    public String toString()
    {
        return String.format("%s - %s", this.name, this.email);
    }
}
