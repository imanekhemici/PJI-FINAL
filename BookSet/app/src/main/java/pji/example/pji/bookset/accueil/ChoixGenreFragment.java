package pji.example.pji.bookset.accueil;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import pji.example.pji.bookset.R;
import pji.example.pji.bookset.ajout.AjoutElementSuiteActivity;
import pji.example.pji.implementation.Collection.Livre;
import pji.example.pji.implementation.CollectionBdd.LivreDaoImpl;
import pji.example.pji.implementation.base.DatabaseManager;

/**
 * Created by raissa on 28/05/15.
 */
public class ChoixGenreFragment extends Fragment {

   public final static String EXTRA_MESSAGE= "";

    public ChoixGenreFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_choix_genre, container, false);

        Spinner spinner = (Spinner) rootView.findViewById(R.id.Genrespinner);

        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this.getActivity(), R.array.genre_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        return rootView;

    }


}

