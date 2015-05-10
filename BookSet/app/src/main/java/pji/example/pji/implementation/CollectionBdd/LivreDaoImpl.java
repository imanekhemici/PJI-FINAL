package pji.example.pji.implementation.CollectionBdd;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pji.example.pji.implementation.Collection.Livre;

/**
 * Created by imane khemici on 08/04/15.
 */
public class LivreDaoImpl extends BaseDaoImpl<Livre,Integer> implements  LivreDao{


 public LivreDaoImpl(ConnectionSource connectionSource)
            throws SQLException {

     super(connectionSource, Livre.class);
    }
    //Tout
    public List findAll() {
        List livres = new ArrayList<>();
        try {
            livres = queryForAll();
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return livres;
    }
    //Par titre
    public List findByTitle(String titre) throws SQLException {
        List<Livre> livres = new ArrayList<>();
        List<Livre> resultat = new ArrayList();
        try {
            livres = queryForAll();
            for (Livre livre : livres){
                if(livre.getTitre().equals(titre)){
                    resultat.add(livre);
                }
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return resultat;


/**
        PreparedQuery<Livre> requete = null;
        List result = new ArrayList();
        try {
            requete = queryBuilder().where().gt("titre",titre).prepare();
            result = query(requete);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
*/
    }
    public Livre findByTitre(String titre){
        List<Livre> livres = new ArrayList<>();
        Livre resultat = new Livre();
        try {
            livres = queryForAll();
            for (Livre livre : livres){
                if(livre.getTitre().equals(titre)){
                    resultat=livre;
                }
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return resultat;
    }
    //Isbn
    public List findByIsbn(String isbn) {
        List<Livre> livres = new ArrayList<>();
        List<Livre> resultat = new ArrayList();
        try {
            livres = queryForAll();
            for (Livre livre : livres){
                if(livre.getIsbn().equals(isbn)){
                    resultat.add(livre);
                }
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return resultat;
        /**PreparedQuery<Livre> requete = null;
        List result = new ArrayList();

        try {
            requete = queryBuilder().where().gt("isbn",isbn).prepare();
            result = query(requete);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;*/

    }
    //Auteur
    public List findByAuteur(String auteur){
        List<Livre> livres = new ArrayList<>();
        List<Livre> resultat = new ArrayList();
        try {
            livres = queryForAll();
            for (Livre livre : livres){
                if(livre.getAuteur().equals(auteur)){
                    resultat.add(livre);
                }
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return resultat;
       /** PreparedQuery<Livre> requete = null;
        List result = new ArrayList();

        try {
            requete = queryBuilder().where().gt("auteur",auteur).prepare();
            result = query(requete);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;*/

    }

    @Override
    public List findByGenre(String genre) {
        List<Livre> livres = new ArrayList<>();
        List<Livre> resultat = new ArrayList();
        try {
            livres = queryForAll();
            for (Livre livre : livres){
                if(livre.getGenre().equals(genre)){
                    resultat.add(livre);
                }
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return resultat;
       /** PreparedQuery<Livre> requete = null;
        List result = new ArrayList();

        try {
            requete = queryBuilder().where().gt("genre",genre).prepare();
            result = query(requete);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;*/
    }

    @Override
    public List findByLangue(String langue) {
        List<Livre> livres = new ArrayList<>();
        List<Livre> resultat = new ArrayList();
        try {
            livres = queryForAll();
            for (Livre livre : livres){
                if(livre.getLangue().equals(langue)){
                    resultat.add(livre);
                }
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return resultat;
        /**PreparedQuery<Livre> requete = null;
        List result = new ArrayList();

        try {
            requete = queryBuilder().where().gt("langue",langue).prepare();
            result = query(requete);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;*/
    }


    public List findAllPanier(){
        List<Livre> resultat = new ArrayList();
        List<Livre> all = new ArrayList();
        all =  findAll();
        for(Livre livre1 : all){
            if(livre1.isPanier() == true){
                resultat.add(livre1);
            }

        }
        return resultat;

    }

    public List findAllFavoris(){

        List<Livre> resultat = new ArrayList();
        List<Livre> all = new ArrayList();
        all =  findAll();
        for(Livre livre1 : all){
            if(livre1.isFavori() == true){
                resultat.add(livre1);
            }

        }
        return resultat;
    }


    public Livre findById(int id) {
        Livre livres = new Livre();
        try {
            livres = (Livre) queryForId(id);
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return livres
                ;
    }


    public boolean existe(String titre) throws SQLException {
        List<Livre> all = queryForAll();
        boolean existe = false;
        for(Livre livre1 : all){
            if(livre1.getTitre().equals(titre)){
                existe = true;
            }

        }
        return existe;

    }
    public int addData(Livre livre) throws SQLException {

        return this.create(livre);
    }
    public int delete(Livre livre) throws SQLException {

        return this.deleteById(livre.getId());
    }
}
