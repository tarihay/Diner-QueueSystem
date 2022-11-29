package ru.nsu.gorin.ooaid.new_diner.service;

import ru.nsu.gorin.ooaid.new_diner.exceptions.NoSuchProductFoundException;
import ru.nsu.gorin.ooaid.new_diner.model.OrderDTO;

public interface SaveOrderService {
    long saveOrder(OrderDTO orderDTO) throws NoSuchProductFoundException;
}
