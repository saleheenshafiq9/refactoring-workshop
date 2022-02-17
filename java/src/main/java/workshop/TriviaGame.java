package workshop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;

public class TriviaGame {

    private static final int NB_CELLS = 12;
    private static final Category[] CATEGORIES = new Category[] { Category.POP, Category.SCIENCE, Category.SPORTS,
            Category.ROCK };
    private List<String> players = new ArrayList<>();
    int[] places = new int[6];
    int[] purses = new int[6];
    boolean[] inPenaltyBox = new boolean[6];
    private final Map<Integer, Category> categoriesByPosition = new HashMap<>(NB_CELLS);
    private final Map<Category, Deque<String>> questionsByCategory = new HashMap<>();
    private List<String> popQuestions = new LinkedList<>();
    private List<String> scienceQuestions = new LinkedList<>();
    private List<String> sportsQuestions = new LinkedList<>();
    private List<String> rockQuestions = new LinkedList<>();

    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;

    public TriviaGame() {
        for (Category category : CATEGORIES) {
            questionsByCategory.put(category, new LinkedList<>());
        }
        for (int i = 0; i < 50; i++) {
            for (Category category : CATEGORIES) {
                questionsByCategory.get(category).addLast(category.toString() + " Question " + i);
            }
        }

        for (int i = 0; i < NB_CELLS; i++) {
            categoriesByPosition.put(i, CATEGORIES[i % CATEGORIES.length]);
        }
    }

    public boolean isPlayable() {
        return (howManyPlayers() >= 2);
    }

    public boolean add(String playerName) {

        players.add(playerName);
        places[howManyPlayers()] = 0;
        purses[howManyPlayers()] = 0;
        getInPenaltyBox()[howManyPlayers()] = false;

        announce(playerName + " was added");
        announce("T, int[] ishey are player number " + players.size());
        return true;
    }

    public int howManyPlayers() {
        return players.size();
    }

    public void roll(int roll) {
        announce(players.get(currentPlayer) + " is the current player");
        announce("They have rolled a " + roll);

        findCategory(roll);

    }

    private void findCategory(int roll) {
        if (getInPenaltyBox()[currentPlayer]) {
            if (roll % 2 != 0) {
                isGettingOutOfPenaltyBox = true;

                announce(players.get(currentPlayer) + " is getting out of the penalty box");
                places[currentPlayer] = places[currentPlayer] + roll;
                if (places[currentPlayer] > 11)
                    places[currentPlayer] = places[currentPlayer] - 12;

                announce(players.get(currentPlayer)
                        + "'s new location is "
                        + places[currentPlayer]);
                announce("The category is " + currentCategory());
                askQuestion();
            } else {
                announce(players.get(currentPlayer) + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
            }

        } else {

            places[currentPlayer] = places[currentPlayer] + roll;
            if (places[currentPlayer] > 11)
                places[currentPlayer] = places[currentPlayer] - 12;

            announce(players.get(currentPlayer)
                    + "'s new location is "
                    + places[currentPlayer]);
            announce("The category is " + currentCategory());
            askQuestion();
        }
    }

    private boolean[] getInPenaltyBox() {
        return inPenaltyBox;
    }

    private void askQuestion() {
        announce(questionsByCategory.get(currentCategory()).removeFirst());
    }

    private Category currentCategory() {
        return categoriesByPosition.get(currentPosition());
    }

    private Object currentPosition() {
        return null;
    }

    public boolean wasCorrectlyAnswered() {
        if (getInPenaltyBox()[currentPlayer]) {
            if (isGettingOutOfPenaltyBox) {
                announce("Answer was correct!!!!");
                purses[currentPlayer]++;
                announce(players.get(currentPlayer)
                        + " now has "
                        + purses[currentPlayer]
                        + " Gold Coins.");

                boolean winner = didPlayerWin();
                currentPlayer++;
                if (currentPlayer == players.size())
                    currentPlayer = 0;

                return winner;
            } else {
                currentPlayer++;
                if (currentPlayer == players.size())
                    currentPlayer = 0;
                return true;
            }

        } else {

            announce("Answer was correct!!!!");
            purses[currentPlayer]++;
            announce(players.get(currentPlayer)
                    + " now has "
                    + purses[currentPlayer]
                    + " Gold Coins.");

            boolean winner = didPlayerWin();
            currentPlayer++;
            if (currentPlayer == players.size())
                currentPlayer = 0;

            return winner;
        }
    }

    public boolean wrongAnswer() {
        announce("Question was incorrectly answered");
        announce(players.get(currentPlayer) + " was sent to the penalty box");
        getInPenaltyBox()[currentPlayer] = true;

        currentPlayer++;
        if (currentPlayer == players.size())
            currentPlayer = 0;
        return true;
    }

    private boolean didPlayerWin() {
        return !(purses[currentPlayer] == 6);
    }

    protected void announce(Object message) {
        System.out.println(message);
    }

    public List<String> getPopQuestions() {
        return popQuestions;
    }

    public void setPopQuestions(List<String> popQuestions) {
        this.popQuestions = popQuestions;
    }

    public List<String> getScienceQuestions() {
        return scienceQuestions;
    }

    public void setScienceQuestions(List<String> scienceQuestions) {
        this.scienceQuestions = scienceQuestions;
    }

    public List<String> getSportsQuestions() {
        return sportsQuestions;
    }

    public void setSportsQuestions(List<String> sportsQuestions) {
        this.sportsQuestions = sportsQuestions;
    }

    public List<String> getRockQuestions() {
        return rockQuestions;
    }

    public void setRockQuestions(List<String> rockQuestions) {
        this.rockQuestions = rockQuestions;
    }
}