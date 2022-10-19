package com.melita.ordertakingapi.order;

import com.melita.ordertakingapi.common.Country;
import lombok.Builder;
import lombok.Getter;
import lombok.With;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@With
public class OrderCreateQuery {

    private final OrderCustomer customer;
    private final LocalDateTime dateTimeInstallation;
    private final List<Integer> productCategoryIds;


    @Builder(builderMethodName = "internalBuilder")
    @Getter
    @With
    public static class OrderCustomer {

        private final String name;
        private final String email;
        private final String phone;
        private final String street;
        private final String streetAdditional;
        private final String zip;
        private final String city;
        private final Country country;

        public static OrderCreateQuery.OrderCustomer.OrderCustomerBuilder builder(String name, String email, String phone, String street, String zip, String city, Country country) {
            return internalBuilder().name(name).email(email).phone(phone).street(street).zip(zip).city(city).country(country);
        }
    }
}
