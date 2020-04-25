package lesson5;

public class Bird extends Animal{

    Bird(String name) {
        super("Bird", name, 0.2f, 100f, 0f);
    }

    @Override
    protected int swim(float distance) {
        return Animal.SWIM_FAIL;
    }
}
