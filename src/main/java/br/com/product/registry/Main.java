package br.com.product.registry;

import br.com.product.registry.model.Category;
import br.com.product.registry.repository.CategoryCollectionRepository;
import br.com.product.registry.view.CategoryView;
import br.com.product.registry.view.Options;
import br.com.product.registry.view.OptionsView;

public class Main {
    public static void main(String[] args) {

        Options options = null;

        do {
            options = OptionsView.select();

            switch (options) {
                case REGISTER_CATEGORY -> registerCategory();
                case REGISTER_PRODUCT -> registerProduct();
                case VIEW_PRODUCT_BY_ID -> viewProductById();
                case VIEW_PRODUCT_BY_CATEGORY -> viewProductByCategory();
                case CHANGE_PRODUCT -> changeProduct();
                case FINISH -> finish();
            }

        }while(options != Options.FINISH);

    }

    private static void registerCategory() {

        CategoryView view = new CategoryView();
        Category category =  view.form();
        CategoryCollectionRepository.save(category);
        view.sucess(category);
    }
    private static void registerProduct() {}
    private static void viewProductById() {}
    private static void viewProductByCategory() {}
    private static void changeProduct() {}
    private static void finish() {
        System.exit(0);
    }
}