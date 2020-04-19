package lesson5;

public class Horse extends Animal{

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
    public void jump(float height) {
        if(height > maxJumpHeight)
            System.out.println("Barrier " + height + " meters is too high for " + this.name);
        else if(height <= maxJumpHeight && height >= 0)
            System.out.println(this.name + " jumped over a " + height + " meter high barrier");
        else
            System.out.println("The height can't be negative!");
    }

    @Override
    public void run(float distance) {
        if(distance > maxRunDistance)
            System.out.println("Distance " + distance + " meters is too far for " + this.name);
        else if (distance >= 0 && distance <= maxRunDistance)
            System.out.println(this.name + " ran " + distance + " meters!");
        else
            System.out.println("The distance can't be negative!");
    }

    @Override
    public void swim(float distance) {
        if(distance > maxSwimDistance)
            System.out.println("Distance " + distance + " meters is too far for " + this.name);
        else if(distance >= 0 && distance <= maxSwimDistance)
            System.out.println(this.name + " swum " + distance + " meters!");
        else
            System.out.println("The distance can't be negative!");
    }
}
