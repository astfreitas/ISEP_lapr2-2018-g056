package lapr.project.gpsd.model;

public class PostalCode {

    private String postalCode;

    /**
     * 
     * Creates an instance of Postal Code
     * 
     * @param postalCode 
     */
    public PostalCode(String postalCode) {
        if(!validatePostalCode(postalCode)){
            throw new IllegalArgumentException("Postal code not valid.");
        }
         if ( (postalCode == null)||
                (postalCode.isEmpty()))
            throw new IllegalArgumentException("None of the arguments can be null or empty.");
        this.postalCode = postalCode;
    }

    /**
     * 
     * Checks if the postal code is present in the postal code's file
     * 
     * @param postalCode
     * @return 
     */
    public boolean validatePostalCode(String postalCode){
        return false;
    }
    
    /**
     * 
     * Get the Postal Code
     * 
     * @return Postal Code as a String
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * 
     * Alters the Postal Code
     * 
     * @param postalCode New Postal Code
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
