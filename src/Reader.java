import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

public class Reader {

    public static void read(List<Team> list) {

        String str;

        try (BufferedReader br = new BufferedReader(new FileReader("scores.txt"))) {
            while ((str = br.readLine()) != null) {
                StringTokenizer t = new StringTokenizer(str, ", ");
                while (t.hasMoreTokens()) {
                    list.add(new Team(t.nextToken(), Integer.parseInt(t.nextToken())));
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
