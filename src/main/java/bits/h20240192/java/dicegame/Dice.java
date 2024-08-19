package bits.h20240192.java.dicegame;

import java.util.Random;

public class Dice {
    protected int faceValue;
    protected int faceCount;
    protected static Random diceNumberGenerator = new Random();

    public Dice(int faceCount) {
        this.faceCount = faceCount;
        this.roll();
    }

    public void roll(){
        faceValue = diceNumberGenerator.nextInt(1, faceCount);
    }

    public int getFaceValue() {
        return faceValue;
    }
}
