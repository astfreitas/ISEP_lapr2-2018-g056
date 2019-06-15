package lapr.project.authentication.model;

import java.util.HashSet;
import java.util.Set;

public class UserRegistry
{
    private Set<User> users = new HashSet<>();

    /**
     * 
     * Creates an instance of UserRegistry
     * 
     */
    public UserRegistry() {
    }
    
    /**
     * 
     * Creates a new User
     * 
     * @param name User's name
     * @param email User's Email
     * @param password User's password
     * @return The created User
     */
    public User newUser(String name, String email, String password)
    {
        return new User(name,email,password);
    }
    
    /**
     * 
     * Adds a User to the registry
     * 
     * @param user User being added
     * @return The success of the operation
     */
    public boolean addUser(User user)
    {
        if (user != null)
            return this.users.add(user);
        return false;
    }
    
    /**
     * 
     * Removes a User from the registry
     * 
     * @param user User being removed
     * @return The success of the operation
     */
    public boolean removeUser(User user)
    {
        if (user != null)
            return this.users.remove(user);
        return false;
    }
    
    /**
     * 
     * Searchs for a user with a certain Email and returns it
     * 
     * @param id Email of the User being looked for
     * @return User with the Email
     */
    public User searchUser(String id)
    {
        for(User utlz: this.users)
        {
            if(utlz.hasId(id))
                return utlz;
        }
        return null;
    }
    
    /**
     * 
     * Checks if a user is registered
     * 
     * @param id User's email
     * @return True if the user is registered
     */
    public boolean hasUser(String id)
    {
        User user = searchUser(id);
        if (user != null)
            return this.users.contains(user);
        return false;
    }
    
    /**
     * 
     * Checks if a user is registered
     * 
     * @param user Instance of user
     * @return True if the user is registered
     */
    public boolean hasUser(User user)
    {
        return this.users.contains(user);
    }
}
