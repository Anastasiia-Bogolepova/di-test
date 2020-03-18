package com.example.todo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

import com.example.todo.model.Category;
import com.example.todo.model.Item;
import org.springframework.stereotype.Repository;

@Repository
public class ItemRepositoryCustomImpl implements ItemRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Item> findItemsByCategory(Long categoryId) {
        Query query = entityManager.createQuery("select category.items from Category as category where category.id = ?1");
        query.setParameter(1, categoryId);
        return query.getResultList();
    }
}
