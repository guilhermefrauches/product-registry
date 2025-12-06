package br.com.product.registry.controller;

import br.com.product.registry.model.Category;
import br.com.product.registry.model.Product;
import br.com.product.registry.repository.CategoryCollectionRepository;
import br.com.product.registry.repository.ProductsCollectionRepository;
import br.com.product.registry.view.CategoryView;
import br.com.product.registry.view.Options;
import br.com.product.registry.view.OptionsView;
import br.com.product.registry.view.ProductView;

import javax.swing.*;
import java.util.List;

public class MenuController {

    public void start() {
        Options options = null;

        do {
            options = OptionsView.select();

            if (options == null || options == Options.FINISH) {
                finish();
                break;
            }

            switch (options) {
                case REGISTER_CATEGORY -> registerCategory();
                case REGISTER_PRODUCT -> registerProduct();
                case CHANGE_PRODUCT -> changeProduct();
                case VIEW_PRODUCT_BY_ID -> viewProductById();
                case VIEW_PRODUCT_BY_CATEGORY -> viewProductByCategory();
                case FINISH -> finish();
            }

        } while (options != Options.FINISH);
    }

    private void registerCategory() {
        CategoryView view = new CategoryView();
        Category category = view.form(new Category());

        if (category != null) {
            Category saved = CategoryCollectionRepository.save(category);
            if (saved != null) {
                view.sucess(saved);
            } else {
                JOptionPane.showMessageDialog(null, "Category already exists!");
            }
        }
    }

    private void registerProduct() {
        if (CategoryCollectionRepository.findAll().isEmpty()) {
            JOptionPane.showMessageDialog(null, "You need to register a Category first!");
            return;
        }

        Product product = ProductView.form(new Product());

        if (product != null) {
            Product saved = ProductsCollectionRepository.save(product);
            if (saved != null) {
                ProductView.sucess(saved);
            } else {
                JOptionPane.showMessageDialog(null, "Product already exists!");
            }
        }
    }

    private void changeProduct() {
        if (ProductsCollectionRepository.findAll().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No products registered to change!");
            return;
        }

        Product product = ProductView.select(null);
        if (product != null) {
            ProductView.update(product);
        }
    }

    private void viewProductById() {
        if (ProductsCollectionRepository.findAll().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No products registered!");
            return;
        }

        String inputId = JOptionPane.showInputDialog(null, "Digite o ID do Produto:");

        if (inputId == null || inputId.trim().isEmpty()) {
            return;
        }

        try {
            Long id = Long.parseLong(inputId);
            Product product = ProductsCollectionRepository.findById(id);

            if (product != null) {
                ProductView.show(product);
            } else {
                JOptionPane.showMessageDialog(null, "There is no product with ID: " + id);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid ID! Please enter only numbers!");
        }
    }

    private void viewProductByCategory() {
        if (CategoryCollectionRepository.findAll().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No categories registered!");
            return;
        }

        Category category = CategoryView.select(null);

        if (category == null) return;

        List<Product> products = ProductsCollectionRepository.findByCategory(category);

        if (products.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nothing found in category: " + category.getName() + "!");
        } else {
            products.forEach(ProductView::show);
        }
    }

    private void finish() {
        System.exit(0);
    }
}