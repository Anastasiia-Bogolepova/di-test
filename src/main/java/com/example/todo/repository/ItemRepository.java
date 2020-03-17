package com.example.todo.repository;

import com.example.todo.model.CategoryEntity;
import com.example.todo.model.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {
}
