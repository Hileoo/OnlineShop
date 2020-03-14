import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import store.ProductSet;
import store.Store;

/**
 * Class DeleteProductFromCartController contains
 * the servlet controller functionality for processing
 * customer's request to delete Product from the cart
 *
 */
public class DeleteProductFromCartController extends HttpServlet {
    
    public void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String Product_id = request.getParameter("Product_id");
        
        // Get cart of the current session.
        HttpSession session = request.getSession();
        ProductSet cart;
        cart = (ProductSet) session.getAttribute("cart");
        
        try {
            Store store = new Store();
            store.deleteProductFromCart(cart, Product_id);
            
            session.setAttribute("cart", cart);
            response.sendRedirect(request.getHeader("referer"));
        } catch(Exception e) {}
        
    }
    
}
