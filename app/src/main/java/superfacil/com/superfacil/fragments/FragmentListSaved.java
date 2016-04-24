package superfacil.com.superfacil.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import io.realm.RealmList;
import io.realm.RealmResults;
import superfacil.com.superfacil.R;
import superfacil.com.superfacil.adapters.ListAllShopingListAdapter;
import superfacil.com.superfacil.adapters.ShopingListAdapter;
import superfacil.com.superfacil.callbacks.DialogAddListCallback;
import superfacil.com.superfacil.fragments.dialogFragments.CreateList;
import superfacil.com.superfacil.model.Product;
import superfacil.com.superfacil.model.ShopingList;
import superfacil.com.superfacil.model.realm.RealmService;
import superfacil.com.superfacil.utilities.DataHelper;

/**
 * Created by edgarperez on 4/23/16.
 */
public class FragmentListSaved extends Fragment implements DialogAddListCallback {

    CreateList mDialog;

    private FloatingActionButton mFab;

    private ListView mShopping;
    private ListAllShopingListAdapter mAdapter;
    private RealmResults<ShopingList> mShopingLists;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_shoping_list, container, false);

        InitViews(rootView);

        return rootView;
    }

    private void InitViews(View rootView){
        mFab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowAddList();
            }
        });

        mShopingLists = RealmService.getAllShoppingLists(RealmService.getInstace());
        mShopping = (ListView) rootView.findViewById(R.id.list_shopping);

        mAdapter = new ListAllShopingListAdapter(mShopingLists, getActivity());

        mShopping.setAdapter(mAdapter);
        mShopping.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ShowProductsList(mShopingLists.get(position).getProducts());
            }
        });
    }

    private void ShowAddList(){
        mDialog = new CreateList();
        mDialog.show(getFragmentManager(), mDialog.TAG);
        mDialog.setTargetFragment(this, 0);
    }

    @Override
    public void okPressed(String name) {
        RealmList<Product> products = new RealmList<>();
        ShopingList shopingList = new ShopingList();
        shopingList.setId(DataHelper.randInt(1, 10000));
        shopingList.setName(name);
        shopingList.setDate(DataHelper.now());
        shopingList.setProducts(products);

        RealmService.saveList(shopingList, RealmService.getInstace());

        mDialog.dismiss();
    }

    @Override
    public void cancelPressed() {
        if (mDialog != null){
            mDialog.dismiss();
        }
    }

    private void ShowProductsList(RealmList<Product> products){
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, FragmentDetailShopping.newInstance(products))
                .addToBackStack(FragmentDetailShopping.TAG)
                .commit();
    }
}
