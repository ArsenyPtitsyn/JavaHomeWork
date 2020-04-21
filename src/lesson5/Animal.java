package lesson5;

public class Animal {
    protected  final float maxJumpHeight;
    protected  final float maxRunDistance;

    protected final String name;
    protected final String color;
    protected int age;

    public Animal(String name,
                  String color,
                  int age,
                  float maxJumpHeight,
                  float maxRunDistance) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.maxJumpHeight = maxJumpHeight;
        this.maxRunDistance = maxRunDistance;
    }

    protected boolean jump(float height) {
        if(height <= maxJumpHeight && height >= 0)
            return true;
        else return false;
    }

    protected boolean run(float distance) {
        if (distance >= 0 && distance <= maxRunDistance)
            return true;
        else return false;
    }

    protected boolean swim(float distance) {
        return false;
    }
}
