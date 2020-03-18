package com.example.todo.repository;

import java.util.List;

import com.example.todo.model.Item;

public interface ItemRepositoryCustom {
    public List<Item> findItemsByCategory(Long categoryId);
}
