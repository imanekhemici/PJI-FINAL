package pji.example.pji.bookset.recherche;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import pji.example.pji.bookset.accueil.AccueilActivity;
import pji.example.pji.bookset.R;
import pji.example.pji.bookset.ajout.AjouterActivity;


public class RechercheChoixActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche_choix);
    }
    public void ajouterElement(View view) {
        Intent intent = new Intent(this, AjouterActivity.class);
        startActivity(intent);

    }

    public void accueil(View view){
        Intent intent = new Intent(this, AccueilActivity.class);
        startActivity(intent);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_recherche_choix, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void rechercheManuelle(View view){
            Intent intent = new Intent(this, RechercheActivity.class);
            startActivity(intent);
    }
}
