package superfacil.com.superfacil.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import superfacil.com.superfacil.R;
import superfacil.com.superfacil.model.Tarjeta;

/**
 * Created by Uriel on 24/04/2016.
 */
public class PagoFragment extends Fragment{
    public final static String NUMERO = "pago_numero_tarjeta";
    public final static String NOMBRE = "pago_nombre";
    public final static String MES = "pago_mes";
    public final static String ANIO = "pago_anio";
    public final static String CVV = "pago_cvv";

    private FloatingActionButton fab;
    private RecyclerView rv;
    private TextView emptyView;
    private List<Tarjeta> list;
    SharedPreferences prefs;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        prefs = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_pago, parent, false);
        fab = (FloatingActionButton) getActivity().findViewById(R.id.fab_pago);
        rv = (RecyclerView) v.findViewById(R.id.rv_tarjetas);
        emptyView = (TextView) v.findViewById(R.id.empty_view);

        fab.setVisibility(View.VISIBLE);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment f = new RegistrarPagoFragment();

                ft.replace(R.id.fragment_container, f)
                        .addToBackStack(null).commit();
            }
        });

        if(list.isEmpty()){
            rv.setVisibility(View.GONE);
            emptyView.setVisibility(View.VISIBLE);
        }
        return v;
    }

    public void initializeData(){
        int cont = 0;
        list = new ArrayList<>();
        while(prefs.getString("numero_tarjeta"+cont, null) != null){
            Tarjeta tarjeta = new Tarjeta();
            tarjeta.setNoTarjeta(prefs.getString(NUMERO+cont, null));
            tarjeta.setNombre(prefs.getString(NOMBRE+cont, null));
            tarjeta.setMes(prefs.getString(MES+cont, null));
            tarjeta.setAnio(prefs.getString(ANIO+cont, null));
            tarjeta.setCvv(prefs.getString(CVV+cont, null));
            list.add(tarjeta);
        }
    }
}
