package superfacil.com.superfacil.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import io.realm.RealmList;
import superfacil.com.superfacil.R;
import superfacil.com.superfacil.adapters.DetailShppingAdapter;
import superfacil.com.superfacil.model.Product;

/**
 * Created by edgarperez on 4/24/16.
 */
public class FragmentDetailShopping extends Fragment {

    public static final String TAG = FragmentDetailShopping.class.getSimpleName();
    private ListView mProductsList;
    private DetailShppingAdapter mAdapter;
    private RealmList<Product> mProducts;

    private Button mPay;

    public static FragmentDetailShopping newInstance(RealmList<Product> products){
        FragmentDetailShopping fragmentDetailShopping = new FragmentDetailShopping();
        fragmentDetailShopping.setProducts(products);

        return fragmentDetailShopping;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail_shopping, container, false);

        InitViews(rootView);

        return rootView;
    }

    private void InitViews(View rootView){
        mProductsList = (ListView) rootView.findViewById(R.id.products_list);
        mAdapter = new DetailShppingAdapter(mProducts, getActivity());
        mProductsList.setAdapter(mAdapter);

        mPay = (Button) rootView.findViewById(R.id.pay);
        mPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPayment();
            }
        });
    }

    public void setProducts(RealmList<Product> products){
        mProducts = products;
    }

    private void ShowPayment(){
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new FragmentPayment())
                .addToBackStack(FragmentPayment.TAG)
                .commit();
    }
}
