public class TennisGame2 implements TennisGame {
    public int scorePlayer1 = 0;
    public int scorePlayer2 = 0;
    public final String[] points = {"Love", "Fifteen", "Thirty", "Forty"};

    public String resultPlayer1 = "";
    public String resultPlayer2 = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }


    public boolean isTie() {
        return scorePlayer1 == scorePlayer2;
    }

    public String tiePoints() {
        return scorePlayer1 < 3 ? points[scorePlayer1] + "-All" : "Deuce";
    }

    public boolean isntAdvanced() {
        return scorePlayer1 < 4 && scorePlayer2 < 4;
    }

    public String gameScore() {
        resultPlayer1 = points[scorePlayer1];
        resultPlayer2 = points[scorePlayer2];
        return resultPlayer1 + "-" + resultPlayer2;
    }

    public boolean advancedGame() {
        return scorePlayer1 >= 4 || scorePlayer2 >= 4;
    }

    public int remainder() {
        return scorePlayer1 - scorePlayer2;
    }

    public String winnerScore() {
        return remainder() >= 2 ? "Win for player1" : "Win for player2";
    }

    public String advancedScore() {
        switch (remainder()) {
            case 1:
                return "Advantage player1";
            case -1:
                return "Advantage player2";
            default:
                return winnerScore();

        }
    }

    public String getScore() {
        String score = "";
        if (isTie()) {
            score = tiePoints();
        }

        if (!isTie() && isntAdvanced()) {
            score = gameScore();
        }

        if (!isTie() && advancedGame()) {
            score = advancedScore();
        }
        
        return score;
    }

    public void SetP1Score(int number) {

        for (int i = 0; i < number; i++) {
            P1Score();
        }

    }

    public void SetP2Score(int number) {

        for (int i = 0; i < number; i++) {
            P2Score();
        }

    }

    public void wonPoint(String player) {
        if (player.equals("player1"))
            P1Score();
        else
            P2Score();
    }

    public void P1Score() {
        scorePlayer1++;
    }

    public void P2Score() {
        scorePlayer2++;
    }


}