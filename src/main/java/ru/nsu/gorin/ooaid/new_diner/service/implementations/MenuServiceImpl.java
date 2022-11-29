package ru.nsu.gorin.ooaid.new_diner.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.gorin.ooaid.new_diner.entities.ProductEntity;
import ru.nsu.gorin.ooaid.new_diner.model.ProductDTO;
import ru.nsu.gorin.ooaid.new_diner.model.mapper.ProductMapper;
import ru.nsu.gorin.ooaid.new_diner.repository.ProductRepository;
import ru.nsu.gorin.ooaid.new_diner.service.MenuService;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    private final ProductRepository productRepository;

    @Autowired
    public MenuServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductEntity addProductToMenu(ProductDTO productDTO) {
        ProductEntity product = ProductMapper.mapProductDtoToEntity(productDTO);

        return productRepository.save(product);
    }

    @Override
    public ProductEntity deleteProductFromMenu(long id) {
        ProductEntity product = productRepository.findById(id).get();
        productRepository.deleteById(id);
        return product;
    }

    @Override
    public List<ProductEntity> getMenu() {
        return productRepository.findAll();
    }
}
