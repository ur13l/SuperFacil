package superfacil.com.superfacil.utilities;

import android.app.Activity;
import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import superfacil.com.superfacil.R;
import superfacil.com.superfacil.model.Product;

/**
 * Created by edgarperez on 4/23/16.
 */
public class DataHelper {

    public static List<Product> getFakeData(Context activity){
        List<Product> products = new ArrayList<>();

        String[] images = activity.getResources().getStringArray(R.array.images);
        String[] prodKeys = activity.getResources().getStringArray(R.array.product);
        String[] prices = activity.getResources().getStringArray(R.array.prices);

        for (int i=0; i<20; i++){
            Product product = new Product();
            product.setId(randInt(1, 1000));

            int prodNum = randInt(1, 8);
            product.setImage(images[prodNum]);
            product.setNombre(prodKeys[prodNum]);
            product.setPrecio(Double.parseDouble(prices[prodNum]));

            products.add(product);
        }

        return products;
    }

    private static int randInt(int min, int max) {
        Random rand = new Random();

        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
}
