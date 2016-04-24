package superfacil.com.superfacil.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.realm.RealmList;
import superfacil.com.superfacil.R;
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
}
