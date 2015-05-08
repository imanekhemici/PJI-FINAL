package pji.example.pji.implementation.TypeGenre;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by imane khemici on 18/03/15.
 */
public class GenreLivre {

    private List<String> genres;

    public GenreLivre(){
        genres = new ArrayList<>();
    }

    public void addGenre(String genre){
        genres.add(genre);
    }

    public void removeGenre(String genre){
        genres.remove(genre);
    }

}
