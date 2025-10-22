package br.com.product.registry.view;

public enum Options {

    REGISTER_CATEGORY(1, "Register Category"),
    REGISTER_PRODUCT(2, "Register Product"),
    CHANGE_PRODUCT(3, "Change Product"),
    VIEW_PRODUCT_BY_ID(4, "View Product By ID"),
    VIEW_PRODUCT_BY_CATEGORY(5, "View Product By Category"),
    FINISH(6, "Finish"),;

    int id;
    String name;

    Options(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Options setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Options setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return name.toUpperCase();
    }
}
