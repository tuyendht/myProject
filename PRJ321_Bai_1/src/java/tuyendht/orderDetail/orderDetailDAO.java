/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuyendht.orderDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import tuyendht.utils.DBHelper;

/**
 *
 * @author Trungtuyen
 */
public class orderDetailDAO {
    private List<orderDetailDTO> orderDetail;
    public List<orderDetailDTO> getOrderDetail(){
        return orderDetail;
    }
    private String getBookIDByName(String bookName)
            throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        String bookID = null;
        try {
            con = DBHelper.makeConection();
            if(con!=null){
                String sql = "SELECT bookID, name "
                           + "FROM Books "
                           + "WHERE name = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, bookName);
                rs = stm.executeQuery();
                if(rs.next()){
                    return bookID = rs.getString("bookID");
                }
            }
        } catch (Exception e) {
        }
        return null;
    }
    public boolean insertBookToOrderDetail(int orderID, String bookName, int quantity) 
            throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBHelper.makeConection();
            if(con!=null){
                String sql = "INSERT INTO OrdersDetail "
                           + "VALUES(?,?,?) ";
                stm = con.prepareStatement(sql);
                stm.setInt(1, orderID);
                stm.setString(2, getBookIDByName(bookName));
                stm.setInt(3, quantity);
                int rowEffect = stm.executeUpdate();
                if(rowEffect>0){
                    return true;
                }
            }
        } finally{
            if(stm!=null){
                stm.close();
            }
            if(con!=null){
                con.close();
            }
        }
        return false;
    }
}
