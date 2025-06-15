package org.example.java_4.service;

import org.example.java_4.model.ItemModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    private List<ItemModel> items = new ArrayList<>();


    public void addItem(ItemModel itemModel) {
        items.add(itemModel);
    }
    public List<ItemModel> getItems() {
        return items;
    }
}
