<%-- 
    Document   : newjsp2
    Created on : 2019-10-22, 15:38:19
    Author     : Hileo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="store.*"%>
<jsp:useBean id="tags" scope="page" class="store.CommonTags" />

<%
    String err = (request.getParameter("err") == null)
            ? ""
            : request.getParameter("err");
    
    String email = (request.getParameter("email") == null)
            ? ""
            : request.getParameter("email");
%>

<!DOCTYPE html>
<html lang="en">
	<head>
            <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">  
	    <title>MyShop - Sign Up</title>
            <meta name="description" content="">
            <meta name="author" content="templatemo">
	    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,700' rel='stylesheet' type='text/css'>
	    <link href="css/font-awesome.min.css" rel="stylesheet">
	    <link href="css/bootstrap.min.css" rel="stylesheet">
	    <link href="css/templatemo-style.css" rel="stylesheet"> 
	</head>
        
	<body class="light-gray-bg">
            <div class="templatemo-content-widget templatemo-login-widget white-bg">
                <header class="text-center">
                    <div class="square"></div>
                    <h1>SIGN UP</h1>
                </header>
                <p>Please SIGN UP and LOG IN to make the orders</p>
                <form action="CustomerSignupController" method="post">
                    <div class="form-group">
                        <div class="input-group">
                             <div class="input-group-addon"><i class="fa fa-user fa-fw"></i></div>
                             <input type="text" class="form-control" name="email" value="<%=email%>" placeholder="name@myshop.com">
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-addon"><i class="fa fa-key fa-fw"></i></div>
                            <input type="password" class="form-control" name="password" placeholder="******">
                        </div>
                    </div>

                        
                    <div class="form-group">
                        <%=tags.getColumnSpace(1)%>
                        <button type="submit" class="templatemo-blue-button width-100">Sign Up</button>
                    </div>
                    
                    <div align="center"><font color="red"><%=err%></font></div>
                </form>
            </div>
         
	</body>
</html>
