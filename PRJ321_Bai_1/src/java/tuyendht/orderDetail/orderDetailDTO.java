/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuyendht.orderDetail;

/**
 *
 * @author Trungtuyen
 */
public class orderDetailDTO {
    private String orderID;
    private String productID;
    private int quantity;

    public orderDetailDTO(){
        
    }
    public orderDetailDTO(String orderID, String productID, int quantity) {
        this.orderID = orderID;
        this.productID = productID;
        this.quantity = quantity;
    }

    public String getOrderID() {
        return orderID;
    }

    public String getProductID() {
        return productID;
    }

    public int getQuantity() {
        return quantity;
    }
    
}
