package br.com.product.registry.model;

import java.util.Objects;

public class Category {

    private Long id;

    private String name;

    public Category() {
    }

    public Category(String name, Long id) {
        this.setName(name);
        this.setId(id);
    }

    public Category(String name) {
        this.setName(name);
    }

    public Long getId() {
        return id;
    }

    public Category setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Category setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return name.toUpperCase();
    }
}
