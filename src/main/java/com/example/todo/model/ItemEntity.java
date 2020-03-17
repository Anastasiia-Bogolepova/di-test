package com.example.todo.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

import lombok.Data;

@Entity
@Data
@Table(name = "item")
public class ItemEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "text")
    private String text;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "item_category", joinColumns = {@JoinColumn(referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(referencedColumnName = "id")})
    private List<CategoryEntity> categories;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemEntity that = (ItemEntity) o;
        return id == that.id &&
                Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text);
    }
}
