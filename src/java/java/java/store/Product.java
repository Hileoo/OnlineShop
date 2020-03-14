package store;

/**
 * A class representing a Product
 */
public class Product {
     
    private String Product_id;	// Product's Product_id
    private String title;	// Product's title
    private String description;	// Product's description
    private String Manufacturer;	// Product's Manufacturer
    private String publicationDate; // Product's publication date
    private String ProductType; // Product's type
    private float price; // Product's price
    private int remain;
    private int quantity; // Product's quantity (for cart and orders)
    
    /**
     * class Product constructor
     */
    public Product() {} 
    
    /**
     *Product constructor
     */
    public Product(String inProduct_id, String inTitle, String inDescription, 
            String inManufacturer, String inPublicationDate, 
            String inProductType, Float inPrice) {
            
        
        Product_id = inProduct_id;
        title = inTitle;
        description = inDescription;
        Manufacturer = inManufacturer;
        publicationDate = inPublicationDate;
        ProductType = inProductType;
        price = inPrice;
        remain = 1;
        quantity = 1;
    }
    
    /**
     * Accessor for Product_id
     */
    public String getProduct_id() {
        return Product_id;
    }
    
    /**
     * Mutator for Product_id
     */
    public void setProduct_id(String inProduct_id) {
        Product_id = inProduct_id;
    }
    
    /**
     * Accessor for title
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Mutator for title
     */
    public void setTitle(String inTitle) {
        title = inTitle;
    }
    
    /**
     * Accessor for description
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Mutator for description
     */
    public void setDescription(String inDescription) {
        description = inDescription;
    }
    
    /**
     * Accessor for Manufacturer
     */
    public String getManufacturer() {
        return Manufacturer;
    }
    
    /**
     * Mutator for Manufacturer
     */
    public void setManufacturer(String inManufacturer) {
        Manufacturer = inManufacturer;
    }
    
    /**
     * Accessor for publication date
     */
    public String getPublicationDate() {
        return publicationDate;
    }
    
    /**
     * Mutator for publication date
     */
    public void setPublicationDate(String inPublicationDate) {
        publicationDate = inPublicationDate;
    }
    
    /**
     * Accessor for Product type
     */
    public String getProductType() {
        return ProductType;
    }
    
    /**
     * Mutator for Product type
     */
    public void setProductType(String inProductType) {
        ProductType = inProductType;
    }
    
    /**
     * Accessor for price
     */
    public float getPrice() {
        return price;
    }
    
    /**
     * Mutator for price
     */
    public void setPrice(float inPrice) {
        price = inPrice;
    }
    
    /**
     * Accessor for quantity
     */
    public int getQuantity() {
        return quantity;
    }
    
    /**
     * Mutator for quantity
     */

    public int getRemain() {
        return (1001 - this.getQuantity());
    }
    public void setRemain(int inRemain) {
        remain = inRemain;
    }
    public void setQuantity(int inQuantity) {
        quantity = inQuantity;
    }

}
