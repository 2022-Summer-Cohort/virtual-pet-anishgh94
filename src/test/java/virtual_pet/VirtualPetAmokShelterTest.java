package virtual_pet;

import VirtualPetAmok.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class VirtualPetAmokShelterTest {

    VirtualPetAmokShelter underTest;

    @BeforeEach
    public void initializeValue() {
        underTest = new VirtualPetAmokShelter();
        underTest.admitPet(new OrganicCat("OrganicCat", 5, 5, 5, 5, 5));
        underTest.admitPet(new OrganicDog("OrganicDog", 4, 5, 6, 7, 9));
        underTest.admitPet(new RoboticDog("RoboticDog", 6, 7, 5, 4));
        underTest.admitPet(new RoboticCat("RoboticCat", 3, 5, 7, 6));
    }

    @Test
    public void allPetsHappinessShouldGoUp() {
        underTest.playWithBothTypesOfPets();
        underTest.playWithAllCats();
        underTest.walkAllDogs();

        assertEquals(7, underTest.getOnePetWithIndex(0).getHappinessLevel());
        assertEquals(6, underTest.getOnePetWithIndex(1).getHappinessLevel());
        assertEquals(8, underTest.getOnePetWithIndex(2).getHappinessLevel());
        assertEquals(5, underTest.getOnePetWithIndex(3).getHappinessLevel());

    }

    @Test
    public void onlyRoboticDogsShouldBeAbleToWalk() {
        underTest.walkOnlyRoboticDog();

        assertEquals(7, underTest.getOnePetWithIndex(2).getHappinessLevel());
        assertEquals(6, ((RoboticDog)underTest.getOnePetWithIndex(2)).getOilLevel());
        assertEquals(4, ((RoboticDog)underTest.getOnePetWithIndex(2)).getMaintenanceLevel());
        assertEquals(3, ((RoboticDog)underTest.getOnePetWithIndex(2)).getChargeLevel());
    }

    @Test
    public void bothOrganicAndRoboticCatsShouldPlay() {
        underTest.playWithAllCats();

        //Organic Cats
        assertEquals(6,underTest.getOnePetWithIndex(0).getHappinessLevel());
        assertEquals(4,((OrganicCat)underTest.getOnePetWithIndex(0)).getBoredomLevel());
        assertEquals(6,((OrganicCat)underTest.getOnePetWithIndex(0)).getHungerLevel());
        assertEquals(6,((OrganicCat)underTest.getOnePetWithIndex(0)).getThirstLevel());
        assertEquals(4,((OrganicCat)underTest.getOnePetWithIndex(0)).getCageCleanLevel());

        //Robotic Cats
        assertEquals(4,underTest.getOnePetWithIndex(3).getHappinessLevel());
        assertEquals(4, ((RoboticCat)underTest.getOnePetWithIndex(3)).getOilLevel());
        assertEquals(6, ((RoboticCat)underTest.getOnePetWithIndex(3)).getMaintenanceLevel());
        assertEquals(5, ((RoboticCat)underTest.getOnePetWithIndex(3)).getChargeLevel());
    }
}
