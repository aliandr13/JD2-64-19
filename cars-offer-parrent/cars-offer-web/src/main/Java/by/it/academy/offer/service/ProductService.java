package by.it.academy.offer.service;

import by.it.academy.offer.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    void addNewProduct(Product product);
    void deleteProduct(Product id);
    void update(Product product);
}
