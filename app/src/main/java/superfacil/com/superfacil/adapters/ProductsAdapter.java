package superfacil.com.superfacil.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import superfacil.com.superfacil.R;
import superfacil.com.superfacil.model.Product;

/**
 * Created by edgarperez on 4/23/16.
 */
public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {

    public List<Product> mProducts;

    public Pro

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView imageProduct;
        public TextView productTitle;
        public TextView productPrice;
        public ImageView addList;

        public ViewHolder(View itemView) {
            super(itemView);

            imageProduct = (ImageView) itemView.findViewById(R.id.image_product);
            productTitle = (TextView) itemView.findViewById(R.id.name_product);
            productPrice = (TextView) itemView.findViewById(R.id.price_product);
        }
    }
}
