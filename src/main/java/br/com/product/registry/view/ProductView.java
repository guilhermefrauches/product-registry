package br.com.product.registry.view;

import br.com.product.registry.model.Category;
import br.com.product.registry.model.Product;
import br.com.product.registry.repository.ProductsCollectionRepository;

import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductView {

    public static Product form(Product product) {

        Category category = CategoryView.select(product.getCategory());
        if (category == null) return null;

        String name = JOptionPane.showInputDialog(null, "Enter the product name", product.getName());
        if (name == null) return null;

        String description = JOptionPane.showInputDialog(null, "Enter the product description", product.getDescription());
        if (description == null) return null;

        double price = 0;
        boolean validPrice = false;

        while (!validPrice) {
            String priceInput = JOptionPane.showInputDialog(null, "Enter the product price", product.getPrice());

            if (priceInput == null) return null;

            try {
                price = Double.parseDouble(priceInput);
                if (price > 0) {
                    validPrice = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Price must be greater than zero.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid price! Please numbers only.");
            }
        }

        return product
                .setCategory(category)
                .setName(name)
                .setDescription(description)
                .setCreationDate(LocalDateTime.now())
                .setPrice(BigDecimal.valueOf(price));
    }

    public static void sucess(Product product) {
        JOptionPane.showMessageDialog(null, "Product " + product.getName() + " saved successfully!");
    }

    public static Product select(Product product) {
        Object selection = JOptionPane.showInputDialog(
                null,
                "Select a product:",
                "Menu",
                JOptionPane.QUESTION_MESSAGE,
                null,
                ProductsCollectionRepository.findAll().toArray(),
                product == null ? null : product);

        return (Product) selection;
    }

    public static void update(Product product) {
        Product updatedProduct = form(product);

        if (updatedProduct != null) {
            sucess(updatedProduct);
            show(updatedProduct);
        }
    }

    public static void show(Product product) {
        System.out.println(product );

        String formattedText = String.format( "PRODUCT: " + product.getName() + System.lineSeparator()
                + "DESCRIPTION: " + product.getDescription() + System.lineSeparator()
                + "CATEGORY: " + product.getCategory().toString() + System.lineSeparator()
                + "PRICE: %,.2f ", product.getPrice()
        );

        JOptionPane.showMessageDialog(null, formattedText);
    }
}