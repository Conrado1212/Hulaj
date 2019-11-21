package pl.edu.wszib.hulaj.model;

import pl.edu.wszib.hulaj.HulajConnection;

import java.time.LocalDate;

public class Scooter {
    public static final pl.edu.wszib.hulaj.HulajConnection HulajConnection = new HulajConnection();
    private  String brand,model;
    private  int scooterId;
    private double price;
    private boolean rent;


   /* public Scooter(String brand, String model, int scooterId,double price) {
        this.brand = brand;
        this.model = model;
        this.scooterId = scooterId;
        this.rent = false;
        this.price = price;

    }*/

    public  String getBrand() {
        return brand;
    }



    public void setBrand(String brand) {
        this.brand = brand;
    }

    public  String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public  int getScooterId() {
        return scooterId;
    }

    public void setScooterId(int scooterId) {
        this.scooterId = scooterId;
    }

    public boolean isRent() {
        return rent;
    }

    public void setRent(boolean rent) {
        this.rent = rent;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



    @Override
    public String toString() {
        return "Scooter{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", scooterId=" + scooterId +
                ", price=" + price +
                ", rent=" + rent +
                '}';
    }
}
