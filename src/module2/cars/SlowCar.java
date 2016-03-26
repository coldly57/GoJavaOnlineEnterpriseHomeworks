package module2.cars;

import module2.enums.Transmission;

/**
 * Created by Konstantin A. on 20.03.2016.
 */
public class SlowCar extends Car {

    public SlowCar(String model, Transmission transmissionType) {
        this.model = model;
        this.transmissionType = transmissionType;
    }
}
