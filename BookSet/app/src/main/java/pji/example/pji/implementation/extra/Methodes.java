package pji.example.pji.implementation.extra;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import java.io.File;
import java.sql.SQLException;

import pji.example.pji.bookset.accueil.AccueilActivity;
import pji.example.pji.bookset.ajout.AjouterActivity;
import pji.example.pji.bookset.ajout.AjouterElementActivity;
import pji.example.pji.bookset.recherche.RechercheChoixActivity;

/**
 * Created by imane khemici on 09/05/15.
 */
public class Methodes  extends ActionBarActivity {
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    public static final int MEDIA_TYPE_IMAGE = 1;
    public static final int MEDIA_TYPE_VIDEO = 2;
    private Uri fileUri;
    public void ajouterElement(View view) {
        Intent intent = new Intent(this, AjouterActivity.class);
        startActivity(intent);

    }

    public void accueil(View view){
        Intent intent = new Intent(this, AccueilActivity.class);
        startActivity(intent);

    }
    public void annuler(View view){
        Intent intent = new Intent(this, AccueilActivity.class);
        startActivity(intent);

    }
    public void recherche(View view){
        Intent intent = new Intent(this,RechercheChoixActivity.class);
        startActivity(intent);
    }

    public void scan(View view){
        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
        startActivityForResult(intent, 0);
    }

    public void ajouter(View view) throws SQLException {
        Intent intent = new Intent(this, AjouterElementActivity.class);
        startActivity(intent);
    }

/**public void information(View view) throws SQLException {
 TextView livreTitre = (TextView) findViewById(R.id.titreaff);
 Livre livre = DatabaseManager.getInstance().getHelper().getLivreDao().findByTitle(livreTitre.getText().toString());
 Intent intent = new Intent(this,InformationActivity.class);
 intent.putExtra("livreDetails",livre);
 startActivity(intent);
 }*/

    public void photo(View view){
        File path = new File( Environment.getExternalStorageDirectory(), getPackageName() );
        if(!path.exists()){
        path.mkdir();
        }
        File tempFile = new File(Environment.getExternalStorageDirectory(), "temp.jpg");
         Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // start the image capture Intent
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(tempFile));
         startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
    }

    public void galerry(View view){



    }
    public void ajouterAnouveau(View view){

        Intent intent = new Intent(this, AjouterElementActivity.class);
        startActivity(intent);
    }

}
