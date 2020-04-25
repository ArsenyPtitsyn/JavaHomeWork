package lesson5;

import java.util.Random;

public abstract class Animal {
    static final int SWIM_FAIL = 0;
    static final int SWIM_OK = 1;
    static final int SWIM_WTF = -1;

    private String type;
    private String name;
    private float maxRun;
    private float maxSwim;
    private float maxJump;
    private final Random random = new Random();

    Animal(String type, String name, float maxJump, float maxRun, float maxSwim) {
        this.type = type;
        this.name = name;
        this.maxJump = createVariation(maxJump);
        this.maxRun = createVariation(maxRun);
        this.maxSwim = createVariation(maxSwim);
    }

    private float createVariation(float reference) {
        return reference + random.nextFloat() * reference - (reference / 2);
    }

    String getName() {
        return this.name;
    }

    String getType() {
        return this.type;
    }

    float getMaxRun() {
        return this.maxRun;
    }

    float getMaxSwim() {
        return this.maxSwim;
    }

    float getMaxJump() {
        return this.maxJump;
    }

    void trainJumping() {
        maxJump += 0.1f;
    }

    protected boolean run(float distance) {
        return (distance <= maxRun);
    }

    protected int swim(float distance) {
        return (distance <= maxSwim) ? SWIM_OK : SWIM_FAIL;
    }

    protected boolean jump(float height) {
        return (height <= maxJump);
    }
}
