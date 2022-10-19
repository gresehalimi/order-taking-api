package com.melita.ordertakingapi.order;

import com.melita.ordertakingapi.product.ProductCategory;
import com.melita.ordertakingapi.product.ProductCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
class OrderStorage {

    private final OrderRepository repository;
    private final ProductCategoryRepository productCategoryRepository;

    Order store(Order order){
        return repository.saveAndFlush(order);
    }

    List<OrderProductCategory> items(List<Integer> productCategoryIds){
        List<OrderProductCategory> orderProductCategories = new ArrayList<>();
        List<ProductCategory>  productCategories = productCategoryRepository.findAllByIdIn(productCategoryIds);
        productCategories.forEach(productCategory -> {
            OrderProductCategory orderProductCategory = new OrderProductCategory();
            orderProductCategory.setProductCategory(productCategory);
            orderProductCategories.add(orderProductCategory);});
        return orderProductCategories;
    }
}
