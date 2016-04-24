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
import superfacil.com.superfacil.fragments.DetalleCompra;
import superfacil.com.superfacil.fragments.DetalleCompraFragment;
import superfacil.com.superfacil.model.Compra;
import superfacil.com.superfacil.utilities.MathFormat;

/**
 * Created by Uriel on 23/04/2016.
 */
public class RVHistorialAdapter extends RecyclerView.Adapter<RVHistorialAdapter.HistorialViewHolder> {
    public static List<Compra> list;

    public RVHistorialAdapter(List<Compra> list){
        this.list = list;
    }

    @Override
    public HistorialViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_compra, parent, false);
        HistorialViewHolder pvh = new HistorialViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(HistorialViewHolder holder, int position) {

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat df2 = new SimpleDateFormat("dd/MM/yyyy 'a las' HH:mm");
        Date fecha = list.get(position).getFecha();
        Date fechaEntrega = list.get(position).getFechaEntrega();
        String strFecha = df.format(fecha);
        boolean entregado = list.get(position).isEntregado();
        boolean enviado = list.get(position).isEnCamino();

       holder.title.setText("Compra del " + strFecha);
        holder.total.setText("$"+MathFormat.removeDots((float)MathFormat.round((double) list.get(position).getTotal(),2)));
        if(entregado) {

            String strFechaEntrega = df.format(fechaEntrega);
            holder.description.setText("Entregado el " + strFechaEntrega);
            holder.status.setImageResource(R.drawable.entregado);
        }
        else if(enviado){
            holder.description.setText("En camino... ");
            holder.status.setImageResource(R.drawable.enviado);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public Compra getItem(int pos){
        return list.get(pos);
    }


    public void setFilter(List<Compra> list) {
        list = new ArrayList<>();
        list.addAll(list);
        notifyDataSetChanged();
    }


    public static class HistorialViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        TextView description;
        TextView total;
        ImageView status;

        HistorialViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);
            status = (ImageView) itemView.findViewById(R.id.status);
            total = (TextView) itemView.findViewById(R.id.total);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            AppCompatActivity a = (AppCompatActivity)v.getContext();
            FragmentManager fm = a.getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            Fragment f = DetalleCompraFragment.newInstance(list.get(this.getAdapterPosition()).getIdCompra(), list.get(this.getAdapterPosition()).getSubtotal(),
                    list.get(this.getAdapterPosition()).isEntregado());
            ft.replace(R.id.fragment_container, f)
                    .addToBackStack(null)
                    .commit();

        }
    }

}
