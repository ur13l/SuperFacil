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

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import superfacil.com.superfacil.R;
import superfacil.com.superfacil.fragments.DetalleCompraFragment;
import superfacil.com.superfacil.model.Product;
import superfacil.com.superfacil.utilities.MathFormat;

/**
 * Created by Uriel on 23/04/2016.
 */
public class RVDetalleCompraAdapter extends RecyclerView.Adapter<RVDetalleCompraAdapter.DetalleCompraViewHolder> {
    public static List<Product> list;

    public RVDetalleCompraAdapter(List<Product> list){
        this.list = list;
    }

    @Override
    public DetalleCompraViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_producto_simple, parent, false);
        DetalleCompraViewHolder pvh = new DetalleCompraViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(DetalleCompraViewHolder holder, int position) {
        holder.nombre.setText(list.get(position).getNombre());
        holder.precio.setText("$"+MathFormat.removeDots((float)MathFormat.round(list.get(position).getPrecio(),2))+".00");
        Glide.with(holder.imagen.getContext()).load(list.get(position).getImage()).crossFade().into(holder.imagen);

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public Product getItem(int pos){
        return list.get(pos);
    }


    public void setFilter(List<Product> list) {
        list = new ArrayList<>();
        list.addAll(list);
        notifyDataSetChanged();
    }


    public static class DetalleCompraViewHolder extends RecyclerView.ViewHolder {
        TextView nombre;
        ImageView imagen;
        TextView precio;

        DetalleCompraViewHolder(View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.name_product);
            imagen = (ImageView) itemView.findViewById(R.id.image_product);
            precio = (TextView) itemView.findViewById(R.id.precio);

        }

    }

}
