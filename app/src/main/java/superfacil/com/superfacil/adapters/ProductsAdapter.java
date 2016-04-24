package superfacil.com.superfacil.adapters;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import io.realm.RealmResults;
import superfacil.com.superfacil.R;
import superfacil.com.superfacil.fragments.dialogFragments.DialogSelectList;
import superfacil.com.superfacil.model.Product;
import superfacil.com.superfacil.model.ShopingList;
import superfacil.com.superfacil.model.realm.RealmService;

/**
 * Created by edgarperez on 4/23/16.
 */
public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {

    public List<Product> mProducts;
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

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView imageProduct;
        public TextView productTitle;
        public TextView productPrice;
        public ImageView addList;

        public ViewHolder(View itemView) {
            super(itemView);

            imageProduct = (ImageView) itemView.findViewById(R.id.image_product);
            productTitle = (TextView) itemView.findViewById(R.id.name_product);
            productPrice = (TextView) itemView.findViewById(R.id.price_product);
            addList = (ImageView) itemView.findViewById(R.id.add_list);

            addList.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            RealmResults<ShopingList> shopingLists = RealmService.getAllShoppingLists(RealmService.getInstace());

            AppCompatActivity activity = (AppCompatActivity) itemView.getContext();
            DialogSelectList dialogSelectList = DialogSelectList.newInstance(shopingLists, mProducts.get(getAdapterPosition()));
            dialogSelectList.show(activity.getSupportFragmentManager(), DialogSelectList.TAG);
        }
    }
}
