<%-- 
    Document   : checkOut
    Created on : Mar 8, 2021, 8:28:30 PM
    Author     : Trungtuyen
--%>

<%@page import="java.util.Map"%>
<%@page import="tuyendht.cart.CartObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bill</title>
    </head>
    <body>
        <h1>Your Bill</h1>
        <%
            if(session!=null){
                CartObj cart = (CartObj)session.getAttribute("CART");
                if(cart!=null){
                    Map<String, Integer> items = cart.getItems();
                    if(items!=null){
                        %>
                        <table border="1">
                            <thead>
                                <tr>
                                    <th>No.</th>
                                    <th>Title</th>
                                    <th>Quantity</th>
                                </tr>
                            </thead>
                            <tbody>
                            <form action="DispatchServlet">
                                Your Name <input type="text" name="txtCustName" value="" /></br>
                                <p>Your Address</p><textarea name="txtAddress" value="" rows="4" cols="20"></textarea></br>
                                <input type="submit" value="Finish Check Out" name="btnAction" />
                                <%
                                    int count = 0;
                                    for(String title : items.keySet()){
                                        %>
                                        <tr>
                                            <td>
                                                <%= ++count %>
                                            </td>
                                            <td>
                                                <%= title %>
                                            </td>
                                            <td>
                                                <%= items.get(title) %>
                                            </td>
                                        </tr>
                                        <input type="hidden" name="BookTitle" value="<%= title %>" />
                                        <input type="hidden" name="<%= title %>" value="<%= items.get(title) %>" />
                                <%
                                    }
                                %>                               
                            </form>
                            </tbody>
                        </table>

        <%
                    }
                }
            }
        %>
    </body>
</html>
