package workshop;

public class Player {
    private final String name;
    private int place = 0;
    private int coins = 0;
    private boolean inPenaltyBox = false;

    public Player(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    public int getPlace() {
        return place;
    }

    public void movePlayer(int roll) {
        place += roll;
        if (place > 11) {
            place -= 12;
        }
    }

    public void addCoin() {
        coins++;
    }

    public int getCoins() {
        return coins;
    }

    public void moveToPenaltyBox() {
        inPenaltyBox = true;
    }

    public boolean isInPenaltyBox() {
        return inPenaltyBox;
    }

    public boolean didPlayerWin() {
        return !(getCoins() == 6);
    }
}
