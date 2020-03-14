import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import store.ProductSet;
import store.Store;

/**
 * Class AddToCartController contains the servlet controller functionality 
 * for processing customer's request to add a Product into the cart.
 *
 */
public class AddToCartController extends HttpServlet {
    
    public void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String Product_id = request.getParameter("Product_id");
        
        // Get session to add Product into the cart.
        HttpSession session = request.getSession();
        ProductSet cart;
        cart = (ProductSet) session.getAttribute("cart");
        
        try {
            Store store = new Store();
            store.addProductToCart(cart, Product_id);
            request.getSession().setAttribute("cart", cart);
            response.sendRedirect(request.getHeader("referer"));
        } catch(Exception e) {}

    }
    
}
