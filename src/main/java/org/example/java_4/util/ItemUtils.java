package org.example.java_4.util;

import org.example.java_4.model.ItemModel;
import org.example.java_4.model.ItemRequest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ItemUtils {

    public static ItemModel convertItem (ItemRequest itemRequest) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<ItemModel> itemModelClass = ItemModel.class;
        Constructor<ItemModel> constructor = itemModelClass.getConstructor();
        ItemModel itemModel = constructor.newInstance();
        Field nameField = itemModelClass.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(itemModel, itemRequest.getName());
        Field quantityField = itemModelClass.getDeclaredField("quantity");
        quantityField.setAccessible(true);
        quantityField.set(itemModel, itemRequest.getQuantity());
        return itemModel;
    }
}
