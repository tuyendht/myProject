/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuyendht.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tuyendht.cart.CartObj;
import tuyendht.order.OrderDAO;
import tuyendht.order.OrderDTO;
import tuyendht.orderDetail.orderDetailDAO;

/**
 *
 * @author Trungtuyen
 */
@WebServlet(name = "CheckOutServlet", urlPatterns = {"/CheckOutServlet"})
public class CheckOutServlet extends HttpServlet {
    private final String SHOPPING_PAGE = "onlineStore.html";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     * @throws javax.naming.NamingException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = SHOPPING_PAGE;
        String custName = request.getParameter("txtCustName");
        String custAdd = request.getParameter("txtAddress");
        int billID;
        try {
            HttpSession session = request.getSession(false);
            //true thi tu tao, false neu ko co thi khong tao
            if(session!=null){
                CartObj cart = (CartObj)session.getAttribute("CART");
                if(cart!=null){
                    Map<String, Integer> items = cart.getItems();
                    if(items!=null){
                        String insertItem[] = request.getParameterValues("BookTitle");
                        if(insertItem!=null){    
                            OrderDAO order = new OrderDAO();
                            billID = order.getLastBillID()+1;
                            order.insertCustInfoToOrder(custName, custAdd);                            
                            for(String item : insertItem){                               
                                orderDetailDAO orderDetail = new orderDetailDAO();
                                int quantity = Integer.parseInt(request.getParameter(item));
                                orderDetail.insertBookToOrderDetail(billID, item, quantity);
                            }
                            session.removeAttribute("CART");
                        }                                             
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }finally{
            response.sendRedirect(url);
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
