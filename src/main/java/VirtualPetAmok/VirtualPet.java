package VirtualPetAmok;

public abstract class VirtualPet {

    private String name;
    protected int happinessLevel;

    public VirtualPet(String name, int happinessLevel) {
        this.name = name;
        this.happinessLevel = happinessLevel;
    }

    public String getName() {
        return name;
    }

    public int getHappinessLevel() {
        return happinessLevel;
    }

    public abstract void makeNoise();

    public void tick() {
        happinessLevel--;
    }

}
