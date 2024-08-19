package bits.h20240192.java.dicegame;

public class GameBoard {
    protected int diceCount;
    protected Dice[] dices;

    public GameBoard(int diceCount) {
        this(diceCount, 6);
    }

    public GameBoard(int diceCount, int diceFaces) {
        this.diceCount = diceCount;
        dices = new Dice[diceCount];
        for(int i = 0; i < diceCount; i++) {
            dices[i] = new Dice(diceFaces);
        }
    }

    public void rollDice(){
        for (Dice d : dices)
            d.roll();
    }

    public int getDiceValueSum(){
        int sum = 0;
        for(Dice d : dices)
            sum += d.getFaceValue();
        return sum;
    }

    public boolean checkWin(){
        return getDiceValueSum() == 7;
    }
}
