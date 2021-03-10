/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuyendht.book;

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
public class BookDAO {
    private List<BookDTO> books;
    public List<BookDTO> getBooks(){
        return books;
    }
    public void searchBook(String name) 
            throws SQLException, NamingException{           
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConection();
            if(con!=null){
                String sql = "SELECT bookID, name "
                           + "FROM Books "
                           + "WHERE name LIKE ?";
                stm = con.prepareStatement(sql);
                stm.setString(1,"%"+ name +"%");
                rs = stm.executeQuery();
                while(rs.next()){
                    name = rs.getString("name");
                    String id = rs.getString("bookID");
                    BookDTO dto = new BookDTO(id, name);
                    if(this.books==null){
                        this.books = new ArrayList<>();
                    }
                    this.books.add(dto);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
}
