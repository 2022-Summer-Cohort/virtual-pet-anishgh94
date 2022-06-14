package VirtualPetAmok;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class VirtualPetAmokShelterTest {

    VirtualPetAmokShelter underTest;

    @BeforeEach
    public void initializeValue() {
        underTest = new VirtualPetAmokShelter();
        underTest.admitPet(new OrganicCat("a", 5, 5, 5, 5, 5));
        underTest.admitPet(new OrganicCat("b", 5, 5, 5, 5, 5));
    }

}
