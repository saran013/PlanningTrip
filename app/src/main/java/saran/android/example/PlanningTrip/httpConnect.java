package saran.android.example.PlanningTrip;

// added below imports
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import android.util.Log;

/**
 * Created by Computing on 01/11/2016.
 */

public class httpConnect {


    final String TAG = "JsonParser.java";

    static String json = "";

    public String getJSONFromUrl(String url){
        try{
            URL u = new URL(url);
            HttpURLConnection restConnection = (HttpURLConnection) u.openConnection();
            restConnection.setRequestMethod("GET");
            restConnection.setRequestProperty("Content-length", "0");
            restConnection.setUseCaches(false);
            restConnection.setAllowUserInteraction(false);
            restConnection.setConnectTimeout(10000);
            restConnection.setReadTimeout(10000);
            restConnection.connect();
            int status = restConnection.getResponseCode();

            // switch statement to catch HTTP 200 and 201 errors
            switch(status) {
                case 200:
                case 201:

                    BufferedReader br = new BufferedReader(new InputStreamReader(restConnection.getInputStream()));

                    StringBuilder sb = new StringBuilder();
                    String line;

                    while ((line = br.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    br.close();

                    try {
                        json = sb.toString();
                    } catch (Exception e) {
                        Log.e(TAG, "Error parsing data " + e.toString());
                    }

                    restConnection.disconnect();
                    return json;
            }
        } catch (MalformedURLException ex){
            Log.e(TAG, "Malformed URL ");
        } catch (IOException ex){
            Log.e(TAG, "IO Exception");
        }
        return null;
    }
}
