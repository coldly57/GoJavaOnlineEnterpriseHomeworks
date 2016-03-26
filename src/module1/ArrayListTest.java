package module1;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ArrayListTest implements ListTest {

    private List<Integer> testList;
    double startTime;
    double endTime;

    public ArrayListTest(int numberOfElements) {
        testList = new ArrayList<>();
        for (int i = 0; i < numberOfElements; i++) {
            testList.add(i);
        }
    }

    @Override
    public double testAdd(int index) {
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            testList.add(index, i);
        }
        endTime = System.currentTimeMillis();

        return (endTime - startTime) / 100;
    }

    @Override
    public double testGet(int index) {
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            testList.get(index);
        }
        endTime = System.currentTimeMillis();

        return (endTime - startTime) / 100;
    }

    @Override
    public double testRemove(int index) {
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            testList.remove(index);
        }
        endTime = System.currentTimeMillis();

        return (endTime - startTime) / 100;
    }

    @Override
    public double testContains(int value) {
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            testList.contains(value);
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
        testList = new ArrayList<>();

        for (int i = 0; i < numberOfElements; i++) {
            testList.add(i);
        }
    }

    @Override
    public double testIteratorAdd() {
        ListIterator iterator = testList.listIterator();

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            while (iterator.hasNext()) {
                if (iterator.next().equals(i)) {
                    iterator.add(i + 10);
                }
            }
        }
        endTime = System.currentTimeMillis();

        return (endTime - startTime) / 100;
    }

    @Override
    public double testIteratorRemove() {
        ListIterator iterator = testList.listIterator();

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            while (iterator.hasNext()) {
                if (iterator.next().equals(i)) {
                    iterator.remove();
                }
            }
        }



        endTime = System.currentTimeMillis();

        return (endTime - startTime) / 100;
    }
}
