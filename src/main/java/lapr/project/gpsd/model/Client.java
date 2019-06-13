package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client {

    private String name;
    private String NIF;
    private String telephone;
    private String email;
    private ArrayList<Address> addresses = new ArrayList<Address>();

    public Client(String name, String NIF, String telephone, String email) {
        if ((name == null) || (NIF == null) || (telephone == null)
                || (email == null)
                || (name.isEmpty()) || (NIF.isEmpty()) || (telephone.isEmpty())
                || (email.isEmpty())) {
            throw new IllegalArgumentException("None of the arguments can be null or empty.");
        }

        this.name = name;
        this.email = email;
        this.NIF = NIF;
        this.telephone = telephone;
    }

    /**
     *
     * Returns the Client's name
     *
     * @return Client's name
     */
    public String getName() {
        return this.name;
    }

    /**
     *
     * Returns the Client's email
     *
     * @return Client's email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     *
     * Returns the Client's NIF
     *
     * @return Client's NIF
     */
    public String getNIF() {
        return NIF;
    }

    /**
     *
     * Checks if the Cliend has a certain email
     *
     * @param email
     * @return
     */
    public boolean hasEmail(String email) {
        return this.email.equalsIgnoreCase(email);
    }

    /**
     *
     * Adds an Address to the Client's instance
     *
     * @param address Address to be added
     * @return True/false if the operation is/isn't successful
     */
    public boolean addAddress(Address address) {
        if(validateAddress(address)) {
            return this.addresses.add(address);
        }
        return false;
    }

    /**
     *
     * returns the list of Addresses in the client
     *
     * @return returns the list of Addresses in the client
     */
    public ArrayList<Address> getAddresses() {
        return addresses;
    }

    /**
     *
     * returns the Address Instance of the client by local, postalCode and
     * address
     *
     * @param local Local
     * @param postalCode Postal code
     * @param address Address
     * @return returns client's Address
     */
    public Address getAddress(String local, PostalCode postalCode, String address) {
        for (Address a : addresses) {
            if (a.getLocal().equals(local) && a.getPostalCode().equals(postalCode) && a.getAddress().equals(address)) {
                return a;
            }
        }
        return null;
    }
    
    /**
     *
     * Removes an Address to the Client's instance
     *
     * @param address Address to be removed
     * @return True/false if the operation is/isn't successful
     */
    public boolean removeAddress(Address address) {
        return this.addresses.remove(address);
    }

    /**
     *
     * Compares two instances of Client and returns true/false if they are
     * equals or possess the same atributes
     *
     * @param otherClient Address to compare
     * @return True/false if they are equals or possess the same atributes
     */
    @Override
    public boolean equals(Object otherClient) {
        // Inspired in https://www.sitepoint.com/implement-javas-equals-method-correctly/

        // self check
        if (this == otherClient) {
            return true;
        }
        // null check
        if (otherClient == null) {
            return false;
        }
        // type check and cast
        if (getClass() != otherClient.getClass()) {
            return false;
        }
        // field comparison
        Client obj = (Client) otherClient;
        return (Objects.equals(email, obj.email) || Objects.equals(NIF, obj.NIF));
    }

    /**
     *
     * Returns the info of the Client in a String
     *
     * @return Info of the instance
     */
    @Override
    public String toString() {
        String str = String.format("Name: %s \nNIF: %s \nTelephone: %s \nEmail: %s", this.name, this.NIF, this.telephone, this.email);
        for (Address morada : this.addresses) {
            str += "\nMorada:\n" + morada.toString();
        }
        return str;
    }

    /**
     *
     * Creates a new instance of Address
     *
     * @param local City name
     * @param postalCode Postal code
     * @param address Street name
     * @return Address instatiated
     */
    public static Address newAddress(String local, String postalCode, String address) {
        return new Address(local, postalCode, address);
    }

    /**
     * Verifies if there is already an Address equals to the one given as
     * argument in the Client's List of Addresses
     *
     * @param address
     * @return
     */
    public boolean validateAddress(Address address) {
        for (Address registeredAddress : addresses) {
            if (registeredAddress.equals(address)) {
                return false;
            }
        }
        return true;
    }
}
