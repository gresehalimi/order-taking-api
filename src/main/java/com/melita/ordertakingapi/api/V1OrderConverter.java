package com.melita.ordertakingapi.api;

import com.melita.ordertakingapi.common.Country;
import com.melita.ordertakingapi.order.Order;
import com.melita.ordertakingapi.order.OrderCreateQuery;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class V1OrderConverter {

    V1OrderCreateResponse toCreateResponse(Order order){
        return V1OrderCreateResponse.builder().orderId(order.getId()).build();
    }

    OrderCreateQuery toCreateQuery(V1OrderCreateRequest payload) {
        return OrderCreateQuery.builder().customer(toCustomer(payload.customer))
                .dateTimeInstallation(toDateTimeInstallation(payload.dateInstallation, payload.timeInstallation))
                .productCategoryIds(payload.productCategoryIds).build();
    }
        OrderCreateQuery.OrderCustomer toCustomer(V1OrderCreateRequest.OrderCustomer customer){
            return OrderCreateQuery.OrderCustomer.builder(customer.name, customer.email, customer.phone, customer.street, customer.zip, customer.city, getCountry(customer.country)).streetAdditional(customer.streetAdditional).build();
        }

        LocalDateTime toDateTimeInstallation(String installationDate, String installationTime){
            LocalDate datePart = LocalDate.parse(installationDate);
            LocalTime timePart = LocalTime.parse(installationTime + ":00");
            return LocalDateTime.of(datePart, timePart);
        }

        public boolean contains(String country){
            for (Country c : Country.values()) {
                if (c.name().equals(country)) {
                    return true; }
            }
            throw new IllegalArgumentException("value" + country + "is not valid");
        }
        public Country getCountry(String country){
            contains(country);
           return Country.valueOf(Country.class,country);
        }
}
