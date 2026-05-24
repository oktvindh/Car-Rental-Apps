/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrentalmanagementsystem;

import java.sql.Date;

/**
 *
 * @author Hype G12
 */
public class invoiceData {
    
    private Integer invoiceId;
    private String customer;
    private String car;
    private Double total;
    private Double amount;
    private Double balance;
    private Date date;

    public invoiceData(Integer invoiceId, String customer,
            String car, Double total, Double amount,
            Double balance, Date date) {

        this.invoiceId = invoiceId;
        this.customer = customer;
        this.car = car;
        this.total = total;
        this.amount = amount;
        this.balance = balance;
        this.date = date;

    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public String getCustomer() {
        return customer;
    }

    public String getCar() {
        return car;
    }

    public Double getTotal() {
        return total;
    }

    public Double getAmount() {
        return amount;
    }

    public Double getBalance() {
        return balance;
    }

    public Date getDate() {
        return date;
    }
    
}
