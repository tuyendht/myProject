/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuyendht.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import tuyendht.utils.DBHelper;

/**
 *
 * @author Trungtuyen
 */
public class OrderDAO {
    private List<OrderDTO> order;
    public List<OrderDTO> getOrder(){
        return order;
    }
    public int getLastBillID()
            throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int lastBillID = 0;
        try {
            con = DBHelper.makeConection();
            if(con!=null){
                String sql = "SELECT MAX(orderID) AS orderID "
                           + "FROM Orders ";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                if(rs.next()){
                    return lastBillID = rs.getInt("orderID");
                }
                
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if(stm!=null){
                stm.close();
            }
            if(con!=null){
                con.close();
            }
        }
        return lastBillID;
    }
    public boolean insertCustInfoToOrder(String custName, String custAddress) 
            throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBHelper.makeConection();
            if(con!=null){
                String sql = "INSERT INTO Orders "
                           + "VALUES(?,?) ";
                stm = con.prepareStatement(sql);
                stm.setString(1, custName);
                stm.setString(2, custAddress);
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
