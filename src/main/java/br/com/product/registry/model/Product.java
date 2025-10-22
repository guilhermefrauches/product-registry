package br.com.product.registry.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Product {

    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    private LocalDateTime creationDate;

    private Category category;

    public Product() {
    }

    public Product(Long id, String name, String description, BigDecimal price, LocalDateTime creationDate, Category category) {
        this.setId(id);
        this.setName(name);
        this.setDescription(description);
        this.setPrice(price);
        this.setCreationDate(creationDate);
        this.setCategory(category);
    }

    public Product(String description, String name, BigDecimal price, LocalDateTime creationDate, Category category) {
        this.setDescription(description);
        this.setName(name);
        this.setPrice(price);
        this.setCreationDate(creationDate);
        this.setCategory(category);
    }

    public Long getId() {
        return id;
    }

    public Product setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Product setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public Product setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Product setCategory(Category category) {
        this.category = category;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
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
