package org.example.java_4.controller;

import lombok.RequiredArgsConstructor;
import org.example.java_4.model.ItemModel;
import org.example.java_4.model.ItemRequest;
import org.example.java_4.service.ItemService;
import org.example.java_4.util.ItemUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    public ResponseEntity<Void> addItem(@RequestBody ItemRequest itemRequest) throws Exception {
        itemService.addItem(ItemUtils.convertItem(itemRequest));
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<ItemModel>> getItems() {
        return ResponseEntity.ok(itemService.getItems());
    }
}
