public class Team {

    private final String teamName;
    private final int score;
    private int leaguePoint = 0;

    public Team(String teamName, int score) {
        this.teamName = teamName;
        this.score = score;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getScore() {
        return score;
    }

    public int getLeaguePoint() {
        return leaguePoint;
    }

    public void incLeaguePoints(int amount) {
        leaguePoint += amount;
    }
}
