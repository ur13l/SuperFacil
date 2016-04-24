package superfacil.com.superfacil.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import superfacil.com.superfacil.R;
import superfacil.com.superfacil.adapters.RVHistorialAdapter;
import superfacil.com.superfacil.model.Compra;

/**
 * Created by Uriel on 23/04/2016.
 */
public class HistorialComprasFragment extends Fragment {
    private RecyclerView rv;
    private List<Compra> list;
    private RVHistorialAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        try {
            initializeData();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_historial_compras, parent, false);
        rv = (RecyclerView) v.findViewById(R.id.rv_historial_compras);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(llm);
        adapter = new RVHistorialAdapter(list);
        rv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        return v;
    }

    private void initializeData() throws ParseException {
        list = new ArrayList<Compra>();
        Compra compra = new Compra();
        compra.setIdCompra(1);
        compra.setEnCamino(true);
        compra.setEntregado(false);
        compra.setFecha(new Date(1461173013000l));
        compra.setFechaEntrega(null);
        compra.setSubtotal(230.23f);
        compra.setIva((float)(compra.getSubtotal() * 0.16));
        compra.setTotal(compra.getSubtotal() + compra.getIva());

        list.add(compra);

        Compra compra2 = new Compra();
        compra2.setIdCompra(1);
        compra2.setEnCamino(false);
        compra2.setEntregado(true);
        compra2.setFecha(new Date(1455127392000l));
        compra2.setFechaEntrega(new Date(1455145235000l));
        compra2.setSubtotal(521.24f);
        compra2.setIva((float)(compra2.getSubtotal() * 0.16));
        compra2.setTotal(compra2.getSubtotal() + compra2.getIva());
        list.add(compra2);
    }
}
