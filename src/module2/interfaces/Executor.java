package module2.interfaces;

import java.util.List;

public interface Executor<Car> {

    void addTask(Task task);

    void addTask(Task task, Validator validator);

    void execute();

    List<Car> getValidResults();

    List<Car> getInvalidResults();
}
