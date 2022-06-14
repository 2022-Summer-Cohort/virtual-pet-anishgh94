package VirtualPetAmok;

public class RoboticDog extends Robotic implements WalkDog {

    public RoboticDog(String name, int happinessLevel, int oilLevel, int maintenanceLevel, int chargeLevel) {
        super(name, happinessLevel, oilLevel, maintenanceLevel, chargeLevel);
    }

    @Override
    public void makeNoise() {
        System.out.println("Electric Bark");
    }

    @Override
    public void goWalking() {
        happinessLevel++;
        oilLevel--;
        maintenanceLevel--;
        chargeLevel--;
    }
}
