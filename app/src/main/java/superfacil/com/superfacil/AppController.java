package superfacil.com.superfacil;

import android.app.Application;
import android.util.Log;

import java.util.List;

import superfacil.com.superfacil.activities.ContentActivity;
import superfacil.com.superfacil.model.Product;
import superfacil.com.superfacil.utilities.DataHelper;

/**
 * Created by edgarperez on 4/23/16.
 */
public class AppController extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        List<Product> products = DataHelper.getFakeData(this);

        Log.i("", "");
    }
}
