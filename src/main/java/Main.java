import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        // TODO --> complete main function
        runMenu();
        Scanner myobj = new Scanner(System.in);
        String moviename = myobj.nextLine();
        Movie movieinfo = new Movie();
        String data1=movieinfo.getMovieData(moviename);
        System.out.println("Enter one of the name of an actor from screen\nYou can also choose other" +
                "actors: ");
        String actorname=myobj.nextLine();
        Actors actorsinfo=new Actors();
        String data1_a=actorsinfo.getActorData(actorname);

//        System.out.println(data1_a);
//        System.out.println(actorsinfo.isAlive(data1_a));
//        System.out.println(actorsinfo.getDateOfDeathViaApi(data1_a));


    }

    public static void runMenu() {
        // TODO
        System.out.println("Enter the name of movie: ");
    }
}