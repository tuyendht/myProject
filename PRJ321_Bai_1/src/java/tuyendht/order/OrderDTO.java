/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuyendht.order;

/**
 *
 * @author Trungtuyen
 */
public class OrderDTO {
    private int orderId;
    private String custName;
    private String custAddress;
    public OrderDTO(){
        
    }
    public OrderDTO(int orderId, String custName, String custAddress) {
        this.orderId = orderId;
        this.custName = custName;
        this.custAddress = custAddress;
    }

    public int getOrderId() {
        return orderId;
    }


    public String getCustName() {
        return custName;
    }


    public String getCustAddress() {
        return custAddress;
    }

    
}
