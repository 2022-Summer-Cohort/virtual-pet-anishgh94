package VirtualPetAmok;

import java.util.ArrayList;

public class VirtualPetAmokShelter {
    private ArrayList<VirtualPet> amokPetShelter;

    public VirtualPetAmokShelter() {
        this.amokPetShelter = new ArrayList<>();
    }

    public VirtualPet getOnePetWithIndex(int n) {
//        VirtualPet temp = null;
//
//        if (amokPetShelter.get(n) instanceof RoboticDog) {
//            temp = new RoboticDog("asdf",4,4,4,4);
//        }

        return amokPetShelter.get(n);
    }

    public VirtualPet getOnePetWithGivenName(String name) {
        int index = 0;
        for (int i = 0; i < amokPetShelter.size(); i++) {
            if (amokPetShelter.get(i).getName().equalsIgnoreCase(name)) {
                index = i;
                break;
            }
        }
        return getOnePetWithIndex(index);
    }

    public int findSize(){
        return amokPetShelter.size();
    }
    public boolean containsInShelter(String name) {
        for (VirtualPet temp : amokPetShelter) {
            if (temp.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void admitPet(VirtualPet pet) {
        amokPetShelter.add(pet);
    }

    public void adoptPet(String name) {
        amokPetShelter.remove(getOnePetWithGivenName(name));
    }


    public void showStatusOfAllPets() {
        for (VirtualPet temp : amokPetShelter) {
            if (temp instanceof Robotic) {
                System.out.println(temp.getName() + " >> Happiness: " + temp.getHappinessLevel() + " || Charge: " + ((Robotic) temp).getChargeLevel()
                        + " || Maintenance: " + ((Robotic) temp).getMaintenanceLevel() + " || Oil: " + ((Robotic) temp).getOilLevel());
            } else if (temp instanceof Organic) {
                System.out.println(temp.getName() + " >> Happiness:  " + temp.getHappinessLevel() + " || Boredom: " + ((Organic) temp).getBoredomLevel() +
                        " || Hunger: " + ((Organic) temp).getHungerLevel() + " || Thirst: " + ((Organic) temp).getThirstLevel() + " || CageSoil: " + ((Organic) temp).getCageCleanLevel());
            }
        }
    }

    public boolean checkIfEmpty() {
        return amokPetShelter.isEmpty();
    }

    public void feedAllOrganicPets() {
        for (VirtualPet temp : amokPetShelter) {
            if (temp instanceof Organic) {
                ((Organic) temp).feedOnePet();
            }
        }
    }

    public void drinkAllOrganicPets() {
        for (VirtualPet temp : amokPetShelter) {
            if (temp instanceof Organic) {
                ((Organic) temp).drinkOnePet();
            }
        }
    }

    public void gameAllOrganicPets() {
        for (VirtualPet temp : amokPetShelter) {
            if (temp instanceof Organic) {
                ((Organic) temp).playOnePet();
            }
        }
    }

    public void cleanAllOrganicPets() {
        for (VirtualPet temp : amokPetShelter) {
            if (temp instanceof Organic) {
                ((Organic) temp).cleanOnePetCage();
            }
        }
    }

    public void doAllActivityOrganicPets() {
        for (VirtualPet temp : amokPetShelter) {
            if (temp instanceof Organic) {
                ((Organic) temp).doAll();
            }
        }
    }

    public void oilAllRoboticPets() {
        for (VirtualPet temp : amokPetShelter) {
            if (temp instanceof Robotic) {
                ((Robotic) temp).refillOil();
            }
        }
    }

    public void maintenanceAllRoboticPets() {
        for (VirtualPet temp : amokPetShelter) {
            if (temp instanceof Robotic) {
                ((Robotic) temp).doMaintenance();
            }
        }
    }

    public void chargeAllRoboticPets() {
        for (VirtualPet temp : amokPetShelter) {
            if (temp instanceof Robotic) {
                ((Robotic) temp).chargePets();
            }
        }
    }

    public void doAllActivityRoboticPets() {
        for (VirtualPet temp : amokPetShelter) {
            if (temp instanceof Robotic) {
                ((Robotic) temp).doAll();
            }
        }
    }

    public void playWithBothTypesOfPets() {
        for (VirtualPet temp : amokPetShelter) {
            if (temp instanceof Robotic) {
                ((Robotic) temp).doAll();
            }
            if (temp instanceof Organic) {
                ((Organic) temp).doAll();
            }
        }
    }

    public void walkAllDogs() {
        for (VirtualPet temp : amokPetShelter) {
            if (temp instanceof OrganicDog || temp instanceof RoboticDog) {
                ((WalkDog) temp).goWalking();
            }
        }
    }

    public void playWithAllCats() {
        for (VirtualPet temp : amokPetShelter) {
            if (temp instanceof OrganicCat || temp instanceof RoboticCat) {
                ((PlayWithCat) temp).playYarnBall();
            }
        }
    }

    public void walkOnlyOrganicDog() {
        for (VirtualPet temp : amokPetShelter){
            if(temp instanceof OrganicDog) {
                ((WalkDog) temp).goWalking();
            }
        }
    }

    public void walkOnlyRoboticDog() {
        for (VirtualPet temp : amokPetShelter){
            if(temp instanceof RoboticDog) {
                ((WalkDog) temp).goWalking();
            }
        }
    }

    public void playWithOnlyOrganicCat() {
        for(VirtualPet temp:amokPetShelter){
            if(temp instanceof OrganicCat) {
                ((PlayWithCat)temp).playYarnBall();
            }
        }
    }

    public void playWithOnlyRoboticCat() {
        for(VirtualPet temp:amokPetShelter){
            if(temp instanceof RoboticCat) {
                ((PlayWithCat)temp).playYarnBall();
            }
        }
    }

    public void tickAllHappiness() {
        for (VirtualPet temp : amokPetShelter) {
            temp.tick();
        }
    }

    public void tickForAll() {
        for (VirtualPet temp : amokPetShelter) {
            temp.tick();
        }
    }
}
