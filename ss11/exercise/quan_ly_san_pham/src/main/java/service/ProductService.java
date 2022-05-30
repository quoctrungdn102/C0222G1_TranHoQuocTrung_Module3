package service;

import model.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
     List<Product> displayProduct();
     void creatProduct(Product product);
     void editProduct(int id,Product product);
     void deleteProduct(int id);
     Product viewProduct(int id);
     Product searchProduct( String name);
}
