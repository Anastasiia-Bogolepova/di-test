package com.example.todo.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "item")
public class Item {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "item_category", joinColumns = { @JoinColumn(name = "item_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "category_id", referencedColumnName = "id") })
    private List<Category> categories;

    @Column(name = "text")
    private String text;

}
