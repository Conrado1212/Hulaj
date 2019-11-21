package pl.edu.wszib.hulaj.model;

import pl.edu.wszib.hulaj.HulajConnection;
import pl.edu.wszib.hulaj.gui.Gui;

public class Main {
    public static void main(String[] args) {
        Gui.showMenu();
        {
        }
        HulajConnection.connect();
        Scooter scooter = new Scooter();
        scooter.setBrand("Brand");
        scooter.setModel("Model");
        scooter.setScooterId(0);
        scooter.getPrice();
        scooter.isRent();

        HulajConnection.addScooter(scooter);
        HulajConnection.getScooter("Brand","Model",0,5,false);
        HulajConnection.removeScooterId(0);
        HulajConnection.getUpdate("Model");

        Scooter scooter1 =  HulajConnection.getScooter("Brand","Model",0,5,false);
        Scooter scooter2 =  HulajConnection.removeScooterId(1);
        Scooter scooter3 =  HulajConnection.getUpdate("Model");
        System.out.println(scooter1);
        System.out.println(scooter2);
        System.out.println(scooter3);
    }
}