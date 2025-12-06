package br.com.product.registry.repository;

import br.com.product.registry.model.Category;
import java.util.ArrayList;
import java.util.List;
public class CategoryCollectionRepository {

    private static final List<Category> categoryList = new ArrayList<>();



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
        boolean exists = categoryList.stream()
                .anyMatch(c -> c.getName().trim().equalsIgnoreCase(category.getName().trim()));

        if (!exists) {
            category.setId((long) categoryList.size() + 1);
            categoryList.add(category);
            return category;
        }

        return null;
    }

}
