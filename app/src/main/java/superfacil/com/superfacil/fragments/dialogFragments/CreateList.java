package superfacil.com.superfacil.fragments.dialogFragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import superfacil.com.superfacil.R;
import superfacil.com.superfacil.callbacks.DialogAddListCallback;

/**
 * Created by edgarperez on 4/24/16.
 */
public class CreateList extends DialogFragment implements View.OnClickListener{

    public static final String TAG = CreateList.class.getSimpleName();

    private EditText mEditText;
    private Button mCancel, mOk;

    private DialogAddListCallback mDialogAddListCallback;

    public CreateList() {
        // Empty constructor is required for DialogFragment
        // Make sure not to add arguments to the constructor
        // Use `newInstance` instead as shown below
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_add_list, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Get field from view
        mEditText = (EditText) view.findViewById(R.id.txt_your_name);
        // Show soft keyboard automatically and request focus to field
        mEditText.requestFocus();

        mOk = (Button) view.findViewById(R.id.ok);
        mOk.setOnClickListener(this);

        mCancel = (Button) view.findViewById(R.id.cancel);
        mCancel.setOnClickListener(this);

        getDialog().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cancel:
                Cancel();
                break;
            case R.id.ok:
                Ok();
                break;
        }
    }

    private void Ok(){
        DialogAddListCallback dialogAddListCallback = (DialogAddListCallback) getTargetFragment();
        dialogAddListCallback.okPressed(mEditText.getText().toString());
    }

    private void Cancel(){
        DialogAddListCallback dialogAddListCallback = (DialogAddListCallback) getTargetFragment();
        dialogAddListCallback.cancelPressed();
    }
}
