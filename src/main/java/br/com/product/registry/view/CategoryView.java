package br.com.product.registry.view;

import br.com.product.registry.model.Category;
import br.com.product.registry.repository.CategoryCollectionRepository;

import javax.swing.*;

public class CategoryView {

    public static Category select (Category category) {
        Object ret = JOptionPane.showInputDialog(
                null,
                "Select an option:",
                "Menu",
                JOptionPane.QUESTION_MESSAGE,
                null,
                CategoryCollectionRepository.findAll().toArray(),
                category == null ? null : category);
        return (Category) ret;
    }

    public void sucess (Category category){
        JOptionPane.showMessageDialog(null, "Category " + category.getName() + " saved successfully!");
    }

    public static Category form(Category category){
        String name = JOptionPane.showInputDialog(null, "Enter the category name", category!= null? category.getName(): "");

        if (name == null || name.trim().isEmpty()) {
            return null;
        }

        return new Category(name);
    }
}