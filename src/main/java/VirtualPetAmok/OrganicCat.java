package VirtualPetAmok;

public class OrganicCat extends Organic implements PlayWithCat{

    public OrganicCat(String name, int happinessLevel, int boredomLevel, int hungerLevel, int thirstLevel, int cageCleanLevel) {
        super(name, happinessLevel, boredomLevel, hungerLevel, thirstLevel, cageCleanLevel);
    }

    @Override
    public void playYarnBall() {
        happinessLevel++;
        boredomLevel--;
        hungerLevel++;
        thirstLevel++;
        cageCleanLevel--;
    }

    @Override
    public void makeNoise() {
        System.out.println("Organic Meow");

    }

}
