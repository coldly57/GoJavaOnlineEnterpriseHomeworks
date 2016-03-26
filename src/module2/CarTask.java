package module2;

import module2.cars.AverageCar;
import module2.cars.Car;
import module2.cars.FastCar;
import module2.cars.SlowCar;
import module2.interfaces.Task;

/**
 * Created by Konstantin A. on 20.03.2016.
 */
public class CarTask implements Task<Car> {

    private Car car;

    public CarTask(Car car) {
        this.car = car;
    }

    @Override
    public void execute() {
        if (car instanceof SlowCar){
            car.setMaxSpeedKmh(150);
        }
        else if (car instanceof AverageCar){
            car.setMaxSpeedKmh(200);
        }
        else if (car instanceof FastCar){
            car.setMaxSpeedKmh(250);
        }
    }

    @Override
    public Car getResult() {
        return car;
    }
}
