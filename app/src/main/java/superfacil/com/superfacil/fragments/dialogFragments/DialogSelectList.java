package superfacil.com.superfacil.fragments.dialogFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import io.realm.RealmResults;
import superfacil.com.superfacil.R;
import superfacil.com.superfacil.adapters.ProductsAdapter;
import superfacil.com.superfacil.adapters.ShopingListAdapter;
import superfacil.com.superfacil.model.Product;
import superfacil.com.superfacil.model.ShopingList;
import superfacil.com.superfacil.model.realm.RealmService;

/**
 * Created by edgarperez on 4/24/16.
 */
public class DialogSelectList extends DialogFragment {

    public static final String TAG = DialogSelectList.class.getSimpleName();

    private ListView mList;
    private ShopingListAdapter mAdapter;
    private RealmResults<ShopingList> mShopingLists;
    private Product mProduct;

    public static DialogSelectList newInstance(RealmResults<ShopingList> shopingLists, Product product){
        DialogSelectList dialogSelectList = new DialogSelectList();
        dialogSelectList.setList(shopingLists);
        dialogSelectList.setProduct(product);

        return dialogSelectList;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.dialog_shoping_list, container, false);

        return rootview;
    }

    public void setList(RealmResults<ShopingList> shopingLists){
        mShopingLists = shopingLists;
    }

    public void setProduct(Product product){
        mProduct = product;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        mList = (ListView) view.findViewById(R.id.list_shopping);
        mAdapter = new ShopingListAdapter(mShopingLists, getActivity());
        mList.setAdapter(mAdapter);
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                RealmService.addProduct(mShopingLists.get(position), mProduct, RealmService.getInstace());
                dismiss();
                Toast.makeText(getActivity(), R.string.product_added, Toast.LENGTH_SHORT).show();
            }
        });

        getDialog().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }
}
