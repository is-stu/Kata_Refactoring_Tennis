
public class TennisGame1 implements TennisGame {

    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;
    private String FirstPlayer;
    private String SecondPlayer;

    public TennisGame1(String FirstPlayer, String SecondPlayer) {
        this.FirstPlayer = FirstPlayer;
        this.SecondPlayer = SecondPlayer;
    }

    public boolean isFirstPlayer(String playerName) {
        return playerName == "player1";
    }

    public void wonPoint(String playerName) {
        if (isFirstPlayer(playerName))
            scorePlayer1 += 1;
        else
            scorePlayer2 += 1;
    }

    public boolean isTie() {
        return scorePlayer1 == scorePlayer2;
    }

    public String FirstPoints() {

        switch (scorePlayer1) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";
        }
    }

    public boolean FourOrHigher() {
        return scorePlayer1 >= 4 || scorePlayer2 >= 4;
    }

    public boolean AdvantagePlayer1(int minusResult) {
        return minusResult == 1;
    }

    public boolean AdvantagePlayer2(int minusResult) {
        return minusResult == -1;
    }

    public boolean WinPlayer1(int minusResult) {
        return minusResult >= 2;
    }

    public String GameMessage() {
        int minusResult = scorePlayer1 - scorePlayer2;
        String message;
        if (AdvantagePlayer1(minusResult)) message = "Advantage player1";
        else if (AdvantagePlayer2(minusResult)) message = "Advantage player2";
        else if (WinPlayer1(minusResult)) message = "Win for player1";
        else message = "Win for player2";
        return message;
    }

    public String ScoreSwitch(int tempScore) {

        switch (tempScore) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "";
        }
    }

    public String getPoint(String score, int tempScore) {
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = scorePlayer1;
            else {
                score += "-";
                tempScore = scorePlayer2;
            }
            score += ScoreSwitch(tempScore);
        }
        return score;
    }

    public String getScore() {
        String score = "";
        int tempScore = 0;
        if (isTie()) score = FirstPoints();
        else if (FourOrHigher()) {
            score = GameMessage();
        } else {
            score = getPoint(score, tempScore);
        }
        return score;
    }

}
