package lesson5;

public class Horse extends Animal {

    public float maxSwimDistance;

    public Horse(String name,
                 String color,
                 int age,
                 float maxJumpHeight,
                 float maxRunDistance,
                 float maxSwimDistance) {
        super(name, color, age, maxJumpHeight, maxRunDistance);
        this.maxSwimDistance = maxSwimDistance;
    }

    @Override
    public boolean swim(float distance) {
        if (distance >= 0 && distance <= maxSwimDistance)
            return true;
        else return false;
    }
}
