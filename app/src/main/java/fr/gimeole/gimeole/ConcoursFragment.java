package fr.gimeole.gimeole;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by Utilisateur on 12/01/2017.
 */

public class ConcoursFragment extends Fragment{

    View myView;

    @Nullable
    @Override
    //public void onStart() {
        //requetes
        //super.onStart();
    //}

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.concours, container, false);
        return myView;
    }
}
