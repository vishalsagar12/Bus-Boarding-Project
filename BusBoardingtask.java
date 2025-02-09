package jdbc.com;

import java.util.Random;

public class BusBoardingtask {
    public static void main(String[] args) {
        final int capacity = 30;
        int currentPassangers = 0;
        int PassangerseleftfBehind = 0;
        int[] passangersUnboarding = {0, 2, 4};
        int[] passangersBoarding = {5, 7, 6};
        int numofstops = passangersBoarding.length;
        System.out.println("Welcome To The Bus Boarding Simulation!");
        System.out.println("The Bus Can Hold a Maximum of " + capacity + " passengers.\n");

        
        int familySeatsNeeded = 3; 
        String familyPNR = generatePNR(); 

        for (int stop = 0; stop < numofstops; stop++) {
            System.out.println("---stop " + (stop + 1) + "---");
            System.out.println("Current passengers on the bus: " + currentPassangers);
            int unboarding = passangersUnboarding[stop];
            if (unboarding > currentPassangers) {
                System.out.println("Error: More passengers unboarding than currently on the bus.");
                unboarding = currentPassangers;
            }
            currentPassangers -= unboarding;
            System.out.println(unboarding + " passengers unboarded..");

            int boarding = passangersBoarding[stop];
            if (currentPassangers + boarding > capacity) {
                int canBoard = capacity - currentPassangers;
                PassangerseleftfBehind += (boarding - canBoard);
                currentPassangers = capacity;
                System.out.println(canBoard + " passengers boarded the bus. " + (boarding - canBoard) + " left behind.");
            } else {
               
                if (boarding >= familySeatsNeeded) {
                    System.out.println(familySeatsNeeded + " family members with PNR " + familyPNR + " boarded together.");
                    boarding -= familySeatsNeeded;
                    currentPassangers += familySeatsNeeded;
                }

                
                if (boarding > 0) {
                    currentPassangers += boarding;
                    System.out.println(boarding + " passengers boarded the bus.");
                }

                if (currentPassangers == capacity) {
                    System.out.println("The bus is now full!");
                }
            }
            System.out.println();
        }

        System.out.println("Simulation completed..");
        System.out.println("Final passengers on the bus: " + currentPassangers);
        System.out.println("Total passengers left behind: " + PassangerseleftfBehind);
    }

    
    public static String generatePNR() {
        Random rand = new Random();
        int number = rand.nextInt(1000000); 
        return "PNR" + String.format("%06d", number);
    }
}