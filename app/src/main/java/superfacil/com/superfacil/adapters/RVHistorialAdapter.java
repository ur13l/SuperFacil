package superfacil.com.superfacil.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import superfacil.com.superfacil.R;
import superfacil.com.superfacil.model.Compra;

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
       /*
        holder.nombre.setText(directorio.get(position).getNombre());
        holder.telefono.setText(directorio.get(position).getTelefono());
        holder.direccion.setText(directorio.get(position).getDireccion());
        Picasso.with(holder.image.getContext()).load("https://scontent-atl3-1.xx.fbcdn.net/hphotos-xta1/v/t1.0-9/12631273_1130437723656560_589676129209315058_n.jpg?_nc_eui=ARjemxZWiglR9GTDbDpwdIEKt1vEoJcyadiKfNmq_e9idtveI6TSGg&oh=fcc864d2883d28a9ad1d493c7c202bc4&oe=57931F0A")
                .placeholder(R.drawable.user)
                .into(holder.image);
                */
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
        ImageView status;

        HistorialViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            View parent = (View)v.getParent().getParent().getParent();

        }
    }

}
