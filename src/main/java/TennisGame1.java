
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

    public String switchScore() {
        String result;
        switch (scorePlayer1) {
            case 0:
                result = "Love-All";
                break;
            case 1:
                result = "Fifteen-All";
                break;
            case 2:
                result = "Thirty-All";
                break;
            default:
                result = "Deuce";
                break;
        }
        return result;
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

    public String tempScoreSwitch(int parameter) {
        String aux;
        switch (parameter) {
            case 0:
                aux = "Love";
                break;
            case 1:
                aux = "Fifteen";
                break;
            case 2:
                aux = "Thirty";
                break;
            case 3:
                aux = "Forty";
                break;
            default:
                aux = "";
                break;
        }
        return aux;
    }

    public String getScore() {
        String score = "";
        int tempScore = 0;
        if (isTie()) score = switchScore();
        else if (FourOrHigher()) {
            score = GameMessage();
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = scorePlayer1;
                else {
                    score += "-";
                    tempScore = scorePlayer2;
                }
                score += tempScoreSwitch(tempScore);
            }
        }
        return score;
    }

}
