import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;
public class Actors {
    public static final String API_KEY = "MUe0TUVLwecAyRMOykNLug==t8vIZHAmHzVqKBbU";
    String netWorth;
    Boolean isAlive;
    JSONObject Actorsinfo_json;
    String name;

    @SuppressWarnings({"deprecation"})
    /**
     * Retrieves data for the specified actor.
     * @param name for which Actor should be retrieved
     * @return a string representation of the Actors info or null if an error occurred
     */
    public String getActorData(String name) {
        this.name=name;
        try {
            URL url = new URL("https://api.api-ninjas.com/v1/celebrity?name="+
                    name.replace(" ", "+")+"&apikey="+API_KEY);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("X-Api-Key", API_KEY);
            System.out.println(connection);
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                Actorsinfo_json=new JSONObject(response.substring(1,response.length()-1));
                return response.substring(1,response.length()-1);
            } else {
                return "Error: " + connection.getResponseCode() + " " + connection.getResponseMessage();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public double getNetWorthViaApi(String actorsInfoJson){
        //TODO --> (This function must return the "NetWorth")
        double result = 0.0;
        result=Actorsinfo_json.getDouble("net_worth");
        return result;
    }

    public boolean isAlive(String actorsInfoJson){
        //TODO --> (If your chosen actor is alive it must return true otherwise it must return false)
        boolean statues = false;
        statues=Actorsinfo_json.getBoolean("is_alive");
        if(statues==false){
            //getDateOfDeathViaApi(getActorData(name));
            return false;
        }
        return statues;
    }

    public String getDateOfDeathViaApi(String actorsInfoJson){
        //TODO --> (If your chosen actor is deceased it must return the date of death)  -->
        String date = "ALIVE";
        if (isAlive(getActorData(name))==false){
            date=Actorsinfo_json.getString("death");
        }
        return date;
    }

}