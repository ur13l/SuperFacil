package superfacil.com.superfacil.model.realm;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;
import superfacil.com.superfacil.model.ShopingList;

/**
 * Created by edgarperez on 4/24/16.
 */
public class RealmService {

    private static Realm mRealm;

    public static Realm getInstace(){
        if (mRealm == null) {
            mRealm = Realm.getDefaultInstance();
        }

        return mRealm;
    }

    public static RealmResults<ShopingList> getAllShoppingLists(Realm realm){
        return realm.where(ShopingList.class).findAll();
    }

    public static void saveList(ShopingList shopingList, Realm realm){
        realm.beginTransaction();

        realm.copyToRealm(shopingList);

        realm.commitTransaction();
    }
}
