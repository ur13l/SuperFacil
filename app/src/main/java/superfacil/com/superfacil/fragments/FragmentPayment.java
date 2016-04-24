package superfacil.com.superfacil.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import superfacil.com.superfacil.R;

/**
 * Created by edgarperez on 4/24/16.
 */
public class FragmentPayment extends Fragment {

    public static final String TAG = FragmentPayment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.select_pay, container, false);

        return rootView;
    }
}
