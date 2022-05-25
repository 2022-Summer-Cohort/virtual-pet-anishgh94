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

    public void feedPet(int n) {
        hungerLevel -= n;
    }

    public void drinkWater(int n) {
        thirstLevel -= n;
    }

    public void showStatus() {
        System.out.print("Stats of " + name);
        System.out.print("!! Hunger Level: " + hungerLevel);
        System.out.print(" || Thirst Level: " + thirstLevel);
        System.out.println(" || Boredom Level: " + boredomLevel);
        System.out.println();
    }

    public void displayOptions() {
        System.out.println("Pick an option to interact with " + name);
        System.out.print("Food: F/f || Water: W/w || Activity: A/a");
        System.out.println(" || Exit: E/e ");
        System.out.println("If you don't want to do anything, press ENTER: ");
    }

    public void doActivity(String str) {
        switch (str) {
            case "a":
                boredomLevel--;
                break;
            case "b":
                boredomLevel -= 2;
                break;
            case "c":
                boredomLevel -= 3;
                break;
        }
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
