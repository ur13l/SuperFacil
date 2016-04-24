package superfacil.com.superfacil.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import superfacil.com.superfacil.R;
import superfacil.com.superfacil.fragments.HistorialComprasFragment;

public class ContentActivity extends AppCompatActivity {
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
        }
        ft.replace(R.id.fragment_container, f).commit();
    }
}
