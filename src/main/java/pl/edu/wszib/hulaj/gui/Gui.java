package pl.edu.wszib.hulaj.gui;

import pl.edu.wszib.hulaj.HulajConnection;
import pl.edu.wszib.hulaj.model.Scooter;
import pl.edu.wszib.hulaj.repository.HulajRepository;

import java.util.Scanner;

public class Gui {
    public static void showMenu(){


        System.out.println("1.Dodaj do bazy: ");
        System.out.println("2.Wyciagnij z bazy: ");
        System.out.println("3.Aktualizacja bazy:");
        System.out.println("4.Avaliable list: ");
        System.out.println("5.Rent scooter: ");
        System.out.println("6.Exit.");

        Scanner in = new Scanner(System.in);

        String menu = in.nextLine();

        switch (menu){
            case "1":
                Scooter scooter = new Scooter();
                HulajConnection.addScooter(scooter);
                break;
            case "2":
                System.out.println("Podaj model hulajki: ");
                String model = in.nextLine();
                HulajConnection.getScooter("Brand","Model",0,5,false);
                break;
            case "3":
                HulajConnection.getUpdate("Model");
                break;
            case "4":
                Scooter[] avaliableScooters = HulajRepository.hulajrepository.getNotRentScooters();
                for(Scooter s : avaliableScooters){
                    if(s!=null){
                        System.out.println(s.getBrand()+ " - " + s.getModel() + " - " + s.getScooterId());
                    }
                }
                break;
            case "5":
                rentScooterMenu();
                break;
            case "6":
                System.exit(0);
                break;
                default:
                    break;
        }
    }
    public  static void rentScooterMenu(){
        System.out.println("Write ScooterId: ");
    }
}
