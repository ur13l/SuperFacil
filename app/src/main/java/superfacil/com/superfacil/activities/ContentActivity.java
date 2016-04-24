package superfacil.com.superfacil.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import superfacil.com.superfacil.R;
import superfacil.com.superfacil.callbacks.BackCallback;
import superfacil.com.superfacil.callbacks.FragmentCallbacks;
import superfacil.com.superfacil.fragments.FragmentListSaved;
import superfacil.com.superfacil.fragments.HistorialComprasFragment;
import superfacil.com.superfacil.fragments.MapFragment;
import superfacil.com.superfacil.fragments.SearchFragment;

public class ContentActivity extends AppCompatActivity implements BackCallback{
    public final static String OPTION = "content_activity_option";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        int option = getIntent().getIntExtra(OPTION, -1);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment f = null;
        switch (option){
            case R.id.nav_historial_compras:
                f = new HistorialComprasFragment();
                break;
            case R.id.nav_listas_guardadas:
                f = new FragmentListSaved();
                break;
            case R.id.nav_map:
                f = new MapFragment();
                break;
        }
        ft.replace(R.id.fragment_container, f).commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home){
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setElevation(0);
    }

    @Override
    public void onBackPressedCallback(){
        int fragmentCount = getSupportFragmentManager().getBackStackEntryCount();

        if (fragmentCount > 0){
            getSupportFragmentManager().popBackStackImmediate();
        }else {
            finish();
        }
    }
}
