package br.com.product.registry.repository;

import br.com.product.registry.model.Category;
import br.com.product.registry.model.Product;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProductsCollectionRepository {

    private static List<Product> productList = new ArrayList<>();



    public static List<Product> findAll() {
        return productList;
    }

    public static Product save(Product product) {
        if (!productList.contains(product)) {
            product.setId((long) productList.size() + 1);
            productList.add(product);
            return product;
        }
        return null;
    }

    public static List<Product> findByCategory(Category category) {
        return productList.stream().filter(product -> product.getCategory().equals(category)).toList();
    }

    public static Product findById(Long id) {
        return productList.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}