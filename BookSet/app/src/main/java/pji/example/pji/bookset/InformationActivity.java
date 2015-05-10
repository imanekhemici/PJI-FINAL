package pji.example.pji.bookset;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import pji.example.pji.implementation.Collection.Livre;
import pji.example.pji.implementation.extra.Methodes;


public class InformationActivity extends Methodes {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        Intent intent = getIntent();
        Livre livre = (Livre)intent.getSerializableExtra("livreDetails");


        ListView vue = (ListView) findViewById(R.id.listInfor);

            List<HashMap<String, String>> liste = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> element;
            //Pour chaque personne dans notre répertoire…

                element = new HashMap<String, String>();
                element.put("nom", "Titre:");
                element.put("valeur", livre.getTitre());

                liste.add(element);

                element = new HashMap<String, String>();
                element.put("nom", "Auteur:");
                element.put("valeur", livre.getAuteur());

                liste.add(element);

                element = new HashMap<String, String>();
                element.put("nom", "Isbn:");
                element.put("valeur", livre.getIsbn());

                liste.add(element);

                element = new HashMap<String, String>();
                element.put("nom", "Genre:");
                element.put("valeur", livre.getGenre());

                liste.add(element);

                element = new HashMap<String, String>();
                element.put("nom", "Langue:");
                element.put("valeur", livre.getLangue());

                liste.add(element);

                element = new HashMap<String, String>();
                element.put("nom", "Publié le:");
                element.put("valeur", livre.getPublie_le());

                liste.add(element);

                element = new HashMap<String, String>();
                element.put("nom", "Emprunté de:");
                element.put("valeur", livre.getEmprunte());

                liste.add(element);

                element = new HashMap<String, String>();
                element.put("nom", "Preté a:");
                element.put("valeur", livre.getPrete());

                liste.add(element);

                element = new HashMap<String, String>();
                element.put("nom", "Note:");
                element.put("valeur", Float.toString(livre.getNote()));

                liste.add(element);

                element = new HashMap<String, String>();
                element.put("nom", "Lu:");
                if(livre.isLu()) {
                    element.put("valeur", "Oui");
                }else{
                    element.put("valeur", "Non");
                }
                liste.add(element);

                element = new HashMap<String, String>();
                element.put("nom", "Favoris:");
                if(livre.isFavori()) {
                    element.put("valeur", "Oui");
                }else{
                     element.put("valeur", "Non");
                }
                liste.add(element);


            ListAdapter adapter = new SimpleAdapter(this, liste, R.layout.activity_information_livre,
                    new String[]{"nom","valeur"},
                    new int[]{R.id.inforX,R.id.inforY});

            //Pour finir, on donne à la ListView le SimpleAdapter

            vue.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_information, menu);
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

}
