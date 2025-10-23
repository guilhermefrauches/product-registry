package br.com.product.registry.view;

import br.com.product.registry.model.Category;
import br.com.product.registry.model.Product;
import br.com.product.registry.repository.ProductsCollectionRepository;

import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


public class ProductView {


    public static Product form(Product product) {

        Category category = null;

        do {
            category = CategoryView.select(product.getCategory());
        }while (category == null);


        String name = "";

        do {
            name = JOptionPane.showInputDialog(null, "Enter the product name", product.getName());
        }while (name.equals(""));


        String description = "";

        do {
            description = JOptionPane.showInputDialog(null, "Enter the product description",  product.getDescription());
        }while (description.equals(""));


        double price = 0;

        do {
            try {
                price = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the product price",  product.getPrice()));
            }catch (Exception ex){
                price = 0;
            }
        }while (price <= 0);


        Product ret = new Product()
                .setCategory(category)
                .setName(name)
                .setDescription(description)
                .setCreationDate(LocalDateTime.now())
                .setPrice(BigDecimal.valueOf(price));

        return ret;
    }

    public void sucess (){
        JOptionPane.showMessageDialog(null, "Product saved successfully!");
    }

    public static void sucess(Product product){
        JOptionPane.showMessageDialog(null, "Product " + product.getName() + " saved successfully!");
    }
    public static Product select (Product product) {
        Product ret = (Product) JOptionPane.showInputDialog(
                null,
                "Select an product:",
                "Menu",
                JOptionPane.QUESTION_MESSAGE,
                null,
                ProductsCollectionRepository.findAll().toArray(),
                product == null ? 1 : product);
        return ret;
    }

    public static void  update (Product product) {
        form(product);
        sucess(product);
        show(product);

    }

    private static void show(Product product) {
        System.out.println(product );

        String formattedText = String.format( "PRODUCT" + product.getName() + System.lineSeparator()
                + "DESCRIPTION: " + product.getDescription() + System.lineSeparator()
                + "CATEGORY: " + product.getCategory().toString() + System.lineSeparator()
                + "PRICE: %,.2f ", product.getPrice()
        );

        JOptionPane.showMessageDialog(null, formattedText);
    }
}
