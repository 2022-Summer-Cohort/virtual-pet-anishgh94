package VirtualPetAmok;

public abstract class Organic extends VirtualPet {

    protected int boredomLevel;
    protected int hungerLevel;
    protected int thirstLevel;
    protected int cageCleanLevel;

    public Organic(String name, int happinessLevel, int boredomLevel, int hungerLevel, int thirstLevel, int cageCleanLevel) {
        super(name, happinessLevel);
        this.boredomLevel = boredomLevel;
        this.hungerLevel = hungerLevel;
        this.thirstLevel = thirstLevel;
        this.cageCleanLevel = cageCleanLevel;
    }

    public int getBoredomLevel() {
        return boredomLevel;
    }

    public int getHungerLevel() {
        return hungerLevel;
    }

    public int getThirstLevel() {
        return thirstLevel;
    }

    public int getCageCleanLevel() {
        return cageCleanLevel;
    }

    public void feedOnePet() {
        hungerLevel--;
    }

    public void drinkOnePet() {
        thirstLevel--;
    }

    public void playOnePet() {
        boredomLevel--;
    }

    public void cleanOnePetCage() {
        cageCleanLevel++;
        happinessLevel++;
    }

    public void doAll() {
        happinessLevel++;
        hungerLevel--;
        thirstLevel--;
        boredomLevel--;
        cageCleanLevel--;
    }

    @Override
    public void tick() {
        happinessLevel--;
        hungerLevel--;
        thirstLevel--;
        boredomLevel--;
        cageCleanLevel--;
    }
}
