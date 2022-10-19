package com.melita.ordertakingapi.order;

import com.melita.ordertakingapi.common.Country;
import com.melita.ordertakingapi.order.Order;
import com.melita.ordertakingapi.order.OrderProductCategory;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor @AllArgsConstructor
@Builder
@Getter @Setter
@ToString
@Table(name = "order_customer")
@Entity
public class OrderCustomer {
    @Id
    private Integer orderId;
    private String name;
    private String email;
    private String phone;
    private String street;
    private String streetAdditional;
    private String zip;
    private String city;
    @Enumerated(EnumType.STRING)
    private Country country;

    @OneToOne
    @JoinColumn(name =  "orderId", referencedColumnName ="id", nullable = false)
    @MapsId
    Order order;
}
