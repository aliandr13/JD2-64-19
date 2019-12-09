package by.it.academy.offer.service;

import by.it.academy.offer.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private static final ProductService INSTANCE = new ProductServiceImpl();

    private final List<Product> products;

    private ProductServiceImpl() {
        products = new ArrayList<>();
        products.add(new Product(1L, "Porsche", 350, "black", "V8", 2015));
        products.add(new Product(2L, "BMW 5", 150, "white", "V6", 2012));
        products.add(new Product(2L, "Subaru", 100, "red", "V6", 2013));
    }

    public static ProductService getService() {
        return INSTANCE;
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public void addNewProduct(Product product) {
        product.setId((long) products.size() + 1);
        products.add(product);
    }

    @Override
    public void deleteProduct(Product id) {
        products.remove(id);
    }

    @Override
    public void update(Product product) {

    }
}
