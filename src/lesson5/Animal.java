package lesson5;

public abstract class Animal {
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

    protected abstract void jump(float height);

    protected abstract void run(float distance);

    protected abstract void swim(float distance);
}
