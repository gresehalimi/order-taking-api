package com.melita.ordertakingapi.order;

import com.melita.ordertakingapi.common.Country;
import com.melita.ordertakingapi.agent.AgentService;
import com.melita.ordertakingapi.order.outbound.OrderOutboundApi;
import com.melita.ordertakingapi.product.Category;
import com.melita.ordertakingapi.product.Product;
import com.melita.ordertakingapi.product.ProductCategory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    private final String NAME = "name";
    private final String PHONE = "+12123456";
    private final String EMAIL = "email@email.com";
    private final String CITY = "city";
    private final String STREET = "street";
    private final String ZIP = "134";;
    private final Country COUNTRY = Country.AL;
    private final Integer ORDER_ID = 1;
    @Mock OrderOutboundApi api;
    @Mock AgentService agentService;
    @Mock OrderStorage orderStorage;
    @InjectMocks OrderService underTest;

    @Test
    void create_shouldCreateOrder() {
        LocalDateTime dateTime = LocalDateTime.MAX;
        Order order = Order.builder()
                .id(ORDER_ID)
                .orderCustomer(OrderCustomer.builder().country(COUNTRY).city(CITY).email(EMAIL).phone(PHONE).zip(ZIP).city(CITY).name(NAME).street(STREET).build())
                .orderProductCategories(Collections.singletonList(OrderProductCategory.builder()
                        .productCategory(ProductCategory.builder().id(1).product(Product.builder().id(1).build()).category(Category.builder().id(1).build()).build())
                        .build()))
                .dateTimeInstallation(dateTime)
                .build();
        when(orderStorage.store(any())).thenReturn(order);
        when(api.publishPendingOrder(any())).thenReturn("message_sent");
        Order result = underTest.create(OrderCreateQuery.builder()
                .productCategoryIds(Collections.singletonList(1))
                .dateTimeInstallation(dateTime)
                .customer(OrderCreateQuery.OrderCustomer.builder(NAME,EMAIL,PHONE,STREET,ZIP,CITY,COUNTRY).build())
                .build());
        assertEquals(order,result);
    }
}
