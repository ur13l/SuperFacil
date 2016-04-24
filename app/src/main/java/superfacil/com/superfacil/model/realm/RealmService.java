package superfacil.com.superfacil.model.realm;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;
import superfacil.com.superfacil.model.Product;
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

    public static void addProduct(ShopingList shoppingList, Product product, Realm realm){

        realm.beginTransaction();

        RealmList<Product> realmResults = shoppingList.getProducts();
        realmResults.add(product);

        realm.commitTransaction();

    }

    public static void deleteProduct(RealmList<Product> products, Product product, Realm realm){
        realm.beginTransaction();

        products.remove(product);

        realm.commitTransaction();
    }
}
