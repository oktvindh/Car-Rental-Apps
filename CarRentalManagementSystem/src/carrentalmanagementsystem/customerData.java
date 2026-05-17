/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrentalmanagementsystem;

/**
 *
 * @author Hype G12
 */
public class customerData {
    private Integer customerId;
    private String firstName;
    private String lastName;
    private String gender;
    private Integer carId;
    private String brand;
    private String model;
    private Double total;

    public customerData(Integer customerId, String firstName,
            String lastName, String gender,
            Integer carId, String brand,
            String model, Double total) {

        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.total = total;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public Integer getCarId() {
        return carId;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Double getTotal() {
        return total;
    }

}
