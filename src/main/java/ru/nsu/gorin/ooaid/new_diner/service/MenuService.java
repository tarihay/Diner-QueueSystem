package ru.nsu.gorin.ooaid.new_diner.service;

import ru.nsu.gorin.ooaid.new_diner.entities.ProductEntity;
import ru.nsu.gorin.ooaid.new_diner.model.ProductDTO;

import java.util.List;
import java.util.Set;

public interface MenuService {
    ProductEntity addProductToMenu(ProductDTO productDTO);

    ProductEntity deleteProductFromMenu(long id);

    List<ProductEntity> getMenu();
}
