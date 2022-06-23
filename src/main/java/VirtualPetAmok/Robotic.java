package VirtualPetAmok;

public abstract class Robotic extends VirtualPet {

    protected int oilLevel;
    protected int maintenanceLevel;
    protected int chargeLevel;


    public Robotic(String name, int happinessLevel, int oilLevel, int maintenanceLevel, int chargeLevel) {
        super(name, happinessLevel);
        this.oilLevel = oilLevel;
        this.maintenanceLevel = maintenanceLevel;
        this.chargeLevel = chargeLevel;
    }

    public int getOilLevel() {
        return oilLevel;
    }

    public int getMaintenanceLevel() {
        return maintenanceLevel;
    }

    public int getChargeLevel() {
        return chargeLevel;
    }

    public void refillOil() {
        oilLevel--;
    }

    public void doMaintenance() {
        maintenanceLevel--;
    }

    public void chargePets() {
        chargeLevel--;
    }

    public void doAll() {
        happinessLevel++;
        oilLevel--;
        maintenanceLevel--;
        chargeLevel--;
    }

    @Override
    public void tick() {
        happinessLevel--;
        oilLevel--;
        maintenanceLevel--;
        chargeLevel--;
    }
}

