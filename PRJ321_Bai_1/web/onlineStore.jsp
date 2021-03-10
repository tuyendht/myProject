<%-- 
    Document   : onlineStore.jsp
    Created on : Mar 7, 2021, 8:26:48 PM
    Author     : Trungtuyen
--%>

<%@page import="java.util.List"%>
<%@page import="tuyendht.book.BookDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Store</title>
    </head>
    <body>
        <h1>Book Store</h1>
        <form action="DispatchServlet">
            Search Book <input type="text" name ="txtSearchBook" 
                               value="<%= request.getParameter("txtSearchBook") %>"/>
            <input type="submit" value="Search Book" name="btnAction"/>
            <input type="submit" value="View Cart" name="btnAction"/>
        </form></br>
        <%
            String searchBook = request.getParameter("txtSearchBook");
            if(searchBook!=null){
                List<BookDTO> result = (List<BookDTO>)request.getAttribute("SEARCHBOOK");
                if(result!=null){
                    %>
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>ID</th>
                                <th>Book Name</th>
                                <th>Add</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                int count = 0;
                                for(BookDTO dto : result){
                                    String id = dto.getId();
                                    String name = dto.getName();
                                    %>
                        <form action="DispatchServlet">
                            <tr>
                                <td>
                                    <%= ++count %>
                                </td>
                                <td>
                                    <%= id %>                                    
                                </td>
                                <td>
                                    <%= name %>
                                    <input type="hidden" name="txtBookName" value="<%= name %>" />
                                </td>
                                <td>
                                    <input type ="submit" name="btnAction" value="Add to Cart"/>
                                    <input type="hidden" name="lastSearchValue" value="<%= searchBook%>" />
                                </td>
                            </tr>
                        </form>
                            <%
                                }
                            %>
                        </tbody>
                    </table>

        <%
                }
            }
        %>
    </body>
</html>
