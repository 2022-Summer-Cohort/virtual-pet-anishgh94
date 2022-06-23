package virtual_pet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//IGNORE: to update comment
public class VirtualPetShelterTest {

    VirtualPetShelter underTest;
    @BeforeEach
    public void initializeValue(){
        underTest = new VirtualPetShelter();
        underTest.admitPet(new VirtualPet("a", 6, 4, 2));
        underTest.admitPet(new VirtualPet("b", 5, 3, 8));
        underTest.admitPet(new VirtualPet("c", 4, 5, 5));
        underTest.admitPet(new VirtualPet("d", 7, 6, 1));

    }

    @Test
    public void allPetShouldBeFed(){
        underTest.feedAll();
        assertEquals(5,underTest.getOnePetWithIndex(0).getHungerLevel());
        assertEquals(4,underTest.getOnePetWithIndex(1).getHungerLevel());
        assertEquals(3,underTest.getOnePetWithIndex(2).getHungerLevel());
        assertEquals(6,underTest.getOnePetWithIndex(3).getHungerLevel());
    }

    @Test
    public void allPetShouldDrink() {
        underTest.waterAll();
        assertEquals(3, underTest.getOnePetWithIndex(0).getThirstLevel());
        assertEquals(2, underTest.getOnePetWithIndex(1).getThirstLevel());
        assertEquals(4, underTest.getOnePetWithIndex(2).getThirstLevel());
        assertEquals(5, underTest.getOnePetWithIndex(3).getThirstLevel());
    }

    @Test
    public void allPetShouldDoActivity() {
        underTest.playAll();
        assertEquals(1, underTest.getOnePetWithIndex(0).getBoredomLevel());
        assertEquals(7, underTest.getOnePetWithIndex(1).getBoredomLevel());
        assertEquals(4, underTest.getOnePetWithIndex(2).getBoredomLevel());
        assertEquals(0, underTest.getOnePetWithIndex(3).getBoredomLevel());
    }

    @Test
    public void onlyOnePetShouldBeFed(){
        underTest.feedOneOnly(underTest.getOnePetWithIndex(0));
        assertEquals(5,underTest.getOnePetWithIndex(0).getHungerLevel());
        assertEquals(5,underTest.getOnePetWithIndex(1).getHungerLevel());
        assertEquals(4,underTest.getOnePetWithIndex(2).getHungerLevel());
        assertEquals(7,underTest.getOnePetWithIndex(3).getHungerLevel());
    }

    @Test
    public void onlyOnePetShouldBeGivenWater() {
        underTest.waterOneOnly(underTest.getOnePetWithIndex(1));
        assertEquals(4, underTest.getOnePetWithIndex(0).getThirstLevel());
        assertEquals(2, underTest.getOnePetWithIndex(1).getThirstLevel());
        assertEquals(5, underTest.getOnePetWithIndex(2).getThirstLevel());
        assertEquals(6, underTest.getOnePetWithIndex(3).getThirstLevel());
    }

    @Test
    public void onlyOnePetShouldDoAnActivity() {
        underTest.playOneOnly(underTest.getOnePetWithIndex(2));
        assertEquals(2, underTest.getOnePetWithIndex(0).getBoredomLevel());
        assertEquals(8, underTest.getOnePetWithIndex(1).getBoredomLevel());
        assertEquals(4, underTest.getOnePetWithIndex(2).getBoredomLevel());
        assertEquals(1, underTest.getOnePetWithIndex(3).getBoredomLevel());
    }

    @Test
    public void onePetShouldBeAdmittedIntoTheShelter() {
        VirtualPet toBeAddedPet = new VirtualPet("e", 6, 4, 2);
        underTest.admitPet(toBeAddedPet);
        assertTrue(underTest.checkContains(toBeAddedPet));
    }

    @Test
    public void onePetShouldBeRemovedFromShelterWhenAdopted() {
        VirtualPet petToRemove = underTest.getOnePetWithIndex(2);
        underTest.adoptPet(petToRemove.getName());
        assertFalse(underTest.checkContains(petToRemove));
    }

    @Test
    public void allLevelsShouldTickOnce() {
        underTest.tickForAll();

        assertEquals(7, underTest.getOnePetWithIndex(0).getHungerLevel());
        assertEquals(6, underTest.getOnePetWithIndex(1).getHungerLevel());
        assertEquals(5, underTest.getOnePetWithIndex(2).getHungerLevel());
        assertEquals(8, underTest.getOnePetWithIndex(3).getHungerLevel());

        assertEquals(5, underTest.getOnePetWithIndex(0).getThirstLevel());
        assertEquals(4, underTest.getOnePetWithIndex(1).getThirstLevel());
        assertEquals(6, underTest.getOnePetWithIndex(2).getThirstLevel());
        assertEquals(7, underTest.getOnePetWithIndex(3).getThirstLevel());

        assertEquals(3, underTest.getOnePetWithIndex(0).getBoredomLevel());
        assertEquals(9, underTest.getOnePetWithIndex(1).getBoredomLevel());
        assertEquals(6, underTest.getOnePetWithIndex(2).getBoredomLevel());
        assertEquals(2, underTest.getOnePetWithIndex(3).getBoredomLevel());
    }
}
