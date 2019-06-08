package lapr.project.authentication.model;

import java.util.HashSet;
import java.util.Set;

public class UserRegistry
{
    private Set<User> users = new HashSet<>();

    public UserRegistry() {
    }
    
    public User newUser(String name, String email, String password)
    {
        return new User(name,email,password);
    }
    
    public boolean addUser(User user)
    {
        if (user != null)
            return this.users.add(user);
        return false;
    }
    
    public boolean removeUser(User user)
    {
        if (user != null)
            return this.users.remove(user);
        return false;
    }
    
    public User searchUser(String id)
    {
        for(User utlz: this.users)
        {
            if(utlz.hasId(id))
                return utlz;
        }
        return null;
    }
    
    public boolean hasUser(String id)
    {
        User user = searchUser(id);
        if (user != null)
            return this.users.contains(user);
        return false;
    }
    
    public boolean hasUser(User user)
    {
        return this.users.contains(user);
    }
}
