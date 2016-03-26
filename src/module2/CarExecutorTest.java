package module2;

import module2.cars.AverageCar;
import module2.cars.FastCar;
import module2.cars.SlowCar;
import module2.enums.Transmission;
import module2.interfaces.Executor;
import org.junit.Test;

/**
 * Created by Konstantin A. on 20.03.2016.
 */
public class CarExecutorTest {

    @Test
    public void test(){

        Executor carExecutor = new CarExecutor();

        carExecutor.addTask(new CarTask(new SlowCar("VAZ", Transmission.MT)));
        carExecutor.addTask(new CarTask(new AverageCar("Subaru", Transmission.AT)));
        carExecutor.addTask(new CarTask(new FastCar("Ferrari", Transmission.MT)));

        carExecutor.addTask(new CarTask(new SlowCar("OKA", Transmission.MT)), new CarValidator());
        carExecutor.addTask(new CarTask(new SlowCar("FIAT", Transmission.AT)), new CarValidator());
        carExecutor.addTask(new CarTask(new AverageCar("FORD", Transmission.MT)), new CarValidator());
        carExecutor.addTask(new CarTask(new AverageCar("SUZUKI", Transmission.AT)), new CarValidator());
        carExecutor.addTask(new CarTask(new FastCar("Bugatti", Transmission.MT)), new CarValidator());

        carExecutor.execute();

        System.out.println("Valid results:");
        for (Object car : carExecutor.getValidResults()){
            System.out.println(car.toString());
        }

        System.out.println("Invalid results:");
        for (Object car : carExecutor.getInvalidResults()){
            System.out.println(car.toString());
        }

    }

}