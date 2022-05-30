package service;

import model.Product;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public  class ProductServicelmpl implements ProductService {
    static Map<Integer, Product> map;

    static {
        map = new HashMap<>();

        map.put(1, new Product(1, "xa phong", "dn", 22000));
        map.put(2, new Product(2, "xa phong1", "dn", 20000));
        map.put(3, new Product(3, "xa phong2", "dn", 20000));
        map.put(4, new Product(4, "xa phong3", "dn", 20000));
        map.put(5, new Product(5, "xa phong4", "dn", 20000));
    }

    @Override
    public List<Product> displayProduct() {
        return new ArrayList<>(map.values());
    }

    @Override
    public void creatProduct(Product product) {
        map.put(product.getId(), product);

    }

    @Override
    public void editProduct(int id, Product product) {
        map.put(id, product);
    }


    @Override
    public void deleteProduct(int id) {
        map.remove(id);
    }

    @Override
    public Product viewProduct(int id) {
        return map.get(id);
    }

    @Override
    public Product searchProduct(String name) {
        for (Map.Entry<Integer,Product> temp : map.entrySet()) {
            if (temp.getValue().getName().contains(name)){
                return temp.getValue() ;
            }
        }
        return null;

    }


}
