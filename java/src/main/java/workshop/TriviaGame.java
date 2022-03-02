package workshop;

import java.util.ArrayList;
import java.util.List;

public class TriviaGame {
    private final List<Player> players = new ArrayList<>();
    private final questions questions = new questions();

    private int currentPlayer = 0;
    private boolean isGettingOutOfPenaltyBox;

    public TriviaGame() {

    }

    public void add(String playerName) {
        players.add(new Player(playerName));
        announce(playerName + " was added");
        announce("They are player number " + players.size());
    }

    public void roll(int roll) {
        announce(currentPlayer().name() + " is the current player");
        announce("They have rolled a " + roll);

        if (currentPlayer().isInPenaltyBox()) {
            if (roll % 2 != 0) {
                isGettingOutOfPenaltyBox = true;

                announce(currentPlayer() + " is getting out of the penalty box");
                currentPlayer().movePlayer(roll);

                announce(currentPlayer().name()
                        + "'s new location is "
                        + currentPlayer().getPlace());
                announce("The category is " + questions.currentCategory(currentPlayer().getPlace()).getLabel());
                askQuestion();
            } else {
                announce(currentPlayer() + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
            }

        } else {
            currentPlayer().movePlayer(roll);

            announce(currentPlayer().name()
                    + "'s new location is "
                    + currentPlayer().getPlace());
            announce("The category is " + questions.currentCategory(currentPlayer().getPlace()).getLabel());
            askQuestion();
        }
    }

    private void askQuestion() {
        announce(questions.extractNextQuestion(currentPlayer().getPlace()));
    }

    private Player currentPlayer() {
        return players.get(currentPlayer);
    }

    public void wasCorrectlyAnswered() {
        if (currentPlayer().isInPenaltyBox()) {
            if (isGettingOutOfPenaltyBox) {
                announce("Answer was correct!!!!");
                currentPlayer().addCoin();
                announce(currentPlayer().name() + " now has " + currentPlayer().getCoins() + " Gold Coins.");
                checkWinner();
            }
            else {
                moveToNextPlayer();
            }
        }
        else {
            announce("Answer was correct!!!!");
            currentPlayer().addCoin();
            announce(currentPlayer().name() + " now has " + currentPlayer().getCoins() + " Gold Coins.");

            checkWinner();
        }
    }

    private void checkWinner() {
        currentPlayer().didPlayerWin();
        moveToNextPlayer();
    }

    private void moveToNextPlayer() {
        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;
    }

    public void wrongAnswer() {
        announce("Question was incorrectly answered");
        announce(currentPlayer().name() + " was sent to the penalty box");
        currentPlayer().moveToPenaltyBox();

        moveToNextPlayer();
    }

    protected void announce(Object message) {
        System.out.println(message);
    }
}