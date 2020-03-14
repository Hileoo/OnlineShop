import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import store.ProductSet;
import store.Store;

/**
 * Class SearchController contains
 * the servlet controller functionality for processing
 * customer's request to search a Product by title or author.
 *
 */
public class SearchController extends HttpServlet {
    
    public void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String searchString = request.getParameter("searchString");
        
        // Ensure that search request is not empty.
        if (searchString.equals("")) {
        	response.sendRedirect(request.getHeader("referer"));
        } else {
            ProductSet Products = new ProductSet();

            try {
                Store store = new Store();
                Products = store.search(searchString);
                
                request.getSession().setAttribute("Products", Products);
                response.sendRedirect(request.getContextPath() + "/search_results.jsp?searchString=" + searchString);
            } catch (Exception e) {}

        }
    }
    
}
