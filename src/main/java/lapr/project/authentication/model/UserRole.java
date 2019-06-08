package lapr.project.authentication.model;

import java.util.Objects;

public class UserRole
{
    private String role;
    private String description;
    
    public UserRole(String role)
    {
        if ( (role == null) || (role.isEmpty()))
            throw new IllegalArgumentException("Argument cannot be null or empty.");
        
        this.role = role;
        this.description = role;
    }
    
    public UserRole(String role, String description)
    {
        if ( (role == null) || (description == null) || (role.isEmpty())|| (description.isEmpty()))
            throw new IllegalArgumentException("None of the arguments can be null or empty.");
        
        this.role = role;
        this.description = description;
    }
    
    public String getRole()
    {
        return this.role;
    }
    
    public String getDescription()
    {
        return this.description;
    }

    public boolean hasId(String strId)
    {
        return this.role.equals(strId);
    }
    
    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.role);
        return hash;
    }
    
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
    
    @Override
    public String toString()
    {
        return String.format("%s - %s", this.role, this.description);
    }
}
