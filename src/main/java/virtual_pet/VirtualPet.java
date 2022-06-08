package virtual_pet;

public class VirtualPet {

    private final String name;
    private int hungerLevel;
    private int thirstLevel;
    private int boredomLevel;

    public VirtualPet(String name, int hungerLevel, int thirstLevel, int boredomLevel) {
        this.name = name;
        this.hungerLevel = hungerLevel;
        this.thirstLevel = thirstLevel;
        this.boredomLevel = boredomLevel;
    }


    public String getName() {
        return name;
    }

    public int getHungerLevel() {
        return hungerLevel;
    }

    public int getThirstLevel() {
        return thirstLevel;
    }

    public int getBoredomLevel() {
        return boredomLevel;
    }

    public void feedPet() {
        hungerLevel--;
    }

    public void drinkWater() {
        thirstLevel--;
    }

    public void doActivity() {
        boredomLevel--;
    }

    public void showStatus() {
        System.out.print(getName());
        System.out.print(" >> Hunger Level: " + getHungerLevel());
        System.out.print(" || Thirst Level: " + getThirstLevel());
        System.out.println(" || Boredom Level: " + getBoredomLevel());
    }

    public void displayOptions() {
        System.out.println("Pick an option to interact with " + name);
        System.out.print("Food: F/f || Water: W/w || Activity: A/a");
        System.out.println(" || Exit: E/e ");
        System.out.println("If you don't want to do anything, press ENTER: ");
    }


    public void tick() {
        hungerLevel++;
        thirstLevel++;
        boredomLevel++;

        if (hungerLevel >= 8) {
            System.out.println("!!!DANGER!!! " + name + " is extremely hungry rn.");
        } else if (thirstLevel >= 8) {
            System.out.println("!!!DANGER!!! " + name + " needs water badly.");
        } else if (boredomLevel >= 8) {
            System.out.println("!!!DANGER!!! " + name + " is very bored rn.");
        }
    }

}
