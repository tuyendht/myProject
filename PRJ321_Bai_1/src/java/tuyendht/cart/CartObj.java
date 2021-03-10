/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuyendht.cart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Trungtuyen
 */
public class CartObj implements Serializable{
    private Map<String, Integer> items; //item la gio hang

    public Map<String, Integer> getItems() {
        return items;
    }
    
    public void addToCart(String title){
        //1. Check existed items
        if(this.items == null){
            this.items = new HashMap<>();
        }//end if items is not existed
        //2. Check existed books
        int quantity = 1;
        if (this.items.containsKey(title)){
            quantity = this.items.get(title) + 1;
        }
        this.items.put(title, quantity);        
    }
    
    public void removeFromCart(String title){
        //1. Check existed items
        if(this.items == null){
            return;
        }
        //2. Check existed book
        if(this.items.containsKey(title)){
            //3. Remove
            this.items.remove(title);
            if(this.items.isEmpty()){
                this.items = null;
            }
        }
    }
}
