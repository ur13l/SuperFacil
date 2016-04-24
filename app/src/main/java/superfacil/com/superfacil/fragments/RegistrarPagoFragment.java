package superfacil.com.superfacil.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import superfacil.com.superfacil.R;

/**
 * Created by Uriel on 24/04/2016.
 */
public class RegistrarPagoFragment extends Fragment {
    String a;
    int keyDel;

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_registrar_pago, parent, false);
        final EditText noTarjeta = (EditText) v.findViewById(R.id.no_tarjeta);
        //noTarjeta = (EditText) v.findViewById(R.id.no_tarjeta);

        return v;
    }
}
