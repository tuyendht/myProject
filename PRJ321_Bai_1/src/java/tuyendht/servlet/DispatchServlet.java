/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuyendht.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Trungtuyen
 */
@WebServlet(name = "DispatchServlet", urlPatterns = {"/DispatchServlet"})
public class DispatchServlet extends HttpServlet {
    private final String LOGIN_PAGE = "login.html";
    private final String LOGIN_CONTROLLER = "LoginServlet";
    private final String SEARCH_LASTNAME_CONTROLLER = "SearchServlet";
    private final String DELETE_ACCOUNT_CONTROLLER = "DeleteAccountServlet";
    private final String UPDATE_ACCOUNT_CONTROLLER = "UpdateAccountServlet";
    private final String START_UP_APP_CONTROLLER = "StartUpAppServlet";
    private final String ADD_TO_CART = "AddToCartServlet";
    private final String VIEW_CART = "viewCart.jsp";
    private final String SEARCH_BOOK_CONTROLLER = "SearchBookServlet";
    private final String REMOVE_FROM_CART = "RemoveFromCartServlet";
    private final String CHECK_OUT_PAGE = "checkOut.jsp";
    private final String CHECK_OUT_CONTROLLER = "CheckOutServlet";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String url = LOGIN_PAGE;
        String button = request.getParameter("btnAction");
        
        try {
            if(button == null){
                url = START_UP_APP_CONTROLLER;
            }
            else if(button.equals("Login")){
                url = LOGIN_CONTROLLER;
            }
            else if(button.equals("Search")){
                url = SEARCH_LASTNAME_CONTROLLER;
            }
            else if(button.equals("Delete")){
                url = DELETE_ACCOUNT_CONTROLLER;
            }
            else if(button.equals("Update")){
                url = UPDATE_ACCOUNT_CONTROLLER;
            }
            else if(button.equals("Search Book")){
                url = SEARCH_BOOK_CONTROLLER;
            }
            else if(button.equals("Add to Cart")){
                url = ADD_TO_CART;
            }
            else if(button.equals("View Cart")){
                url = VIEW_CART;
            }
            else if(button.equals("Remove Selected Item")){
                url = REMOVE_FROM_CART;
            }
            else if(button.equals("Check Out")){
                url = CHECK_OUT_PAGE;
            }
            else if(button.equals("Finish Check Out")){
                url = CHECK_OUT_CONTROLLER;
            }
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
