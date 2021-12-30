
package sprint1;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    ApplicationSystem system;

    public Admin() {
        
    }

    public Admin(ApplicationSystem system) {
        this.system = system;
    }
    
    public void verify(){
        for(Driver driver: system.pendingDriverList){
            driver.verified = true;
            system.users.add(driver);
            system.verifiedDrivers.add(driver);
            system.pendingDriverList = null;
            system.pendingDriverList = new ArrayList<>();
        }
    }
    
    public void suspendUser(){
        
        system.getUsers();
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose the number of the user to suspend: ");
        int indexChoice = scan.nextInt();
        
        system.users.get(indexChoice-1).setSuspend(true);
        
    }
    
    public ArrayList<Driver> getPendingDriverList() {
        return system.getPendingDriverList();
    }
    
    public void getAllOffers(){
        //system.setAllOffers();
        for(RideOffer ride : system.rideOffers)
            System.out.println(ride);
    }
    
    public void getAllAcceptedRides(){
        
        for(Ride ride : system.acceptedRides){
            System.out.println(ride);
        }
            
    }
    
    public void getArrivingEvent(){
        
        for(Ride ride : system.acceptedRides){
            System.out.println("Arriving Time: " + ride.arrivingTime+", Driver Name: "+ ride.getDriver().getUsername() +", Customer Name: "+ ride.customer.getUsername());
        }
    }
    
    public void getDestinationEvent(){
        for(Ride ride : system.acceptedRides){
            LocalTime destTime = ride.arrivingTime.plusMinutes(ride.duration);
            System.out.println("Destination Time: " + destTime +", Driver Name: "+ ride.getDriver().getUsername() +", Customer Name: "+ ride.customer.getUsername());
        }
    }

}
