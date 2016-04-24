package superfacil.com.superfacil.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import superfacil.com.superfacil.R;
import superfacil.com.superfacil.model.Product;

/**
 * Created by edgarperez on 4/23/16.
 */
public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {

    private List<Product> mProducts;
    private Context mContext;

    public ProductsAdapter(List<Product> products, Context context){
        this.mProducts = products;
        this.mContext = context;
    }

    public void setProducts(List<Product> products){
        mProducts = products;
        notifyDataSetChanged();
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Product product = mProducts.get(position);

        Glide.with(mContext).load(product.getImage()).crossFade().into(holder.imageProduct);
        holder.productTitle.setText(product.getNombre());
        holder.productPrice.setText(String.valueOf(product.getPrecio()));
    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView imageProduct;
        public TextView productTitle;
        public TextView productPrice;
        public ImageView addList;

        public ViewHolder(View itemView) {
            super(itemView);

            imageProduct = (ImageView) itemView.findViewById(R.id.image_product);
            productTitle = (TextView) itemView.findViewById(R.id.name_product);
            productPrice = (TextView) itemView.findViewById(R.id.price_product);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
