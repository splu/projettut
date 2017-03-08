package fr.gimeole.gimeole;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;

//Tâche asynchrone qui permet de gérer une tâche qui se passe en arrière plan

public class EquipeAsyncTask extends AsyncTask {
    private Context context;
    private ListView mlistView;

    //flag 0 means get and 1 means post.(By default it is get.)
    public EquipeAsyncTask(Context context, ListView listView) {
        this.context = context;
        mlistView = listView;
    }


    protected void onPreExecute() {
    }

    @Override
    protected Object doInBackground(Object[] arg0) { //permet lorsqu'on envoi et reçoit la requête
        try { //TRY on essaye le bloc
            // String username = (String) arg0[0]; //sort username des arguments
            // String password = (String) arg0[1]; //sort password des arguments
            String link = "http://mysqlgimeole.gimeole.fr/script_php_gimeole/requetes_php_TABLE_CLASSEMENT.php";
            //liens ? paramètres
            //URL url = new URL("http://mysqlgimeole.gimeole.fr/"); //déclaration url avec le lien
            DefaultHttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet(); //requete : get pour récupérer info
            request.setURI(new URI(link));

            // parametes de la requete
            HttpParams params = new BasicHttpParams();
            params.setParameter("password", "etu");
            params.setParameter("user", "etu");
            request.setParams(params);

            // Make request
            HttpResponse response = client.execute(request);

            BufferedReader in = new BufferedReader(new
                    InputStreamReader(response.getEntity().getContent()));


            StringBuffer sb = new StringBuffer("");
            String line = "";

            while ((line = in.readLine()) != null) {
                sb.append(line);
                break;
            }
            return sb.toString();
        } catch (Exception e) { //CATCH si ça echoue, on attrape l'exeption
            Log.e("GIMEOLE.HTTP", e.getMessage());
        }
        return "";
    }

    @Override
    /*****fait revenir la requete****/
    protected void onPostExecute(Object result) {
        try {


            // Create and populate a List of planet names.
            ArrayList<String> planetList = new ArrayList<String>();
            JSONArray jsonArray = new JSONArray((String) result);

            for (int i = 0 ; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Log.w("request", jsonObject.getString("ID"));
                Log.w("request", jsonObject.getString("Nom_equipe"));
                //Log.w("request", jsonObject.getString("Performance"));

                planetList.add(jsonObject.getString("Nom_equipe"));
                //planetList.add(jsonObject.getString("Performance"));
            }

            // Create ArrayAdapter using the planet list.
            ArrayAdapter listAdapter = new ArrayAdapter<String>(context, R.layout.equipe_row, planetList);

            // Add more planets. If you passed a String[] instead of a List<String>
            // into the ArrayAdapter constructor, you must not add more items.
            // Otherwise an exception will occur.
            //listAdapter.add( "Ceres" );

            // Set the ArrayAdapter as the ListView's adapter.
            mlistView.setAdapter( listAdapter );

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}