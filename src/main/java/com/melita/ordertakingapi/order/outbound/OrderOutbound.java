package com.melita.ordertakingapi.order.outbound;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@orderId",
        scope = OrderOutbound.class)
@Getter
@Setter
@Builder @AllArgsConstructor @NoArgsConstructor
@ToString
public class OrderOutbound {

    private Integer orderId;
    private String customerName;
    private String customerPhone;
    private String customerEmail;
    private String installationAddress;
    private String products;
    private String dateTimeInstallation;
}

