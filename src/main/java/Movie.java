import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.regex.Pattern;


public class Movie {
    public static final String API_KEY = "d61cbed8";
    int ImdbVotes;
    ArrayList<String> actorsList;
    String rating;
    String title;
    JSONObject movieinfo_json;


    @SuppressWarnings("deprecation")
    /**
     * Retrieves data for the specified movie.
     *
     * @param title the name of the title for which MovieData should be retrieved
     * @return a string representation of the MovieData, or null if an error occurred
     */

    public String getMovieData(String title) throws IOException {
        URL url = new URL("https://www.omdbapi.com/?t="+title+"&apikey="+API_KEY);
        URLConnection Url = url.openConnection();
        Url.setRequestProperty("Authorization", "Key" + API_KEY);
        BufferedReader reader = new BufferedReader(new InputStreamReader(Url.getInputStream()));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = reader.readLine())!=null) {
            stringBuilder.append(line);
        }
        reader.close();
        movieinfo_json=new JSONObject(stringBuilder.toString());
        //handle an error if the chosen movie is not found
        return stringBuilder.toString();
    }
    public int getImdbVotesViaApi(String moviesInfoJson){
        //TODO --> (This function must change and return the "ImdbVotes" as an Integer)
        // NOTICE :: you are not permitted to convert this function to return a String instead of an int !!!
        ImdbVotes=0;
        String str_ImdbVotes=movieinfo_json.getString("imdbVotes");
        String new_str_Imdbvotes= arrtostr(arrlist_string(str_ImdbVotes));
        ImdbVotes=Integer.parseInt(new_str_Imdbvotes);
        return ImdbVotes;
    }

    public String getRatingViaApi(String moviesInfoJson){
        //TODO --> (This function must return the rating in the "Ratings" part
        // where the source is "Internet Movie Database")  -->
        rating = "";
        rating= new JSONObject(movieinfo_json.getJSONArray("Ratings").get(0).toString())
                .getString("Value");
        return rating;
    }
    public void getActorListViaApi(String moviesInfoJson){
        //TODO --> (This function must return the "Actors" in actorsList)
        System.out.println(movieinfo_json.getString("Actors"));

    }
    /*
    these are auxiliary functions
     */
    public static String[] arrlist_string(String input){
        String regex=",";
        Pattern pattern=Pattern.compile(regex);
        return pattern.split(input);
    }
    public static String arrtostr(String[] arr){
        String string="";
        for (String s:arr){
            string+=s;
        }
        return string;
    }

}