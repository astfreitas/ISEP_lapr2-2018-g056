package lapr.project.gpsd.model;

public class PostalCode {
    
    /**
     * Postal Code string information
     */
    private String postalCode;
    
    /**
     * Postal code coordinate latitude information
     */
    private double cpLatitude;
    /**
     * Postal code coordinate longitude information
     */
    private double cpLongitude;

    
    /**
     * Constructor for PostalCode instance receiving all the attributes by method parameters
     * @param postalCode postal code string info
     * @param cpLatitude latitude 
     * @param cpLongitude longitude
     */
    public PostalCode(String postalCode, double cpLatitude, double cpLongitude) {
        if (postalCode.isEmpty()) {
            throw new IllegalArgumentException("Argument Postal Code cannot be empty");
        } else if (cpLatitude==0 || cpLongitude==0) {
            throw new IllegalArgumentException("Postal Code arguments for the coordinates cannot be zero or null.");
        }
        this.postalCode = postalCode;
        this.cpLatitude = cpLatitude;
        this.cpLongitude = cpLongitude;
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
    /**
     * Returns the value for the latitude 
     * @return latitude of the center of postalcode
     */
    public double getCpLatitude() {
        return cpLatitude;
    }
    /**
     * Sets the value for the latitude 
     * @param cpLatitude latitude value
     */
    public void setCpLatitude(double cpLatitude) {
        this.cpLatitude = cpLatitude;
    }
    /**
     * Returns the value for the longitude
     * @return longitude of the center of postalcode
     */
    public double getCpLongitude() {
        return cpLongitude;
    }
    /**
     * Sets the value for the longitude
     * @param cpLongitude longitude value
     */
    public void setCpLongitude(double cpLongitude) {
        this.cpLongitude = cpLongitude;
    }

    @Override
    public String toString() {
        return postalCode;
    }
    
    /**
     * Compares the PostalCode instance with an objet received by reference in
     * the method parameter.
     *
     * @param otherObject Objet to compare with the PostalCode instance
     * @return true if the received object represent and equal object of the
     * instanced PostalCode. Otherwise returns False.
     */
    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }
        PostalCode otherPostalCode = (PostalCode) otherObject;
        return this.postalCode.equals(otherPostalCode.postalCode)
                && this.cpLatitude == otherPostalCode.cpLatitude
                && this.cpLongitude == otherPostalCode.cpLongitude;
    }     

}
