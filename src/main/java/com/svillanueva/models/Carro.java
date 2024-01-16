package com.svillanueva.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Carro {
    private final List<ItemCarro> items;

    public Carro() {
        this.items = new ArrayList<>();
    }

    public void addItemCarro(ItemCarro itemCarro) {
        if (items.contains(itemCarro)) {
            Optional<ItemCarro> optionalItemCarro = items.stream()
                    .filter(i -> i.equals(itemCarro))
                    .findAny();
            if (optionalItemCarro.isPresent()) {
                ItemCarro i = optionalItemCarro.get();
                i.setCantidad(i.getCantidad() + 1);
            }
        } else {
            this.items.add(itemCarro);
        }
    }

    public List<ItemCarro> getItems() {
        return items;
    }

    public int getTotal() {
        return getItems().stream()
                .mapToInt(ItemCarro::getImporte)
                .sum();
    }

    public void updateItemCarro(String id, String cantidad) {
        Optional<ItemCarro> optionalItemCarro = items.stream()
                .filter(i -> i.getProducto()
                        .getId()
                        .equals(Long.parseLong(id)))
                .findAny();
        int parseInt = Integer.parseInt(cantidad);
        // Si la cantidad es 0 o menor, se elimina el producto del carro
        if (parseInt <= 0) {
            removeItemCarro(id);
        } else if (optionalItemCarro.isPresent()) {
            ItemCarro i = optionalItemCarro.get();
            i.setCantidad(parseInt);
        }
    }

    public void removeItemCarro(String id) {
        Optional<ItemCarro> optionalItemCarro = items.stream()
                .filter(i -> i.getProducto()
                        .getId()
                        .equals(Long.parseLong(id)))
                .findAny();
        if (optionalItemCarro.isPresent()) {
            ItemCarro i = optionalItemCarro.get();
            items.remove(i);
        }
    }
}
