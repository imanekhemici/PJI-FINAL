package pji.example.pji.bookset.ajout;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import pji.example.pji.bookset.accueil.AccueilActivity;
import pji.example.pji.bookset.R;
import pji.example.pji.bookset.recherche.RechercheChoixActivity;


public class AjouterActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajouter_activity);
    }

    public void recherche(View view){
        Intent intent = new Intent(this,RechercheChoixActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ajouter, menu);
        return true;
    }

    public void scan(View view){
        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
        startActivityForResult(intent, 0);
    }
    public void accueil(View view){
        Intent intent = new Intent(this, AccueilActivity.class);
        startActivity(intent);

    }
    public void ajouter(View view){
        Intent intent = new Intent(this, AjouterElementActivity.class);
        startActivity(intent);
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
}
