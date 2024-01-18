package forkJoin;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by kantipin on 21.05.2016.
 */
public class ProductListGenerator {

    public static List<Product> generate(int size) {
        List result = new ArrayList<Product>();
        for (int i = 0; i < size; i++) {
            Product p = new Product();
            p.setName("Product" + i);
            p.setPrice(10);
            result.add(p);
        }
        return result;
    }
}
