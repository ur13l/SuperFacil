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
public class ShopingListAdapter extends BaseAdapter {

    RealmResults<ShopingList> mShoppingLists;
    Context mContext;

    public ShopingListAdapter(RealmResults<ShopingList> shopingLists, Context context){
        this.mShoppingLists = shopingLists;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mShoppingLists.size();
    }

    @Override
    public Object getItem(int position) {
        return mShoppingLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mShoppingLists.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        View view = convertView;

        if (view == null){
            viewHolder = new ViewHolder();

            view = LayoutInflater.from(mContext).inflate(R.layout.item_shoping_list, parent, false);

            viewHolder.title = (TextView) view.findViewById(R.id.shoping_name);

            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.title.setText(mShoppingLists.get(position).getName());

        return view;
    }

    static class ViewHolder{
        public TextView title;
    }
}
