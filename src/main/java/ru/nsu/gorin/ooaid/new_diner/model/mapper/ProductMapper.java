package ru.nsu.gorin.ooaid.new_diner.model.mapper;

import ru.nsu.gorin.ooaid.new_diner.entities.ProductEntity;
import ru.nsu.gorin.ooaid.new_diner.model.ProductDTO;

public class ProductMapper {
    public static ProductEntity mapProductDtoToEntity(ProductDTO productDTO) {
        ProductEntity product = new ProductEntity();

        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setAmount(productDTO.getAmount());

        return product;
    }
}
