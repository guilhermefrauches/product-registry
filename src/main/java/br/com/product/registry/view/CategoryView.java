package br.com.product.registry.view;

import br.com.product.registry.model.Category;
import br.com.product.registry.repository.CategoryCollectionRepository;

import javax.swing.*;

public class CategoryView {
    static CategoryCollectionRepository repository;

    public static Category select (Category category) {
        Category ret = (Category) JOptionPane.showInputDialog(
                null,
                "Select an option:",
                "Menu",
                JOptionPane.QUESTION_MESSAGE,
                null,
                repository.findAll().toArray(),
                category == null ? 1 : category);
        return ret;
    }

    public void sucess (){
        JOptionPane.showMessageDialog(null, "Category saved successfully!");
    }

    public void sucess (Category category){
        JOptionPane.showMessageDialog(null, "Category " + category.getName() + " saved successfully!");
    }

    public static Category form(){
        String name = JOptionPane.showInputDialog(null, "Enter the category name");
        return  new Category(name);
    }


}
