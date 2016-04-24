package superfacil.com.superfacil.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String fecha = df.format(list.get(position).getFecha());
        holder.title.setText("Compra del " + fecha);
        holder.description.setText("");
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
            description = (TextView) itemView.findViewById(R.id.description);
            status = (ImageView) itemView.findViewById(R.id.status);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            View parent = (View)v.getParent().getParent().getParent();

        }
    }

}
