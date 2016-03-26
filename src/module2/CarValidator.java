package module2;

import module2.cars.Car;
import module2.enums.Transmission;
import module2.interfaces.Validator;

/**
 * Created by Konstantin A. on 20.03.2016.
 */
public class CarValidator implements Validator<Car> {

    @Override
    public boolean isValid(Car car) {

        return (car.getMaxSpeedKmh() >= 200 && car.getTransmissionType() == Transmission.AT);
    }
}
