package br.com.product.registry.repository;

import br.com.product.registry.model.Category;
import br.com.product.registry.model.Product;

import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import java.util.List;
import java.util.Vector;


public class ProductsCollectionRepository {

    private static List <Product>  productList;

    static  {

        productList = new Vector<Product>();

        Product cell = new Product();

        cell.setName("Iphone 14 Pro Max")
                .setDescription("Cell Phone of the apple")
                .setCategory(CategoryCollectionRepository.findById(2L))
                .setCreationDate(LocalDateTime.now())
                .setPrice(BigDecimal.valueOf(12000));

        save(cell);

    }

    public static List <Product> findAll()
    {
        return productList;
    }

    public static Product save(Product product) {
        if (!productList.contains(product)) {
            product.setId((long) productList.size() + 1);
            productList.add(product);
            return product;
        } else  {
            JOptionPane.showMessageDialog(null, "Product already exists!");
            return null;
        }

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
