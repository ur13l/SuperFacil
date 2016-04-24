package superfacil.com.superfacil.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import superfacil.com.superfacil.R;
import superfacil.com.superfacil.adapters.ProductsAdapter;
import superfacil.com.superfacil.callbacks.BackCallback;
import superfacil.com.superfacil.model.Product;
import superfacil.com.superfacil.utilities.DataHelper;

/**
 * Created by edgarperez on 4/23/16.
 */
public class SearchFragment extends Fragment {

    public static final String TAG = SearchFragment.class.getSimpleName();

    private RecyclerView mProducts;
    private ProductsAdapter mProductsAdapter;
    private List<Product> mListProducts;
    private TextView mEmptyView;

    private BackCallback mBackCallback;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mBackCallback = (BackCallback) activity;
        }catch (ClassCastException e){
            throw new ClassCastException("Activity " + activity + " must implement BackCallback interface");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mListProducts = DataHelper.getFakeData(getActivity());

        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);

        InitViews(rootView);

        return rootView;
    }

    private void InitViews(View rootView){
        mProducts = (RecyclerView) rootView.findViewById(R.id.products_recycler_view);
        mEmptyView = (TextView) rootView.findViewById(R.id.empty_view);

        List<Product> products = new ArrayList<>();

        mProductsAdapter = new ProductsAdapter(products, getActivity());

        mProducts.setLayoutManager(new LinearLayoutManager(getActivity()));
        mProducts.setAdapter(mProductsAdapter);
        LoadEmptyDataState();
    }

    private void LoadEmptyDataState(){
        if (mProductsAdapter.getItemCount() == 0) {
            mProducts.setVisibility(View.GONE);
            mEmptyView.setVisibility(View.VISIBLE);
        }
        else {
            mProducts.setVisibility(View.VISIBLE);
            mEmptyView.setVisibility(View.GONE);
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        MenuItem item = menu.add("Search");
        item.setIcon(R.drawable.ic_search);
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        SearchView sv = new SearchView(getActivity());
        sv.setIconified(false);

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(final String query) {
                if (query.length() > 0){
                    final List<Product> filteredModelList = filter(mListProducts, query);
                    if (mProductsAdapter != null){
                        mProductsAdapter.setProducts(filteredModelList);
                        LoadEmptyDataState();
                    }
                }else {
                    ResetAdapter();
                }
                return true;
            }
        });
        item.setActionView(sv);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    private List<Product> filter(List<Product> models, String query) {
        query = query.toLowerCase();

        final List<Product> filteredModelList = new ArrayList<>();
        for (Product model : models) {
            final String text = model.getNombre().toLowerCase();
            if (text.contains(query)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }

    private void ResetAdapter(){
        ArrayList<Product> products = new ArrayList<>();
        if (mProductsAdapter != null){
            mProductsAdapter.setProducts(products);
            LoadEmptyDataState();
        }
    }

    private void onBackPressed(){
        mBackCallback.onBackPressedCallback();
    }
}
