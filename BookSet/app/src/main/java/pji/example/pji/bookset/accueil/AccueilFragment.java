package pji.example.pji.bookset.accueil;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import pji.example.pji.bookset.R;
import pji.example.pji.implementation.Collection.Livre;
import pji.example.pji.implementation.CollectionBdd.LivreDaoImpl;
import pji.example.pji.implementation.base.DatabaseManager;

/**
 * Created by raissa on 18/04/15.
 */
public class AccueilFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
        savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_accueil, container, false);

            ListView view = (ListView) rootView.findViewById(R.id.listLivre) ;

            LivreDaoImpl livreDao = DatabaseManager.getInstance().getHelper().getLivreDao();
            if(livreDao != null) {
                List<Livre> livres = livreDao.findAll();
                List<HashMap<String, Object>> liste = new ArrayList<HashMap<String, Object>>();
                HashMap<String, Object> element;

                //Pour chaque personne dans notre répertoire…
                for (Livre livre : livres) {

                    element = new HashMap<String, Object>();

                    element.put("titre",  livre.getTitre());
                    element.put("auteur", livre.getAuteur());


                    final BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = 8;
                    Bitmap bm = BitmapFactory.decodeFile(livre.getImage(),options);

                    element.put("image",bm);
                    liste.add(element);

                }

                SimpleAdapter adapter = new SimpleAdapter(this.getActivity(), liste, R.layout.afficher_livre,
                        new String[]{"titre", "auteur","image"},
                        new int[]{R.id.titreaff, R.id.auteuraff,R.id.couverture});
                adapter.setViewBinder(new AfficherLivre());
                //Pour finir, on donne à la ListView le SimpleAdapter

                view.setAdapter(adapter);
            }
            return rootView;

    }
}
