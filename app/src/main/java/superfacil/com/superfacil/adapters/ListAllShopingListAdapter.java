package superfacil.com.superfacil.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import io.realm.RealmResults;
import superfacil.com.superfacil.R;
import superfacil.com.superfacil.model.ShopingList;

/**
 * Created by edgarperez on 4/24/16.
 */
public class ListAllShopingListAdapter extends BaseAdapter {

    private RealmResults<ShopingList> mShopingLists;
    private Context mContext;

    public ListAllShopingListAdapter(RealmResults<ShopingList> shopingLists, Context context) {
        mShopingLists = shopingLists;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mShopingLists.size();
    }

    @Override
    public Object getItem(int position) {
        return mShopingLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mShopingLists.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        View view = convertView;

        if (view == null){
            viewHolder = new ViewHolder();

            view = LayoutInflater.from(mContext).inflate(R.layout.shopping_item, parent, false);
            viewHolder.title = (TextView) view.findViewById(R.id.title);
            viewHolder.date = (TextView) view.findViewById(R.id.date);

            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        ShopingList shoppingList = mShopingLists.get(position);

        viewHolder.title.setText(shoppingList.getName());
        viewHolder.date.setText(shoppingList.getDate());

        return view;
    }

    static class ViewHolder{
        TextView title;
        TextView date;
    }
}
