<%-- 
    Document   : search
    Created on : Feb 24, 2021, 10:52:51 AM
    Author     : Trungtuyen
--%>

<%@page import="tuyendht.registration.RegistrationDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
    <body>
        <% 
            Cookie[] cookies = request.getCookies();
            if(cookies!=null){
                Cookie lastCookie = cookies[cookies.length - 1];
                %>
                Welcome, <%= lastCookie.getName() %>
        <%
            }
        %>
        <h1>Search Page</h1>
        <form action="DispatchServlet">
            Search by Name <input type="text" name="txtSearch" 
                                value="<%= request.getParameter("txtSearch") %>" /> <br/>
            <input type="submit" value="Search" name="btnAction" />           
        </form>
        <% 
            String searchValue = request.getParameter("txtSearch");
            if(searchValue!=null){//first time to load search page
                List<RegistrationDTO> result = 
                        (List<RegistrationDTO>) request.getAttribute("SEARCHRESULT");
                if(result!=null){
                    %> 
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>Username</th>
                                <th>Password</th>
                                <th>Full Name</th>
                                <th>Roll</th>
                                <th>Delete</th>
                                <th>Update</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% 
                                int count = 0;
                                for(RegistrationDTO dto : result){
                                    String urlRewriting = "DispatchServlet"
                                                        + "?btnAction=Delete"
                                                        + "&pk="+dto.getUsername()+
                                                          "&lastSearchValue="+searchValue  ;                                    
                                    %> 
                        <form action="DispatchServlet">
                        
                            <tr>
                                <td>
                                    <%= ++count %>.
                                </td>
                                <td>
                                    <%= dto.getUsername() %>
                                    <input type="hidden" name="txtUsername" 
                                           value="<%= dto.getUsername() %>" />
                                </td>
                                <td>
                                    <input type="text" name="txtPassword" 
                                           value="<%= dto.getPassword() %>" />
                                </td>
                                <td>
                                    <%= dto.getFullName() %>
                                </td>
                                <td>
                                    <input type="checkbox" name="cbRole" value="ON" 
                                           <% 
                                           if(dto.isRole()){
                                               %>
                                               checked="checked"
                                           <%
                                           }
                                           %>
                                           />
                                </td>
                                <td>
                                    <a href="<%=urlRewriting%>">Delete</a>
                                </td>
                                <td>
                                    <input type="submit" value="Update" name="btnAction" />
                                    <input type="hidden" name="lastSearchValue" 
                                           value="<%= searchValue %>" />
                                </td>
                            </tr>   
                        </form>
                            <%
                                }//end if traversing result
                            %>
                        </tbody>
                    </table>

        <%
                } else {
                    %>
                    <h2>
                        No record is matched!!!
                    </h2>
        <%            
                }
            }//end if search value has inputted
        %>
        <a href="onlineStore.html">Buy Here</a>
    </body>
</html>
