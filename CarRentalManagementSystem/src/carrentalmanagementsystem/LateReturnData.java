package carrentalmanagementsystem;

import java.sql.Date;

public class LateReturnData {

    private Integer customerId;
    private String brand;
    private String model;
    private Integer lateDays;
    private Double fine;
    private Double amount;
    private Double balance;
    private Date dateReturned;

    public LateReturnData(Integer customerId, String brand, String model,
                          Integer lateDays, Double fine,
                          Double amount, Double balance,
                          Date dateReturned) {

        this.customerId = customerId;
        this.brand = brand;
        this.model = model;
        this.lateDays = lateDays;
        this.fine = fine;
        this.amount = amount;
        this.balance = balance;
        this.dateReturned = dateReturned;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Integer getLateDays() {
        return lateDays;
    }

    public Double getFine() {
        return fine;
    }

    public Double getAmount() {
        return amount;
    }

    public Double getBalance() {
        return balance;
    }

    public Date getDateReturned() {
        return dateReturned;
    }
}