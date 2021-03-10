/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuyendht.registration;

import java.io.Serializable;
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
public class RegistrationDAO implements Serializable{
    public boolean checkLogin(String username, String password) 
            throws SQLException, NamingException{       
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1.Connect DB
            con = DBHelper.makeConection();
            if(con!=null){
                //2. Create sql string
                String sql = "SELECT username "
                           + "FROM Registration "
                           + "WHERE username = ? AND password = ?";
                //3.Create statement & assign para value
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                //4.Excute Query
                rs = stm.executeQuery();
                //5. Process result
                if(rs.next()){
                    return true;
                }
            }//end if con is opened
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
        return false;
    }
    private List<RegistrationDTO> accountList;//chi doc khong duoc phep ghi

    public List<RegistrationDTO> getAccountList() {
        return accountList;
    }
    
    public void searchLastname(String searchValue)
            throws SQLException, NamingException{       
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1.Connect DB
            con = DBHelper.makeConection();
            if(con!=null){
                //2. Create sql string
                String sql = "SELECT username, password, lastname, isAdmin "
                           + "FROM Registration "
                           + "WHERE lastname LIKE ?";
                //3.Create statement & assign para value
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                //4.Excute Query
                rs = stm.executeQuery();
                //5. Process result
                while(rs.next()){
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String fullName = rs.getString("lastname");
                    boolean role = rs.getBoolean("isAdmin");
                    RegistrationDTO dto = new RegistrationDTO(username, password, fullName, role);
                    if(this.accountList == null){
                        this.accountList = new ArrayList<>();
                    }//end if accountlist is not allocated
                    this.accountList.add(dto);
                }//end if rs is traversal
            }//end if con is opened
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
    }
    public boolean deleteAccount(String username)
            throws SQLException, NamingException{ 
        Connection con = null;
        PreparedStatement stm = null;
        try {
            //1.Connect DB
            con = DBHelper.makeConection();
            if(con!=null){
                //2. Create sql string
                String sql = "DELETE FROM Registration "
                           + "WHERE username = ?";
                //3.Create statement & assign para value
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                //4.Excute Query
                int effectRow = stm.executeUpdate();
                //5. Process result
                if(effectRow>0){
                    return true;
                }
            }//end if con is opened
        } finally {           
            if(stm!=null){
                stm.close();
            }
            if(con!=null){
                con.close();
            }
        }
        return false;
    }
    public boolean updateAccount(String username, String password, boolean isRole)
            throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        try {
            //1.Connect DB
            con = DBHelper.makeConection();
            if(con!=null){
                //2. Create sql string
                String sql = "UPDATE Registration "
                           + "SET password = ?, isAdmin = ? "
                           + "WHERE username = ?";
                //3.Create statement & assign para value
                stm = con.prepareStatement(sql);
                stm.setString(1, password);
                stm.setBoolean(2, isRole);
                stm.setString(3, username);
                
                
                //4.Excute Query
                int effectRow = stm.executeUpdate();
                //5. Process result
                if(effectRow>0){
                    return true;
                }
            }//end if con is opened
        } finally {           
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
    
