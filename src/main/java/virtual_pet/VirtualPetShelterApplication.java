package virtual_pet;

import java.util.Arrays;
import java.util.Scanner;

//IGNORE: to update comment
public class VirtualPetShelterApplication {

    public static String askForOption(Scanner sc) {

        System.out.print("Select an option: Food: F/f || Water: W/w || Games: G/g: ");
        String interactiveOption = sc.nextLine();
        interactiveOption = interactiveOption.toLowerCase();

        return interactiveOption;
    }

    public static String returnName(VirtualPetShelter myShelter, Scanner sc) {

        System.out.println("Names: " + Arrays.asList(myShelter.listOfNames()));
        System.out.print("Input the name of the pet to interact with: ");
        String name = sc.nextLine();
        name = name.toLowerCase();

        return name;
    }

    public static void playForOnePet(VirtualPetShelter myShelter, Scanner sc) {
        String userOption = askForOption(sc);
        if (!(userOption.equals("f") || userOption.equals("feed") || userOption.equals("w") || userOption.equals("water")
                || userOption.equals("g") || userOption.equals("game"))) {
            System.out.println("Wrong Option, Go through the game again please.");
        } else {
            String petName = returnName(myShelter, sc);
            VirtualPet tempPet = myShelter.getOnePetWithGivenName(petName);

            if (userOption.equals("f") || userOption.equals("feed")) {
                myShelter.feedOneOnly(tempPet);
            } else if (userOption.equals("w") || userOption.equals("water")) {
                myShelter.waterOneOnly(tempPet);
            } else {
                myShelter.playOneOnly(tempPet);
            }

        }

    }

    public static void playForAllPet(VirtualPetShelter myShelter, Scanner sc) {
        String userOption = askForOption(sc);

        if (userOption.equals("f") || userOption.equals("feed")) {
            myShelter.feedAll();
        } else if (userOption.equals("w") || userOption.equals("water")) {
            myShelter.waterAll();
        } else if (userOption.equals("g") || userOption.equals("game")) {
            myShelter.playAll();
        }
        endTheProgram(userOption);
    }

    public static void adoptPet(VirtualPetShelter myShelter, Scanner sc) {
        System.out.println("Names: " + Arrays.asList(myShelter.listOfNames()));
        System.out.println("Input the name of the pet to adopt: ");
        String name = sc.nextLine();
        name = name.toLowerCase();

        if (myShelter.checkContains(myShelter.getOnePetWithGivenName(name))) {
            System.out.println("The pet " + name + " will be adopted from the shelter. TY");
            myShelter.adoptPet(name);
        } else {
            System.out.println("The pet does not exist in the shelter, please go through the options again");
        }
    }

    public static void admitPet(VirtualPetShelter myShelter, Scanner sc) {
        VirtualPet toBeAdmitted;
        System.out.println("Please enter the name of the pet to admit into the shelter: ");
        String name = sc.nextLine();
        name = name.toLowerCase();
        System.out.println("How happy is the pet when being admitted (1 - 10)?");
        int happinessLevel = sc.nextInt();
        sc.nextLine();

        if (happinessLevel > 5) {
            toBeAdmitted = new VirtualPet(name, 3, 3, 3);
        } else {
            toBeAdmitted = new VirtualPet(name, 6, 6, 6);
        }
        myShelter.admitPet(toBeAdmitted);
    }

    public static void petDeath(VirtualPetShelter myShelter) {

        int count = 0;
        for (int i = 0; i < myShelter.sizeOfShelter(); i++) {
            String name = myShelter.getOnePetWithIndex(i).getName();

            if (myShelter.getOnePetWithIndex(i).getHungerLevel() > 10) {
                System.out.println(name + " died of hunger :(");
                myShelter.adoptPet(myShelter.getOnePetWithIndex(i).getName());
                i--;
                count++;

            } else if (myShelter.getOnePetWithIndex(i).getBoredomLevel() > 10) {
                System.out.println(name + " got too bored and ran away :(");
                myShelter.adoptPet(myShelter.getOnePetWithIndex(i).getName());
                i--;
                count++;

            } else if (myShelter.getOnePetWithIndex(i).getThirstLevel() > 10) {
                System.out.println(name + " died of thirst :(");
                myShelter.adoptPet(myShelter.getOnePetWithIndex(i).getName());
                i--;
                count++;

            }
        }
        if (count >= 1) {
            System.out.println("These are the remaining pets and their stats: ");
            myShelter.showStatusAll();
            System.out.println();
        }
    }

    public static boolean endTheProgram(String userChoice) {

        boolean returnValue = true;
        if (userChoice.equals("e")) {
            returnValue = false;
        }
        return returnValue;
    }

    public static void main(String[] args) {
        System.out.println();

        VirtualPet cat = new VirtualPet("Tom", 3, 4, 5);
        VirtualPet dog = new VirtualPet("Spike", 4, 9, 6);
        VirtualPet mouse = new VirtualPet("Jerry", 9, 2, 1);
        VirtualPet duck = new VirtualPet("Quacker", 5, 5, 5);
        VirtualPetShelter myShelter = new VirtualPetShelter();
        myShelter.admitPet(cat);
        myShelter.admitPet(dog);
        myShelter.admitPet(mouse);
        myShelter.admitPet(duck);

        Scanner sc = new Scanner(System.in);
        String userOptionToInteract = "";
        boolean endValue = endTheProgram(userOptionToInteract);

        System.out.println("----------------------------------------------------------");
        System.out.println("These are the pets currently in shelter and their stats:");
        System.out.println();
        myShelter.showStatusAll();
        System.out.println();

        while (!myShelter.checkIfEmpty() && endValue) {

            System.out.println("Would you like to interact with only one pet or all of them? ");
            System.out.println("                   OR                   ");
            System.out.println("Would you like to admit/adopt a pet?");
            System.out.print("One: One/O/o || For all: All/A/a || Adopt: adopt || Admit: admit: ");
            userOptionToInteract = sc.nextLine();
            userOptionToInteract = userOptionToInteract.toLowerCase();
            endValue = endTheProgram(userOptionToInteract);

            if (!endValue) {
                System.out.println();
                System.out.println("The Program Ended!! GOODBYE!!");

            } else if (!(userOptionToInteract.equals("one") || userOptionToInteract.equals("o") || userOptionToInteract.equals("all")
                    || userOptionToInteract.equals("a") || userOptionToInteract.equals("admit") || userOptionToInteract.equals("adopt"))) {
                System.out.println();
                System.out.println("Wrong Option, Go through the game again please.");
                System.out.println();

            } else {
                if (userOptionToInteract.equals("one") || userOptionToInteract.equals("o")) {
                    playForOnePet(myShelter, sc);
                } else if (userOptionToInteract.equals("all") || userOptionToInteract.equals("a")) {
                    playForAllPet(myShelter, sc);
                } else if (userOptionToInteract.equals("adopt")) {
                    adoptPet(myShelter, sc);
                } else {
                    admitPet(myShelter, sc);
                }
                System.out.println();
                myShelter.tickForAll();
                System.out.println();
                myShelter.showStatusAll();
                System.out.println();
                petDeath(myShelter);
            }


        }
    }
}
