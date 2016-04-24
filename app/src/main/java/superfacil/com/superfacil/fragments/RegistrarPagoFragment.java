package superfacil.com.superfacil.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;

import superfacil.com.superfacil.R;

/**
 * Created by Uriel on 24/04/2016.
 */
public class RegistrarPagoFragment extends Fragment {
    private EditText noTarjeta;
    private EditText nombreTitular;
    private EditText mes;
    private EditText anio;
    private EditText cvv;
    private Button registrar;
    private SharedPreferences prefs;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        prefs = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_registrar_pago, parent, false);
        noTarjeta = (EditText) v.findViewById(R.id.no_tarjeta);
        mes = (EditText)v.findViewById(R.id.mes);
        anio = (EditText)v.findViewById(R.id.anio);
        cvv = (EditText)v.findViewById(R.id.cvv);
        registrar = (Button)v.findViewById(R.id.registrar_tarjeta);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarTarjeta();
            }
        });

        return v;
    }

    public void registrarTarjeta(){
        
    }
}
