package lesson5;

public class Main {
    public static void main(String[] args) {
        Cat с = new Cat("Murzik", "Grey", 5, 2.3f, 313.4f);
        Dog d1 = new Dog("Biggie", "speckled", 3, 1.1f, 1235.3f, 134.3f);
        Horse h = new Horse("Savras", "piebald", 4, 2.9f, 5137.8f, 357.4f);
        Bird b = new Bird("Kesha", "blue", 1, 0.3f, 23.5f);
        Dog d2 = new Dog("Sharik", "brown", 2, 0.5f, 327.4f, 1345.3f);
        Animal[] zoo = {с, d1, h, b, d2};
        for(int i = 0; i < zoo.length; i++) {
            runReaction(zoo[i], 407.3f);
            jumpReaction(zoo[i], 2.1f);
            swimReaction(zoo[i], 3.5f);
            System.out.println("---------------------------------------------------");
        }
    }

    private static void runReaction(Animal a, float x) {
        if(a.run(x) == true)
            System.out.println(a.name + " ran " + x + " meters!");
        else
            System.out.println("Too far! " + a.name + " can't run " + x + "meters.");
    }

    private static void jumpReaction(Animal a, float x) {
        if(a.jump(x) == true)
            System.out.println(a.name + " jumped on " + x + " meters!");
        else
            System.out.println("Too high! " + a.name + " can't jump on " + x + " meters.");
    }

    private static void swimReaction(Animal a, float x) {
        if(a.swim(x) == true)
            System.out.println(a.name + " swum " + x + " meters!");
        else
            System.out.println("Too far! " + a.name + " can't swim " + x + " meters.");
    }
}
