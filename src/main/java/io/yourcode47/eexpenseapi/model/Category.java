package io.yourcode47.eexpenseapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Objects;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Category extends BaseEntity {

    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    private Collection<Purchase> purchaseList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name) && Objects.equals(purchaseList, category.purchaseList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, purchaseList);
    }
}
