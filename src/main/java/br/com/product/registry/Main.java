package br.com.product.registry;

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

public class Main {
    public static void main(String[] args) {

        Options options = null;

        do {
            options = OptionsView.select();

            switch (options) {
                case REGISTER_CATEGORY -> registerCategory();
                case REGISTER_PRODUCT -> registerProduct();
                case CHANGE_PRODUCT -> changeProduct();
                case VIEW_PRODUCT_BY_ID -> viewProductById();
                case VIEW_PRODUCT_BY_CATEGORY -> viewProductByCategory();
                case FINISH -> finish();
            }

        }while(options != Options.FINISH);

    }

    private static void registerCategory() {

        CategoryView view = new CategoryView();
        Category category =  view.form(new  Category());
        CategoryCollectionRepository.save(category);
        view.sucess(category);

    }
    private static void registerProduct() {

        Product product = ProductView.form(new  Product());
        ProductsCollectionRepository.save(product);
        ProductView.sucess(product);
    }
    private static void changeProduct() {
        Product product = ProductView.select(null);
        ProductView.update(product);
    }
    private static void viewProductById() {}
    private static void viewProductByCategory() {
        Category category = CategoryView.select(null);

        List<Product> products = ProductsCollectionRepository.findByCategory(category);

        if(products.isEmpty()){
            JOptionPane.showMessageDialog(null, "Nothing found in category: " +category.getName()+ "!");
        }else {
            products.forEach(ProductView::show);
            products.forEach(System.out::println);
        }
    }
    private static void finish() {
        System.exit(0);
    }
}