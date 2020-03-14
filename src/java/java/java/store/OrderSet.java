package store;

import java.util.*;

/**
 * Class OrderSet represents a collection of orders
 */
public class OrderSet {
    
	//The set is maintained in an array list.
    private ArrayList<Order> set = null;
    
    /**
     * class OrderSet constructor
     */
    public OrderSet() {
    	set = new ArrayList<Order>();
    } 
    
    /**
     * class OrderSet constructor
     */
    public OrderSet(ArrayList<Order> inSet) {
    	set = new ArrayList<Order>(inSet);
    }
    
    /**
     * getOrderAt returns the order at the specified location in the set.
     */
    public Order getOrderAt(int index) {
    	return (Order)set.get(index);
    }
    
    /**
     * getOrderCount returns the number of orders in the set.
     */
    public int getOrderCount() {
    	return set.size();
    }
    
    /**
     * addOrder adds an order to the set.
     */
    public void addOrder(Order order) {
    	set.add(order);
    }
    
    /**
     * removeOrderAt removes an order at the specified index and returns it.
     */
    public Order removeOrderAt(int index) {
    	return (Order)set.remove(index);
    }
    
    /**
     * removeOrder removes the input order from the set.
     */
    public boolean removeOrder(Order order) {
    	return set.remove(order);
    }
    
}
