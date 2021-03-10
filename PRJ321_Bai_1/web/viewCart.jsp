<%-- 
    Document   : viewCart
    Created on : Mar 6, 2021, 11:30:55 AM
    Author     : Trungtuyen
--%>

<%@page import="java.util.Map"%>
<%@page import="tuyendht.cart.CartObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Store</title>
    </head>
    <body>
        <h1>Your Cart Includes</h1>
        
        <% 
            //1. Cust goes to cart place
            if(session!=null){
                CartObj cart = (CartObj)session.getAttribute("CART");
                
                if(cart!=null){
                    if(cart.getItems()!=null){
                        %>
                        <table border="1">
                            <thead>
                                <tr>
                                    <th>No.</th>
                                    <th>Title</th>
                                    <th>Quantity</th>
                                    <th>Delete</th>
                                </tr>
                            </thead>
                            <tbody>
                            <form action="DispatchServlet">                               
                                <%
                                    Map<String, Integer> items = cart.getItems();
                                    int count = 0;
                                    for(String title : items.keySet()){
                                        %>
                                        <tr>
                                            <td>
                                                <%= ++count %>
                                            .</td>
                                            <td>
                                                <%= title %>
                                                <input type="hidden" name="BookTitle" value="<%= title %>" />
                                            </td>
                                            <td>
                                                <%= items.get(title) %>
                                                <input type="hidden" name="<%= title %>" value="<%= items.get(title) %>" />
                                            </td>
                                            <td>
                                                <input type="checkbox" name="chkItem" value="<%= title %>" />
                                            </td>
                                        </tr>
                                        
                                        
                                <%
                                    }// end for title
                                %>
                                <tr>
                                    <td colspan="3">
                                        <a href="onlineStore.html">Add more Items to Your Cart</a>
                                    </td> 
                                    <td>
                                        <input type="submit" value="Remove Selected Item" name="btnAction" />
                                    </td> 
                                    
                                </tr>
                                <input type="submit" value="Check Out" name="btnAction" />
                            </form>
                            </tbody>                            
                        </table>                       
        <%
                        return;
                    }//end item
                }//end cart
            }//end session
        %>
        <h2>No cart is existed</h2>
    </body>
</html>
