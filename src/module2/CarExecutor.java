package module2;

import module2.cars.Car;
import module2.interfaces.Executor;
import module2.interfaces.Task;
import module2.interfaces.Validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Konstantin A. on 20.03.2016.
 */
public class CarExecutor implements Executor<Car> {

    private List<Task<? extends Car>> tasksList;
    private Map<Task<? extends Car>, Validator<Car>> tasksMap;
    private List<Car> validResults;
    private List<Car> invalidResults;

    public CarExecutor() {
        this.tasksList = new ArrayList<>();
        this.tasksMap = new HashMap<>();
        validResults = new ArrayList<>();
        invalidResults = new ArrayList<>();
    }

    @Override
    public void addTask(Task task) {
        tasksList.add(task);
    }

    @Override
    public void addTask(Task task, Validator validator) {
        tasksMap.put(task, validator);
    }

    @Override
    public void execute() {
        for (Task<? extends Car> task : tasksList){
            task.execute();
            validResults.add(task.getResult());
        }

        for (Map.Entry<Task<? extends Car>, Validator<Car>> pair : tasksMap.entrySet()){
            Task task = pair.getKey();
            Validator validator = pair.getValue();

            task.execute();
            if (validator.isValid(task.getResult())){
                validResults.add((Car) task.getResult());
            }
            else {
                invalidResults.add((Car) task.getResult());
            }
        }
    }

    @Override
    public List<Car> getValidResults() {
        return this.validResults;
    }

    @Override
    public List<Car> getInvalidResults() {
        return this.invalidResults;
    }
}
