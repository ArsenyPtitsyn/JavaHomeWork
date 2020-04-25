package lesson5;

public class Dog extends Animal{

    public float maxSwimDistance;

    public Dog(String name,
               String color,
               int age,
               float maxJumpHeight,
               float maxRunDistance,
               float maxSwimDistance) {
        super(name, color, age, maxJumpHeight, maxRunDistance);
        this.maxSwimDistance = maxSwimDistance;
    }

    public boolean swim(float distance) {
        if (distance >= 0 && distance <= maxSwimDistance)
            return true;
        else return false;
    }
}
