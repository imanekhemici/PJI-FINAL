package pji.example.pji.bookset.modification;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import pji.example.pji.bookset.R;
import pji.example.pji.implementation.Collection.Livre;

public class Modification1Activity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modification1);

        final Livre livre = (Livre) getIntent().getSerializableExtra("livreDe");

        EditText text = (EditText) findViewById(R.id.titreModif);
        String titre = livre.getTitre();
        text.setText(titre);
        text = (EditText) findViewById(R.id.auteurModif);
        text.setText(livre.getAuteur());

        text = (EditText) findViewById(R.id.isbnModif);
        text.setText(livre.getIsbn());

        EditText langue_t = (EditText) findViewById(R.id.langueModif);
        langue_t.setText(livre.getLangue());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_modification1, menu);
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
    public void suivantModif(View view){
        final Livre livre = (Livre) getIntent().getSerializableExtra("livreDe");
        EditText text = (EditText) findViewById(R.id.titreModif);
        String titre = livre.getTitre();
        text.setText(titre);
        text = (EditText) findViewById(R.id.auteurModif);
        text.setText(livre.getAuteur());

        text = (EditText) findViewById(R.id.isbnModif);
        text.setText(livre.getIsbn());

        EditText langue_t = (EditText) findViewById(R.id.langueModif);
        langue_t.setText(livre.getLangue());

    }
}
