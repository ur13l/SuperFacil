package superfacil.com.superfacil.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import superfacil.com.superfacil.R;
import superfacil.com.superfacil.adapters.RVDetalleCompraAdapter;
import superfacil.com.superfacil.adapters.RVHistorialAdapter;
import superfacil.com.superfacil.model.Product;
import superfacil.com.superfacil.utilities.DataHelper;
import superfacil.com.superfacil.utilities.MathFormat;


/**
 * Created by Uriel on 23/04/2016.
 */
public class DetalleCompraFragment extends Fragment {
    private ImageView imageView;
    private RecyclerView rv;
    private List<Product> mListProducts;
    private RVDetalleCompraAdapter adapter;
    private TextView subtotal;
    private TextView iva;
    private TextView total;
    private Button repetir;
    private Button cancelar;
    private Button rastrear;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        AppCompatActivity appcom = (AppCompatActivity) getActivity();
        appcom.getSupportActionBar().setDisplayShowHomeEnabled(true);
        appcom.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        appcom.getSupportActionBar().setHomeButtonEnabled(true);
        appcom.getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        mListProducts = DataHelper.getFakeDataSelected(getActivity(), getArguments().getInt("id_compra"));
        //setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_detalle_compra, parent, false);
        imageView = (ImageView) v.findViewById(R.id.img_tv);
        rv = (RecyclerView) v.findViewById(R.id.rv_detalle_compra);
        Picasso.with(imageView.getContext()).load("http://steezo.com/wp-content/uploads/2012/12/man-in-suit2.jpg")
                .placeholder(R.drawable.user)
                .into(imageView);

        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(llm);
        adapter = new RVDetalleCompraAdapter(mListProducts);
        rv.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        subtotal = (TextView) v.findViewById(R.id.subtotal);
        iva = (TextView) v.findViewById(R.id.iva);
        total = (TextView) v.findViewById(R.id.total);

        float st = getArguments().getFloat("subtotal");
        subtotal.setText("Subtotal: $"+st);
        iva.setText("IVA: $"+ MathFormat.removeDots((float)(MathFormat.round(st *0.16, 2))));
        total.setText("Total: $"+  MathFormat.removeDots((float)(MathFormat.round((st)+(st*0.16), 2))));

        repetir = (Button) v.findViewById(R.id.repetir);
        cancelar = (Button) v.findViewById(R.id.cancelar);
        rastrear = (Button) v.findViewById(R.id.rastrear);
        boolean entregado = getArguments().getBoolean("entregado");
        if(!entregado){
            repetir.setVisibility(View.GONE);
            cancelar.setVisibility(View.VISIBLE);
            rastrear.setVisibility(View.VISIBLE);

            rastrear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager fm = getActivity().getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    Fragment f = new MapFragment();

                    ft.replace(R.id.fragment_container, f)
                    .addToBackStack(null).commit();
                }
            });
        }
        return v;
    }

    public ArrayList<Product> getProductosDeCompra(int idCompra){
        ArrayList<Product> list = new ArrayList<>();

        return list;
    }

    public static DetalleCompraFragment newInstance(long idCompra, float subtotal, boolean isEntregado){
        DetalleCompraFragment fragment = new DetalleCompraFragment();
        Bundle args = new Bundle();
        args.putLong("id_compra", idCompra);
        args.putFloat("subtotal", subtotal);
        args.putBoolean("entregado", isEntregado);
        fragment.setArguments(args);
        return fragment;
    }
}
