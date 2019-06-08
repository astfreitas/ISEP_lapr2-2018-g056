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
    
    public User(String name, String email, String password)
    {
    
        if ( (name == null) || (email == null) || (password == null) || (name.isEmpty()) || (email.isEmpty()) || (password.isEmpty()))
            throw new IllegalArgumentException("None of the arguments can be null or empty.");
        
        this.name = name;
        this.email = email;
        this.password = password;
        
    }
    
    public String getId()
    {
        return this.email;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public String getEmail()
    {
        return this.email;
    }
    
    public boolean hasId(String id)
    {
        return this.email.equals(id);
    }
    
    public boolean hasPassword(String pwd)
    {
        return this.password.equals(pwd);
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
    
    public boolean hasRole(UserRole role)
    {
        return this.roles.contains(role);
    }
    
    public boolean hasRole(String role)
    {
        for(UserRole oRole: this.roles)
        {
            if (oRole.hasId(role))
                return true;
        }
        return false;
    }
    
    public List<UserRole> getRoles(){
        List<UserRole> list = new ArrayList<>();
        for(UserRole role: this.roles)
            list.add(role);
        return list;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.email);
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
        User obj = (User) o;
        return Objects.equals(email, obj.email);
    }
    
    @Override
    public String toString()
    {
        return String.format("%s - %s", this.name, this.email);
    }
}
