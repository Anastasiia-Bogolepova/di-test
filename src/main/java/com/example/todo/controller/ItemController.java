package com.example.todo.controller;

import java.util.List;

import com.example.todo.model.Item;
import com.example.todo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo/items")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return itemRepository.save(item);
    }

    @GetMapping
    public List<Item> getItemsByCategory(@RequestParam(name = "categoryId", required = false) Long categoryId) {
        if (categoryId == null) {
            return itemRepository.findAll();
        } else {
            return itemRepository.findItemsByCategory(categoryId);
        }
    }

    @GetMapping("/{id}")
    public Item getItem(@PathVariable("id") Long id) {
        return itemRepository.findById(id).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteItem(@PathVariable("id") Long id) {
        itemRepository.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
