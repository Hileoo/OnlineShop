import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import store.ProductSet;
import store.Store;

/**
 * Class CategorizeController contains
 * the servlet controller functionality for processing
 * customer's request to show the Products of a particular category.
 */
public class CategorizeController extends HttpServlet {
    
    public void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String category = request.getParameter("category");
        ProductSet categorizedProducts = new ProductSet();

        try {
            Store store = new Store();
            categorizedProducts = store.categorize(category);
            // Set categorizedProducts attribute to provide Products of a category.
            request.getSession().setAttribute("categorizedProducts", categorizedProducts);
            response.sendRedirect(request.getContextPath() + "/categorized_Products.jsp?category=" + category);
        } catch (Exception e) {}

    }
    
}
