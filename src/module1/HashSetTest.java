package module1;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest implements SetTest {

    private Set<Integer> testSet;
    private double startTime;
    private double endTime;

    public HashSetTest(int numberOfElements){
        testSet = new HashSet<>();
        for (int i = 0; i < numberOfElements; i++) {
            testSet.add(i);
        }
    }

    @Override
    public double testAdd(int value) {
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            testSet.add(value + i);
        }
        endTime = System.currentTimeMillis();

        return (endTime - startTime) / 100;
    }

    @Override
    public double testRemove(int value) {
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            testSet.remove(value + i);
        }
        endTime = System.currentTimeMillis();

        return (endTime - startTime) / 100;
    }

    @Override
    public double testContains(int value) {
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            testSet.contains(value);
        }
        endTime = System.currentTimeMillis();

        return (endTime - startTime) / 100;
    }

    @Override
    public double testPopulate(int numberOfElements) {
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            populate(numberOfElements);
        }
        endTime = System.currentTimeMillis();

        return (endTime - startTime) / 100;
    }

    private void populate(int numberOfElements) {
        testSet = new HashSet<>();

        for (int i = 0; i < numberOfElements; i++) {
            testSet.add(i);
        }
    }
}
