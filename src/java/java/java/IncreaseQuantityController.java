import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import store.ProductSet;

/**
 * Class IncreaseQuantityController contains
 * the servlet controller functionality for processing
 * customer's request to increase the number of Products of a title in the cart
 *
 */
public class IncreaseQuantityController extends HttpServlet {
    
    public void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String Product_id = request.getParameter("Product_id");
        
        // Get cart of the current session.
        HttpSession session = request.getSession();
        ProductSet cart;
        cart = (ProductSet) session.getAttribute("cart");
        
        for (int i = 0; i < cart.getProductCount(); i++) {
            if (cart.getProductAt(i).getProduct_id().equals(Product_id)) {
                cart.getProductAt(i).setQuantity(cart.getProductAt(i).getQuantity() + 1);
                break;
            }
        }
        
        session.setAttribute("cart", cart);
        response.sendRedirect(request.getHeader("referer"));
    }
    
}
