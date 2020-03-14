package store;

import java.util.*;

/**
 * Class ProductSet represents a
 * collection of Products.
 */
public class ProductSet {
	
	// The set is maintained in an array list.
    private ArrayList<Product> set = null;
    
    /**
     * class ProductSet constructor
     */
    public ProductSet() {
    	set = new ArrayList<Product>();
    } 
    
    /**
     * class ProductSet constructor	
     */
    public ProductSet(ArrayList<Product> inSet) {
    	set = new ArrayList<Product>(inSet);
    }
    
    /**
     * getProductAt returns the Product at the specified location in the set.
     */
    public Product getProductAt(int index) {
    	return (Product)set.get(index);
    }
    
    /**
     * getProductCount returns the number of Products in the set.
     */
    public int getProductCount() {
    	return set.size();
    }
    
    /**
     * addProduct adds a Product to the set.
     */
    public void addProduct(Product Product) {
    	set.add(Product);
    }
    
    /**
     * removeProductAt removes a Product at the specified index and returns it.
     */
    public Product removeProductAt(int index) {
    	return (Product)set.remove(index);
    }

    /**
     * removeProduct removes the input Product from the set.
     */
    public boolean removeProduct(Product Product) {
    	return set.remove(Product);
    }
    
}
