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

public class EquipesFragment extends Fragment{

    View myView;
    ListView mainListView;
    // DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.equipes, container, false);
        // Find the ListView resource.
        mainListView = (ListView) myView.findViewById( R.id.equipeListView );
        return myView;
    }

    // Fonction click sur sur bouton equipe
    public void actionEquipe(Context context) {
        new EquipeAsyncTask(context, mainListView).execute();
    }
}
