package pl.edu.wszib.hulaj.repository;

import pl.edu.wszib.hulaj.model.Scooter;

public class HulajRepository {
    public static final HulajRepository hulajrepository = new HulajRepository();

 /*   private HulajRepository(){
        Scooter s1 = new Scooter("Xiaomi","MIjia M365",1,5);
        Scooter s2 = new Scooter("Xiaomi","MIjia M365 Pro",2,5);
        Scooter s3 = new Scooter("NInebot by Segway","KickScooter ES2",3,5.5);
        Scooter s4 = new Scooter("Fiat","F500 8",4,4);
        Scooter s5 = new Scooter("Fiat","F500 8,5",5,4.5);

        this.scooters[0] = s1;
        this.scooters[1] = s2;
        this.scooters[2] = s3;
        this.scooters[3] = s4;
        this.scooters[4] = s5;

    }*/
    private Scooter[] scooters = new Scooter[6];

    public void addScooter(Scooter scooter){
        for(int i=0;i<this.scooters.length;i++){
            if(this.scooters[i] == null){
                this.scooters[i] = scooter;
                break;
            }
        }
    }

    public Scooter getScooter (int scooterId){
        for(int i=0;i<this.scooters.length;i++){
            if(this.scooters[i].getScooterId() == scooterId){
                return this.scooters[i];
            }
        }
        return  null;
    }

    public Scooter[] getAllScooters(){
        return this.scooters;
    }
    public Scooter[] getNotRentScooters(){
        Scooter[] result = new Scooter[this.scooters.length];
        int pomIndex = 0;
        for(int i=0;i<this.scooters.length;i++){
            if(!this.scooters[i].isRent()) {
                result [pomIndex++] =this.scooters[i];
            }
        }
        return  result;
    }
}
