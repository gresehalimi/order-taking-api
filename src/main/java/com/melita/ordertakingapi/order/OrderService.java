package com.melita.ordertakingapi.order;

import com.melita.ordertakingapi.agent.AgentService;
import com.melita.ordertakingapi.order.outbound.OrderOutbound;
import com.melita.ordertakingapi.order.outbound.OrderOutboundApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderStorage storage;
    private final OrderOutboundApi api;
    private final AgentService agentService;

    public Order create(OrderCreateQuery query) {
        query = OrderQueryValidator.validateCreateQuery(query);
        Order order = storage.store(Order.builder()
                .orderCustomer(OrderCustomer.builder().name(query.getCustomer().getName())
                        .email(query.getCustomer().getEmail())
                        .phone(query.getCustomer().getPhone())
                        .street(query.getCustomer().getStreet())
                        .streetAdditional(query.getCustomer().getStreetAdditional())
                        .zip(query.getCustomer().getZip())
                        .city(query.getCustomer().getCity())
                        .country(query.getCustomer().getCountry())
                        .build())
                .orderProductCategories(storage.items(query.getProductCategoryIds()))
                .dateTimeInstallation(query.getDateTimeInstallation())
                .build());
        api.publishPendingOrder(OrderOutbound.builder()
                .orderId(order.getId())
                .customerName(order.getOrderCustomer().getName())
                .customerEmail(order.getOrderCustomer().getEmail())
                .customerPhone(order.getOrderCustomer().getPhone())
                .dateTimeInstallation(order.getDateTimeInstallation().format(DateTimeFormatter.ISO_DATE_TIME))
                .installationAddress(getInstallationAddress(order.getOrderCustomer()))
                .products(getProducts(order.getOrderProductCategories())).build());
        agentService.sendEmailToAgent(order.getOrderCustomer().getCountry(), order.getOrderCustomer().getCity(),order.getId());
        return order;
    }

    private String getProducts(List<OrderProductCategory> productCategoryList) {
        StringBuilder builder = new StringBuilder(" ");
        productCategoryList.forEach(p -> builder.append(p.getProductCategory().getProduct().getName() + ", " + p.getProductCategory().getCategory().getName()));
        return builder.toString();
    }

    private String getInstallationAddress(OrderCustomer customer) {
        StringBuilder builder = new StringBuilder();
        builder.append(customer.getStreet()).append(", ");
        if (customer.getStreetAdditional() != null) {
            builder.append(customer.getStreetAdditional()).append(", ");
        }
        builder.append(customer.getZip()).append(", ");
        builder.append(customer.getCity()).append(", ");
        builder.append(customer.getCountry());
        return builder.toString();
    }
}
