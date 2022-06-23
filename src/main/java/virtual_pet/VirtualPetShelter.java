package virtual_pet;

import java.util.ArrayList;

//IGNORE: to update comment
public class VirtualPetShelter {

    private ArrayList<VirtualPet> petShelter;

    public VirtualPetShelter() {
        this.petShelter = new ArrayList<>();
    }

    public String[] listOfNames() {
        String[] temp = new String[petShelter.size()];
        for (int i = 0; i < petShelter.size(); i++) {
            temp[i] = petShelter.get(i).getName();
        }
        return temp;
    }

    public int sizeOfShelter() {
        return petShelter.size();
    }

    public boolean checkIfEmpty() {
        return petShelter.isEmpty();
    }

    public void admitPet(VirtualPet pet) {
        petShelter.add(pet);
    }

    public boolean checkContains(VirtualPet pet) {
        if (petShelter.contains(pet)) {
            return true;
        }
        return false;
    }

    public void adoptPet(String nameOfPet) {
        for (int i = 0; i < petShelter.size(); i++) {
            if (petShelter.get(i).getName().equals(nameOfPet)) {
                petShelter.remove(i);
                i = petShelter.size() + 1;
            }
        }
    }

    public VirtualPet getOnePetWithIndex(int n) {
        return petShelter.get(n);
    }

    public VirtualPet getOnePetWithGivenName(String nameOfPet) {
        int index = 0;
        for (int i = 0; i < petShelter.size(); i++) {
            if (petShelter.get(i).getName().equalsIgnoreCase(nameOfPet)) {
                index = i;
                break;
            }
        }
        return getOnePetWithIndex(index);
    }

    public void showStatusAll() {
        for (VirtualPet tempPet : petShelter) {
            tempPet.showStatus();
        }
    }

    public void feedAll() {
        for (VirtualPet tempPet : petShelter) {
            tempPet.feedPet();
        }
    }

    public void waterAll() {
        for (VirtualPet tempPet : petShelter) {
            tempPet.drinkWater();
        }
    }

    public void playAll() {
        for (VirtualPet tempPet : petShelter) {
            tempPet.doActivity();
        }
    }

    public void feedOneOnly(VirtualPet pet) {
        pet.feedPet();
    }

    public void waterOneOnly(VirtualPet pet) {
        pet.drinkWater();
    }

    public void playOneOnly(VirtualPet pet) {
        pet.doActivity();
    }

    public void tickForAll() {
        for (VirtualPet tempPet : petShelter) {
            tempPet.tick();
        }
    }

}
