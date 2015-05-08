package pji.example.pji.bookset.ajout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.io.File;

import pji.example.pji.bookset.R;
import pji.example.pji.bookset.accueil.AccueilActivity;
import pji.example.pji.implementation.Collection.Livre;


public class AjouterElementManSuite2Activity extends ActionBarActivity {

    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    public static final int MEDIA_TYPE_IMAGE = 1;
    public static final int MEDIA_TYPE_VIDEO = 2;
    private Uri fileUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_element_man_suite2);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ajouter_element_man_suite2, menu);
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

    public void suiteMan(View view){

        Livre livre = (Livre)getIntent().getSerializableExtra("livre1");

        EditText emprunte = (EditText)findViewById(R.id.emprunte);
        String emprunte_s = emprunte.getText().toString();

        livre.setEmprunte(emprunte_s);

        EditText prete = (EditText)findViewById(R.id.prete);
        String prete_s = prete.getText().toString();

        livre.setPrete(prete_s);

        Intent intent = new Intent(this, ConfirmationAjout.class);
        intent.putExtra("livre2",livre);

        startActivity(intent);


    }
    public void annuler(View view){
        Intent intent = new Intent(this, AccueilActivity.class);
        startActivity(intent);

    }

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


}
