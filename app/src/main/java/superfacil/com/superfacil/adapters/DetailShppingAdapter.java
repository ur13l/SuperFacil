package superfacil.com.superfacil.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import io.realm.Realm;
import io.realm.RealmList;
import superfacil.com.superfacil.R;
import superfacil.com.superfacil.model.Product;
import superfacil.com.superfacil.model.realm.RealmService;

/**
 * Created by edgarperez on 4/24/16.
 */
public class DetailShppingAdapter extends BaseAdapter {

    private RealmList<Product> mProducts;
    private Context mContext;

    public DetailShppingAdapter(RealmList<Product> products, Context context) {
        mProducts = products;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mProducts.size();
    }

    @Override
    public Object getItem(int position) {
        return mProducts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mProducts.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder = null;

        if (view == null){
            viewHolder = new ViewHolder();

            view = LayoutInflater.from(mContext).inflate(R.layout.detail_shpping_item, parent, false);

            viewHolder.productImage = (ImageView) view.findViewById(R.id.image_product);
            viewHolder.productTitle = (TextView) view.findViewById(R.id.name_product);
            viewHolder.productPrice = (TextView) view.findViewById(R.id.price_product);
            viewHolder.deleteProduct = (ImageView) view.findViewById(R.id.delete_product);

            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        final Product product = mProducts.get(position);

        Glide.with(mContext).load(product.getImage()).crossFade().into(viewHolder.productImage);
        viewHolder.deleteProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(mContext)
                        .setTitle(R.string.delete)
                        .setMessage(R.string.delete_product)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                RealmService.deleteProduct(mProducts, product, RealmService.getInstace());
                                notifyDataSetChanged();
                                dialog.dismiss();
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
            }
        });
        viewHolder.productTitle.setText(product.getNombre());
        viewHolder.productPrice.setText(String.valueOf(product.getPrecio()));

        return view;
    }

    static class ViewHolder{
        ImageView productImage;
        ImageView deleteProduct;
        TextView productTitle;
        TextView productPrice;
    }
}
