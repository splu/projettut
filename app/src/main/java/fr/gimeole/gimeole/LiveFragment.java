package fr.gimeole.gimeole;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by Utilisateur on 12/01/2017.
 */

public class LiveFragment extends Fragment{

    View myView;
    ListView mainListView;
    // DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.live, container, false);
        // Find the ListView resource.
        mainListView = (ListView) myView.findViewById( R.id.liveListView );
        return myView;
    }

    // Fonction click sur sur bouton classement
    public void actionLive(Context context) {
        new LiveAsyncTask(context, mainListView).execute();
    }
}
