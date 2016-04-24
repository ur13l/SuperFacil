package superfacil.com.superfacil.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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
        nombreTitular = (EditText)v.findViewById(R.id.nombre_titular);
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
        int cont = 0;
//        Log.d("NNNN", prefs.getString(PagoFragment.NUMERO+cont, null));
        while(prefs.getString(PagoFragment.NUMERO+cont, null) != null){
            cont++;
        }
        prefs.edit().putString(PagoFragment.NUMERO+cont, noTarjeta.getText().toString()).commit();
        prefs.edit().putString(PagoFragment.NOMBRE+cont, nombreTitular.getText().toString()).commit();
        prefs.edit().putString(PagoFragment.MES+cont, mes.getText().toString()).commit();
        prefs.edit().putString(PagoFragment.ANIO+cont, anio.getText().toString()).commit();
        prefs.edit().putString(PagoFragment.CVV+cont, cvv.getText().toString()).commit();
        getFragmentManager().popBackStack();
    }
}
