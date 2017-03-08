package fr.gimeole.gimeole;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         VideoView _VideoView = (VideoView) findViewById(R.id.videoView);

         MediaController MediaController = new MediaController(this);
         MediaController.setAnchorView(_VideoView);
         Uri uri = Uri.parse("rtsp://r6---sn-5hnednlk.googlevideo.com/Cj0LENy73wIaNAnfpas_YHyo5RMYDSANFC0EYXtYMOCoAUIASARg9pWq6uXty7ZYigELeDduQ1pfZkZtTzgM/01A33AFB2C66FAF7B21BE4C30D8D7611D2C2BA04.3FF599A4D0383DD745590F00B7EF10F9CB6C9A0D/yt6/1/video.3gp");
         _VideoView.setMediaController(MediaController);
         _VideoView.setVideoURI(uri);
         _VideoView.requestFocus();
         _VideoView.start();
         **/

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

    }

    /******* LIENS ******/

    public void lienGIM(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.iutgim.org/"));
        startActivity(browserIntent);
    }

    public void lienREGLEMENT(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gimeole.fr/sites/default/files/R%C3%A8glement%20GIMEole%202017%20v2.pdf"));
        startActivity(browserIntent);
    }

    // Fonction click sur sur bouton equipe
    public void actionEquipe(View view) {
        android.app.FragmentManager fm = getFragmentManager();
        Fragment currentFragment = fm.findFragmentByTag("EquipeFragment");
        ((EquipesFragment)currentFragment).actionEquipe(this);
        //new EquipeAsyncTask(this).execute();
    }

    // Fonction click sur sur bouton live (classement général)
    public void actionLive(View view) {
        android.app.FragmentManager fm = getFragmentManager();
        Fragment currentFragment = fm.findFragmentByTag("LiveFragment");
        ((LiveFragment)currentFragment).actionLive(this);
        //new EquipeAsyncTask(this).execute();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    /********* MENU DE DROITE*********/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        android.app.FragmentManager fragmentManager = getFragmentManager();
        //noinspection SimplifiableIfStatement
        if (id == R.id.nav_partenaires) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new PartenairesFragment()).commit();

        } else if (id == R.id.nav_reglement) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new ReglementFragment()).commit();

        } else if (id == R.id.nav_apropos) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new AproposFragment()).commit();
        }

        return super.onOptionsItemSelected(item);

    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override

    /********MENU DE GAUCHE*********/
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        android.app.FragmentManager fragmentManager = getFragmentManager();

        if (id == R.id.nav_Accueil) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new AccueilFragment()).commit();

            // Handle the camera action

        } else if (id == R.id.nav_Concours) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new ConcoursFragment()).commit();

        } else if (id == R.id.nav_equipes) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new EquipesFragment(), "EquipeFragment").commit();

        } else if (id == R.id.nav_defis) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new DefisFragment()).commit();

        } else if (id == R.id.nav_live) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new LiveFragment(), "LiveFragment").commit();

        } else if (id == R.id.nav_live2) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new Live2Fragment(), "Live2Fragment").commit();

        } else if (id == R.id.nav_animationsetdefis) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new AnimationsetdefisFragment()).commit();

        } else if (id == R.id.nav_souvenirs) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new SouvenirsFragment()).commit();

        } else if (id == R.id.nav_videos) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new VideosFragment()).commit();

        } else if (id == R.id.nav_share) {

                Intent share = new Intent(android.content.Intent.ACTION_SEND);
                share.setType("text/plain");

            // Add data to the intent, the receiving app will decide what to do with it.
                share.putExtra(Intent.EXTRA_SUBJECT, "APP");
                share.putExtra(Intent.EXTRA_TEXT, "Pour télécharger l'application GIM'EOLE, rendez-vous sur le play store :  https://play.google.com/store?hl=fr");
                startActivity(Intent.createChooser(share, getString(R.string.share_subject)));
                return true;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}




/****
 * //requetes

 private EditText usernameField, passwordField;
 private TextView status, role, method;

 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);

 usernameField = (EditText) findViewById(R.id.editText1);
 passwordField = (EditText) findViewById(R.id.editText2);

 status = (TextView) findViewById(R.id.textView6);
 role = (TextView) findViewById(R.id.textView7);
 method = (TextView) findViewById(R.id.textView9);
 }


 public void login(View view) {
 String username = usernameField.getText().toString();
 String password = passwordField.getText().toString();
 method.setText("Get Method");
 new EquipeAsyncTask(this, status, role, 0).execute(username, password);

 }

 public void loginPost(View view) {
 String username = usernameField.getText().toString();
 String password = passwordField.getText().toString();
 method.setText("Post Method");
 new EquipeAsyncTask(this, status, role, 1).execute(username, password);
 }

 /**
  * ATTENTION: This was auto-generated to implement the App Indexing API.
  * See https://g.co/AppIndexing/AndroidStudio for more information.

public Action getIndexApiAction() {
    Thing object = new Thing.Builder()
            .setName("Main Page") // TODO: Define a title for the content shown.
            // TODO: Make sure this auto-generated URL is correct.
            .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
            .build();
    return new Action.Builder(Action.TYPE_VIEW)
            .setObject(object)
            .setActionStatus(Action.STATUS_TYPE_COMPLETED)
            .build();
}

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
//fin requetes ***/



