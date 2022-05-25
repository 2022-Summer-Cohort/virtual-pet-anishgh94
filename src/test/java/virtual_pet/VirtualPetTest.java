package virtual_pet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VirtualPetTest {

    @Test
    public void shouldReturnHungerLevelWhenFed() {
        VirtualPet underTest = new VirtualPet("Buddy", 5, 3, 2);
        underTest.feedPet(2);
        assertEquals(3, underTest.getHungerLevel());
    }

    @Test
    public void shouldReturnThirstLevelWhenGivenWater() {
        VirtualPet underTest = new VirtualPet("Buddy", 4, 7, 6);
        underTest.drinkWater(4);
        assertEquals(3, underTest.getThirstLevel());
    }

    @Test
    public void shouldReturnBoredomLevelWhenActivityDone() {
        VirtualPet underTest = new VirtualPet("Buddy", 4, 7, 6);
        underTest.doActivity("b");
        assertEquals(5, underTest.getBoredomLevel());
    }
}
