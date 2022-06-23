package VirtualPetAmok;

public class OrganicDog extends Organic implements WalkDog{


    public OrganicDog(String name, int happinessLevel, int boredomLevel, int hungerLevel, int thirstLevel, int cageCleanLevel) {
        super(name, happinessLevel, boredomLevel, hungerLevel, thirstLevel, cageCleanLevel);
    }

    @Override
    public void makeNoise() {
        System.out.println("Organic Bark");
    }


    @Override
    public void goWalking() {
        happinessLevel++;
        boredomLevel--;
        hungerLevel++;
        thirstLevel++;
        cageCleanLevel++;

    }
}
