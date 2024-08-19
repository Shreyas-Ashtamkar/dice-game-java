package bits.h20240192.java.dicegame;

import java.util.Arrays;

public class GameBoard {
    protected int diceCount;
    protected Dice[] dices;
    protected int winConditionValue;

    public GameBoard(int diceCount) {
        this(diceCount, 6);
    }

    public GameBoard(int diceCount, int diceFaces) {
        this.diceCount = diceCount;
        dices = new Dice[diceCount];
        for(int i = 0; i < diceCount; i++) {
            dices[i] = new Dice(diceFaces);
        }
        winConditionValue = 7;
    }

    public void rollDice(){
        for (Dice d : dices)
            d.roll();
    }

    public int getDiceValueSum(){
        return Arrays.stream(dices).mapToInt(Dice::getFaceValue).sum();
    }

    public boolean checkWin(){
        return getDiceValueSum() == winConditionValue;
    }
}
