package org.example.java_4.controller;

import org.example.java_4.model.ItemModel;
import org.example.java_4.model.ItemRequest;
import org.example.java_4.service.ItemService;
import org.example.java_4.util.ItemUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public void addItem(@RequestBody ItemRequest itemRequest) throws NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ItemModel itemModel = ItemUtils.convertItem(itemRequest);
        itemService.addItem(itemModel);
    }

    @GetMapping
    public List<ItemModel> getItems() {
        return itemService.getItems();
    }
}
