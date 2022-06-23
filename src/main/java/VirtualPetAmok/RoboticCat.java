package VirtualPetAmok;

public class RoboticCat extends Robotic implements PlayWithCat{

    public RoboticCat(String name, int happinessLevel, int oilLevel, int maintenanceLevel, int chargeLevel) {
        super(name, happinessLevel, oilLevel, maintenanceLevel, chargeLevel);
    }

    @Override
    public void playYarnBall() {
        happinessLevel++;
        oilLevel--;
        maintenanceLevel--;
        chargeLevel--;
    }

    @Override
    public void makeNoise() {
        System.out.println("Electric Meow");

    }
}
