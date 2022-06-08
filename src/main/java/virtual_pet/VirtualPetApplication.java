package virtual_pet;

import java.util.Arrays;
import java.util.Scanner;

public class VirtualPetApplication {

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

    public static void feedOnlyOnePet(VirtualPetShelter myShelter, Scanner sc) {

        String name = returnName(myShelter, sc);
        VirtualPet tempPet = myShelter.getOnePetWithGivenName(name);
        myShelter.feedOneOnly(tempPet);
    }

    public static void waterOnlyOnePet(VirtualPetShelter myShelter, Scanner sc) {

        String name = returnName(myShelter, sc);
        VirtualPet tempPet = myShelter.getOnePetWithGivenName(name);
        myShelter.waterOneOnly(tempPet);
    }

    public static void gameOnlyOnePet(VirtualPetShelter myShelter, Scanner sc) {

        String name = returnName(myShelter, sc);
        VirtualPet tempPet = myShelter.getOnePetWithGivenName(name);
        myShelter.playOneOnly(tempPet);
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
        VirtualPet dog = new VirtualPet("Spike", 4, 5, 6);
        VirtualPet mouse = new VirtualPet("Jerry", 7, 2, 1);
        VirtualPet duck = new VirtualPet("Quacker", 5, 5, 5);
        VirtualPetShelter myShelter = new VirtualPetShelter();
        myShelter.admitPet(cat);
        myShelter.admitPet(dog);
        myShelter.admitPet(mouse);
        myShelter.admitPet(duck);

        Scanner sc = new Scanner(System.in);
        String oneOrAll = "";
        boolean endValue = endTheProgram(oneOrAll);

        System.out.println("----------------------------------------------------------");
        System.out.println("These are the pets currently in shelter and their stats:");
        System.out.println();
        myShelter.showStatusAll();
        System.out.println();

        while (!myShelter.checkIfEmpty() && endValue) {

            System.out.println("Would you like to interact with only one pet or all of them? ");
            System.out.print("For one: One/O/o || For all: All/A/a: ");
            oneOrAll = sc.nextLine();
            oneOrAll = oneOrAll.toLowerCase();
            endValue = endTheProgram(oneOrAll);

            if (endValue == false) {
                System.out.println();
                System.out.println("The Program Ended!! GOODBYE!!");

            } else if (oneOrAll.equals("one") || oneOrAll.equals("o") || oneOrAll.equals("all")
                    || oneOrAll.equals("a")) {
                String userOption = askForOption(sc);
                endValue = endTheProgram(userOption);

                if ((userOption.equals("f") || userOption.equals("feed")) && (oneOrAll.equals("one")
                        || oneOrAll.equals("o"))) {
                    feedOnlyOnePet(myShelter, sc);

                } else if (userOption.equals("f") || userOption.equals("feed")) {
                    myShelter.feedAll();

                } else if ((userOption.equals("w") || userOption.equals("water")) && (oneOrAll.equals("one")
                        || oneOrAll.equals("o"))) {
                    waterOnlyOnePet(myShelter, sc);

                } else if (userOption.equals("w") || userOption.equals("water")) {
                    myShelter.waterAll();

                } else if ((userOption.equals("g") || userOption.equals("games")) && (oneOrAll.equals("one")
                        || oneOrAll.equals("o"))) {
                    gameOnlyOnePet(myShelter, sc);

                } else if (userOption.equals("g") || userOption.equals("games")) {
                    myShelter.playAll();
                } else {
                    System.out.println();
                    System.out.println("1That is not a valid response, please enter valid response.");
                }

            } else {
                System.out.println();
                System.out.println("2That is not a valid response, please enter valid response.");
            }

            System.out.println();
            myShelter.tickForAll();
            System.out.println();
            myShelter.showStatusAll();
            System.out.println();
        }
    }
}



