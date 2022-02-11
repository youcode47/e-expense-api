package io.yourcode47.eexpenseapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Purchase extends BaseEntity {

    private String name;

    private String description;

    private BigDecimal price;

    private int quantity;

    private BigDecimal total;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryid", referencedColumnName = "id")
    private Category category;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return quantity == purchase.quantity && Objects.equals(name, purchase.name) && Objects.equals(description, purchase.description) && Objects.equals(price, purchase.price) && Objects.equals(total, purchase.total) && Objects.equals(category, purchase.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, price, quantity, total, category);
    }
}
