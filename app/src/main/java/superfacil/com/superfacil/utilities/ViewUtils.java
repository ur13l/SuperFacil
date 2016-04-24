package superfacil.com.superfacil.utilities;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by edgarperez on 4/24/16.
 */
public class ViewUtils {

    public static void HideKeyBoard(Activity activity, View view){
        InputMethodManager imm = (InputMethodManager)
        activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(
                view.getWindowToken(), 0);
    }
}
