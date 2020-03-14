import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import store.Product;
import store.Store;

/**
 * Class ProductDetailsController contains
 * the servlet controller functionality for processing
 * customer's request to see the details about a Product.
 *
 */
public class ProductDetailsController extends HttpServlet {
    
    public void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String Product_id = request.getParameter("Product_id");
        
        Product Product = new Product();
        
        try {
            Store store = new Store();
            Product = store.getProductDetail(Product_id);
            // Set Product session attribute to provide its details.
            request.getSession().setAttribute("Product", Product);
            response.sendRedirect(request.getContextPath() + "/product-details.jsp?Product_id=" + Product_id);
        } catch(Exception e) {}
    }
    
}
