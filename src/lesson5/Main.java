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
            zoo[i].run(400.6f);
            zoo[i].jump(2.1f);
            zoo[i].swim(3.5f);
            System.out.println("---------------------------------------------------");
        }
    }
}
