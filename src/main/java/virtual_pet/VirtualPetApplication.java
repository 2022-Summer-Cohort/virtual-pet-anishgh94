package virtual_pet;

import java.util.Locale;
import java.util.Scanner;

public class VirtualPetApplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        VirtualPet buddy = new VirtualPet("Buddy", 5, 5, 5);
        System.out.println();
        boolean continueGame = true;
        while (buddy.getHungerLevel() != 10 && buddy.getThirstLevel() != 10 && buddy.getBoredomLevel() != 10 && continueGame) {

            buddy.showStatus();

            buddy.displayOptions();
            String optionToDo = sc.nextLine();
            optionToDo = optionToDo.toLowerCase();
            System.out.println();

            if (optionToDo.equals("e")) {
                continueGame = false;

            } else if (optionToDo.equals("f")) {
                System.out.println("1 scoop = -1 hunger level");
                System.out.print("Enter the number of scoops of food to feed: ");
                int scoopsOfFood = sc.nextInt();
                sc.nextLine();
                buddy.feedPet(scoopsOfFood);
                System.out.println();

            } else if (optionToDo.equals("w")) {
                System.out.println("1 cup = -1 thirst level");
                System.out.print("Enter the number of cups of water to drink: ");
                int cupsOfWater = sc.nextInt();
                sc.nextLine();
                buddy.drinkWater(cupsOfWater);
                System.out.println();

            } else if (optionToDo.equals("a")) {
                System.out.println("Pick an activity to do with " + buddy.getName() + ": ");
                System.out.print("Play Ball: B/b || Watch Videos: V/v || Walks: W/w ");
                String activityChoice = sc.nextLine();
                activityChoice = activityChoice.toLowerCase();
                buddy.doActivity(activityChoice);
                System.out.println();
            }
            System.out.println("------------------------------------------------------------------------");
            buddy.tick();
        }
        System.out.println("Thank you for playing. Goodbye!!");
    }

}

