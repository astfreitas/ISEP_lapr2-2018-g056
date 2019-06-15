package lapr.project.authentication.model;

import java.util.Objects;

public class UserRole
{
    private String role;
    private String description;
    
    /**
     * 
     * Creates a new instance of User Role
     * 
     * @param role User Role name
     */
    public UserRole(String role)
    {
        if ( (role == null) || (role.isEmpty()))
            throw new IllegalArgumentException("Argument cannot be null or empty.");
        
        this.role = role;
        this.description = role;
    }
    
    /**
     * 
     * Creates an instance of User Role with description
     * 
     * @param role User Role name
     * @param description User Role's description
     */
    public UserRole(String role, String description)
    {
        if ( (role == null) || (description == null) || (role.isEmpty())|| (description.isEmpty()))
            throw new IllegalArgumentException("None of the arguments can be null or empty.");
        
        this.role = role;
        this.description = description;
    }
    
    /**
     * 
     * Returns the User Role
     * 
     * @return User Role
     */
    public String getRole()
    {
        return this.role;
    }
    
    /**
     * 
     * Returns the User Role description
     * 
     * @return User Role description
     */
    public String getDescription()
    {
        return this.description;
    }

    /**
     * 
     * Checks if the User Role has a certain name
     * 
     * @param strId Name of the User Role
     * @return True if the User Role has the name being looked for
     */
    public boolean hasId(String strId)
    {
        return this.role.equals(strId);
    }
    
    /**
     * 
     * Calculates the Hashcode
     * 
     * @return Hashcode
     */
    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.role);
        return hash;
    }
    
    /**
     * 
     * Checks if the UserRole is equal to another object
     * 
     * @param o Object being compared
     * @return True if the User Role is equal to the object
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
        UserRole obj = (UserRole) o;
        return Objects.equals(role, obj.role);
    }
    
    /**
     * 
     * Returns the User Role info
     * 
     * @return User Role info
     */
    @Override
    public String toString()
    {
        return String.format("%s - %s", this.role, this.description);
    }
}
