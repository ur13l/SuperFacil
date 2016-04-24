package superfacil.com.superfacil.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import superfacil.com.superfacil.R;

/**
 * Created by edgarperez on 4/23/16.
 */
public class SearchFragment extends Fragment {

    private RecyclerView mProducts;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
    }
}
