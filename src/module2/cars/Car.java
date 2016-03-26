package module2.cars;

import module2.enums.Transmission;

public abstract class Car {

    protected String model;
    protected Transmission transmissionType;
    protected int maxSpeedKmh;

    public Transmission getTransmissionType() {
        return transmissionType;
    }

    public int getMaxSpeedKmh() {
        return maxSpeedKmh;
    }

    public void setMaxSpeedKmh(int maxSpeedKmh) {
        this.maxSpeedKmh = maxSpeedKmh;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", transmissionType=" + transmissionType +
                ", maxSpeedKmh=" + maxSpeedKmh +
                '}';
    }
}
