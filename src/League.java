import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class League {

    static Comparator<Team> compNames = new Comparator<>() {
        @Override
        public int compare(Team o1, Team o2) {
            return o1.getTeamName().compareToIgnoreCase(o2.getTeamName());
        }
    };

    static Comparator<Team> compScores = new Comparator<>() {
        @Override
        public int compare(Team o1, Team o2) {
            return Integer.compare(o2.getLeaguePoint(), o1.getLeaguePoint());
        }
    };

    public static void main(String[] args) {


        List<Team> testList = new ArrayList<>();

        Reader.read(testList);

        playGame(testList);

        getLeaguePoints(testList);

    }

    public static void playGame(List<Team> list) {
        for (int i = 0; i < list.size(); i += 2) {

            if (list.get(i).getScore() < list.get(i + 1).getScore()) {
                list.get(i + 1).incLeaguePoints(3);
            } else if (list.get(i).getScore() > list.get(i + 1).getScore()) {
                list.get(i).incLeaguePoints(3);
            } else if (list.get(i).getScore() == list.get(i + 1).getScore()) {
                list.get(i).incLeaguePoints(1);
                list.get(i + 1).incLeaguePoints(1);
            }
        }
    }

    public static void getLeaguePoints(List<Team> teams) {
        for (int i = 0; i < teams.size(); i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                if (teams.get(i).getTeamName().equalsIgnoreCase(teams.get(j).getTeamName())) {
                    teams.get(i).incLeaguePoints(teams.get(j).getLeaguePoint());
                    teams.remove(j);
                }
            }
        }

        teams.sort(compScores.thenComparing(compNames));

        for (int i = 0; i < teams.size(); i++) {
            System.out.println((i + 1) + "." + teams.get(i).getTeamName()
                    + "\n\t" + teams.get(i).getLeaguePoint());
        }
    }
}
