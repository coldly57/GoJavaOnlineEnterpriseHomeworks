package module2.cars;

import module2.enums.Transmission;

/**
 * Created by Konstantin A. on 20.03.2016.
 */
public class FastCar extends Car {

    public FastCar(String model, Transmission transmissionType) {
        this.model = model;
        this.transmissionType = transmissionType;
    }
}
