package superfacil.com.superfacil.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import superfacil.com.superfacil.R;
import superfacil.com.superfacil.fragments.DetalleCompraFragment;
import superfacil.com.superfacil.fragments.RegistrarPagoFragment;
import superfacil.com.superfacil.model.Tarjeta;
import superfacil.com.superfacil.utilities.MathFormat;

/**
 * Created by Uriel on 23/04/2016.
 */
public class RVTarjetasAdapter extends RecyclerView.Adapter<RVTarjetasAdapter.TarjetasViewHolder> {
    public static List<Tarjeta> list;

    public RVTarjetasAdapter(List<Tarjeta> list){
        this.list = list;
    }

    @Override
    public TarjetasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_tarjeta, parent, false);
        TarjetasViewHolder pvh = new TarjetasViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(TarjetasViewHolder holder, int position) {


    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public Tarjeta getItem(int pos){
        return list.get(pos);
    }


    public void setFilter(List<Tarjeta> list) {
        list = new ArrayList<>();
        list.addAll(list);
        notifyDataSetChanged();
    }


    public static class TarjetasViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        TarjetasViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            AppCompatActivity a = (AppCompatActivity)v.getContext();
            FragmentManager fm = a.getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            Fragment f = new RegistrarPagoFragment();
            ft.replace(R.id.fragment_container, f)
                    .addToBackStack(null)
                    .commit();

        }
    }

}
