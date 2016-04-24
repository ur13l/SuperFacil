package superfacil.com.superfacil;

import android.app.Application;
import android.util.Log;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import superfacil.com.superfacil.activities.ContentActivity;
import superfacil.com.superfacil.model.Product;
import superfacil.com.superfacil.model.ShopingList;
import superfacil.com.superfacil.model.realm.RealmService;
import superfacil.com.superfacil.utilities.DataHelper;

/**
 * Created by edgarperez on 4/23/16.
 */
public class AppController extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        InitRealmConfiguration();

        //RealmResults<ShopingList> shopingLists = RealmService.getAllShoppingLists(RealmService.getInstace());

        //Log.i("", "");
    }

    private void InitRealmConfiguration(){
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this)
                .name("SuperFacil.realm")
                .build();

        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
