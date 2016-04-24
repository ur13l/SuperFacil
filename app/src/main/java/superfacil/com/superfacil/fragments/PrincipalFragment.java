package superfacil.com.superfacil.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import superfacil.com.superfacil.R;
import superfacil.com.superfacil.callbacks.FragmentCallbacks;

/**
 * Created by Uriel on 23/04/2016.
 */
public class PrincipalFragment extends Fragment {

    private FragmentCallbacks mFragmentCallbacks;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mFragmentCallbacks = (FragmentCallbacks) activity;
        }catch (ClassCastException e){
            throw new ClassCastException("Activity " + activity + " must implement FragmentCallback interface");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_principal, parent, false);

        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.search_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.search:
                LoadSearchFragment();
        }

        return super.onOptionsItemSelected(item);
    }

    private void LoadSearchFragment(){
        if (mFragmentCallbacks != null){
            mFragmentCallbacks.showFragmentSearch();
        }
    }
}
