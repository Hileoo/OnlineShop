package store;

/**
 * A class representing a customer
 */
public class Customer {
	
    private String email; // customer's email
    private String password;	// customer's password
    
    /**
     * class Customer constructor
     */
    public Customer() {}
    
    /**
     * class Customer constructor.
     */
    public Customer(String inEmail, String inPassword) {
        email = inEmail;
        password = inPassword;
    }
    
    /**
     * Accessor for email
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Mutator for email
     */
    public void setEmail(String inEmail) {
        email = inEmail;
    }
    
    /**
     * Accessor for password
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * Mutator for password
     */
    public void setPassword(String inPassword) {
        password = inPassword;
    }
    
}
