package store;

/**
 * Class CommonTags represents functions to print
 * common header, customer form, logged customer form,
 * CSS file path, cart form, categories form, etc.

 */
public class CommonTags {
    /**
     * Common tags constructor 
    */
    public CommonTags() {}
    
    /**
    * getHeader returns the string of HTML for the common store header.
    */
    public String getHeader() {
        String header = ""
                + "<table>"
                + "<tr>"
                + "<td>"
                + "<a href='index.jsp' style='color: white'>"
                + "<img src='images/logo.png' width='170' height='60'>"
                + "</a>"
                + "</td>"
                + "<td>"
                + getSpace(10)
                + "</td>"
                + "<td>"
                + "<form action='SearchController' method='post'>"
                + "<input type='text' name='searchString' size='50'>"
                + "</td>"
                + "<td>"
                + "<input type='image' src='images/search.png' alt='Search' height='26' width='73'>"
                + "</form>"
                + "</td>"
                + "</tr>"
                + "</table>";
        
        return header;
    }
    
    /**
     * getCustomerForm return the string of HTML to get common customer form.
     */
    public String getCustomerForm() {
        String form = "<div id='userForm' class='nav-item active'>"
                + "<br><br>"
                + "<table align='right'>"
                + "<tr>"
                + "<td>"
                + "<a class='nav-link' href='login.jsp'>Login</a>"
                + "<td>"
                + "<a class='nav-link' href='signup.jsp'>SignUp</a>"
                + "</td>"
                + "</tr>"
                + "</table>"
                + "</div>";
//        
//        String form = "<div id='userForm'>"
//                + "<table align='right'>"
//                + "<tr>"
//                + "<td>"
//                + "<a href='login.jsp'><image src='images/login.png' alt='Log in' height='26' width='65'></a>"
//                + "<td>"
//                + "<a href='signup.jsp'><image src='images/signup.png' alt='Log in' height='26' width='75'></a>"
//                + "</td>"
//                + "</tr>"
//                + "</table>"
//                + "</div>";
        
        return form;
    }
    
    /**
     * getLoggedCustomerForm return the string of HTML to get common logged customer form.
     */
    public String getLoggedCustomerForm(String email) {
        String form = "<div id='userForm' class='nav-item active'>"
                + "<br><br>"
                + "<table align='right'>"
                + "<tr>"
                + "<td>"
                + "<p>"
                + "Dear, "
                + "</p>"
                + "</td>"
                + "<td>"
                + "<p>"
                + email
                + "</p>"
                + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td>"
                + "<form action='CustomerOrderHistoryController' method='post'>"
                + "<input type='image' src='images/cabinet.png' height='26' width='78'>"
                + "</form>"
                + "</td>"
                + "<td>"
                + "<form action='CustomerLogoutController' method='post'>"
                + "<input type='image' src='images/logout.png' height='26' width='78'>"
                + "</form>"
                + "</td>"
                + "</tr>"
                + "</table>"
                + "</div>";
        
        return form;
    }
    
    /**
     * getCss returns the string of HTML of common CSS file path.
     */
    public String getCss() {
        String css = "<link rel='stylesheet' type='text/css' href='layout.css'>";
        
        return css;
    }
    
    /**
     * addToCartForm returns the string of HTML of common form to add Products into the cart.
     */
    public String addToCartForm(String Product_id) {
        String form = ""
                + "<form action='AddToCartController' method='post'>"
                + "<data-toggle='tooltip' data-placement='left' title='Add to cart'>"
                + "<input type='image' src='img/core-img/cart.png' alt=''>"
                + "<input type='hidden' name='Product_id' value='" + Product_id + "'>"
                + "</form>";

        return form;
    }
    
    /**
     * getCartView returns the string of HTML of common form to view the cart items.
     */
    public String getCartView() {
        String cartView = "<div align='center'>"
                + "<form action='cart_items.jsp' align='right'>"
                + "<input type='image' src='images/cart.png' alt='cart' height='70' width='70' align='center'>"
                + "</form>"
                + "</div>";
        
        return cartView;
    }
    
    /**
     * getCategoriesForm returns the string of HTML of common form of the categories.
     */
    public String getCategoriesForm() {
        String form = ""
                + "<div id='categories'>"
                + "<h3 align='center'><font color='white'><i>Categories:</i></font></h3>"
                + "<form action='CategorizeController' method='post'>"
                + "<input type='submit' class='linkButton' value='Arts'>"
                + "<input type='hidden' name='category' value='Arts'>"
                + "</form>"
                + "<br>"
                + "<form action='CategorizeController' method='post'>"
                + "<input type='submit' class='linkButton' value='Computer Science'>"
                + "<input type='hidden' name='category' value='Computer Science'>"
                + "</form>"
                + "<br>"
                + "<form action='CategorizeController' method='post'>"
                + "<input type='submit' class='linkButton' value='Cooking'>"
                + "<input type='hidden' name='category' value='Cooking'>"
                + "</form>"
                + "<br>"
                + "<form action='CategorizeController' method='post'>"
                + "<input type='submit' class='linkButton' value='Fiction'>"
                + "<input type='hidden' name='category' value='Fiction'>"
                + "</form>"
                + "<br>"
                + "<form action='CategorizeController' method='post'>"
                + "<input type='submit' class='linkButton' value='TextProducts'>"
                + "<input type='hidden' name='category' value='TextProducts'>"
                + "</form>"
                + "</div>";
        
        return form;
    }
    
    /**
     * getRowSpace returns the string of HTML to get row space in the table.
     */
    public String getRowSpace(int length) {
        String space = "";
        for (int i = 0; i < length; i++) {
            space += "<tr></tr>";
        }
        
        return space;
    }
    
    /**
     * getColumnSpace returns the string of HTML to get column space in the table
     */
    public String getColumnSpace(int length) {
        String space = "<td>";
        for (int i = 0; i < length; i++) {
            space += "&nbsp;";
        }
        space += "</td>";
        
        return space;
    }
    
    /**
     * getSpace returns the string of HTML to get space.
     */
    public String getSpace(int length) {
        String space = "";
        for (int i = 0; i < length; i++) {
            space += "&nbsp";
        }
        
        return space;
    }
    
    /**
     * getBreaks returns the string of HTML to get line breaks.
     */
    public String getBreaks(int length) {
        String space = "";
        for (int i = 0; i < length; i++) {
            space += "<br>";
        }
        
        return space;
    }
}
