
public class TennisGame3 implements TennisGame {

    private int scorePlayer2;
    private int scorePlayer1;
    private String player1Name;
    private String player2Name;
    public final String[] points = {"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public boolean isMatchNormal() {
        return scorePlayer1 < 4 && scorePlayer2 < 4;
    }

    public boolean isDeuce() {
        return scorePlayer1 + scorePlayer2 == 6;
    }

    public boolean isTie() {
        return scorePlayer1 == scorePlayer2;
    }

    public String whoIsWinning() {
        return scorePlayer1 > scorePlayer2 ? player1Name : player2Name;

    }

    public String scoreTieOrWinning() {
        return isTie() ? points[scorePlayer1] + "-All" : points[scorePlayer1] + "-" + points[scorePlayer2];
    }

    public int difScores() {
        return scorePlayer1 - scorePlayer2;
    }

    public String finalScore() {
        String score;
        score = whoIsWinning();
        return (Math.pow(difScores(), 2) == 1) ? "Advantage " + score : "Win for " + score;
    }

    public String getScore() {
        if (isMatchNormal() && !isDeuce()) {
            return scoreTieOrWinning();
        } else if (isTie()) {
            return "Deuce";
        } else {
            return finalScore();
        }
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            this.scorePlayer1 += 1;
        else
            this.scorePlayer2 += 1;

    }

}
