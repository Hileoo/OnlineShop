package store;

/**
 * Class Order represents an order.
 */
public class Order {

    private int orderId; // order number
    private String email; // email of the customer who made the order
    private String firstName; // first name of the customer
    private String lastName; // last name of the customer
    private String address; // address of the customer
    private String phone; // phone number of the customer
    private String deliveryMethod; // delivery method chosen by the customer
    private String orderDate; // date of the order made by the customer
    private float orderCost; // total cost of the order including delivery
    
    /**
     * class Order constructor
     */
    public Order() {}
    
    /**
     *Order constructor
     */
    public Order(int inOrderId, String inEmail, String inFirstName, 
            String inLastName, String inAddress, String inPhone, 
            String inDeliveryMethod, String inOrderDate, Float inOrderCost) {
        
        orderId = inOrderId;
        email = inEmail;
        firstName = inFirstName;
        lastName = inLastName;
        address = inAddress;
        phone = inPhone;
        deliveryMethod = inDeliveryMethod;
        orderDate = inOrderDate;
        orderCost = inOrderCost;
    }
    
    /**
     * Accessor for order number
     */
    public int getOrderId() {
        return orderId;
    }
    
    /**
     * Mutator for order number
     */
    public void setOrderId(int inOrderId) {
        orderId = inOrderId;
    }
    
    /**
     * Accessor for customer's email
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Mutator for customer's email
     */
    public void setEmail(String inEmail) {
        email = inEmail;
    }
    
    /**
     * Accessor for customer's first name
     */
    public String getFirstName() {
        return firstName;
    }
    
    /**
     * Mutator for customer's first name
     */
    public void setFirstName(String inFirstName) {
        firstName = inFirstName;
    }
    
    /**
     * Accessor for customer's last name
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * Mutator for customer's last name
     */
    public void setLastName(String inLastName) {
        lastName = inLastName;
    }
    
    /**
     * Accessor for customer's address
     */
    public String getAddress() {
        return address;
    }
    
    /**
     * Mutator for customer's address
     */
    public void setAddress(String inAddress) {
        address = inAddress;
    }
    
    /**
     * Accessor for customer's phone number
     */
    public String getPhone() {
        return phone;
    }
    
    /**
     * Mutator for customer's phone number
     */
    public void setPhone(String inPhone) {
        phone = inPhone;
    }
    
    /**
     * Accessor for chosen delivery method
     */
    public String getDeliveryMethod() {
        return deliveryMethod;
    }
    
    /**
     * Mutator for chosen delivery method
     */
    public void setDeliveryMethod(String inDeliveryMethod) {
        deliveryMethod = inDeliveryMethod;
    }
    
    /**
     * Accessor for order date.
     */
    public String getOrderDate() {
        return orderDate;
    }
    
    /**
     * Mutator for order date.
     */
    public void setOrderDate(String inOrderDate) {
        orderDate = inOrderDate;
    }
    
    /**
     * Accessor for total cost of the order
     */
    public float getOrderCost() {
        return orderCost;
    }
    
    /**
     * Mutator for total cost of the order
     */
    public void setOrderCost(float inOrderCost) {
        orderCost = inOrderCost;
    }
    
}
