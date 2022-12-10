package View;

public interface Player {
    public int getScore();

    public int getID();

    public String getHandString();

    public ArrayList<Letter> getHandLetters();

    public void removeFromHand(String letterToRemove);

    public void addToHand(Letter letterToAdd);

    public void addToScore(int scoreToAdd);

    public void setScore(int score);

    public void setHand(ArrayList<Letter> hand);

}
