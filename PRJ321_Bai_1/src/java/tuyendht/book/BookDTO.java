/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuyendht.book;

import java.io.Serializable;

/**
 *
 * @author Trungtuyen
 */
public class BookDTO implements Serializable{
    private String id;
    private String name;

    public BookDTO(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
}
