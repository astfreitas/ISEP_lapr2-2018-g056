package lapr.project.gpsd.controller;

import java.util.List;
import lapr.project.authentication.model.UserRole;

/**
 *
 * @author paulomaio
 */
public class AuthenticationController{
    
    private ApplicationGPSD m_oApp;
    
    /**
     * 
     * Creates an instance of AuthenticationController
     * 
     */
    public AuthenticationController(){
        this.m_oApp = ApplicationGPSD.getInstance();
    }
    
    /**
     * 
     * Logs in a User
     * 
     * @param strId User's email
     * @param strPwd User's pwd
     * @return The success of the operation
     */
    public boolean doLogin(String strId, String strPwd){
        return this.m_oApp.doLogin(strId, strPwd);
    }
    
    /**
     * 
     * Returns the list of User Roles 
     * 
     * @return List of User Roles
     */
    public List<UserRole> getUserRoles(){
        if (this.m_oApp.getCurrentSession().isLoggedIn()){
            return this.m_oApp.getCurrentSession().getUserRoles();
        }
        return null;
    }

    /**
     * 
     * Logs out the currently logged User
     * 
     */
    public void doLogout(){
        this.m_oApp.doLogout();
    }
}
