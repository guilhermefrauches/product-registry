package br.com.product.registry.repository;

import br.com.product.registry.model.Category;
import br.com.product.registry.model.Product;

import javax.swing.*;
import java.util.List;
import java.util.Vector;

public class CategoryCollectionRepository {

    private static List<Category> categoryList;

    static {

        categoryList = new Vector<>();

        Category electronics = new Category("Electronics", 1l);
        Category CellPhones = new Category("Cell Phones", 2l);
        Category Books = new Category("Books", 3l);


        categoryList.add(electronics);
        categoryList.add(CellPhones);
        categoryList.add(Books);

    }

    public static List<Category> findAll() {
        return categoryList;
    }

    public static Category findById(Long id) {
        return categoryList.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }


    public static List<Category> findByName(String name) {
        return categoryList.stream()
                .filter(c -> c.getName().equalsIgnoreCase(name))
                .toList();
    }

    public static Category save(Category category) {
        if (!categoryList.contains(category)) {
            category.setId((long) categoryList.size() + 1);
            categoryList.add(category);
            return category;
        } else {
            JOptionPane.showMessageDialog(null, "Category already exists!");
        }
        return category;
    }

}
