package store;

import java.sql.*;

/**
 * This class is used to represents the functionality of the store.
 */
public class Store {

    private DBWrapper myConnection = null;
   
    //Store constructor
    public Store() 
    		throws Exception {
    	myConnection = DBWrapper.Instance();
    }
    
    /**
     * search product in the store by input Chair_name.
     */
    public ProductSet search(String searchString) 
            throws Exception {
        
        ProductSet Products = new ProductSet();
        
        String query = "SELECT DISTINCT Product_id, Chair_name, description, Manufacturer, "
                + "Manufacturing_date, chair_type, price "
                + "FROM Commodities "
                + "WHERE LOWER(Chair_name) LIKE LOWER('%" + searchString + "%') "
                + "ORDER BY Chair_name";
                
        
        ResultSet r = myConnection.runQuery(query);
        while (r.next()) {
            Product temp = new Product(r.getString("Product_id"), r.getString("Chair_name"), r.getString("description"), 
                    r.getString("Manufacturer"), r.getString("Manufacturing_date"), 
                    r.getString("chair_type"), r.getFloat("price"));
            
            Products.addProduct(temp);
        }
        
        return Products;
    }
    
    /**
     * get all Production
     */
    public ProductSet getAll() 
            throws Exception {
        ProductSet Products = new ProductSet();

        String query = "SELECT Product_id, Chair_name, description, Manufacturer, Manufacturing_date, chair_type, price FROM Commodities";
        
        ResultSet r = myConnection.runQuery(query);
        while (r.next()) {
            Product temp = new Product(r.getString("Product_id"), r.getString("Chair_name"), r.getString("description"), 
                    r.getString("Manufacturer"), r.getString("Manufacturing_date"), 
                    r.getString("chair_type"), r.getFloat("price"));
            Products.addProduct(temp);
        }
        
        return Products;
    }
    /**
     * Return the specified category.
     */
    public ProductSet categorize(String category) 
            throws Exception {
        
        ProductSet Products = new ProductSet();
        
        String query = "SELECT Product_id, Chair_name, description, Manufacturer, Manufacturing_date as pub_date, "
                + "STR_TO_DATE(Manufacturing_date, '%Y-%m-%d') Manufacturing_date, chair_type, price FROM ChairCATEGORIES "
                + "NATURAL JOIN Commodities "
                + "WHERE category_name = '" + category + "' "
                + "ORDER BY Chair_name";
                
        
        ResultSet r = myConnection.runQuery(query);
        while (r.next()) {
            Product temp = new Product(r.getString("Product_id"), r.getString("Chair_name"), r.getString("description"), 
                    r.getString("Manufacturer"), r.getString("Manufacturing_date"), 
                    r.getString("chair_type"), r.getFloat("price"));
            
            Products.addProduct(temp);
        }
        
        return Products;
    }
    
    /**
     * getProduction Details returns the production specified by its Product_id.
     */
    public Product getProductDetail(String Product_id) 
            throws Exception {
        
        String query = "SELECT Product_id, Chair_name, description, Manufacturer, Manufacturing_date as pub_date, "
                + "STR_TO_DATE(Manufacturing_date, '%Y-%m-%d') Manufacturing_date, chair_type, price FROM Commodities "
                + "WHERE Product_id = '" + Product_id + "'";
        ResultSet r = myConnection.runQuery(query);
        r.next();
        Product Product = new Product(r.getString("Product_id"), r.getString("Chair_name"), r.getString("description"), 
                r.getString("Manufacturer"), r.getString("Manufacturing_date"), 
                r.getString("chair_type"), r.getFloat("price"));
        r.close();
        
        return Product;
    }
    
    /**
     * getProductCategories returns the string of categories to which the Production belongs to.
     */
    public String getProductCategories(String Product_id)
            throws Exception {
        
        String categories = "";
        String query = "SELECT category_name FROM ChairCATEGORIES WHERE Product_id = '" + Product_id + "'";
        ResultSet result = myConnection.runQuery(query);
        ResultSet count = myConnection.runQuery("SELECT COUNT(Product_id) AS num FROM ChairCATEGORIES WHERE Product_id ='" + Product_id + "'");    //*************************
        count.next();
        int num = count.getInt("num");
        count.close();
        
        for (int i = 0; i < num - 1 ; i++) {
            result.next();
            categories += result.getString("category_name") + ", ";
        }
        
        result.next();
        categories += result.getString("category_name");
        
        return categories;
    }
    
    
    /**
     * addProductToCart adds Production into the cart.
     */
    public void addProductToCart(ProductSet cart, String Product_id) 
            throws Exception{
        cart.addProduct(getProductDetail(Product_id));
        
    }
    
    /**
     * deleteProductFromCart deletes Production from the cart.
     */
    public void deleteProductFromCart(ProductSet cart, String Product_id) 
            throws Exception {
        
        for (int i = 0; i < cart.getProductCount(); i++) {
            if (cart.getProductAt(i).getProduct_id().equals(Product_id)) {
                cart.removeProductAt(i);
                break;
            }
        }
    }
    
    /**
     * validateCustomer validates the customer when he logs in.
     */
    public Customer validateCustomer(String email, String password) 
            throws Exception {
        
        String checkQuery = "SELECT * FROM CUSTOMERS WHERE email = '" + email + "' AND "
                + "password = '" + password + "'";
        
        Customer customer = null;
        ResultSet r = myConnection.runQuery(checkQuery);
        
        if (r == null) {
            return null;
        } else {
            r.next();
            customer = new Customer(r.getString("email"), r.getString("password"));
            r.close();
            
            return customer;
        }
    }
    
    /**
     * signupCustomer registers a new customer.
     */
    public void signupCustomer(String email, String password) 
            throws Exception {
        
        String query = "INSERT INTO CUSTOMERS VALUES ('" + email + "', '" + password + "')";
        int r = myConnection.runUpdate(query);
    }
    
    /**
     * addOrder adds a new order.
     */
    public void addOrder(ProductSet cart, String email, String firstName, 
            String lastName, String address, String phone, String deliveryMethod) 
            throws Exception {
        
        float orderCost = 0;
        for (int i = 0; i < cart.getProductCount(); i++) {
            orderCost += cart.getProductAt(i).getPrice() * cart.getProductAt(i).getQuantity();
        }
        
        if (deliveryMethod.equals("courier")) {
            orderCost += 5.0;
        }
        
        String orderQuery = "INSERT INTO ORDERS VALUES ("
                + "null, '"+email+"', "
                + "'" + firstName + "', '" + lastName + "', '" + address + "', '" + phone + "', "
                + "'" + deliveryMethod + "', current_date, " + orderCost + ")";

        
        int r1 = myConnection.runUpdate(orderQuery);
    }
    
    /**
     * getOrderHistory returns a collection of orders made by the customer.
     */
    public OrderSet getOrderHistory(String email) 
            throws Exception {
        
        OrderSet orders = new OrderSet();
        
        String query = "SELECT order_id, email, first_name, last_name, "
                + "address, phone, delivery_method, STR_TO_DATE(order_date, '%Y-%m-%d') as order_date, "
                + "order_cost FROM ORDERS WHERE email = '" + email + "'";
        
        ResultSet r = myConnection.runQuery(query);
        while (r.next()) {
            Order temp = new Order(r.getInt("order_id"), r.getString("email"), 
                    r.getString("first_name"), r.getString("last_name"), 
                    r.getString("address"), r.getString("phone"), 
                    r.getString("delivery_method"), r.getString("order_date"), 
                    r.getFloat("order_cost"));
            
            orders.addOrder(temp);
        }
        
        return orders;
    }

}   
