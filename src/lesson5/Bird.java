package lesson5;

public class Bird extends Animal {

    Bird(String name) {
        super("Bird", name, 0.2f, 150f, SWIM_FAIL);
    }

    @Override
    protected int swim(float distance) {
        return Animal.SWIM_FAIL;
    }
}

