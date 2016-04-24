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

        DateFormat format = new SimpleDateFormat("DD/MM/YYYY hh:mm:ss");
        Compra compra = new Compra();
        compra.setIdCompra(1);
        compra.setEnCamino(false);
        compra.setEntregado(true);
        String fecha1 = "20/04/2016 20:04:23";
        Date date = format.parse(fecha1);
        compra.setFecha(date);
        String fecha2 = "21/04/2016 16:34:23";
        Date date2 = format.parse(fecha2);
        compra.setFechaEntrega(date2);
        compra.setSubtotal(230);
        compra.setIva((float)(compra.getSubtotal() * 1.16));
        compra.setTotal(compra.getSubtotal() + compra.getIva());

        list.add(compra);

        Compra compra2 = new Compra();
        compra.setIdCompra(1);
        compra.setEnCamino(false);
        compra.setEntregado(true);
        String fecha3 = "10/02/2016 12:03:12";
        Date date3 = format.parse(fecha1);
        compra.setFecha(date);
        String fecha4 = "10/02/2016 17:00:35";
        Date date4 = format.parse(fecha2);
        compra.setFechaEntrega(date2);
        compra.setSubtotal(230);
        compra.setIva((float)(compra.getSubtotal() * 1.16));
        compra.setTotal(compra.getSubtotal() + compra.getIva());
        list.add(compra2);
    }
}
