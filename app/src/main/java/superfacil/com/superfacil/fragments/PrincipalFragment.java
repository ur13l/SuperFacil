package superfacil.com.superfacil.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import superfacil.com.superfacil.R;

/**
 * Created by Uriel on 23/04/2016.
 */
public class PrincipalFragment extends Fragment {

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
}
