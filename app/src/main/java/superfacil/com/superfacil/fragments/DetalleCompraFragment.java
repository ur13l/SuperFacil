package superfacil.com.superfacil.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import superfacil.com.superfacil.R;
import superfacil.com.superfacil.model.Product;


/**
 * Created by Uriel on 23/04/2016.
 */
public class DetalleCompraFragment extends Fragment {
    private ImageView imageView;
    private RecyclerView rv;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        AppCompatActivity appcom = (AppCompatActivity) getActivity();
        appcom.getSupportActionBar().setDisplayShowHomeEnabled(true);
        appcom.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        appcom.getSupportActionBar().setHomeButtonEnabled(true);
        appcom.getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
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
        return v;
    }

    public ArrayList<Product> getProductosDeCompra(int idCompra){
        ArrayList<Product> list = new ArrayList<>();

        return list;
    }

    public static DetalleCompraFragment newInstance(long idCompra){
        DetalleCompraFragment fragment = new DetalleCompraFragment();
        Bundle args = new Bundle();
        args.putLong("id_compra", idCompra);
        fragment.setArguments(args);
        return fragment;
    }
}
