
public class TennisGame2 implements TennisGame {
    public int pointsPlayer1 = 0;
    public int pointsPlayer2 = 0;

    public String resultPlayer1 = "";
    public String resultPlayer2 = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public boolean isTie() {
        return pointsPlayer1 == pointsPlayer2;
    }

    public String pointsPlayer(int pointsPlayer) {
        switch (pointsPlayer) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            default:
                return "";
        }
    }

    public boolean isPlayer1Winning() {
        return pointsPlayer1 > pointsPlayer2;
    }

    public boolean isPlayer2Winning() {
        return pointsPlayer2 > pointsPlayer1;
    }

    public boolean diffPointsP1() {
        return (pointsPlayer1 - pointsPlayer2) >= 2;
    }

    public boolean diffPointsP2() {
        return (pointsPlayer2 - pointsPlayer1) >= 2;
    }

    public boolean hasPlayerPoints (int pointsPlayer){
        return pointsPlayer > 0;
    }


    public boolean hasntPlayerPoints(int pointsPlayer){
        return pointsPlayer == 0;
    }


    public String getScore() {
        String score = "";
        if (isTie() && pointsPlayer1 < 4) {
            score = pointsPlayer(pointsPlayer1);
            score += "-All";
        }
        if (isTie() && pointsPlayer1 >= 3)
            score = "Deuce";

        if (hasPlayerPoints(pointsPlayer1) && hasntPlayerPoints(pointsPlayer2)) {
            resultPlayer1 = pointsPlayer(pointsPlayer1);
            resultPlayer2 = "Love";
            score = resultPlayer1 + "-" + resultPlayer2;
        }
        if (hasPlayerPoints(pointsPlayer2) && hasntPlayerPoints(pointsPlayer1)) {
            resultPlayer2 = pointsPlayer(pointsPlayer2);
            resultPlayer1 = "Love";
            score = resultPlayer1 + "-" + resultPlayer2;
        }

        if (isPlayer1Winning() && pointsPlayer1 < 4) {
            if (pointsPlayer1 == 2)
                resultPlayer1 = "Thirty";
            if (pointsPlayer1 == 3)
                resultPlayer1 = "Forty";
            if (pointsPlayer2 == 1)
                resultPlayer2 = "Fifteen";
            if (pointsPlayer2 == 2)
                resultPlayer2 = "Thirty";
            score = resultPlayer1 + "-" + resultPlayer2;
        }
        if (isPlayer2Winning() && pointsPlayer2 < 4) {
            if (pointsPlayer2 == 2)
                resultPlayer2 = "Thirty";
            if (pointsPlayer2 == 3)
                resultPlayer2 = "Forty";
            if (pointsPlayer1 == 1)
                resultPlayer1 = "Fifteen";
            if (pointsPlayer1 == 2)
                resultPlayer1 = "Thirty";
            score = resultPlayer1 + "-" + resultPlayer2;
        }

        if (isPlayer1Winning() && pointsPlayer2 >= 3) {
            score = "Advantage player1";
        }

        if (isPlayer2Winning() && pointsPlayer1 >= 3) {
            score = "Advantage player2";
        }

        if (pointsPlayer1 >= 4 && pointsPlayer2 >= 0 && diffPointsP1()) {
            score = "Win for player1";
        }
        if (pointsPlayer2 >= 4 && pointsPlayer1 >= 0 && diffPointsP2()) {
            score = "Win for player2";
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

    public void P1Score() {
        pointsPlayer1++;
    }

    public void P2Score() {
        pointsPlayer2++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}