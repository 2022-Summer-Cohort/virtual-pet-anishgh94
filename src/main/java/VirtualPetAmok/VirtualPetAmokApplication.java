package VirtualPetAmok;


import java.util.Scanner;

public class VirtualPetAmokApplication {


    public static void main(String[] args) {

        VirtualPet rDog = new RoboticDog("a", 10, 10, 10, 10);
        VirtualPet oDog = new OrganicDog("OrgDog", 10, 10, 10, 10, 10);
        VirtualPet rCat = new RoboticCat("sdf", 10, 10, 10, 10);
        VirtualPet oCat = new OrganicCat("OrgCat", 10, 10, 10, 10, 10);
        VirtualPetAmokShelter myAmokShelter = new VirtualPetAmokShelter();

        myAmokShelter.admitPet(rDog);
        myAmokShelter.admitPet(rCat);
        myAmokShelter.admitPet(oDog);
        myAmokShelter.admitPet(oCat);

        Scanner in = new Scanner(System.in);
        boolean endApplication = false;

        System.out.println("----------------------------------------------------------");
        System.out.println("These are the pets currently in shelter and their stats:");
        System.out.println();
        myAmokShelter.showStatusOfAllPets();
        System.out.println();

        int counter = 1;
        while (!myAmokShelter.checkIfEmpty() && !endApplication) {
            System.out.println("Choose an option to interact with shelter and its contents: ");
            System.out.println("End the application: 0");
            System.out.println("Admit a pet: 1");
            System.out.println("Adopt a pet: 2");
            System.out.println("Interact with all Organic Pets: 3");
            System.out.println("Interact with all Robotic Pets: 4");
            System.out.println("Interact with both types of pets: 5");
            System.out.println("Interact with a single pet or one type of pet: 6");
            int userChoice = in.nextInt();
            in.nextLine();

            if (userChoice == 0) {
                endApplication = true;

            } else if (userChoice == 1) {
                System.out.println("Which type of pet is it? Organic Dog: 1 Organic Cat: 2" +
                        " Robotic Dog: 3 Robotic Cat: 4");
                int petChoice = in.nextInt();
                in.nextLine();
                System.out.println("What is the name of the pet? ");
                String petName = in.nextLine();
                VirtualPet tempPet;
                if (petChoice == 1) {
                    tempPet = new OrganicDog(petName, 10, 10, 10, 10, 10);
                } else if (petChoice == 2) {
                    tempPet = new OrganicCat(petName, 10, 10, 10, 10, 10);
                } else if (petChoice == 3) {
                    tempPet = new RoboticDog(petName, 10, 10, 10, 10);
                } else {
                    tempPet = new RoboticCat(petName, 10, 10, 10, 10);
                }
                myAmokShelter.admitPet(tempPet);

            } else if (userChoice == 2) {
                System.out.println("What is the name of the pet you want to adopt? ");
                String petToAdopt = in.nextLine();
                petToAdopt = petToAdopt.toLowerCase();
                myAmokShelter.getOnePetWithGivenName(petToAdopt).makeNoise();
                myAmokShelter.adoptPet(petToAdopt);
                System.out.println(petToAdopt + " has been adopted. Thank You");


            } else if (userChoice == 3) {
                System.out.println("What would you like to do with all organic pets? ");
                System.out.print("Feed: 1 || Drink: 2 || Game: 3 || Clean: 4 || DO All: 5");
                int choice = in.nextInt();
                if (choice == 1) {
                    myAmokShelter.feedAllOrganicPets();
                } else if (choice == 2) {
                    myAmokShelter.drinkAllOrganicPets();
                } else if (choice == 3) {
                    myAmokShelter.gameAllOrganicPets();
                } else if (choice == 4) {
                    myAmokShelter.cleanAllOrganicPets();
                } else {
                    myAmokShelter.doAllActivityOrganicPets();
                }

            } else if (userChoice == 4) {
                System.out.println("What would you like to do with all robotic pets? ");
                System.out.print("Oil: 1 || Maintenance: 2 || Charge: 3 || DO ALL: 4");
                int choice = in.nextInt();
                if (choice == 1) {
                    myAmokShelter.oilAllRoboticPets();
                } else if (choice == 2) {
                    myAmokShelter.maintenanceAllRoboticPets();
                } else if (choice == 3) {
                    myAmokShelter.chargeAllRoboticPets();
                } else {
                    myAmokShelter.doAllActivityRoboticPets();
                }

            } else if (userChoice == 5) {
                myAmokShelter.playWithBothTypesOfPets();
            } else {
                System.out.println("All Dogs: 1 || All Cats: 2 || Organic Dog: 3 || Robotic Dog: 4 || " +
                        "Organic Cat: 5 || Robotic Cat: 6");
                int singleChoice = in.nextInt();
                in.nextLine();
                if (singleChoice == 1) {
                    System.out.println("Walking all dogs");
                    myAmokShelter.walkAllDogs();
                } else if (singleChoice == 2) {
                    System.out.println("Playing with all cats");
                    myAmokShelter.playWithAllCats();
                } else if (singleChoice == 3) {
                    System.out.println("Walking only Organic Dog");
                    myAmokShelter.walkOnlyOrganicDog();
                } else if (singleChoice == 4) {
                    System.out.println("Walking only Robotic Dog");
                    myAmokShelter.walkOnlyRoboticDog();
                } else if (singleChoice == 5) {
                    System.out.println("Playing with only Organic Cat");
                    myAmokShelter.playWithOnlyOrganicCat();
                } else {
                    System.out.println("Playing with only Robotic Cat");
                    myAmokShelter.playWithOnlyRoboticCat();
                }


            }
            if (counter % 3 == 0) {
                myAmokShelter.tickAllHappiness();
            }
            if (counter % 2 == 0) {
                myAmokShelter.tickForAll();
            }

            System.out.println();
            myAmokShelter.showStatusOfAllPets();
            System.out.println();

            counter++;
        }
        System.out.println("Bye");

    }
}