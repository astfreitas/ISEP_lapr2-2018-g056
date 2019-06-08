/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author astfr
 */
public class PostalCodeRegistry {
    
    /**
     * List of existing and validated PostalCodes in system.
     */
    private List<PostalCode> postalCodeList;

    public PostalCodeRegistry() {
        this.postalCodeList = new ArrayList<>();
    }

    /**
     * Returns the list of existing PostalCodes in system.
     * @return reference for the PostalCodeList
     */
    public List<PostalCode> getPostalCodeList() {
        return postalCodeList;
    }
    /**
     * Sets the PostalCode List 
     * @param postalCodeListReg reference for the new PostalCode List
     */
    public void setPostalCodeList(List<PostalCode> postalCodeListReg) {
        this.postalCodeList = postalCodeListReg;
    }
    
    /**
     * Searchs the PostalCode List for a matching instance with the given String 
     * @param strCP postal code to search
     * @return reference to the found PostalCode instance or null
     */
    public PostalCode getMathingPostalCode(String strCP){
        for (PostalCode postalCode : postalCodeList) {
            if (strCP.equals(postalCode.getPostalCode())) {
                return postalCode;
            }
        }
        return null;
    }
    
    public List<PostalCode> searchMatchPostalCode(String strPC){
        List<PostalCode> pcListMatched = new ArrayList<>();
        String[] strPCray;
        strPCray = strPC.split("-");
        for (PostalCode postalCode : postalCodeList) {
            String[] compPC = postalCode.getPostalCode().split("-");
            if (strPCray[0].equals(compPC[0])) {
                pcListMatched.add(postalCode);
            }
        }
        return pcListMatched;
    }
    
    
    
}
