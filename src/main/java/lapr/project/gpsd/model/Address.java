package lapr.project.gpsd.model;

import java.util.Objects;
import lapr.project.gpsd.controller.ApplicationGPSD;

public class Address{

    private String local;
    private PostalCode postalCode;
    private String address;

    /**
     *
     * Creates an instance of Address
     *
     * @param local City name
     * @param postalCode Postal Code
     * @param address Street name
     */
    public Address(String local, String postalCode, String address) {
        if ((local == null) || (postalCode == null) || (address == null)
                || (local.isEmpty()) || (postalCode.isEmpty()) || (address.isEmpty())) {
            throw new IllegalArgumentException("None of the arguments can be null or empty.");
        }

        this.local = local;
        this.postalCode = ApplicationGPSD.getInstance().getCompany().getPostalCodeRegistry().getMatchingPostalCode(postalCode);
        this.address = address;
    }

    /**
     * 
     * Get the city name
     * 
     * @return City name
     */
    public String getLocal() {
        return local;
    }

    /**
     * 
     * Alters the city name
     * 
     * @param local City name
     */
    public void setLocal(String local) {
        this.local = local;
    }

    /**
     * 
     * Returns the Postal Code
     * 
     * @return Postal Code
     */
    public PostalCode getPostalCode() {
        return postalCode;
    }

    /**
     * 
     * Alters the Postal Code
     * 
     * @param postalCode Postal Code
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = ApplicationGPSD.getInstance().getCompany().getPostalCodeRegistry().getMatchingPostalCode(postalCode);
    }

    /**
     * 
     * Returns the street name
     * 
     * @return Street name
     */
    public String getAddress() {
        return address;
    }

    /**
     * 
     * Alters the street name
     * 
     * @param address Street name
     */
    public void setAddress(String address) {
        this.address = address;
    }   

    /**
     *
     * Compares two instances of Address and returns true/false if they are
     * equals or possess the same atributes
     *
     * @param otherAddress Address to compare
     * @return True/false if they are
     * equals or possess the same atributes
     */
    @Override
    public boolean equals(Object otherAddress) {
        // Inspired in https://www.sitepoint.com/implement-javas-equals-method-correctly/

        // self check
        if (this == otherAddress) {
            return true;
        }
        // null check
        if (otherAddress == null) {
            return false;
        }
        // type check and cast
        if (getClass() != otherAddress.getClass()) {
            return false;
        }
        // field comparison
        Address obj = (Address) otherAddress;
        return (Objects.equals(local, obj.local)
                && Objects.equals(postalCode, obj.postalCode)
                && Objects.equals(address, obj.address));
    }

    /**
     * 
     * Returns the info of the Address in a String
     * 
     * @return Info of the instance
     */
    @Override
    public String toString() {
        return this.address + ", " + this.postalCode.getPostalCode() + ", " + this.local;
    }
}
